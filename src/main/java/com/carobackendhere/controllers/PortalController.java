package com.carobackendhere.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/")
public class PortalController {

    @GetMapping("/")
    public String base(){return "index.html";}

    @GetMapping("/home")
    public String home(){return "index.html";}

    @GetMapping("/contact")
    public String contact(){return "contact.html";}

}
