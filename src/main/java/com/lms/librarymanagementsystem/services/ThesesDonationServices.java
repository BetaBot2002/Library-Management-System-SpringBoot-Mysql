package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.ThesesDonations;
import com.lms.librarymanagementsystem.repositories.ThesesDonationRepository;

@Service
@Transactional
public class ThesesDonationServices {
    private ThesesDonationRepository thesesDonationRepository;

    public ThesesDonationServices(ThesesDonationRepository thesesDonationRepository) {
        this.thesesDonationRepository = thesesDonationRepository;
    }

    public ThesesDonations insertOneThesesDonations(ThesesDonations thesesDonations, MultipartFile file) {
        String currentDirectory = System.getProperty("user.dir");
        String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
        String path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+filename;
        if (file != null && !file.isEmpty()) {
            FileHandler.saveFile(file, path);
            thesesDonations.setThumbnail(filename);
        }
        thesesDonations.setApproved("pending");
        return thesesDonationRepository.save(thesesDonations);
    }

    public List<ThesesDonations> findPendingThesesDonations() {
        return thesesDonationRepository.getPendingThesesDonations();
    }

    public ThesesDonations findSingleThesesDonations(Integer tdnid) {
        return thesesDonationRepository.getSingleThesesDonation(tdnid);
    }

    public Integer updateDonationToApproved(Integer tdnid) {
        return thesesDonationRepository.updateDonationApproval(tdnid);
    }

    public Integer updateDonationToRejection(Integer tdnid) {
        return thesesDonationRepository.updateDonationRejection(tdnid);
    }
}