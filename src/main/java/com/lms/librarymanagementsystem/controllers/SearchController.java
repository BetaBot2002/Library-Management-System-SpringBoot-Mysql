package com.lms.librarymanagementsystem.controllers;

// import java.util.ArrayList;
import java.util.List;
import java.util.Map;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
// import org.springframework.web.bind.annotation.RequestHeader;
// import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.lms.librarymanagementsystem.Handlers.UniqueSoftCopyHandler;
import com.lms.librarymanagementsystem.models.Books;
import com.lms.librarymanagementsystem.models.Journals;
import com.lms.librarymanagementsystem.models.Magazines;
import com.lms.librarymanagementsystem.models.SoftCopy;
import com.lms.librarymanagementsystem.models.Theses;
import com.lms.librarymanagementsystem.services.AlternativeServices;
import com.lms.librarymanagementsystem.services.BooksServices;
import com.lms.librarymanagementsystem.services.ConnectorServices;
import com.lms.librarymanagementsystem.services.CustomQueryServices;
import com.lms.librarymanagementsystem.services.JournalsServices;
import com.lms.librarymanagementsystem.services.MagazinesServices;
import com.lms.librarymanagementsystem.services.SoftCopyServices;
import com.lms.librarymanagementsystem.services.ThesesServices;

@Controller
@RequestMapping("/search")
public class SearchController {
    private AlternativeServices alternativeServices;
    private BooksServices booksServices;
    private ConnectorServices connectorServices;
    private JournalsServices journalsServices;
    private MagazinesServices magazinesServices;
    private ThesesServices thesesServices;
    private SoftCopyServices softCopyServices;
    private CustomQueryServices customQueryServices;

    public SearchController(AlternativeServices alternativeServices, BooksServices booksServices, ConnectorServices connectorServices, JournalsServices journalsServices, MagazinesServices magazinesServices, ThesesServices thesesServices,SoftCopyServices softCopyServices,CustomQueryServices customQueryServices) {
        this.alternativeServices = alternativeServices;
        this.booksServices = booksServices;
        this.connectorServices = connectorServices;
        this.journalsServices = journalsServices;
        this.magazinesServices = magazinesServices;
        this.thesesServices = thesesServices;
        this.softCopyServices= softCopyServices;
        this.customQueryServices=customQueryServices;
    }

    @GetMapping
    public String getSearch(){
        return "subSearchComponent";
    }

    @GetMapping("/books")
    public ResponseEntity<List<Books>> searchAllBooks(){
        return new ResponseEntity<List<Books>>(booksServices.getAllBooks(),HttpStatus.OK);
    }

