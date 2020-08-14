package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Cargo;
import br.com.projetob2w.springbootcommysql.model.Trilha;

public class CargoRs {

    private Long id;
    private String cargo_nome;
    private Trilha trilha_id;

    public static CargoRs converter(Cargo c) {
        var cargo = new CargoRs();
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
