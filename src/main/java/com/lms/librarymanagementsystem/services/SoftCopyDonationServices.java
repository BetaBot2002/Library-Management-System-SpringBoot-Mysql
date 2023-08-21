package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.SoftCopyDonations;
import com.lms.librarymanagementsystem.repositories.SoftCopyDonationRepository;

@Service
@Transactional
public class SoftCopyDonationServices {
    private SoftCopyDonationRepository softCopyDonationRepository;

    public SoftCopyDonationServices(SoftCopyDonationRepository softCopyDonationRepository) {
        this.softCopyDonationRepository = softCopyDonationRepository;
    }

    public SoftCopyDonations insertOneSoftCopyDonations(SoftCopyDonations softCopyDonations, MultipartFile file, MultipartFile thumbnail) {
        String currentDirectory = System.getProperty("user.dir");
        String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
        String path = currentDirectory + "\\src\\main\\webapp\\uploads\\SoftCopy\\"+filename;
        System.out.println(path);
        if (file!=null && !file.isEmpty()) {
            FileHandler.saveFile(file, path);
            softCopyDonations.setFileName(filename);
        }
        if (thumbnail!=null && !thumbnail.isEmpty()) {
            String thumnailfilename=DateHandler.getDateTimePattern()+thumbnail.getOriginalFilename();
            path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+thumnailfilename;
            FileHandler.saveFile(thumbnail, path);
            softCopyDonations.setThumbnail(thumnailfilename);
        }
        softCopyDonations.setApproved("pending");
        return softCopyDonationRepository.save(softCopyDonations);
    }

    public List<SoftCopyDonations> findPendingSoftCopyDonations() {
        return softCopyDonationRepository.getPendingSoftCopyDonations();
    }

    public SoftCopyDonations findSingleJournalDonations(Integer sdnid) {
        return softCopyDonationRepository.getSingleSoftCopyDonation(sdnid);
    }

    public Integer updateDonationToApproved(Integer sdnid) {
        return softCopyDonationRepository.updateDonationApproval(sdnid);
    }

    public Integer updateDonationToRejection(Integer sdnid) {
        return softCopyDonationRepository.updateDonationRejection(sdnid);
    }
}
