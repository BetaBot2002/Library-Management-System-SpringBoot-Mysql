package com.lms.librarymanagementsystem.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.multipart.MultipartFile;

import com.lms.librarymanagementsystem.Handlers.FileHandler;
import com.lms.librarymanagementsystem.Handlers.SessionHandler;
import com.lms.librarymanagementsystem.models.Admin;
import com.lms.librarymanagementsystem.models.Alternative;
import com.lms.librarymanagementsystem.models.BookDonations;
import com.lms.librarymanagementsystem.models.Books;
import com.lms.librarymanagementsystem.models.Borrow;
import com.lms.librarymanagementsystem.models.Connector;
import com.lms.librarymanagementsystem.models.JournalDonations;
import com.lms.librarymanagementsystem.models.Journals;
import com.lms.librarymanagementsystem.models.MagazineDonations;
import com.lms.librarymanagementsystem.models.Magazines;
import com.lms.librarymanagementsystem.models.Payment;
import com.lms.librarymanagementsystem.models.Registration;
import com.lms.librarymanagementsystem.models.SoftCopy;
import com.lms.librarymanagementsystem.models.SoftCopyDonations;
import com.lms.librarymanagementsystem.models.Theses;
import com.lms.librarymanagementsystem.models.ThesesDonations;
import com.lms.librarymanagementsystem.models.Users;
import com.lms.librarymanagementsystem.services.AdminServices;
import com.lms.librarymanagementsystem.services.AlternativeServices;
import com.lms.librarymanagementsystem.services.BooksDonationServices;
import com.lms.librarymanagementsystem.services.BooksServices;
import com.lms.librarymanagementsystem.services.BorrowServices;
import com.lms.librarymanagementsystem.services.ConnectorServices;
import com.lms.librarymanagementsystem.services.EmailServices;
import com.lms.librarymanagementsystem.services.FineServices;
import com.lms.librarymanagementsystem.services.JournalDonationServices;
import com.lms.librarymanagementsystem.services.JournalsServices;
import com.lms.librarymanagementsystem.services.MagazineDonationServices;
import com.lms.librarymanagementsystem.services.MagazinesServices;
import com.lms.librarymanagementsystem.services.PaymentServices;
import com.lms.librarymanagementsystem.services.RegistrationServices;
import com.lms.librarymanagementsystem.services.SoftCopyDonationServices;
import com.lms.librarymanagementsystem.services.SoftCopyServices;
import com.lms.librarymanagementsystem.services.ThesesDonationServices;
import com.lms.librarymanagementsystem.services.ThesesServices;
import com.lms.librarymanagementsystem.services.UsersServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/admin")
public class AdminController {
    private RegistrationServices registrationServices;
    private UsersServices usersServices;
    private EmailServices emailServices;
    private AlternativeServices alternativeServices;
    private BooksServices booksServices;
    private ConnectorServices connectorServices;
    private JournalsServices journalsServices;
    private MagazinesServices magazinesServices;
    private ThesesServices thesesServices;
    private SoftCopyServices softCopyServices;
    private AdminServices adminServices;
    private BorrowServices borrowServices;
    private PaymentServices paymentServices;
    private FineServices fineServices;
    private BooksDonationServices booksDonationServices;
    private ThesesDonationServices thesesDonationServices;
    private JournalDonationServices journalDonationServices;
    private MagazineDonationServices magazineDonationServices;
    private SoftCopyDonationServices softCopyDonationServices;

    public AdminController(RegistrationServices registrationServices, UsersServices usersServices,
            EmailServices emailServices, AlternativeServices alternativeServices, BooksServices booksServices,
            ConnectorServices connectorServices, JournalsServices journalsServices, MagazinesServices magazinesServices,
            ThesesServices thesesServices, SoftCopyServices softCopyServices, AdminServices adminServices,
            BorrowServices borrowServices, PaymentServices paymentServices, FineServices fineServices,
            BooksDonationServices booksDonationServices,
            ThesesDonationServices thesesDonationServices, JournalDonationServices journalDonationServices,
            MagazineDonationServices magazineDonationServices, SoftCopyDonationServices softCopyDonationServices) {
        this.registrationServices = registrationServices;
        this.usersServices = usersServices;
        this.emailServices = emailServices;
        this.alternativeServices = alternativeServices;
        this.booksServices = booksServices;
        this.connectorServices = connectorServices;
        this.journalsServices = journalsServices;
        this.magazinesServices = magazinesServices;
        this.thesesServices = thesesServices;
        this.softCopyServices = softCopyServices;
        this.adminServices = adminServices;
        this.borrowServices = borrowServices;
        this.paymentServices = paymentServices;
        this.fineServices = fineServices;
        this.booksDonationServices = booksDonationServices;
        this.journalDonationServices = journalDonationServices;
        this.thesesDonationServices = thesesDonationServices;
        this.magazineDonationServices = magazineDonationServices;
        this.softCopyDonationServices = softCopyDonationServices;
    }

