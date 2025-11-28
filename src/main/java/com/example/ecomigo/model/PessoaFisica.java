package com.example.ecomigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.NotBlank;

@Entity
@Table(name = "PESSOA_FISICA")
@PrimaryKeyJoinColumn(name = "ID_USUARIO")
public class PessoaFisica extends Usuario{

    @NotBlank(message = "O CPF não pode estar em branco")
    @Column(name = "CPF", unique = true, nullable = false)
    private String cpf;

    @NotBlank(message = "O celular não pode estar em branco")
    @Column(name = "CELULAR", nullable = false)
    private String celular;

    @OneToOne(mappedBy = "pessoaFisica", cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    private PontuacaoPF pontuacao;

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCelular() {
        return celular;
    }

    public void setCelular(String celular) {
        this.celular = celular;
    }

    public PontuacaoPF getPontuacao() {
        return pontuacao;
    }

    public void setPontuacao(PontuacaoPF pontuacao) {
        this.pontuacao = pontuacao;
    }
}