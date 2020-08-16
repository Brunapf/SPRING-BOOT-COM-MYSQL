package br.com.projetob2w.springbootcommysql.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "trilha")
public class Trilha {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="trilha_nome")
    private String trilhaNome;

    @Column(name="diretoria")
    private String diretoria;

    @Column(name="missao_formal")
    private String missaoFormal;

    @Column(name="missao_alternativa")
    private String missaoAlternativa;

    @Column(name="data_atualizacao")
    private Timestamp dataAtualizacao;

    public Trilha() {
    }

    public Trilha(String trilhaNome, String diretoria) {
        this.trilhaNome = trilhaNome;
        this.diretoria = diretoria;
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

    public String getMissaoFormal() {
        return missaoFormal;
    }

    public void setMissaoFormal(String missaoFormal) {
        this.missaoFormal = missaoFormal;
    }

    public String getMissaoAlternativa() {
        return missaoAlternativa;
    }

    public void setMissaoAlternativa(String missaoAlternativa) {
        this.missaoAlternativa = missaoAlternativa;
    }

    public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
