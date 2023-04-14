package com.springonkube.calculadoraservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

@Service
public class CalculadoraService {

    private final SignService signService;

    public CalculadoraService(SignService signService) {
        this.signService = signService;
    }

    public Optional<Integer> calculateAge(LocalDate birth) {
        if(birth == null){
            return Optional.empty();
        }

        return Optional.of(Period.between(birth, LocalDate.now()).getYears());
    }

    public Optional<String> calculateSign(LocalDate birth){
        if(birth == null){
            return Optional.empty();
        }

        return signService.calculateSign(birth.getDayOfMonth(), birth.getMonthValue());
    }

}
