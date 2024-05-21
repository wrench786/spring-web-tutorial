package com.devminhaj.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;


@Controller
public class MainController {

    @RequestMapping("/")
    public String getHomePage(){
        return "home";

    }
    @RequestMapping("/profile")
    public String getProfilePage(){
        return "profile";
    }
}
