package com.example.ecomigo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

// LIXEIRA (Foco Principal e Conteúdo Educacional)
@Entity
@Table(name = "LIXEIRA")
public class Lixeira {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_LIXEIRA")
    private Long idLixeira;

    @Column(name = "COR_LIXEIRA", unique = true, nullable = false)
    private String corLixeira;

    // Conteúdo Educacional (Mapeado para TEXT)
    @Column(name = "INFO_POR_QUE_VAI_NA_LIXEIRA", columnDefinition = "TEXT", nullable = false)
    private String infoPorQueVaiNaLixeira;

    @Column(name = "INFO_IMPORTANCIA_RECICLAR", columnDefinition = "TEXT", nullable = false)
    private String infoImportanciaReciclar;

    @Column(name = "INFO_VIRA_DEPOIS", columnDefinition = "TEXT")
    private String infoViraDepois;

    @Column(name = "INSTRUCOES_COMO_DESCARTAR", columnDefinition = "TEXT", nullable = false)
    private String instrucoesComoDescartar;

    @OneToMany(mappedBy = "lixeira", cascade = CascadeType.ALL)
    private List<Material> materiais;

    // ... Getters e Setters
}