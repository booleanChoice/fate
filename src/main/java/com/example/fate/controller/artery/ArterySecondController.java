package com.example.fate.controller.artery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/artery")
public class ArterySecondController {
    
    @RequestMapping("/page2")
    public String pageEntry() {
        System.out.println("Welcome Artery Page !");
        return "arterySecondPage";
    }
}
