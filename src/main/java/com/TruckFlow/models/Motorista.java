package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String cnh;

    @Column(nullable = true)
    private String telefone;

}
