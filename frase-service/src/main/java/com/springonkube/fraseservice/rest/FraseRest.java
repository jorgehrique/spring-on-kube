package com.springonkube.fraseservice.rest;

import com.springonkube.fraseservice.service.FraseService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.time.LocalDate;

@RestController
@RequestMapping("/frase")
public class FraseRest {

    private final FraseService fraseService;

    public FraseRest(FraseService fraseService) {
        this.fraseService = fraseService;
    }

    @GetMapping
    public ResponseEntity<FraseDTO> buildFrase(@RequestParam String nome,
                                               @RequestParam LocalDate nascimento){
        String frase = fraseService.buildFraseWith(nome, nascimento);
        FraseDTO fraseDTO = new FraseDTO(frase);
        return ResponseEntity.ok(fraseDTO);
    }
}
