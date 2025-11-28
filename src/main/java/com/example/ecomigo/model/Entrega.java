package com.example.ecomigo.model;

import jakarta.persistence.*;
import java.time.LocalDateTime;
import java.util.List;

@Entity
@Table(name = "ENTREGA")
public class Entrega {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "ID_ENTREGA")
    private Long idEntrega;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PF", nullable = false)
    private PessoaFisica pessoaFisica;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "ID_PJ", nullable = false)
    private EmpresaReciclagem empresaReciclagem;

    @Column(name = "DATA_ENTREGA", nullable = false)
    private LocalDateTime dataEntrega;

    @OneToMany(mappedBy = "entrega", cascade = CascadeType.ALL)
    private List<Coleta> itensColetados;

    // ... Getters e Setters
}