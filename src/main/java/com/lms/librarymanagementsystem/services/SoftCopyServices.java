package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.SoftCopy;
import com.lms.librarymanagementsystem.repositories.SoftCopyRepository;

@Service
@Transactional
public class SoftCopyServices {
    private SoftCopyRepository softCopyRepository;

    public SoftCopyServices(SoftCopyRepository softCopyRepository) {
        this.softCopyRepository = softCopyRepository;
    }

    public SoftCopy insertOneSoftCopy(SoftCopy softCopy, MultipartFile file, MultipartFile thumbnail) {
        String currentDirectory = System.getProperty("user.dir");
        String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
        String path = currentDirectory + "\\src\\main\\webapp\\uploads\\SoftCopy\\"+filename;
        System.out.println(path);
        if (file!=null && !file.isEmpty()) {
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\SoftCopy\\" + softCopyRepository.getFileBySid(softCopy.getSid()));
            FileHandler.saveFile(file, path);
            softCopy.setFilename(filename);
        }
        if (thumbnail!=null && !thumbnail.isEmpty()) {
            String thumnailfilename=DateHandler.getDateTimePattern()+thumbnail.getOriginalFilename();
            path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+thumnailfilename;
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + softCopyRepository.getThumbnailBySid(softCopy.getSid()));
            FileHandler.saveFile(thumbnail, path);
            softCopy.setThumbnail(thumnailfilename);
        }
        return softCopyRepository.save(softCopy);
    }

    public List<SoftCopy> findBySearch(String searchParam) {
        return softCopyRepository.findSoftCopyBySearch(searchParam);
    }

    public List<SoftCopy> findBySearchOwner(String searchParam) {
        return softCopyRepository.findSoftCopyBySearchOwner(searchParam);
    }

    public List<SoftCopy> findBySearchPublisher(String searchParam) {
        return softCopyRepository.findSoftCopyBySearchPublisher(searchParam);
    }

    public List<SoftCopy> findBySearchCatagory(String searchParam) {
        return softCopyRepository.findSoftCopyBySearchCatagory(searchParam);
    }

    public List<SoftCopy> findBySearchTitle(String searchParam) {
        return softCopyRepository.findSoftCopyBySearchTitle(searchParam);
    }

    public List<SoftCopy> findBySearchKeywords(String searchParam) {
        return softCopyRepository.findSoftCopyBySearchKeywords(searchParam);
    }

    public SoftCopy findSingleSoftCopyById(String sid) {
        return softCopyRepository.findSingleSoftCopyById(sid);
    }

    public List<SoftCopy> findRelatedSoftCopy(String ITID) {
        return softCopyRepository.findAlternativeSoftCopy(ITID);
    }

    public List<SoftCopy> findLastTwoSoftCopies(){
        return softCopyRepository.getLastTwoSoftCopies();
    }
    
    public String findTitleBySid(String sid){
        return softCopyRepository.getTitleBySid(sid);
    }

    public Integer deleteSoftcopyBySid(String sid){
        return softCopyRepository.deleteSoftcopyBySid(sid);
    }

    public String getLatestSID(){
        return softCopyRepository.getLatestSID();
    }
}
