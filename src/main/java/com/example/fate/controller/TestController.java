package com.example.fate.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.example.fate.entry.master.Master;
import com.example.fate.entry.servent.Servent;
import com.example.fate.service.TestService;

@Controller
public class TestController {
    
    @Autowired
    private TestService service;
    
    @RequestMapping("/")
    public String firstMethod(@RequestParam(defaultValue = "Fate")String search, 
            Model modle) {
        Master master = new Master("Shirou", 17);
        List<Servent> servents = service.summonServents(master);
        modle.addAttribute("search", search);
        modle.addAttribute("servents", servents);
        return "testPage";
    }
}
