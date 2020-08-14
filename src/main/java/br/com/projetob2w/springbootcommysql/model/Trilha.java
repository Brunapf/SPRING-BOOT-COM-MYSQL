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
    private String trilha_nome;

    @Column(name="diretoria")
    private String diretoria;

    @Column(name="missao_formal")
    private String missao_formal;

    @Column(name="missao_alternativa")
    private String missao_alternativa;

    @Column(name="data_atualizacao")
    private Timestamp data_atualizacao;

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

    public String getMissaoFormal() {
        return missao_formal;
    }

    public void setMissaoFormal(String missao_formal) {
        this.missao_formal = missao_formal;
    }

    public String getMissaoAlternativa() {
        return missao_alternativa;
    }

    public void setMissaoAlternativa(String missao_alternativa) {
        this.missao_alternativa = missao_alternativa;
    }

    public Timestamp getDataAtualizacao() {
        return data_atualizacao;
    }

    public void setDataAtualizacao(Timestamp data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }
}
