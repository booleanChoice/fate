package com.example.fate.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import com.example.fate.service.TestService;

@Controller
public class TestController {
    
    @Autowired
    private TestService service;
    
    @RequestMapping("/")
    public String method(Model modle) {
        
        return "testPage";
    }
}
