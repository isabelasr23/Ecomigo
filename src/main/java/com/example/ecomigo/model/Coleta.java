package com.example.ecomigo.model;

import jakarta.persistence.*;
import java.math.BigDecimal;

@Entity
@Table(name = "COLETA")
public class Coleta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_COLETA")
    private Long idColeta;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_ENTREGA", nullable = false)
    private Entrega entrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MATERIAL", nullable = false)
    private Material material;

    @Column(name = "VOLUME_PESO", precision = 10, scale = 2, nullable = false)
    private BigDecimal volumePeso;

    @Column(name = "PONTOS_ATRIBUIDOS", nullable = false)
    private Integer pontosAtribuidos;

    @Column(name = "IMAGEM_PROVA", nullable = false)
    private String imagemProva;

    // ... Getters e Setters
}