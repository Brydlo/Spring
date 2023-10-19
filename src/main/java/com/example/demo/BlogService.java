package com.example.demo;

import org.springframework.stereotype.Component;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

@Component
public class BlogService {
    private List<String> teksty = Collections.synchronizedList(new ArrayList<>());

    public List<String> getTeksty() {
        return Collections.unmodifiableList(teksty);
    }

    public String getTekst(int i) {
        return teksty.get(i);
    }

    public void setTekst(int i, String tekst) {
        teksty.set(i, tekst);
    }


    public void addTekst(String tekst) {
        teksty.add(tekst);
    }
}


