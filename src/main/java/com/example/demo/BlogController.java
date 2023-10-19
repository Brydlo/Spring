package com.example.demo;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/blog")
public class BlogController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public String rozmowaGet() {
        return "blog.html";
    }

    @PostMapping
    public String rozmowaPost(String tekst, Model model) {
        if(tekst != null && !tekst.isBlank()) {
            blogService.addTekst(tekst);
        }
        model.addAttribute("teksty", blogService.getTeksty());
        return "blog.html";
    }

}


