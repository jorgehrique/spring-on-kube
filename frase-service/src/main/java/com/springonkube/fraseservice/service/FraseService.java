package com.springonkube.fraseservice.service;

import com.springonkube.fraseservice.client.CalculadoraServiceClient;
import com.springonkube.fraseservice.dto.AgeDTO;
import com.springonkube.fraseservice.dto.SignDTO;
import org.springframework.stereotype.Service;

import java.time.LocalDate;

@Service
public class FraseService {

    private final CalculadoraServiceClient calculadoraClient;

    public FraseService(CalculadoraServiceClient calculadoraClient) {
        this.calculadoraClient = calculadoraClient;
    }

    public String buildFraseWith(String nome, LocalDate nascimento) {
        AgeDTO age = calculadoraClient.calculateAge(nascimento);
        SignDTO sign = calculadoraClient.calculateSign(nascimento);

        return "Olá %s, você tem %d anos de idade e é do signo de %s!"
                .formatted(nome, age.getAge(), sign.getSign());
    }

}
