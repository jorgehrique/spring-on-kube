package com.springonkube.fraseservice.client;

import com.springonkube.fraseservice.dto.AgeDTO;
import com.springonkube.fraseservice.dto.SignDTO;
import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.time.LocalDate;

@FeignClient(value = "calculadoraService", url = "calculadora-service")
public interface CalculadoraServiceClient {

    @GetMapping("/calculate/age")
    AgeDTO calculateAge(@RequestParam("birth") LocalDate birth);

    @GetMapping("/calculate/sign")
    SignDTO calculateSign(@RequestParam("birth") LocalDate birth);
}
