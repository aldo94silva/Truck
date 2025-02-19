package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;

@Data
@Entity
@Table(name = "frete")
public class Frete {


    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String origem;

    @Column(nullable = true)
    private String destino;

    @Column(nullable = true)
    private LocalDate data_saida;

    @Column(nullable = true)
    private LocalDate data_chegada;

    @Column(nullable = true)
    private String peso_carga;

    @Column(nullable = true)
    private String valor_frete;

}
