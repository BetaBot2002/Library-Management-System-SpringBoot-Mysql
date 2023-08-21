package com.lms.librarymanagementsystem.controllers;

import java.util.*;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.fasterxml.jackson.core.JsonProcessingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.SessionHandler;
import com.lms.librarymanagementsystem.models.Books;
import com.lms.librarymanagementsystem.models.Borrow;
import com.lms.librarymanagementsystem.models.Connector;
import com.lms.librarymanagementsystem.models.Downloads;
import com.lms.librarymanagementsystem.models.Fine;
import com.lms.librarymanagementsystem.models.Journals;
import com.lms.librarymanagementsystem.models.Magazines;
import com.lms.librarymanagementsystem.models.Payment;
import com.lms.librarymanagementsystem.models.SoftCopy;
import com.lms.librarymanagementsystem.models.Theses;
import com.lms.librarymanagementsystem.models.Users;
import com.lms.librarymanagementsystem.services.BooksServices;
import com.lms.librarymanagementsystem.services.BorrowServices;
import com.lms.librarymanagementsystem.services.ConnectorServices;
import com.lms.librarymanagementsystem.services.DownloadsServices;
import com.lms.librarymanagementsystem.services.FineServices;
import com.lms.librarymanagementsystem.services.JournalsServices;
import com.lms.librarymanagementsystem.services.MagazinesServices;
import com.lms.librarymanagementsystem.services.PaymentServices;
import com.lms.librarymanagementsystem.services.SoftCopyServices;
import com.lms.librarymanagementsystem.services.ThesesServices;
import com.lms.librarymanagementsystem.services.UsersServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/user")
public class UserController {
    private UsersServices usersServices;
    private BorrowServices borrowServices;
    private FineServices fineServices;
    private BooksServices booksServices;
    private ConnectorServices connectorServices;
    private JournalsServices journalsServices;
    private MagazinesServices magazinesServices;
    private ThesesServices thesesServices;
    private SoftCopyServices softCopyServices;
    private DownloadsServices downloadsServices;
    private PaymentServices paymentServices;


    public UserController(UsersServices usersServices,BorrowServices borrowServices,FineServices fineServices,BooksServices booksServices,
    ConnectorServices connectorServices, JournalsServices journalsServices, MagazinesServices magazinesServices,
    ThesesServices thesesServices,SoftCopyServices softCopyServices,DownloadsServices downloadsServices,PaymentServices paymentServices) {
        this.usersServices = usersServices;
        this.borrowServices=borrowServices;
        this.fineServices=fineServices;
        this.booksServices = booksServices;
        this.connectorServices = connectorServices;
        this.journalsServices = journalsServices;
        this.magazinesServices = magazinesServices;
        this.thesesServices = thesesServices;
        this.downloadsServices = downloadsServices;
        this.softCopyServices = softCopyServices;
        this.paymentServices = paymentServices;
    }

    @GetMapping
    public String getProfile(HttpServletRequest req,Model model){
        System.out.println(SessionHandler.getUserSession(req));
        System.out.println(SessionHandler.getAccessSession(req));
        Users user=usersServices.findUserByUsername(SessionHandler.getUserSession(req));
        List<Fine> fines=fineServices.findUnpaidFineByUsername(SessionHandler.getUserSession(req));
        Integer totalFine=0;
        for(Fine fine:fines){
            totalFine+=fine.getAmount();
        }
        List<Journals> journals=journalsServices.findLastTwoJournals();
        List<Books> books=booksServices.findLastTwoBooks();
        List<Magazines> magazines=magazinesServices.findLastTwoMagazines();
        List<Theses> theses=thesesServices.findLastTwoTheses();
        List<SoftCopy> softCopies=softCopyServices.findLastTwoSoftCopies();



        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("user", user);
        model.addAttribute("fine", totalFine);
        return "userPanel";
    }

