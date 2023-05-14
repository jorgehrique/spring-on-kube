package com.springonkube.calculadoraservice.rest;

import com.springonkube.calculadoraservice.dto.AgeDTO;
import com.springonkube.calculadoraservice.dto.SignDTO;
import com.springonkube.calculadoraservice.service.CalculadoraService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.time.LocalDate;
import java.util.Optional;

@RestController
@RequestMapping("/calculate")
public class CalculadoraRest {

    private final CalculadoraService calculadoraService;

    public CalculadoraRest(CalculadoraService calculadoraService) {
        this.calculadoraService = calculadoraService;
    }

    @GetMapping("/age")
    public ResponseEntity<AgeDTO> calculateAge(@RequestParam LocalDate birth){
        Optional<Long> age = calculadoraService.calculateAge(birth);

        if (age.isPresent()){
            AgeDTO ageDTO = new AgeDTO();
            ageDTO.setAge(age.get());
            return ResponseEntity.ok(ageDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/days-alive")
    public ResponseEntity<AgeDTO> calculateDaysAlive(@RequestParam LocalDate birth){
        Optional<Long> age = calculadoraService.calculateDaysAlive(birth);

        if (age.isPresent()){
            AgeDTO ageDTO = new AgeDTO();
            ageDTO.setAge(age.get());
            return ResponseEntity.ok(ageDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }

    @GetMapping("/sign")
    public ResponseEntity<SignDTO> calculateSign(@RequestParam("birth") LocalDate birth){
        Optional<String> sign = calculadoraService.calculateSign(birth);

        if (sign.isPresent()){
            SignDTO signDTO = new SignDTO();
            signDTO.setSign(sign.get());
            return ResponseEntity.ok(signDTO);
        } else {
            return ResponseEntity.badRequest().build();
        }
    }
}
