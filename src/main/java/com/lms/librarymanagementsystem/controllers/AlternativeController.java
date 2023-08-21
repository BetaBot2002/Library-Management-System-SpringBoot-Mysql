package com.lms.librarymanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.librarymanagementsystem.services.AlternativeServices;

@Controller
@RequestMapping("/alternative")
public class AlternativeController {
    private AlternativeServices alternativeServices;

    public AlternativeController(AlternativeServices alternativeServices) {
        this.alternativeServices = alternativeServices;
    }

}
