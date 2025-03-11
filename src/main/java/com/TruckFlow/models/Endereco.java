package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "tb_endereco")
public class Endereco {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String cep;

    @Column(nullable = true)
    private String rua;

    @Column(nullable = true)
    private String bairro;

    @Column(nullable = true)
    private String cidade;

    @Column(nullable = true)
    private String uf;

    @Column(nullable = true)
    private String complemento;

    @Column(nullable = true)
    private String numero;




}
