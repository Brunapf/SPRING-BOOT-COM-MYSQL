package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Trilha;

public class TrilhaRs {

    private Long id;
    private String trilhaNome;
    private String diretoria;

    public static TrilhaRs converter(Trilha t) {
        TrilhaRs trilha = new TrilhaRs();
        trilha.setTrilhaNome(t.getTrilhaNome());
        trilha.setDiretoria(t.getDiretoria());
        return trilha;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getTrilhaNome() {
        return trilhaNome;
    }

    public void setTrilhaNome(String trilhaNome) {
        this.trilhaNome = trilhaNome;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public void setDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }
}
