package com.dat20b.demo.controllers;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class ViewController {


    @GetMapping("/")
    public String christiansMap(){
        return "christiansoetour.html";
    }

    @GetMapping("/admin")
    public String getChristiansoeAdminPage(){
        return "admin.html";
    }

}