    @GetMapping
    public String getProfile(HttpServletRequest req, Model model) {
        // System.out.println(SessionHandler.getUserSession(req));
        // System.out.println(SessionHandler.getAccessSession(req));
        List<Registration> top5Registrations = registrationServices.findTopPendings();
        List<Registration> registrations = registrationServices.findAllPending();
        List<Borrow> borrows = borrowServices.findPendingBorrows();
        List<Borrow> returns = borrowServices.findPendingReturns();
        List<Payment> fines = paymentServices.findPendingFinePayment();
        List<Payment> renewals = paymentServices.findPendingRenewalPayment();

        List<BookDonations> bookDonations = booksDonationServices.findPendingBookDonations();
        List<JournalDonations> journalDonations = journalDonationServices.findPendingjournalDonations();
        List<ThesesDonations> thesesDonations = thesesDonationServices.findPendingThesesDonations();
        List<MagazineDonations> magazineDonations = magazineDonationServices.findPendingMagazineDonations();
        List<SoftCopyDonations> softCopyDonations = softCopyDonationServices.findPendingSoftCopyDonations();

        model.addAttribute("registrations", top5Registrations);
        model.addAttribute("noOfRegistrations", registrations.size());
        model.addAttribute("borrows", borrows);
        model.addAttribute("noOfPendingBorrow", borrows.size());
        model.addAttribute("noOfPendingReturn", returns.size());
        model.addAttribute("noOfPendingFines", fines.size());
        model.addAttribute("noOfPendingRenewals", renewals.size());
        model.addAttribute("pendingDonations", bookDonations.size() + journalDonations.size() + thesesDonations.size()
                + magazineDonations.size() + softCopyDonations.size());
        model.addAttribute("title", "Dashboard");
        System.out.println(top5Registrations);
        return "adminPanel";
    }

    @GetMapping("/viewpending/paid")
    public String viewPaidRegistration(Model model) {
        List<Registration> registrations = registrationServices.getPending("paid");
        model.addAttribute("registrations", registrations);
        model.addAttribute("category", "Paid");
        return "pendingRegistrations";
    }

    @GetMapping("/viewpending/bookdonations")
    public String viewPendingBookDonations(Model model) {
        List<BookDonations> bookDonations = booksDonationServices.findPendingBookDonations();
        model.addAttribute("bookDonations", bookDonations);
        return "pendingBookDonations";
    }

    @GetMapping("/viewpending/journaldonations")
    public String viewPendingJournalDonations(Model model) {
        List<JournalDonations> journalDonations = journalDonationServices.findPendingjournalDonations();
        model.addAttribute("journalDonations", journalDonations);
        return "pendingJournalDonations";
    }

    @GetMapping("/viewpending/magazinedonations")
    public String viewPendingMagazineDonations(Model model) {
        List<MagazineDonations> magazineDonations = magazineDonationServices.findPendingMagazineDonations();
        model.addAttribute("magazineDonations", magazineDonations);
        return "pendingMagazineDonations";
    }

    @GetMapping("/viewpending/thesesdonations")
    public String viewPendingThesesDonations(Model model) {
        List<ThesesDonations> thesesDonations = thesesDonationServices.findPendingThesesDonations();
        model.addAttribute("thesesDonations", thesesDonations);
        return "pendingThesesDonations";
    }

