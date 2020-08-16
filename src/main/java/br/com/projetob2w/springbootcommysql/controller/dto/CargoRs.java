package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Cargo;
import br.com.projetob2w.springbootcommysql.model.Trilha;

public class CargoRs {

    private Long id;
    private String cargoNome;
    private Trilha trilhaId;

    public static CargoRs converter(Cargo c) {
        CargoRs cargo = new CargoRs();
        cargo.setId(c.getId());
        cargo.setCargoNome(c.getCargoNome());
        cargo.setTrilhaId(c.getTrilhaId());
        return cargo;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

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
