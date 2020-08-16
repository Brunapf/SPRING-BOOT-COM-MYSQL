package br.com.projetob2w.springbootcommysql.controller.dto;

public class TrilhaRq {

    private String trilhaNome;
    private String diretoria;

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
