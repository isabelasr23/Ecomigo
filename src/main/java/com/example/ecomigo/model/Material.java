package com.example.ecomigo.model;

import jakarta.persistence.*;

import java.math.BigDecimal;
import java.util.List;

@Entity
@Table(name = "MATERIAL")
public class Material {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_MATERIAL")
    private Long idMaterial;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_LIXEIRA", nullable = false)
    private Lixeira lixeira;

    @Column(name = "NOME", unique = true, nullable = false)
    private String nome;

    @Column(name = "RECICLAVEL", nullable = false)
    private Boolean reciclavel;

    // Campo para cálculo de pontuação (RF006)
    @Column(name = "VALOR_PONTO_KG", precision = 5, scale = 2, nullable = false)
    private BigDecimal valorPontoKg;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<Objeto> objetos;

    @OneToMany(mappedBy = "material", cascade = CascadeType.ALL)
    private List<PJMaterial> pjsAceitam;

    // ... Getters e Setters
}