package com.kristian.proyentocol.controller;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
public class ControladorSumaResta {
    @GetMapping("/sumar")
    public int sumar(@RequestParam int a, @RequestParam int b){
        return a+b;
    }
    @GetMapping("/restar")
    public int restar(@RequestParam int a, @RequestParam int b){
        return a-b;
    }
}
