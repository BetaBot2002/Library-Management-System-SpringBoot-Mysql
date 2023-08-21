package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.MagazineDonations;
import com.lms.librarymanagementsystem.repositories.MagazineDonationRepository;

@Service
@Transactional
public class MagazineDonationServices {
    private MagazineDonationRepository magazineDonationRepository;

    public MagazineDonationServices(MagazineDonationRepository magazineDonationRepository) {
        this.magazineDonationRepository = magazineDonationRepository;
    }

    public MagazineDonations insertOneJournalDonations(MagazineDonations magazineDonations, MultipartFile file) {
        String currentDirectory = System.getProperty("user.dir");
        String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
        String path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+filename;
        if (file != null && !file.isEmpty()) {
            FileHandler.saveFile(file, path);
            magazineDonations.setThumbnail(filename);
        }
        magazineDonations.setApproved("pending");
        return magazineDonationRepository.save(magazineDonations);
    }

    public List<MagazineDonations> findPendingMagazineDonations() {
        return magazineDonationRepository.getPendingMagazineDonations();
    }

    public MagazineDonations findSingleMagazineDonations(Integer mdnid) {
        return magazineDonationRepository.getSingleMagazineDonation(mdnid);
    }

    public Integer updateDonationToApproved(Integer mdnid) {
        return magazineDonationRepository.updateDonationApproval(mdnid);
    }

    public Integer updateDonationToRejection(Integer mdnid) {
        return magazineDonationRepository.updateDonationRejection(mdnid);
    }
}