package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.Theses;
import com.lms.librarymanagementsystem.repositories.ThesesRepository;

@Service
@Transactional
public class ThesesServices {
    private ThesesRepository thesesRepository;

    public ThesesServices(ThesesRepository thesesRepository) {
        this.thesesRepository = thesesRepository;
    }

    public Theses insertOneTheses(Theses theses, MultipartFile file) {
        if (file!=null && !file.isEmpty()) {
            String currentDirectory = System.getProperty("user.dir");
            String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
            String path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+filename;
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + thesesRepository.getThumbnailByItid(theses.getItid()));
            System.out.println(path);
            FileHandler.saveFile(file, path);
            theses.setThumbnail(filename);
        }
        return thesesRepository.save(theses);
    }

    public List<Theses> findBySearch(String searchParam) {
        return thesesRepository.findThesesBySearch(searchParam);
    }

    public List<Theses> findBySearchResearcher(String searchParam) {
        return thesesRepository.findThesesBySearchResearcher(searchParam);
    }

    public List<Theses> findBySearchCatagory(String searchParam) {
        return thesesRepository.findThesesBySearchCatagory(searchParam);
    }

    public Theses findSingleThesesById(String tid) {
        return thesesRepository.findSingleThesesById(tid);
    }

    public List<Theses> findBySearchTitle(String searchParam) {
        return thesesRepository.findThesesBySearchTitle(searchParam);
    }

    public List<Theses> findBySearchKeywords(String searchParam) {
        return thesesRepository.findThesesBySearchKeywords(searchParam);
    }

    public Integer decreaseStock(String ITID){
        return thesesRepository.decreaseStock(ITID);
    }
    
    public Integer increaseStock(String ITID){
        return thesesRepository.increaseStock(ITID);
    }

    public List<Theses> findLastTwoTheses(){
        return thesesRepository.getLastTwoTheses();
    }

    public Theses findOneThesesByItid(String itid){
        return thesesRepository.getOneThesesByItid(itid);
    }
    
    public String findTitleByItid(String itid){
        return thesesRepository.getTitleByItid(itid);
    }
}
