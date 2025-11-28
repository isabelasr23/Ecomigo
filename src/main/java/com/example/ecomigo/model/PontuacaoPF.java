package com.example.ecomigo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "PONTUACAO_PF")
public class PontuacaoPF {

    @Id
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "ID_USUARIO")
    private PessoaFisica pessoaFisica;

    @Column(name = "SALDO_PONTOS", nullable = false)
    private Integer saldoPontos = 0;

    @Column(name = "PESO_MES_ATUAL", precision = 10, scale = 2, nullable = false)
    private BigDecimal pesoMesAtual = BigDecimal.ZERO;

    public PessoaFisica getPessoaFisica() {
        return pessoaFisica;
    }

    public void setPessoaFisica(PessoaFisica pessoaFisica) {
        this.pessoaFisica = pessoaFisica;
    }

    public Integer getSaldoPontos() {
        return saldoPontos;
    }

    public void setSaldoPontos(Integer saldoPontos) {
        this.saldoPontos = saldoPontos;
    }

    public BigDecimal getPesoMesAtual() {
        return pesoMesAtual;
    }

    public void setPesoMesAtual(BigDecimal pesoMesAtual) {
        this.pesoMesAtual = pesoMesAtual;
    }
}