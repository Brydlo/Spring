package com.example.demo;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/blog.json")
public class BlogRestController {
    @Autowired
    private BlogService blogService;

    @GetMapping
    public List<String> getTeksty() {
        return blogService.getTeksty();
    }

    @GetMapping(path="/{numer}", produces="application/json")
    public String getTekst(@PathVariable("numer") int i) {
        return blogService.getTekst(i);
    }

    @PutMapping(path="/{numer}", consumes = {"application/json", "text/plain"})
    public void setTekst(
            @PathVariable("numer") int i,
            @RequestBody String tekst) {
        blogService.setTekst(i, tekst);
    }

    @PostMapping(consumes = {"application/json", "text/plain"})
    public void addTekst(@RequestBody String tekst) {
        blogService.addTekst(tekst);
    }
}


