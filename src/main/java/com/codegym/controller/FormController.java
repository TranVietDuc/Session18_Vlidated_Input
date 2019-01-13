package com.codegym.controller;

import com.codegym.model.User;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.PostMapping;

import javax.validation.Valid;


@Controller("/")
public class FormController {

    @GetMapping("/")
    public String showForm(Model model){
        model.addAttribute("user",new User());
        return "index";
    }


    @PostMapping("/")
    public String checkValidation(@Validated @ModelAttribute("User") User user, BindingResult bindingResult,Model model){
        if (bindingResult.hasFieldErrors()){
            model.addAttribute("user",new User());
            return "index";

        }
        return "result";
    }
}
