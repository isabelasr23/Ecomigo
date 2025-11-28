package com.example.ecomigo.model;

import jakarta.persistence.*;
import java.io.Serializable;
import java.util.Objects;

// PJMaterialId (CLASSE OBRIGATÓRIA para a Chave Composta)
@Embeddable
public class PJMaterialId implements Serializable {
    private static final long serialVersionUID = 1L;

    @Column(name = "ID_USUARIO") private Long idUsuario;
    @Column(name = "ID_MATERIAL") private Long idMaterial;

    // OBRIGATÓRIO: Construtores, equals() e hashCode() para chaves compostas
    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        PJMaterialId that = (PJMaterialId) o;
        return Objects.equals(idUsuario, that.idUsuario) &&
                Objects.equals(idMaterial, that.idMaterial);
    }
    @Override
    public int hashCode() { return Objects.hash(idUsuario, idMaterial); }
}