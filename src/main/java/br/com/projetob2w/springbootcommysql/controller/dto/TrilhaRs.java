package br.com.projetob2w.springbootcommysql.controller.dto;

import br.com.projetob2w.springbootcommysql.model.Trilha;

public class TrilhaRs {

    private Long id;
    private String trilha_nome;
    private String diretoria;

    public static TrilhaRs converter(Trilha t) {
        var trilha = new TrilhaRs();
        trilha.setId(t.getId());
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
        return trilha_nome;
    }

    public void setTrilhaNome(String trilha_nome) {
        this.trilha_nome = trilha_nome;
    }

    public String getDiretoria() {
        return diretoria;
    }

    public void setDiretoria(String diretoria) {
        this.diretoria = diretoria;
    }
}
