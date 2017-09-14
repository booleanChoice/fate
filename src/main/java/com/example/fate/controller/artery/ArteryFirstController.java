package com.example.fate.controller.artery;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller//基于Component 辅助spring扫描
@RequestMapping(value="/artery/page1")
public class ArteryFirstController {
    
    /**
     * 入口
     * @return
     */
    @RequestMapping(method=RequestMethod.GET)
    public String pageEntry() {
        System.out.println("Welcome Artery Page !");
        return "/artery/arteryFirstPage";
    }
    
    @RequestMapping(value="/arterybtnclick")
    public Object arteryBtnClick() {
        System.out.println("artery button click method has been called");
        return "/artery/arteryFirstPage";
    }
}
