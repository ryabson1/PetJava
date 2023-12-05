package ru.ryabson.Processing.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;

@Controller
public class MainPageController {

    @GetMapping("/mainForm")
    public String mainForm() {
        return "mainForm";
    }

}
