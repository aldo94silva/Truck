package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;

@Data
@Entity
@Table(name = "tb_cliente")
public class Cliente {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true)
    private String cnpj_cpf;

    @Column(nullable = true)
    private String telefone;

    @OneToMany(mappedBy = "cliente")
    private List<Frete> fretes;
}
