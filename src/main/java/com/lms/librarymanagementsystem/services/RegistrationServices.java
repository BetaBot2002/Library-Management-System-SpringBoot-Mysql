package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.EncryptionHandlers;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.Registration;
import com.lms.librarymanagementsystem.repositories.RegistrationRepository;

import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

@Service
@Transactional
public class RegistrationServices {
    private RegistrationRepository registrationRepository;

    public RegistrationServices(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }

    public List<String> findPendingApprovedUsernames() {
        return registrationRepository.getPendingApprovedUsernames();
    }

    public Registration insertOneRegistration(Registration registration, MultipartFile file) {
        String currentDirectory = System.getProperty("user.dir");
        String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
        String path = currentDirectory + "\\src\\main\\webapp\\uploads\\profilePictures\\"+filename;
        if (file!=null && !file.isEmpty()) {
            FileHandler.saveFile(file, path);
            registration.setProfilePicture(filename);
        }
        if (registration.getDob().equals("")) {
            registration.setDob(null);
        }
        registration.setPassword(EncryptionHandlers.encodePassword(registration.getPassword()));
        return registrationRepository.save(registration);
    }

    public List<Registration> getPending(String paid) {
        return registrationRepository.getPendingRequests(paid);
    }

    public Integer updateApproval(String status, Integer rsid) {
        return registrationRepository.updateApprovedByRsid(status, rsid);
    }

    public Registration getOneRegistration(Integer rsid) {
        return registrationRepository.getRegistrationByID(rsid);
    }

    public List<Registration> findUserByUsernamePending(String username){
        return registrationRepository.getUserByUsernamePending(username);
    }
    public List<Registration> findUserByUsernameRejected(String username){
        return registrationRepository.getUserByUsernameRejected(username);
    }

    public List<Registration> findTopPendings(){
        return registrationRepository.getTopPendings();
    }

    public List<Registration> findAllPending(){
        return registrationRepository.getAllPending();
    }

    
}