    @PostMapping("/checkborrow")
    public ResponseEntity<String> checkBorrow(String itid,HttpServletRequest req){
        String username=SessionHandler.getUserSession(req);
        Map<String, String> keyValue = new HashMap<>();
        keyValue.put("status", "true");
        keyValue.put("message", "Can borrow");
        // String returnString="true";
        if(!borrowServices.findRequestedReturnByItidUsername(itid,username).isEmpty()){
            keyValue.put("status", "false");
            keyValue.put("message", "Your Return Request Hasn't Been Approved Yet.");
        }else if(!borrowServices.findApprovedUnReturnedByItidUsername(itid,username).isEmpty()){
            keyValue.put("status", "false");
            keyValue.put("message", "You have already Borrowed this item.");
        }else if(!borrowServices.findReturnRejectedByItidByUsername(itid,username).isEmpty()){
            keyValue.put("status", "false");
            keyValue.put("message", "Your return for this item is rejected.");
        }else if(!borrowServices.findUnReturnedByItidByUsername(itid,username).isEmpty()){
            keyValue.put("status", "false");
            keyValue.put("message", "You Borrow request haven't been approved yet.");
        }else if(borrowServices.findUnReturnedByUsername(username).size()==2 || borrowServices.findNotReturnedRequestedListByUsername(username).size()==2){
            keyValue.put("status", "false");
            keyValue.put("message", "You have already Borrowed Two Items.");
        }else if(!fineServices.findUnpaidFineByUsername(username).isEmpty()){
            keyValue.put("status", "false");
            keyValue.put("message", "You have a fine.");
        }else if(!usersServices.getInactiveUsers(username).isEmpty()){
            keyValue.put("status", "false");
            keyValue.put("message", "The membership has expired");
        }
        ObjectMapper objectMapper = new ObjectMapper();
        String json="";
        try {
            json = objectMapper.writeValueAsString(keyValue);
        } catch (JsonProcessingException e) {
            e.printStackTrace();
        }
        return new ResponseEntity<String>(json,HttpStatus.OK);
    }

    @PostMapping("/borrow")
    public ResponseEntity<String> borrowItem(Borrow borrow,HttpServletRequest req){
        borrow.setUsername(SessionHandler.getUserSession(req));
        System.out.println(borrow);
        borrowServices.inserOneBorrow(borrow);
        String type=connectorServices.getType(borrow.getitid());
        if(type.equals("book")){
            booksServices.decreaseStock(borrow.getitid());
        }else if(type.equals("journal")){
            journalsServices.decreaseStock(borrow.getitid());
        }else if(type.equals("magazine")){
            magazinesServices.decreaseStock(borrow.getitid());
        }else{
            thesesServices.decreaseStock(borrow.getitid());
        }
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @PostMapping("/return")
    public ResponseEntity<String> returnItem(String itid,HttpServletRequest req){
        borrowServices.performReturn(SessionHandler.getUserSession(req), itid);
        return new ResponseEntity<String>("true",HttpStatus.OK);
    }

    @PostMapping("/downloads")
    public ResponseEntity<String> insertDownloads(Downloads download,HttpServletRequest req){
        download.setUsername(SessionHandler.getUserSession(req));
        System.out.println(download);
        downloadsServices.insertOneDownloads(download);
        return new ResponseEntity<String>("true", HttpStatus.ACCEPTED);
    }

    @GetMapping("/downloads")
    public String viewDownloads(HttpServletRequest req,Model model){
        List<String> SID=downloadsServices.findSidByUsername(SessionHandler.getUserSession(req));
        Set<String> uniqueSid = new HashSet<String>();
        for (String sid : SID) {
            uniqueSid.add(sid);
        }
        List<SoftCopy> softCopies = new ArrayList<SoftCopy>();
        for (String sid : uniqueSid) {
            softCopies.add(softCopyServices.findSingleSoftCopyById(sid));
        }
        System.out.println(softCopies);
        model.addAttribute("softcopies", softCopies);
        return "Downloads";
    }

    @GetMapping("/borrowed/current")
    public String viewCurrentlyBorrowedBooks(HttpServletRequest req, Model model){
        List<Borrow> borrows = borrowServices.findNotReturnedRequestedListByUsername(SessionHandler.getUserSession(req));
        // List<Connector> connectors=new ArrayList<>();
        Set<Connector> connectors = new HashSet<Connector>();
        for(Borrow borrow:borrows){
            connectors.add(connectorServices.getConnectorByItid(borrow.getitid()));
        }
        List<Journals> journals=new ArrayList<>();
        List<Books> books=new ArrayList<>();
        List<Magazines> magazines=new ArrayList<>();
        List<Theses> theses=new ArrayList<>();
        for(Connector connector:connectors){
            if(connector.getType().equals("book")){
                books.add(booksServices.findOneBookByItid(connector.getItid()));
            }else if(connector.getType().equals("journal")){
                journals.add(journalsServices.findOneJournalByItid(connector.getItid()));
            }else if(connector.getType().equals("theses")){
                theses.add(thesesServices.findOneThesesByItid(connector.getItid()));
            }else if(connector.getType().equals("magazine")){
                magazines.add(magazinesServices.findOneMagazineByItid(connector.getItid()));
            }
        }

        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);
        model.addAttribute("borrows", borrows);

        return "UserBorrows";
    }