    @GetMapping("/viewpending/softcopydonations")
    public String viewPendingSoftCopyDonations(Model model) {
        List<SoftCopyDonations> softCopyDonations = softCopyDonationServices.findPendingSoftCopyDonations();
        model.addAttribute("softCopyDonations", softCopyDonations);
        return "pendingSoftCopyDonations";
    }

    @GetMapping("/addDonatedBooks/{bdnid}")
    public String viewOneBookDonationDetails(@PathVariable Integer bdnid, Model model) {
        System.out.println(bdnid);
        BookDonations bookDonation = booksDonationServices.findSingleBookDonations(bdnid);
        model.addAttribute("activity", "donation");
        model.addAttribute("bookdonation", bookDonation);
        booksDonationServices.updateDonationToApproved(bdnid);
        return "books";
    }

    @GetMapping("/addDonatedJournals/{jdnid}")
    public String viewOneJournalDonationDetails(@PathVariable Integer jdnid, Model model) {
        System.out.println(jdnid);
        JournalDonations journalDonation = journalDonationServices.findSingleJournalDonations(jdnid);
        model.addAttribute("activity", "donation");
        model.addAttribute("journaldonation", journalDonation);
        journalDonationServices.updateDonationToApproved(jdnid);
        return "journals";
    }

    @GetMapping("/addDonatedMagazines/{mdnid}")
    public String viewOneMagazineDonationDetails(@PathVariable Integer mdnid, Model model) {
        System.out.println(mdnid);
        MagazineDonations magazineDonation = magazineDonationServices.findSingleMagazineDonations(mdnid);
        model.addAttribute("activity", "donation");
        model.addAttribute("magazinedonation", magazineDonation);
        magazineDonationServices.updateDonationToApproved(mdnid);
        return "magazines";
    }

    @GetMapping("/addDonatedTheses/{tdnid}")
    public String viewOneThesesDonationDetails(@PathVariable Integer tdnid, Model model) {
        System.out.println(tdnid);
        ThesesDonations thesesDonation = thesesDonationServices.findSingleThesesDonations(tdnid);
        model.addAttribute("activity", "donation");
        model.addAttribute("thesesdonation", thesesDonation);
        thesesDonationServices.updateDonationToApproved(tdnid);
        return "theses";
    }

    @GetMapping("/addDonatedSoftcopies/{sdnid}")
    public String viewOneSoftCopyDonationDetails(@PathVariable Integer sdnid, Model model) {
        System.out.println(sdnid);
        SoftCopyDonations softCopyDonation = softCopyDonationServices.findSingleJournalDonations(sdnid);
        model.addAttribute("activity", "donation");
        model.addAttribute("softCopyDonation", softCopyDonation);
        softCopyDonationServices.updateDonationToApproved(sdnid);
        return "Softcopy";
    }

    
    @GetMapping("/rejectDonatedBooks/{bdnid}")
    public String rejectOneBookDonation(@PathVariable Integer bdnid) {
        System.out.println(bdnid);
        booksDonationServices.updateDonationToRejection(bdnid);
        return "redirect:/admin/viewpending/bookdonations";
    }
    
    @GetMapping("/rejectDonatedJournals/{jdnid}")
    public String rejectOneJournalDonation(@PathVariable Integer jdnid) {
        System.out.println(jdnid);
        journalDonationServices.updateDonationToRejection(jdnid);
        return "redirect:/admin/viewpending/journaldonations";
    }
    
    @GetMapping("/rejectDonatedTheses/{tdnid}")
    public String rejectOneThesesDonation(@PathVariable Integer tdnid) {
        System.out.println(tdnid);
        thesesDonationServices.updateDonationToRejection(tdnid);
        return "redirect:/admin/viewpending/thesesdonations";
    }
    
    @GetMapping("/rejectDonatedMagazines/{mdnid}")
    public String rejectOneMagazineDonation(@PathVariable Integer mdnid) {
        System.out.println(mdnid);
        magazineDonationServices.updateDonationToRejection(mdnid);
        return "redirect:/admin/viewpending/magazinedonations";
    }
    
    @GetMapping("/rejectDonatedSoftcopies/{sdnid}")
    public String rejectOneSoftcopyDonation(@PathVariable Integer sdnid) {
        System.out.println(sdnid);
        softCopyDonationServices.updateDonationToRejection(sdnid);
        return "redirect:/admin/viewpending/softcopydonations";
    }

