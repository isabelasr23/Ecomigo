package com.example.ecomigo.model;

import jakarta.persistence.*;
import jakarta.validation.constraints.Email;
import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.Size;

@Entity
@Table(name = "USUARIO")
@Inheritance(strategy = InheritanceType.JOINED)
public class Usuario  {
    public enum TipoCadastro { PF(1), PJ(2); private final int valor; TipoCadastro(int valor) { this.valor = valor; } public int getValor() { return valor; } }

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @NotBlank(message = "O nome não pode estar em branco")
    @Column(name = "NOME", nullable = false)
    private String nome;

    @NotBlank(message = "O nome de usuário não pode estar em branco")
    @Size(min = 3, message = "O nome de usuário deve ter pelo menos 3 caracteres")
    @Column(name = "NOME_USUARIO", unique = true, nullable = false)
    private String nomeUsuario;

    @NotBlank(message = "O email não pode estar em branco")
    @Email(message = "Formato de e-mail inválido")
    @Column(name = "EMAIL", unique = true, nullable = false)
    private String email;

    @NotBlank(message = "A senha não pode estar em branco")
    @Size(min = 6, message = "A senha deve ter pelo menos 6 caracteres")
    @Column(name = "SENHA", nullable = false)
    private String senha;

    @Enumerated(EnumType.ORDINAL)
    @Column(name = "TIPO_CADASTRO", nullable = false)
    private TipoCadastro tipoCadastro;


    public Long getIdUsuario() {
        return idUsuario;
    }

    public void setIdUsuario(Long idUsuario) {
        this.idUsuario = idUsuario;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getNomeUsuario() {
        return nomeUsuario;
    }

    public void setNomeUsuario(String nomeUsuario) {
        this.nomeUsuario = nomeUsuario;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getSenha() {
        return senha;
    }

    public void setSenha(String senha) {
        this.senha = senha;
    }

    public TipoCadastro getTipoCadastro() {
        return tipoCadastro;
    }

    public void setTipoCadastro(TipoCadastro tipoCadastro) {
        this.tipoCadastro = tipoCadastro;
    }
}