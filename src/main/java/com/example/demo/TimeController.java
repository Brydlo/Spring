package com.example.demo;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.time.LocalTime;
import java.time.format.DateTimeFormatter;
import java.util.ArrayList;
import java.util.List;
import java.util.Locale;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.ResponseBody;


@Controller
public class TimeController {

    @GetMapping("/time1")
    @ResponseBody
    public LocalTime time1() {
        return LocalTime.now();
    }
    @GetMapping("/time2")
    @ResponseBody
    public String time2() {
        return LocalTime.now().toString();
    }
    private static final DateTimeFormatter FORMAT_DATY = DateTimeFormatter
            .ofPattern("EEEE, dd.MM.yyyy, 'godzina' HH:mm:ss", new Locale("pl", "PL"));

    @GetMapping("/time3")
    @ResponseBody
    public String time3() {
        return LocalDateTime.now().format(FORMAT_DATY);
    }
    // Jak wysłać w odpowiedzi HTML?
    // 1. Utworzyć bezpośrednio w kodzie Javy... - słabe
    @GetMapping(path="/time4", produces="text/html")
    @ResponseBody
    public String time4() {
        LocalDateTime dt = LocalDateTime.now();
        return String.format(
                """
                    <html><body>
                        <h1>Data i czas</h1>
                        <p>Teraz jest godzina <strong style='color:purple'>%s</strong></p>
                        <p>Dzisiejsza data: <strong style='color:blue'>%s</strong></p>
                        <p style='color: green'>%s</p>
                    </body></html>""",
                dt.toLocalTime(), dt.toLocalDate(), dt.format(FORMAT_DATY));
    }



//    użycie modelu i Spring MVC
    @GetMapping("/time5")
    public String time5(Model model) {
        LocalDateTime dataCzas = LocalDateTime.now();
        model.addAttribute("dt", dataCzas);
        return "wyswietl_czas5.html";
    }
    // Przykład pokazujący dalsze możliwości Thymeleaf.
    // https://www.thymeleaf.org/
    @GetMapping("/time6")
    public String time6(Model model) {
        LocalDateTime dt = LocalDateTime.now();
        model.addAttribute("dt", dt);

        List<LocalDate> dates = new ArrayList<>();
        LocalDate date = dt.toLocalDate();
        for(int i = 0; i <= 5; i++) {
            dates.add(date.plusWeeks(i));
        }
        model.addAttribute("futureWeeks", dates);
        String s = "wyswietl_czas6.html";

        return s;
    }

}


