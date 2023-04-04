package com.springonkube.calculadoraservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class CalculadoraService {

    public Integer calculateAge(LocalDate birth) {
        if(birth == null){
            return 0;
        }

        return LocalDate.now().getYear() - birth.getYear();
    }

}
