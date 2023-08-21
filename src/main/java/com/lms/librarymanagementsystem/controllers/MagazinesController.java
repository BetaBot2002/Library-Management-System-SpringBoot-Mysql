package com.lms.librarymanagementsystem.controllers;

import java.util.List;

// import org.hibernate.mapping.List;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.multipart.MultipartFile;

// import com.lms.librarymanagementsystem.models.Connector;
import com.lms.librarymanagementsystem.models.Magazines;
import com.lms.librarymanagementsystem.services.ConnectorServices;
import com.lms.librarymanagementsystem.services.MagazinesServices;


@Controller
@RequestMapping("/magazines")
public class MagazinesController {
    private MagazinesServices MagazinesServices;
    private ConnectorServices connectorServices;

    public MagazinesController(MagazinesServices MagazinesServices,ConnectorServices connectorServices) {
        this.MagazinesServices = MagazinesServices;
        this.connectorServices = connectorServices;
    }

    @GetMapping("/search")
    public String getMagazinesBySearch(String searchParam,Model model){
        List<Magazines> magazines=MagazinesServices.findBySearch(searchParam);
        model.addAttribute("magazines", magazines);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "magazines");
        return "searchResult";
    }

    @GetMapping("/title")
    public String getMagazinesByTitle(String searchParam,Model model){
        List<Magazines> magazines=MagazinesServices.findBySearchTitle(searchParam);
        model.addAttribute("magazines", magazines);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "magazines");
        return "searchResult";
    }

}