    @GetMapping("/viewpending/unpaid")
    public String viewUnPaidRegistration(Model model) {
        List<Registration> registrations = registrationServices.getPending("unpaid");
        model.addAttribute("registrations", registrations);
        model.addAttribute("category", "Unpaid");
        return "pendingRegistrations";
    }

    @PostMapping("/approveuser")
    public String approveUser(Integer rsid, String pay, String membershipexpire, String libraryCard) {
        registrationServices.updateApproval("approved", rsid);
        Registration registration = registrationServices.getOneRegistration(rsid);
        usersServices.insertOnUser(new Users(registration.getUsername(), registration.getPassword(),
                registration.getProfilePicture(), registration.getFirstName(), registration.getLastName(),
                registration.getGender(), registration.getDob(), registration.getPhone(), registration.getEmail(),
                registration.getCategory(), "active", membershipexpire), libraryCard);
        return "redirect:./viewpending/" + pay.toLowerCase();
    }

    @PostMapping("/rejectuser")
    public String rejectUser(Integer rsid, String message, String pay) {
        Registration registration = registrationServices.getOneRegistration(rsid);
        String content = "Dear " + registration.getFirstName() + ",\n\n" +
                "On the behalf of our library, we are writing to inform you that your registration request for our library system has been rejected. We regret to inform you that we are unable to approve your registration at this time.\n\n"
                +
                "We apologize for any inconvenience this may have caused, and we would like to explain the reasons for our decision. "
                + message + "\n\n"
                +
                "If you have any questions or concerns regarding our decision, please don't hesitate to contact us. We are always here to help.\n\n"
                +
                "Thank you for your interest in our library system, and we wish you all the best in your future endeavors.\n\n"
                +
                "Sincerely,\n\n" +
                "Library Authorities";
        emailServices.sendMail(registration.getEmail(), "Rejection of Library User Registration", content);
        registrationServices.updateApproval("rejected", rsid);
        return "redirect:./viewpending/" + pay.toLowerCase();
    }

    @GetMapping("/addbook")
    public String getBookForm(Model model) {
        model.addAttribute("activity", "add");
        return "books";
    }

    @PostMapping("/addbook")
    public String insertBook(Books book, MultipartFile thumbnailfile) {
        connectorServices.insertOneConnector(new Connector(book.getItid(), "book"));
        Books bookInserted = booksServices.insertOneBook(book, thumbnailfile);
        return "redirect:/search/books/" + bookInserted.getBid();
    }

    @GetMapping("/addjournal")
    public String getJournalForm(Model model) {
        model.addAttribute("activity", "add");
        return "journals";
    }

    @PostMapping("/addjournal")
    public String insertJournal(Journals journal, MultipartFile thumbnailfile) {
        connectorServices.insertOneConnector(new Connector(journal.getItid(), "journal"));
        Journals journalInserted = journalsServices.insertOneJournal(journal, thumbnailfile);
        return "redirect:/search/journals/" + journalInserted.getJid();
    }

    @GetMapping("/addtheses")
    public String getThesesForm(Model model) {
        model.addAttribute("activity", "add");
        return "theses";
    }

    @PostMapping("/addtheses")
    public String insertTheses(Theses theses, MultipartFile thumbnailfile) {
        connectorServices.insertOneConnector(new Connector(theses.getItid(), "theses"));
        Theses thesesInserted = thesesServices.insertOneTheses(theses, thumbnailfile);
        return "redirect:/search/theses/" + thesesInserted.getTid();

    }

    @GetMapping("/addmagazine")
    public String getMagazineForm(Model model) {
        model.addAttribute("activity", "add");
        return "magazines";
    }

    @PostMapping("/addmagazine")
    public String insertMagazine(Magazines magazine, MultipartFile thumbnailfile) {
        connectorServices.insertOneConnector(new Connector(magazine.getItid(), "magazine"));
        Magazines magazineInserted = magazinesServices.insertOneMagazine(magazine, thumbnailfile);
        return "redirect:/search/magazines/" + magazineInserted.getMid();

    }

    @GetMapping("/addsoftcopy")
    public String getSoftCopyForm(Model model) {
        model.addAttribute("activity", "add");
        return "Softcopy";
    }

