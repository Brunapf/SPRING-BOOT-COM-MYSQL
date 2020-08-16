package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Trilha;

public class CargoRq {

    private String cargoNome;
    private Trilha trilhaId;

    public String getCargoNome() {
        return cargoNome;
    }

    public void setCargoNome(String cargoNome) {
        this.cargoNome = cargoNome;
    }

    public Trilha getTrilhaId() {
        return trilhaId;
    }

    public void setTrilhaId(Trilha trilhaId) {
        this.trilhaId = trilhaId;
    }
}
