package com.springonkube.calculadoraservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.Optional;

@Service
public class CalculadoraService {

    private final SignService signService;

    public CalculadoraService(SignService signService) {
        this.signService = signService;
    }

    public Integer calculateAge(LocalDate birth) {
        if(birth == null){
            return 0;
        }

        return LocalDate.now().getYear() - birth.getYear();
    }

    public Optional<String> calculateSign(LocalDate birth){
        return signService.calculateSign(birth.getDayOfMonth(), birth.getMonthValue());
    }

}