    @PostMapping("/addsoftcopy")
    public String insertSoftCopy(SoftCopy softCopy, MultipartFile file, MultipartFile thumbnailfile) {
        SoftCopy softcopyInserted = softCopyServices.insertOneSoftCopy(softCopy, file, thumbnailfile);
        return "redirect:/search/softcopy/" + softcopyInserted.getSid();

    }

    @GetMapping("/addalternative")
    public String getAlternativeForm(Model model) {
        model.addAttribute("activity", "add");
        return "alternative";
    }

    @PostMapping("/addalternative")
    public String insertAlternative(Model model, String itid, String... sids) {
        for (String sid : sids) {
            if (!sid.equals("")) {
                alternativeServices.insertOneAlternative(new Alternative(null, itid, sid));
            }
        }
        Connector connector = connectorServices.getConnectorByItid(itid);
        String redirect = "redirect:/search/";
        if (connector.getType().equals("book")) {
            Books book = booksServices.findOneBookByItid(itid);
            redirect += "books/" + book.getBid();
        } else if (connector.getType().equals("journal")) {
            Journals journal = journalsServices.findOneJournalByItid(itid);
            redirect += "journals/" + journal.getJid();
        } else if (connector.getType().equals("magazine")) {
            Magazines magazine = magazinesServices.findOneMagazineByItid(itid);
            redirect += "magazines/" + magazine.getMid();
        } else {
            Theses theses = thesesServices.findOneThesesByItid(itid);
            redirect += "theses/" + theses.getTid();
        }
        return redirect;
    }

    // Edit Routes

    @GetMapping("/edit/softcopy/{sid}")
    public String editSoftCopy(@PathVariable String sid, Model model) {
        SoftCopy softcopy = softCopyServices.findSingleSoftCopyById(sid);
        model.addAttribute("softcopy", softcopy);
        model.addAttribute("activity", "edit");
        System.out.println(softcopy);
        return "Softcopy";
    }

    @PostMapping("/edit/softcopy")
    public String editSoftCopySave(SoftCopy softCopy, MultipartFile file, MultipartFile thumbnailfile) {
        softCopyServices.insertOneSoftCopy(softCopy, file, thumbnailfile);
        return "redirect:/search/softcopy/" + softCopy.getSid();
    }

    @GetMapping("/edit/books/{bid}")
    public String editBooksCopy(@PathVariable String bid, Model model) {
        Books book = booksServices.findSingleBook(bid);
        model.addAttribute("book", book);
        model.addAttribute("activity", "edit");
        return "books";
    }

    @PostMapping("/edit/books")
    public String editBooksCopySave(Books books, MultipartFile thumbnailfile) {
        booksServices.insertOneBook(books, thumbnailfile);
        return "redirect:/search/books/" + books.getBid();
    }

    @GetMapping("/edit/journals/{jid}")
    public String editJournalsCopy(@PathVariable String jid, Model model) {
        Journals journals = journalsServices.findSingleJournalById(jid);
        model.addAttribute("journal", journals);
        model.addAttribute("activity", "edit");
        return "journals";
    }

    @PostMapping("/edit/journals")
    public String editJournalsCopySave(Journals journals, MultipartFile thumbnailfile) {
        journalsServices.insertOneJournal(journals, thumbnailfile);
        return "redirect:/search/journals/" + journals.getJid();
    }

    @GetMapping("/edit/theses/{tid}")
    public String editThesesCopy(@PathVariable String tid, Model model) {
        Theses theses = thesesServices.findSingleThesesById(tid);
        model.addAttribute("theses", theses);
        model.addAttribute("activity", "edit");
        return "theses";
    }

    @PostMapping("/edit/theses")
    public String editThesesCopySave(Theses theses, MultipartFile thumbnailfile) {
        thesesServices.insertOneTheses(theses, thumbnailfile);
        return "redirect:/search/theses/" + theses.getTid();
    }

    @GetMapping("/edit/magazines/{mid}")
    public String editMagazinesCopy(@PathVariable String mid, Model model) {
        Magazines magazines = magazinesServices.findSingleMagazineById(mid);
        model.addAttribute("magazine", magazines);
        model.addAttribute("activity", "edit");
        return "magazines";
    }

