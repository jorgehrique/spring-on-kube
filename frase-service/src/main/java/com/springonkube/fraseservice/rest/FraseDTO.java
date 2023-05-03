package com.springonkube.fraseservice.rest;

public class FraseDTO {

    private String frase;

    public FraseDTO(String frase) {
        this.frase = frase;
    }

    public String getFrase() {
        return frase;
    }
}
