package com.lms.librarymanagementsystem.controllers;

import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
// import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
// import org.springframework.web.multipart.MultipartFile;

// import com.lms.librarymanagementsystem.FileHandler.FileHandler;
import com.lms.librarymanagementsystem.models.SoftCopy;
import com.lms.librarymanagementsystem.services.SoftCopyServices;

@Controller
@RequestMapping("/softcopy")
public class SoftCopyController {
    private SoftCopyServices softCopyServices;

    public SoftCopyController(SoftCopyServices softCopyServices) {
        this.softCopyServices = softCopyServices;
    }


    @GetMapping("/search")
    public String getSoftCopyBySearch(String searchParam,Model model){
        List<SoftCopy> softCopies=softCopyServices.findBySearch(searchParam);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "softcopy");
        return "searchResult";
    }

    @GetMapping("/title")
    public String getSoftCopyByTitle(String searchParam,Model model){
        List<SoftCopy> softCopies=softCopyServices.findBySearchTitle(searchParam);
        model.addAttribute("softcopies", softCopies);
        model.addAttribute("searchValue", searchParam);
        model.addAttribute("type", "softcopy");
        return "searchResult";
    }
}
