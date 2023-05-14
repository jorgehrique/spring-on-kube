package com.springonkube.fraseservice.client;

import com.fasterxml.jackson.databind.JsonNode;
import com.springonkube.fraseservice.dto.AgeDTO;
import com.springonkube.fraseservice.dto.SignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

import static org.springframework.format.annotation.DateTimeFormat.ISO;

@FeignClient(value = "calculadoraService", url = "calculadora-service")
public interface CalculadoraServiceClient {

    @GetMapping(value = "/calculate/age")
    AgeDTO calculateAge(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate birth);

    @GetMapping(value = "/calculate/days-alive")
    AgeDTO calculateDaysAlive(@RequestParam @DateTimeFormat(iso = ISO.DATE) LocalDate birth);

    @GetMapping("/calculate/sign")
    SignDTO calculateSign(@RequestParam LocalDate birth);
}
