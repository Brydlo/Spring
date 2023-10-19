package com.example.demo;

import jakarta.servlet.http.HttpServletRequest;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

@Controller
@RequestMapping("/parametry")
public class ParametryController {
    // Najprostsze podejście, aby odczytać wartość parametru zapytania:
    // zadeklarować parametr o takiej samej nazwie w metodzie kontrolera.
    // "Spring nam to przekaże".
    // Podejście polegające na tym, że framework wywołuje "naszą metodę",
    // a gdy my czegoś potrzebujemy, to dodajemy odp. parametr do tej metody,
    // nazywa się "inversion of control (IoC)".

    @GetMapping("/witaj")
    @ResponseBody
    public String witaj(String imie) {
        return "Witaj " + imie;
    }

    // Dzięki adnotacji @RequestParam mamy większą kontrolę nad szczegółami parametru.
    // Można m.in. podać inną nazwę niż nazw zmiennej w Javie, może podać wartość domyślną.
    // http://localhost:8080/parametry/powtorz?tekst=Ala%20ma%20kota&n=10
    @GetMapping(path="/powtorz", produces="text/plain;charset=utf-8")
    @ResponseBody
    public String powtorz(
            @RequestParam(defaultValue="") String tekst,
            @RequestParam(name="n", defaultValue="1") int ileRazy) {
        return (tekst + "\n").repeat(ileRazy);
    }

    // Parametry bez adnotacji są opcjonalne - w razie braku Spring wywoła metodę i wstawi nulla.
    // Parametry z adnotacją @RequestParam są domyślnie obowiązkowe. Aby był opcjonalny,
    // trzeba wpisać required=false (wtedy brak parametru = null)
    // lub podać defaultValue.
    @GetMapping(path="/techniczne", produces="text/plain;charset=UTF-8")
    @ResponseBody
    public String parametryTechniczne(HttpServletRequest request,
                                      @RequestHeader("User-Agent") String agent) {
        return """
   			 adres IP klienta: %s:%d
   			 adres serwera: %s:%d
   			 User-Agent z requestu: %s
   			 User-Agent z parametru: %s
   			 """.formatted(request.getRemoteAddr(), request.getRemotePort(),
                request.getLocalAddr(), request.getLocalPort(),
                request.getHeader("User-Agent"), agent);
    }

}


