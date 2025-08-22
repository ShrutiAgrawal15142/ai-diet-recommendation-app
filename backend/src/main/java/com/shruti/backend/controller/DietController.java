package com.shruti.backend.controller;

import org.springframework.web.bind.annotation.*;
import com.shruti.backend.service.DietService;
import com.shruti.backend.model.DietPlan;
import com.shruti.backend.model.DietRequest;

@RestController
@RequestMapping("/diet")
public class DietController {

    private final DietService dietService;

    public DietController(DietService dietService) {
        this.dietService = dietService;
    }

    @GetMapping("/plan")
    public DietPlan getDietPlan(@RequestParam DietRequest request) {
        return dietService.generateDietPlan(request);
    }
}
