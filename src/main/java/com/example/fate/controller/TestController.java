package com.example.fate.controller;

import java.util.List;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import com.example.fate.entry.master.Master;
import com.example.fate.entry.servent.Servent;
import com.example.fate.service.TestService;

@Controller
public class TestController {
    
    @Autowired
    private TestService service;
    
    @RequestMapping("/")
    public String home() {
        return "searchPage";
    }
    
    @RequestMapping(value = "postSearch", method = RequestMethod.POST)
    public String postSearch(HttpServletRequest request, RedirectAttributes attr) {
        String search = request.getParameter("search");
        if (search.toLowerCase().contains("ruler")) {
            attr.addFlashAttribute("error", "Try using correct Servent type");// Flash attributes在对请求的重定向生效之前被临时存储（通常是在session)中
            return "redirect:/";
        }
        attr.addAttribute("search", search);
        return "redirect:result"; //redirect会发送一个302 头信息
        //return "forward:result"; //POST->Forward->GET模式,有时候会导致多次提交问题. 例如用户按F5刷新页面，这时同样的数据会再提交一次。
    }
    
    @RequestMapping("/result")
    public String firstMethod(@RequestParam(defaultValue = "Fate")String search, 
            Model modle) {
        Master master = new Master("Shirou");
        List<Servent> servents = service.summonServents(master);
        modle.addAttribute("search", search);
        modle.addAttribute("servents", servents);
        return "testPage";
    }
}
