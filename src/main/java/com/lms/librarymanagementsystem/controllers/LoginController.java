package com.lms.librarymanagementsystem.controllers;

import java.util.List;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.librarymanagementsystem.Handlers.DateHandler;
import com.lms.librarymanagementsystem.Handlers.EncryptionHandlers;
import com.lms.librarymanagementsystem.Handlers.OtpHandler;
import com.lms.librarymanagementsystem.Handlers.SessionHandler;
import com.lms.librarymanagementsystem.models.Admin;
import com.lms.librarymanagementsystem.models.Borrow;
import com.lms.librarymanagementsystem.models.Fine;
import com.lms.librarymanagementsystem.models.Registration;
import com.lms.librarymanagementsystem.models.Users;
import com.lms.librarymanagementsystem.services.AdminServices;
import com.lms.librarymanagementsystem.services.BorrowServices;
import com.lms.librarymanagementsystem.services.EmailServices;
import com.lms.librarymanagementsystem.services.FineServices;
import com.lms.librarymanagementsystem.services.RegistrationServices;
import com.lms.librarymanagementsystem.services.UsersServices;

import jakarta.servlet.http.HttpServletRequest;

@Controller
@RequestMapping("/login")
public class LoginController {
    private UsersServices usersServices;
    private RegistrationServices registrationServices;
    private AdminServices adminServices;
    private BorrowServices borrowServices;
    private FineServices fineServices;
    private EmailServices emailServices;

    public LoginController(UsersServices usersServices, RegistrationServices registrationServices,
            AdminServices adminServices, BorrowServices borrowServices, FineServices fineServices,
            EmailServices emailServices) {
        this.usersServices = usersServices;
        this.registrationServices = registrationServices;
        this.adminServices = adminServices;
        this.borrowServices = borrowServices;
        this.fineServices = fineServices;
        this.emailServices = emailServices;
    }

    @GetMapping
    public String getLoginForm() {
        return "login";
    }

    @PostMapping("/users")
    public ResponseEntity<String> userLogin(String username, String password, HttpServletRequest req) {
        Users user = usersServices.findUserByUsername(username);
        if (user != null && EncryptionHandlers.matches(password, user.getPassword())) {
            SessionHandler.setSession(req, username, "nonadmin");
            List<Borrow> borrows = borrowServices.findFinableBorrowByUsername(username);
            List<Fine> fines = fineServices.findUnpaidFineByUsername(username);
            if (!borrows.isEmpty() && fines.size() < borrows.size()) {
                fineServices.inserOneFine(new Fine(null, username, DateHandler.getCurrentDate(),
                        (borrows.size() - fines.size()) * 50, "false"));
            }
            return new ResponseEntity<String>("logged", HttpStatus.OK);
        }
        List<Registration> registrationspending = registrationServices.findUserByUsernamePending(username);
        if (!registrationspending.isEmpty()
                && EncryptionHandlers.matches(password, registrationspending.get(0).getPassword())) {
            return new ResponseEntity<String>("pending", HttpStatus.OK);
        }
        List<Registration> registrationsrejected = registrationServices.findUserByUsernameRejected(username);
        if (!registrationsrejected.isEmpty()) {
            return new ResponseEntity<String>("rejected", HttpStatus.OK);
        }
        return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/admin")
    public ResponseEntity<String> adminLogin(String username, String password, HttpServletRequest req) {
        List<Admin> users = adminServices.findUserByUsernamePassword(username, password);
        if (!users.isEmpty()) {
            SessionHandler.setSession(req, username, "admin");
            usersServices.updateMembership();
            return new ResponseEntity<String>("logged", HttpStatus.OK);
        }
        return new ResponseEntity<String>("not found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/getotp")
    public ResponseEntity<String> getOtp(String username, HttpServletRequest req) {
        Users user = usersServices.findUserByUsername(username);
        if (user != null) {
            String OTP = OtpHandler.generateOTP(4);
            String message = "The OTP to Generate New Password is : " + OTP
                    + "\nThis OTP is valid for 60 seconds only.\nDo Not Share It With Anyone.";
            emailServices.sendMail(user.getEmail(), "OTP For Changing User Password", message);
            SessionHandler.setOtpSession(req, OTP, 60);
            return new ResponseEntity<String>(user.getEmail(), HttpStatus.OK);
        }
        return new ResponseEntity<String>("User Not Found", HttpStatus.NOT_FOUND);
    }

    @PostMapping("/checkotp")
    public ResponseEntity<String> checkOtp(String OTP, HttpServletRequest req) {
        String sessionOTP = SessionHandler.getOtpSession(req);
        System.out.println(OTP + "  " + sessionOTP);
        if (OTP.equals(sessionOTP)) {
            SessionHandler.deleteSession(req);
            return new ResponseEntity<String>("true", HttpStatus.FOUND);
        }
        return new ResponseEntity<String>("false", HttpStatus.NOT_FOUND);
    }

    @GetMapping("/deleteotp")
    public ResponseEntity<String> deleteOtp(HttpServletRequest req) {
        SessionHandler.deleteSession(req);
        return new ResponseEntity<String>("deleted", HttpStatus.OK);
    }

    @PostMapping("/updateuserpassword")
    public ResponseEntity<String> updateUserPassword(String username,String password) {
        System.out.println(username + "  " + password);
        usersServices.updateUserPasswordByusername(username, password);
        return new ResponseEntity<String>("true", HttpStatus.OK);
    } 
}
