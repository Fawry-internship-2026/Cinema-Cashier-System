package com.example.Cinema.Ticket.Reservation.App.controller;

import com.example.Cinema.Ticket.Reservation.App.service.ShowTimeService;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;

import java.time.LocalDate;

@Controller
@RequiredArgsConstructor
public class WebUIController {

    private final ShowTimeService showTimeService;

    @GetMapping("/")
    public String homePage(Model model) {
        model.addAttribute("showTimes", showTimeService.getAllShowTimes());
        model.addAttribute("todayDate", LocalDate.now());
        return "index";
    }
}