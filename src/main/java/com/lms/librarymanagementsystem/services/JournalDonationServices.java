package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.JournalDonations;
import com.lms.librarymanagementsystem.repositories.JournalDonationRepository;

@Service
@Transactional
public class JournalDonationServices {
    private JournalDonationRepository journalDonationRepository;

    public JournalDonationServices(JournalDonationRepository journalDonationRepository) {
        this.journalDonationRepository = journalDonationRepository;
    }

    public JournalDonations insertOneJournalDonations(JournalDonations journalDonations, MultipartFile file) {
        String currentDirectory = System.getProperty("user.dir");
        String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
        String path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+filename;
        if (file != null && !file.isEmpty()) {
            FileHandler.saveFile(file, path);
            journalDonations.setThumbnail(filename);
        }
        journalDonations.setApproved("pending");
        return journalDonationRepository.save(journalDonations);
    }

    public List<JournalDonations> findPendingjournalDonations() {
        return journalDonationRepository.getPendingJournalDonations();
    }

    public JournalDonations findSingleJournalDonations(Integer bdnid) {
        return journalDonationRepository.getSingleJournalDonation(bdnid);
    }

    public Integer updateDonationToApproved(Integer jdnid) {
        return journalDonationRepository.updateDonationApproval(jdnid);
    }

    public Integer updateDonationToRejection(Integer jdnid) {
        return journalDonationRepository.updateDonationRejection(jdnid);
    }
}