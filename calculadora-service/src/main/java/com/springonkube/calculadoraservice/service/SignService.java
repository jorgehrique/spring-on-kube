package com.springonkube.calculadoraservice.service;

import org.springframework.stereotype.Service;

import java.time.LocalDate;
import java.util.LinkedHashSet;
import java.util.Optional;
import java.util.Set;

@Service
public class SignService {

    private final Set<Sign> signs;

    private static final int fixedYear = 2023;

    public SignService() {
        signs = new LinkedHashSet<>();
        signs.add(new Sign("Áries", getDiaMes(21, 3), getDiaMes(19, 4)));
        signs.add(new Sign("Touro", getDiaMes(20, 4), getDiaMes(20, 5)));
        signs.add(new Sign("Gêmeos", getDiaMes(21, 5), getDiaMes(20, 6)));
        signs.add(new Sign("Câncer", getDiaMes(21, 6), getDiaMes(22, 7)));
        signs.add(new Sign("Leão", getDiaMes(23, 7), getDiaMes(22, 8)));
        signs.add(new Sign("Virgem", getDiaMes(23, 8), getDiaMes(22, 9)));
        signs.add(new Sign("Libra", getDiaMes(23, 9), getDiaMes(22, 10)));
        signs.add(new Sign("Escorpião", getDiaMes(23, 10), getDiaMes(21, 11)));
        signs.add(new Sign("Sagitário", getDiaMes(22, 11), getDiaMes(21, 12)));
        signs.add(new Sign("Aquário", getDiaMes(22, 12), getDiaMes(19, 1)));
        signs.add(new Sign("Capricórnio", getDiaMes(20, 1), getDiaMes(18, 2)));
        signs.add(new Sign("Peixes", getDiaMes(19, 2), getDiaMes(20, 3)));
    }

    public Optional<String> calculateSign(int dia, int mes){
        try {
            final LocalDate birth = LocalDate.of(fixedYear, mes, dia);

            return signs.stream()
                    .filter(sign -> birth.isAfter(sign.inicio()) && birth.isBefore(sign.fim()))
                    .findFirst()
                    .map(Sign::name);

        } catch (Exception ex){
            System.out.printf("Erro ao calcular signo nas datas (%d, %d) : %s", dia, mes, ex.getMessage());
            return Optional.empty();
        }
    }

    private LocalDate getDiaMes(int dia, int mes){
        return LocalDate.of(fixedYear, mes, dia);
    }

    private record Sign(String name, LocalDate inicio, LocalDate fim) {}

}
