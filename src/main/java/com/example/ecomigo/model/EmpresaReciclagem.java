package com.example.ecomigo.model;


import jakarta.persistence.*;


@Entity
@Table(name = "EMPRESA_RECICLAGEM")
public class EmpresaReciclagem {

    @Id
    @Column(name = "ID_USUARIO")
    private Long idUsuario;

    @OneToOne(fetch = FetchType.LAZY)
    @MapsId
    @JoinColumn(name = "ID_USUARIO")
    private Usuario usuario;

    @Column(name = "CNPJ", unique = true, nullable = false)
    private String cnpj;

    @Column(name = "NOME_FANTASIA", nullable = false)
    private String nomeFantasia;

    @Column(name = "TIPO_ORGANIZACAO", nullable = false)
    private String tipoOrganizacao;

    @Column(name = "TELEFONE", nullable = false)
    private String telefone;

    // Campos de Endereço e Geolocalização
    @Column(name = "CEP", nullable = false) private String cep;
    @Column(name = "LOGRADOURO", nullable = false) private String logradouro;
    @Column(name = "NUMERO", nullable = false) private String numero;
    @Column(name = "BAIRRO", nullable = false) private String bairro;
    @Column(name = "MUNICIPIO", nullable = false) private String municipio;
    @Column(name = "ESTADO", nullable = false) private String estado;
    @Column(name = "COMPLEMENTO") private String complemento;
    @Column(name = "LATITUDE") private Double latitude;
    @Column(name = "LONGITUDE") private Double longitude;

    // ... Getters e Setters
}