    @PostMapping("/edit/magazines")
    public String editMagazinesCopySave(Magazines magazines, MultipartFile thumbnailfile) {
        magazinesServices.insertOneMagazine(magazines, thumbnailfile);
        return "redirect:/search/magazines/" + magazines.getMid();
    }

    @GetMapping("/delete/item/{itid}")
    public String deleteSingleBookById(@PathVariable String itid) {
        String currentDirectory = System.getProperty("user.dir");
        Connector connector = connectorServices.getConnectorByItid(itid);
        if (connector.getType().equals("book")) {
            Books book = booksServices.findOneBookByItid(itid);
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + book.getThumbnail());
        } else if (connector.getType().equals("journal")) {
            Journals journal = journalsServices.findOneJournalByItid(itid);
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + journal.getThumbnail());

        } else if (connector.getType().equals("magazine")) {
            Magazines magazine = magazinesServices.findOneMagazineByItid(itid);
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + magazine.getThumbnail());

        } else {
            Theses theses = thesesServices.findOneThesesByItid(itid);
            FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + theses.getThumbnail());
        }
        connectorServices.deleteSingleItemByItid(itid);
        return "redirect:/search/searchitem?searchParam=";
    }

    @GetMapping("/delete/softcopy/{sid}")
    public String deleteSingleSoftCopyBySId(@PathVariable String sid) {
        String currentDirectory = System.getProperty("user.dir");
        SoftCopy softCopy=softCopyServices.findSingleSoftCopyById(sid);
        FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\thumbnails\\" + softCopy.getThumbnail());
        FileHandler.deleteFile(currentDirectory + "\\src\\main\\webapp\\uploads\\SoftCopy\\" + softCopy.getFilename());
        softCopyServices.deleteSoftcopyBySid(sid);
        return "redirect:/search/searchitem?searchParam=";
    }

    @GetMapping("/pendingborrow")
    public String getPendingBorrowTable(Model model) {
        List<Borrow> borrows = borrowServices.findPendingBorrows();
        model.addAttribute("borrows", borrows);
        return "pendingBorrows";
    }

    @GetMapping("/pendingreturn")
    public String getPendingReturnTable(Model model) {
        List<Borrow> returns = borrowServices.findPendingReturns();
        model.addAttribute("returns", returns);
        return "pendingReturns";
    }

    @PostMapping("/borrowaction")
    public ResponseEntity<String> performBorrowAction(String action, String itid, String username) {
        borrowServices.performAction(action, username, itid);
        String type = connectorServices.getType(itid);
        if (action.equals("rejected")) {
            if (type.equals("book")) {
                booksServices.increaseStock(itid);
                Books book = booksServices.findOneBookByItid(itid);
                usersServices.sendBorrowRejection(username, book.getTitle() , type);
            } else if (type.equals("journal")) {
                journalsServices.increaseStock(itid);
                Journals journal = journalsServices.findOneJournalByItid(itid);
                usersServices.sendBorrowRejection(username, journal.getTitle(), type);
            } else if (type.equals("magazine")) {
                magazinesServices.increaseStock(itid);
                Magazines magazine = magazinesServices.findOneMagazineByItid(itid);
                usersServices.sendBorrowRejection(username, magazine.getTitle(), type);
            } else {
                thesesServices.increaseStock(itid);
                Theses theses = thesesServices.findOneThesesByItid(itid);
                usersServices.sendBorrowRejection(username, theses.getTitle(), type);
            }
        } else {
            if (type.equals("book")) {
                Books book = booksServices.findOneBookByItid(itid);
                usersServices.sendBorrowApproval(username, book.getTitle(), type);
            } else if (type.equals("journal")) {
                Journals journal = journalsServices.findOneJournalByItid(itid);
                usersServices.sendBorrowApproval(username, journal.getTitle(), type);
            } else if (type.equals("magazine")) {
                Magazines magazine = magazinesServices.findOneMagazineByItid(itid);
                usersServices.sendBorrowApproval(username, magazine.getTitle(), type);
            } else {
                Theses theses = thesesServices.findOneThesesByItid(itid);
                usersServices.sendBorrowApproval(username, theses.getTitle(), type);
            }
        }
        return new ResponseEntity<String>("true", HttpStatus.OK);
    }

    @PostMapping("/returnaction")
    public ResponseEntity<String> performReturn(String action, String itid, String username) {
        borrowServices.performReturnAction(action.equals("rejected") ? "return " + action : "returned", username, itid);
        String type = connectorServices.getType(itid);
        if (type.equals("book")) {
            booksServices.increaseStock(itid);
        } else if (type.equals("journal")) {
            journalsServices.increaseStock(itid);
        } else if (type.equals("magazine")) {
            magazinesServices.increaseStock(itid);
        } else {
            thesesServices.increaseStock(itid);
        }
        return new ResponseEntity<String>("true", HttpStatus.OK);
    }

    @GetMapping("/pendingfinepayments")
    public String showPendingFinePayments(Model model) {
        List<Payment> payments = paymentServices.findPendingFinePayment();
        model.addAttribute("payments", payments);
        model.addAttribute("type", "fine");
        return "pendingPayments";
    }

    @GetMapping("/pendingrenewalpayments")
    public String showPendingRenewalPayments(Model model) {
        List<Payment> payments = paymentServices.findPendingRenewalPayment();
        model.addAttribute("payments", payments);
        model.addAttribute("type", "renewal");
        return "pendingPayments";
    }

    @PostMapping("/finepaymentaction")
    public ResponseEntity<String> resolveFinePayment(String pid, String action, String username) {
        paymentServices.updatePayment(pid, action);
        fineServices.updateFineToAction(username, action.equals("rejected") ? action : "true");
        return new ResponseEntity<String>("true", HttpStatus.ACCEPTED);
    }

    @PostMapping("/renewalpaymentaction")
    public ResponseEntity<String> resolveRenewalPayment(String pid, String action, String username) {
        paymentServices.updatePayment(pid, action);
        if (action.equals("approved")) {
            usersServices.updateMembershipActive(username);
        }
        fineServices.updateFineToAction(username, action.equals("rejected") ? action : "true");
        return new ResponseEntity<String>("true", HttpStatus.ACCEPTED);
    }

    @PostMapping("/checkitid")
    public ResponseEntity<String> checkItid(String itid) {
        Connector connector = connectorServices.getConnectorByItid(itid);
        if (connector != null) {
            if (connector.getType().equals("book")) {
                return new ResponseEntity<String>(booksServices.findTitleByItid(itid), HttpStatus.OK);
            } else if (connector.getType().equals("journal")) {
                return new ResponseEntity<String>(journalsServices.findTitleByItid(itid), HttpStatus.OK);
            } else if (connector.getType().equals("theses")) {
                return new ResponseEntity<String>(thesesServices.findTitleByItid(itid), HttpStatus.OK);
            } else if (connector.getType().equals("magazine")) {
                return new ResponseEntity<String>(magazinesServices.findTitleByItid(itid), HttpStatus.OK);
            }
        }

        return new ResponseEntity<String>("false", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/checksid")
    public ResponseEntity<String> checkSid(String sid) {
        String title = softCopyServices.findTitleBySid(sid);
        if (title != null) {
            return new ResponseEntity<String>(title, HttpStatus.OK);
        }
        return new ResponseEntity<String>("false", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/getlatestitid")
    public ResponseEntity<String> findLatestItid() {
        System.out.println(connectorServices.getLatestItid());
        return new ResponseEntity<String>(connectorServices.getLatestItid(), HttpStatus.FOUND);
    }

    @GetMapping("/getlatestsid")
    public ResponseEntity<String> findLatestSID() {
        System.out.println(softCopyServices.getLatestSID());
        return new ResponseEntity<String>(softCopyServices.getLatestSID(), HttpStatus.FOUND);
    }

    @PostMapping("/add-admin")
    public String addAnotherAdmin(String username) {
        adminServices.insertOneAdmin(new Admin(username, "admin"));
        return "redirect:/login";
    }

    @PostMapping("/change-password")
    public String changPassword(String password, HttpServletRequest req) {
        String username = SessionHandler.getUserSession(req);
        adminServices.changePasswordByUsername(username, password);
        SessionHandler.deleteSession(req);
        return "redirect:/login";
    }
}
