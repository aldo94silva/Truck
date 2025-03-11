package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_caminhao")
public class Caminhao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String marca;

    @Column(nullable = true, unique = true)
    private String placa;

    @Column(nullable = true)
    private String modelo;

    @Column(nullable = true)
    private String cor;

    @Column(nullable = true)
    private String capacidade;

}
