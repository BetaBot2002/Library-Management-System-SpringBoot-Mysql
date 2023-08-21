package com.lms.librarymanagementsystem.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import com.lms.librarymanagementsystem.services.ConnectorServices;

@Controller
@RequestMapping("/connector")
public class ConnectorController {
    private ConnectorServices connectorServices;

    public ConnectorController(ConnectorServices connectorServices) {
        this.connectorServices = connectorServices;
    }

}
