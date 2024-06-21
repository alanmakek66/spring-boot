package com.bootcamp.demo_register.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import com.bootcamp.demo_register.model.User;
import com.bootcamp.demo_register.repository.UserRepsitory;

@Controller
public class UserController {
  @Autowired
    private UserRepsitory userRepsitory;

    @GetMapping("/register")
    public String showRegistrationForm(Model model) {
        model.addAttribute("user", new User());
        return "register.html";
    }

      @PostMapping("/register")
     public String registerUser(@ModelAttribute("user") User user) {
         // Check if the username already exists
         if (userRepsitory.findByUsername(user.getUsername()) != null) {
          return "redirect:/register?error";
         }

         // Save the new user
         userRepsitory.save(user);
         return "redirect:/login";
     }
     @GetMapping("/login")
     public String login(){
      return "login.html";
     }
  
}
