package com.example.demo;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.time.LocalDateTime;

@Controller
public class PierwszyKontroler {

    @RequestMapping("/hello")
    @ResponseBody
    public String sayHello() {
        return "Hej, tu Spring, który jest ekstra fajnym narzędziem";
    }

//   POJO - plain old java object
    @RequestMapping("/time")
    @ResponseBody
    public String time() {
        return "Dzisiaj jest: " + LocalDateTime.now();
    }

}
