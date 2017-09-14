package com.example.fate.controller;

import java.util.Locale;

import javax.validation.Valid;

import org.springframework.stereotype.Controller;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.fate.dto.master.Master;
import com.example.fate.formatter.USLocalDateFormatter;

@Controller
public class ProfileController {
    
    @RequestMapping("/profile")
    public String displayMasterProfile(Master master) {
        return "/profile/masterProfilePage";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveMasterProfile(@Valid Master master, BindingResult bindingResult) {
        if (bindingResult.hasErrors()) {
            return "profile/masterProfilePage";
        }
        System.out.println("save ok!" + master);
        return "redirect:/profile";
    }
    
    @ModelAttribute("dateFormat")
    public String localeFormat(Locale locale) {
        return USLocalDateFormatter.getPattern(locale);
    }
}
