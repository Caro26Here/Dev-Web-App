package com.carobackendhere.controllers;

import com.carobackendhere.PersonalException;
import com.carobackendhere.service.ProjectService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.logging.Level;
import java.util.logging.Logger;

@RequiredArgsConstructor
@Controller
@RequestMapping("/portfolio")
public class ProjectController {

    private final ProjectService ps;

    @GetMapping("")
    public String base(){return "portfolio.html";}

    @GetMapping("/entry")
    public String entry(){
        return "portfolio_form.html";
    }

    @PostMapping("/entry")
    public String entry(@RequestParam String name, @RequestParam String url){
        try{
            ps.createProject(name, url);

            return "redirect:../portfolio";

        } catch (PersonalException e) {

            Logger.getLogger(ProjectController.class.getName()).log(Level.SEVERE, null, e);

            return "portfolio_form.html";
        }
    }
}
