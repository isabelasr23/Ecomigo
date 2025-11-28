package com.example.ecomigo.model;

import jakarta.persistence.*;

@Entity
@Table(name = "OBJETO")
public class Objeto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_OBJETO")
    private Long idObjeto;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_MATERIAL", nullable = false)
    private Material material;

    @Column(name = "NOME_OBJETO", nullable = false)
    private String nomeObjeto;

    // ... Getters e Setters
}