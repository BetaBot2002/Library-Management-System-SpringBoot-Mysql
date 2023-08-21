package com.lms.librarymanagementsystem.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.multipart.MultipartFile;

// import com.lms.librarymanagementsystem.models.Connector;
import com.lms.librarymanagementsystem.models.Journals;
import com.lms.librarymanagementsystem.services.ConnectorServices;
import com.lms.librarymanagementsystem.services.JournalsServices;

@Controller
@RequestMapping("/journals")
public class JournalsController {
    private JournalsServices JournalsServices;
    private ConnectorServices connectorServices;


    public JournalsController(JournalsServices JournalsServices, ConnectorServices connectorServices) {
        this.JournalsServices = JournalsServices;
        this.connectorServices = connectorServices;
    }

    @GetMapping("/search")
    public String getJournalsBySearch(String searchParam,Model model){
        List<Journals> journals=JournalsServices.findBySearch(searchParam);
        model.addAttribute("journals", journals);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "journals");
        return "searchResult";

    }

    @GetMapping("/editor")
    public String getJournalsByAuthor(String searchParam,Model model){
        List<Journals> journals=JournalsServices.findBySearchEditor(searchParam);
        model.addAttribute("journals", journals);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "journals");
        return "searchResult";
    }

    @GetMapping("/publisher")
    public String getJournalsByPublisher(String searchParam,Model model){
        List<Journals> journals=JournalsServices.findBySearchPublisher(searchParam);
        model.addAttribute("journals", journals);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "journals");
        return "searchResult";
    }

    @GetMapping("/title")
    public String getJournalsByTitle(String searchParam,Model model){
        List<Journals> journals=JournalsServices.findBySearchTitle(searchParam);
        model.addAttribute("journals", journals);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "journals");
        return "searchResult";
    }
    

}