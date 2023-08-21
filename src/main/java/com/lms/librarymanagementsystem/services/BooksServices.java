package com.lms.librarymanagementsystem.services;

import java.util.List;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.models.Books;
import com.lms.librarymanagementsystem.repositories.BooksRepository;

@Service
@Transactional
public class BooksServices {
    private BooksRepository booksRepository;

    public BooksServices(BooksRepository booksRepository) {
        this.booksRepository = booksRepository;
    }

    public Books insertOneBook(Books book, MultipartFile file) {
        if (file!=null && !file.isEmpty()) {
            String currentDirectory = System.getProperty("user.dir");
            String filename=DateHandler.getDateTimePattern()+file.getOriginalFilename();
            String path = currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\"+filename;
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + booksRepository.getThumbnailByItid(book.getItid()));
            FileHandler.saveFile(file, path);
            book.setThumbnail(filename);
        }
        return booksRepository.save(book);
    }

    public List<Books> getAllBooks() {
        return booksRepository.findAll();
    }

    public List<Books> findBySearch(String searchParam) {
        return booksRepository.findBookBySearch(searchParam);
    }

    public List<Books> findBySearchAuthor(String searchParam) {
        return booksRepository.findBookBySearchAuthor(searchParam);
    }

    public Books findSingleBook(String bookId) {
        return booksRepository.getSingleBook(bookId);
    }

    public List<Books> findBySearchPublisher(String searchParam) {
        return booksRepository.findBookBySearchPublisher(searchParam);
    }

    public List<Books> findBySearchCatagory(String searchParam) {
        return booksRepository.findBookBySearchCatagory(searchParam);
    }

    public List<Books> findBySearchTitle(String searchParam) {
        return booksRepository.findBookBySearchTitle(searchParam);
    }

    public List<Books> findBySearchKeywords(String searchParam) {
        return booksRepository.findBookBySearchKeywords(searchParam);
    }

    public Integer decreaseStock(String ITID){
        return booksRepository.decreaseStock(ITID);
    }
    
    public Integer increaseStock(String ITID){
        return booksRepository.increaseStock(ITID);
    }

    public List<Books> findLastTwoBooks(){
        return booksRepository.getLastTwoBooks();
    }

    public Books findOneBookByItid(String itid){
        return booksRepository.getOneBookByItid(itid);
    }

    public String findTitleByItid(String itid){
        return booksRepository.getTitleByItid(itid);
    }

}
