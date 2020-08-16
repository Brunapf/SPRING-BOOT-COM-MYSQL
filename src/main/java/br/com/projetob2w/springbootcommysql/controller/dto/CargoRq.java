package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Trilha;

public class CargoRq {

    private String cargoNome;
    private Trilha trilha;

    public String getCargoNome() {
        return cargoNome;
    }

    public void setCargoNome(String cargoNome) {
        this.cargoNome = cargoNome;
    }

    public Trilha getTrilha() {
        return trilha;
    }

    public void setTrilha(Trilha trilha) {
        this.trilha = trilha;
    }
}
