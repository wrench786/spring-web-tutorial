package com.devminhaj.controller;

import com.devminhaj.model.User;
import com.devminhaj.service.UserService;
import jakarta.annotation.Nullable;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.ModelAndView;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

@Controller
public class MainController {

    private final UserService userService;
    public MainController(UserService userService) {
        this.userService = userService;
    }

    @RequestMapping("/")
    // This annotation maps HTTP requests to handler methods of MVC and REST controllers.
    public ModelAndView getHomePage(ModelAndView modelAndView){
        // Spring MVC creates the ModelAndView object and passes it to this method.
        modelAndView.setViewName("Home");
        return modelAndView;
    }
    @RequestMapping("/profile")
    public ModelAndView getProfilePage(ModelAndView modelAndView){
        modelAndView.setViewName("Profile");
        return modelAndView;
    }
    @PostMapping("/submit")
    public ModelAndView submitUserDetailsPage(ModelAndView modelAndView,
                                           RedirectAttributes redirectAttributes,
                                           @ModelAttribute User user){
//        System.out.println(user);
        userService.addUser(user);
        redirectAttributes.addFlashAttribute("success","Info submitted Successfully");
        modelAndView.setViewName("redirect:/");
        return modelAndView;
    }
    @GetMapping("/user-details")
    public ModelAndView getUserDetailsPage(ModelAndView modelAndView){
        modelAndView.addObject(userService.getUserList());
        modelAndView.setViewName("UserDetails");
        return modelAndView;
    }
}
