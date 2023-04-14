package com.springonkube.calculadoraservice.rest;

import com.springonkube.calculadoraservice.service.CalculadoraService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;

@RestController
@RequestMapping("/calculate")
public class CalculadoraRest {

    private final CalculadoraService calculadoraService;

    public CalculadoraRest(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/age")
    public Integer calculateAge(@RequestParam("birth") LocalDate birth){
        var result = calculadoraService.calculateAge(birth);
        return result.orElse(0);
    }

    @GetMapping("/sign")
    public String calculateSign(@RequestParam("birth") LocalDate birth){
        var result = calculadoraService.calculateSign(birth);
        return result.orElse("Nenhum signo foi encontrado com essa data.");
    }
}
