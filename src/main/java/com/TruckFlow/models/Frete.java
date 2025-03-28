package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;

@Data
@Entity
@Table(name = "tb_frete")
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

    @ManyToOne
    @JoinColumn(name = "caminhao_id")
    private Caminhao caminhao;

    @OneToMany(mappedBy = "frete")
    private List<Carga> cargas;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;

    @ManyToOne
    @JoinColumn(name = "endereco_id")
    private Endereco endereco;

}