    @GetMapping("/searchitem")
    public String searchItems(String searchParam, Model model){
        List<Journals> journals=journalsServices.findBySearch(searchParam);
        List<Books> books=booksServices.findBySearch(searchParam);
        List<Magazines> magazines=magazinesServices.findBySearch(searchParam);
        List<Theses> theses=thesesServices.findBySearch(searchParam);
        List<SoftCopy> softCopies=softCopyServices.findBySearch(searchParam);
        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/author")
    public String searchByAuthor(String searchParam,Model model){
        List<Books> books=booksServices.findBySearchAuthor(searchParam);
        model.addAttribute("books", books);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/researcher")
    public String searchByReasearcher(String searchParam,Model model){
        List<Theses> theses=thesesServices.findBySearchResearcher(searchParam);
        model.addAttribute("theses", theses);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/editor")
    public String searchByEditor(String searchParam,Model model){
        List<Journals> journals=journalsServices.findBySearchEditor(searchParam);
        model.addAttribute("journals", journals);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/owner")
    public String searchByOwner(String searchParam,Model model){
        List<SoftCopy> softCopies=softCopyServices.findBySearchOwner(searchParam);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/publisher")
    public String searchByPublisher(String searchParam,Model model){
        List<Journals> journals=journalsServices.findBySearchPublisher(searchParam);
        List<Books> books=booksServices.findBySearchPublisher(searchParam);
        List<Magazines> magazines=magazinesServices.findBySearchPublisher(searchParam);
        List<SoftCopy> softCopies=softCopyServices.findBySearchPublisher(searchParam);
        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/category")
    public String searchByCategory(String searchParam, Model model){
        List<Journals> journals=journalsServices.findBySearchCatagory(searchParam);
        List<Books> books=booksServices.findBySearchCatagory(searchParam);
        List<Magazines> magazines=magazinesServices.findBySearchCatagory(searchParam);
        List<Theses> theses=thesesServices.findBySearchCatagory(searchParam);
        List<SoftCopy> softCopies=softCopyServices.findBySearchCatagory(searchParam);
        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/title")
    public String searchByTitle(String searchParam, Model model){
        List<Journals> journals=journalsServices.findBySearchTitle(searchParam);
        List<Books> books=booksServices.findBySearchTitle(searchParam);
        List<Magazines> magazines=magazinesServices.findBySearchTitle(searchParam);
        List<Theses> theses=thesesServices.findBySearchTitle(searchParam);
        List<SoftCopy> softCopies=softCopyServices.findBySearchTitle(searchParam);
        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/category/{category}")
    public String showFromCatagory(@PathVariable("category")String searchParam, Model model){
        List<Journals> journals=journalsServices.findBySearchCatagory(searchParam);
        List<Books> books=booksServices.findBySearchCatagory(searchParam);
        List<Magazines> magazines=magazinesServices.findBySearchCatagory(searchParam);
        List<Theses> theses=thesesServices.findBySearchCatagory(searchParam);
        List<SoftCopy> softCopies=softCopyServices.findBySearchCatagory(searchParam);
        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/keyword/{keyword}")
    public String showFromKeyword(@PathVariable("keyword")String searchParam, Model model){
        List<Journals> journals=journalsServices.findBySearchKeywords(searchParam);
        List<Books> books=booksServices.findBySearchKeywords(searchParam);
        List<Magazines> magazines=magazinesServices.findBySearchKeywords(searchParam);
        List<Theses> theses=thesesServices.findBySearchKeywords(searchParam);
        List<SoftCopy> softCopies=softCopyServices.findBySearchKeywords(searchParam);
        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        return "searchResult";
    }

    @GetMapping("/books/{bookId}")
    public String getSingleBookByBid(@PathVariable("bookId")String bookId,Model model){
        // return new ResponseEntity<Books>(booksServices.findSingleBook(bookId), HttpStatus.OK);\
        Books book = booksServices.findSingleBook(bookId);
        List<SoftCopy> softCopies=softCopyServices.findRelatedSoftCopy(book.getItid());
        model.addAttribute("book", book);
        model.addAttribute("softcopies", UniqueSoftCopyHandler.filterSoftCopies(softCopies));
        return "bookDetails";
    }

    @GetMapping("/journals/{jid}")
    public String getSingleJournalById(@PathVariable("jid")String jid,Model model){
        Journals journal=journalsServices.findSingleJournalById(jid);
        model.addAttribute("journal", journal);
        List<SoftCopy> softCopies=softCopyServices.findRelatedSoftCopy(journal.getItid());
        model.addAttribute("softcopies", UniqueSoftCopyHandler.filterSoftCopies(softCopies));
        return "journalDetails";
    }

    @GetMapping("/magazines/{mid}")
    public String getSingleMagazineById(@PathVariable("mid")String mid,Model model){
        Magazines magazine=magazinesServices.findSingleMagazineById(mid);
        model.addAttribute("magazine", magazine);
        List<SoftCopy> softCopies=softCopyServices.findRelatedSoftCopy(magazine.getItid());
        model.addAttribute("softcopies", UniqueSoftCopyHandler.filterSoftCopies(softCopies));
        return "magazineDetails";
    }

    @GetMapping("/theses/{tid}")
    public String getSingleThesesById(@PathVariable("tid")String tid,Model model){
        Theses theses=thesesServices.findSingleThesesById(tid);
        model.addAttribute("theses", theses);
        List<SoftCopy> softCopies=softCopyServices.findRelatedSoftCopy(theses.getItid());
        model.addAttribute("softcopies", UniqueSoftCopyHandler.filterSoftCopies(softCopies));
        return "thesesDetails";
    }

    @GetMapping("/softcopy/{sid}")
    public String getSingleSoftCopyById(@PathVariable("sid")String sid,Model model){
        SoftCopy softcopy=softCopyServices.findSingleSoftCopyById(sid);
        model.addAttribute("softcopy", softcopy);
        return "softCopyDetails";
    }

    @GetMapping("/filter")
    public String getItemByFilter(String searchParam,@RequestParam Map<String,String> filters,Model model){
        String type=filters.get("itemtype");
        if(searchParam!=null){
            return "redirect:/"+type+"/search?searchParam="+searchParam;
        }
        
        String query="SELECT * FROM "+type;
        String whereOrand=" WHERE";
        for (Map.Entry<String,String> filter : filters.entrySet()) {
            if(!filter.getValue().equals("") && !filter.getKey().equals("itemtype")){
                query=query+whereOrand+" "+filter.getKey()+" like '%"+filter.getValue()+"%'";
                whereOrand=" and";
            }
        }
        if (type.equals("books")) {
            List<Books> books=customQueryServices.executeCustomQuery(query, Books.class);
            model.addAttribute("books", books);
        } else if (type.equals("journals")) {
            List<Journals> journals=customQueryServices.executeCustomQuery(query, Journals.class);
            model.addAttribute("journals", journals);
        } else if (type.equals("theses")) {
            List<Theses> theses=customQueryServices.executeCustomQuery(query, Theses.class);
            model.addAttribute("theses", theses);
        } else if (type.equals("magazines")) {
            List<Magazines> magazines=customQueryServices.executeCustomQuery(query, Magazines.class);
            model.addAttribute("magazines", magazines);
        } else if (type.equals("softcopy")) {
            List<SoftCopy> softcopies=customQueryServices.executeCustomQuery(query, SoftCopy.class);
            model.addAttribute("softcopies", softcopies);
        } else {
            // Handle unknown type
            System.out.println("Unknown type");
        }
        System.out.println(query);
        model.addAttribute("type", type);
        model.addAttribute("filtersearches", filters);
        return "searchResult";
    }
}
