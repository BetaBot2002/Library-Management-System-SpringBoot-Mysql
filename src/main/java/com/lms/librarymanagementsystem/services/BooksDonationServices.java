package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.BookDonations;
import com.lms.librarymanagementsystem.repositories.BookDonationRepository;

@Service
@Transactional
public class BooksDonationServices {
    private BookDonationRepository bookDonationRepository;

    public BooksDonationServices(BookDonationRepository bookDonationRepository) {
        this.bookDonationRepository = bookDonationRepository;
    }

    public BookDonations insertOneBookDonations(BookDonations bookDonations, MultipartFile file) {
        String currentDirectory = System.getProperty("user.dir");
        String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
        String path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+filename;
        if (file != null && !file.isEmpty()) {
            FileHandler.saveFile(file, path);
            bookDonations.setThumbnail(filename);
        }
        bookDonations.setApproved("pending");
        return bookDonationRepository.save(bookDonations);
    }

    public List<BookDonations> findPendingBookDonations() {
        return bookDonationRepository.getPendingBookDonations();
    }

    public BookDonations findSingleBookDonations(Integer bdnid) {
        return bookDonationRepository.getSingleBookDonation(bdnid);
    }

    public Integer updateDonationToApproved(Integer bdnid) {
        return bookDonationRepository.updateDonationApproval(bdnid);
    }

    public Integer updateDonationToRejection(Integer bdnid) {
        return bookDonationRepository.updateDonationRejection(bdnid);
    }
}