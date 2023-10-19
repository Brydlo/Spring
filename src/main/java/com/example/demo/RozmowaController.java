package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMethod;

@Controller
@RequestMapping("/rozmowa")
public class RozmowaController {

    @PostMapping
    public String rozmowaPost(String imie, Model model) {
        if(imie != null && !imie.isBlank()) {
//        jak się dostać do parametru imie z przegladarki
//        <form>
//          <label for="imie">Jak masz na imię?</label><br>
//          <input id="imie" name="imie" type="text"><br>
//          <button>OK</button>
//         </form>
            model.addAttribute("message", "Witaj " + imie);
        }
        return "rozmowa.html";
    }
    @GetMapping
    public String rozmowaGet(String imie, Model model) {
        return "rozmowa.html";
    }

}
