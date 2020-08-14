package br.com.projetob2w.springbootcommysql.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name = "cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="cargo_nome")
    private String cargo_nome;

    @Column(name="trilha_id")
    private Trilha trilha_id;

    @Column(name="cargo_missao")
    private String cargo_missao;

    @Column(name="data_atualizacao")
    private Timestamp data_atualizacao;

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

    public String getCargoMissao() {
        return cargo_missao;
    }

    public void setCargoMissao(String cargo_missao) {
        this.cargo_missao = cargo_missao;
    }

    public Timestamp getDataAtualizacao() {
        return data_atualizacao;
    }

    public void setDataAtualizacao(Timestamp data_atualizacao) {
        this.data_atualizacao = data_atualizacao;
    }
}
