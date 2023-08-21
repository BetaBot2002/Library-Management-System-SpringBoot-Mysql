package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.*;
import com.lms.librarymanagementsystem.repositories.MagazinesRepository;

@Service
@Transactional
public class MagazinesServices {
    private MagazinesRepository magazinesRepository;

    public MagazinesServices(MagazinesRepository magazinesRepository) {
        this.magazinesRepository = magazinesRepository;
    }

    public Magazines insertOneMagazine(Magazines magazine, MultipartFile file) {
        if (file!=null && !file.isEmpty()) {
            String currentDirectory = System.getProperty("user.dir");
            String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
            String path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+filename;
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + magazinesRepository.getThumbnailByItid(magazine.getItid()));
            FileHandler.saveFile(file, path);
            magazine.setThumbnail(filename);
        }
        return magazinesRepository.save(magazine);
    }

    public List<Magazines> findBySearch(String searchParam) {
        return magazinesRepository.findMagazineBySearch(searchParam);
    }

    public List<Magazines> findBySearchPublisher(String searchParam) {
        return magazinesRepository.findMagazineBySearchPublisher(searchParam);
    }

    public List<Magazines> findBySearchCatagory(String searchParam) {
        return magazinesRepository.findMagazineBySearchCatagory(searchParam);
    }

    public Magazines findSingleMagazineById(String mid) {
        return magazinesRepository.findSingleMagazineById(mid);
    }

    public List<Magazines> findBySearchTitle(String searchParam) {
        return magazinesRepository.findMagazineBySearchTitle(searchParam);
    }

    public List<Magazines> findBySearchKeywords(String searchParam) {
        return magazinesRepository.findMagazineBySearchKeywords(searchParam);
    }

    public Integer decreaseStock(String ITID){
        return magazinesRepository.decreaseStock(ITID);
    }
    
    public Integer increaseStock(String ITID){
        return magazinesRepository.increaseStock(ITID);
    }

    public List<Magazines> findLastTwoMagazines(){
        return magazinesRepository.getLastTwoMagazines();
    }

    public Magazines findOneMagazineByItid(String itid){
        return magazinesRepository.getOneMagazineByItid(itid);
    }
    
    public String findTitleByItid(String itid){
        return magazinesRepository.getTitleByItid(itid);
    }

}
