package com.example.fate.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import com.example.fate.entry.master.Master;

@Controller
public class ProfileController {
    
    @RequestMapping("/profile")
    public String displayMasterProfile(Master master) {
        return "/profile/masterProfilePage";
    }
    
    @RequestMapping(value = "/profile", method = RequestMethod.POST)
    public String saveMasterProfile(Master master) {
        System.out.println("save ok!" + master);
        return "redirect:/profile";
    }
}
