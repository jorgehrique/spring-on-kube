package com.springonkube.calculadoraservice.service;

import org.springframework.cglib.core.Local;
import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.time.Period;
import java.util.Optional;

import static java.time.temporal.ChronoUnit.DAYS;
import static java.time.temporal.ChronoUnit.YEARS;

@Service
public class CalculadoraService {

    private final SignService signService;

    public CalculadoraService(SignService signService) {
        this.signService = signService;
    }

    public Optional<Long> calculateAge(LocalDate birth) {
        if(birth == null){
            return Optional.empty();
        }

        return Optional.of(YEARS.between(birth, LocalDate.now()));
    }

    public Optional<Long> calculateDaysAlive(LocalDate birth) {
        if(birth == null){
            return Optional.empty();
        }

        return Optional.of(DAYS.between(birth, LocalDate.now()));
    }

    public Optional<String> calculateSign(LocalDate birth){
        if(birth == null){
            return Optional.empty();
        }

        return signService.calculateSign(birth.getDayOfMonth(), birth.getMonthValue());
    }

}
