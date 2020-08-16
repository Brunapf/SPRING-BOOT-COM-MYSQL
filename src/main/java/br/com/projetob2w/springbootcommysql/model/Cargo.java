package br.com.projetob2w.springbootcommysql.model;

import java.sql.Timestamp;

import javax.persistence.*;

@Entity
@Table(name ="cargo")
public class Cargo {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private Long id;

    @Column(name="cargo_nome")
    private String cargoNome;

    @ManyToOne(cascade = CascadeType.ALL)
    @JoinColumn(name = "trilha_id", referencedColumnName = "id")
    private Trilha trilhaId;

    @Column(name="cargo_missao")
    private String cargoMissao;

    @Column(name="data_atualizacao")
    private Timestamp dataAtualizacao;

    public Cargo(){
    }

    public Cargo(String cargoNome, Trilha trilhaId) {
        this.cargoNome = cargoNome;
        this.trilhaId = trilhaId;
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

    public String getCargoMissao() {
        return cargoMissao;
    }

    public void setCargoMissao(String cargoMissao) {
        this.cargoMissao = cargoMissao;
    }

   public Timestamp getDataAtualizacao() {
        return dataAtualizacao;
    }

    public void setDataAtualizacao(Timestamp dataAtualizacao) {
        this.dataAtualizacao = dataAtualizacao;
    }
}
