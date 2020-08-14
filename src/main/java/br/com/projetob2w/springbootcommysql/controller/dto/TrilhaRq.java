package br.com.projetob2w.springbootcommysql.controller.dto;

public class TrilhaRq {

    private String trilha_nome;
    private String diretoria;

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
