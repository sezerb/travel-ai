package com.baglans.demo.controller;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;
import com.baglans.demo.service.RecommendationService;
import org.springframework.beans.factory.annotation.Autowired;

@Controller
public class RecommendationController {
    @Autowired
    private RecommendationService recommendationService;

    @GetMapping("/")
    public String showForm() {
        return "index";
    }

    @PostMapping("/recommend")
    public String recommend(@RequestParam("place") String place, Model model) {
        model.addAttribute("place", place);
        model.addAttribute("summary", recommendationService.getRecommendationSummary(place));
        return "result";
    }
}
