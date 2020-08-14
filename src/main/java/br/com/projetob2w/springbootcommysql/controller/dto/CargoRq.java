package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Trilha;

public class CargoRq {

    private String cargo_nome;
    private Trilha trilha_id;

    public String getCargoNome() {
        return cargo_nome;
    }

    public void setCargoNome(String cargo_nome) {
        this.cargo_nome = cargo_nome;
    }

    public Trilha getTrilhaId() {
        return trilha_id;
    }

    public void setTrilhaId(Trilha trilha_id) {
        this.trilha_id = trilha_id;
    }
}
