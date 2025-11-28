package com.example.ecomigo.model;

import jakarta.persistence.*;


@Entity
@Table(name = "PJ_MATERIAL")
public class PJMaterial {

    @EmbeddedId
    private PJMaterialId id;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idUsuario")
    @JoinColumn(name = "ID_USUARIO")
    private EmpresaReciclagem empresaReciclagem;

    @ManyToOne(fetch = FetchType.LAZY)
    @MapsId("idMaterial")
    @JoinColumn(name = "ID_MATERIAL")
    private Material material;

    // ... Getters e Setters
}