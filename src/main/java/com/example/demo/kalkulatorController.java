package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
@RequestMapping("/kalkulator")
public class kalkulatorController {
    @PostMapping
    public String obliczPost(double liczba1, double liczba2, String operacja, Model model) {
        Double wynik = 0.0;
        switch(operacja) {
            case "+" -> model.addAttribute("message", wynik = liczba1 + liczba2);
            case "-" -> model.addAttribute("message", wynik = liczba1 - liczba2);
            case "*" -> model.addAttribute("message", wynik =liczba1 * liczba2);
            case "/" -> {
                if(liczba2 != 0) {
                    model.addAttribute("message", wynik = (double) liczba1 / liczba2);
                }
                else model.addAttribute("message", "Pamiętaj cholero nie dziel przez zero");
            }
            default -> model.addAttribute("message", "Błędny wpis");
        }
        return "kalkulator.html";
    }

    @GetMapping
    public String getKalkulator() {
        return "kalkulator.html";
    }

}