    @GetMapping("/borrowed/previous")
    public String viewPreviouslyBorrowedBooks(HttpServletRequest req, Model model){
        List<Borrow> borrows = borrowServices.findReturnedOrRejectedListByUsername(SessionHandler.getUserSession(req));
        Set<Connector> connectors = new HashSet<Connector>();
        for(Borrow borrow:borrows){
            connectors.add(connectorServices.getConnectorByItid(borrow.getitid()));
        }
        List<Journals> journals=new ArrayList<>();
        List<Books> books=new ArrayList<>();
        List<Magazines> magazines=new ArrayList<>();
        List<Theses> theses=new ArrayList<>();
        for(Connector connector:connectors){
            if(connector.getType().equals("book")){
                books.add(booksServices.findOneBookByItid(connector.getItid()));
            }else if(connector.getType().equals("journal")){
                journals.add(journalsServices.findOneJournalByItid(connector.getItid()));
            }else if(connector.getType().equals("theses")){
                theses.add(thesesServices.findOneThesesByItid(connector.getItid()));
            }else if(connector.getType().equals("magazine")){
                magazines.add(magazinesServices.findOneMagazineByItid(connector.getItid()));
            }
        }

        model.addAttribute("books", books);
        model.addAttribute("journals", journals);
        model.addAttribute("magazines", magazines);
        model.addAttribute("theses", theses);

        return "UserBorrows";
    }

    // 

    @GetMapping("/payment")
    public String getPaymentForm(Model model,HttpServletRequest req){
        List<Fine> fines=fineServices.findUnpaidFineByUsername(SessionHandler.getUserSession(req));
        List<Borrow> borrows=borrowServices.findFinableBorrowByUsername(SessionHandler.getUserSession(req));
        List<Borrow> finedRequested=borrowServices.findFinedRequestedReturn(SessionHandler.getUserSession(req));
        Integer totalFine=0;
        for(Fine fine:fines){
            totalFine+=fine.getAmount();
        }
        Integer renewal=300;
        List<Payment> finepayments=paymentServices.findPendingFinePaymentByUsername(SessionHandler.getUserSession(req));
        List<Payment> renewalpayments=paymentServices.findPendingRenewalPaymentByUsername(SessionHandler.getUserSession(req));
        model.addAttribute("pending", !(finepayments.isEmpty()&&renewalpayments.isEmpty()));
        model.addAttribute("fine", totalFine);
        model.addAttribute("renewal", renewal);
        model.addAttribute("borrows", borrows);
        model.addAttribute("finedRequested", finedRequested);
        return "payment";
    }

    @PostMapping("/payment/fine")
    public ResponseEntity<String> payFine(Payment payment,HttpServletRequest req){
        payment.setUsername(SessionHandler.getUserSession(req));
        payment.setPaydate(DateHandler.getCurrentDate());
        payment.setType("fine");
        payment.setApproved("pending");
        paymentServices.insertOnePayment(payment);
        fineServices.updateFineToRequested(SessionHandler.getUserSession(req));
        return new ResponseEntity<String>("true", HttpStatus.ACCEPTED);
    }

    @PostMapping("/payment/renewal")
    public ResponseEntity<String> payRenewal(Payment payment,HttpServletRequest req){
        payment.setUsername(SessionHandler.getUserSession(req));
        payment.setPaydate(DateHandler.getCurrentDate());
        payment.setType("renewal");
        payment.setApproved("pending");
        paymentServices.insertOnePayment(payment);
        fineServices.updateFineToRequested(SessionHandler.getUserSession(req));
        return new ResponseEntity<String>("true", HttpStatus.ACCEPTED);
    }

    @GetMapping("/librarycard")
    public String libraryCard() {
        return "libraryCard";
    }
}
