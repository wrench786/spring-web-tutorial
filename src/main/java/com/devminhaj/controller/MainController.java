package com.devminhaj.controller;

import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.ModelAndView;

@Controller
public class MainController {
    @RequestMapping("/")
    // This annotation maps HTTP requests to handler methods of MVC and REST controllers.
    public ModelAndView getHomePage(ModelAndView modelAndView){
        // Spring MVC creates the ModelAndView object and passes it to this method.
        modelAndView.addObject("name","Minhaj");
        modelAndView.setViewName("Home");
        return modelAndView;
    }
    @RequestMapping("/profile")
    public ModelAndView getProfilePage(ModelAndView modelAndView){
        modelAndView.setViewName("Profile");
        return modelAndView;
    }
    @RequestMapping("/user-details")
    public ModelAndView getUserDetailsPage(ModelAndView modelAndView,
                                           @RequestParam String fullName,
                                           @RequestParam @Nullable Integer age,
                                           @RequestParam String email){
        System.out.println(fullName);
        System.out.println(age);
        System.out.println(email);

        modelAndView.addObject("fullName",fullName);
        modelAndView.addObject("age",age);
        modelAndView.addObject("email",email);

        modelAndView.setViewName("UserDetails");
        return modelAndView;
    }
}
