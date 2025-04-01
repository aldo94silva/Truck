package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.Objects;


@Entity
@Table(name = "tb_carga")
public class Carga {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String descricao;

    @Column(nullable = true)
    private String peso;

    @Column(nullable = true)
    private String tipo_de_carga;

    @ManyToOne(optional = true)
    @JoinColumn(name = "frete_id", nullable = true)
    private Frete frete;

    public Carga() {
    }

    public Carga(Long id, String descricao, String peso, String tipo_de_carga, Frete frete) {
        this.id = id;
        this.descricao = descricao;
        this.peso = peso;
        this.tipo_de_carga = tipo_de_carga;
        this.frete = frete;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getDescricao() {
        return descricao;
    }

    public void setDescricao(String descricao) {
        this.descricao = descricao;
    }

    public String getPeso() {
        return peso;
    }

    public void setPeso(String peso) {
        this.peso = peso;
    }

    public String getTipo_de_carga() {
        return tipo_de_carga;
    }

    public void setTipo_de_carga(String tipo_de_carga) {
        this.tipo_de_carga = tipo_de_carga;
    }

    public Frete getFrete() {
        return frete;
    }

    public void setFrete(Frete frete) {
        this.frete = frete;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Carga carga = (Carga) o;
        return Objects.equals(id, carga.id) && Objects.equals(descricao, carga.descricao) && Objects.equals(peso, carga.peso) && Objects.equals(tipo_de_carga, carga.tipo_de_carga) && Objects.equals(frete, carga.frete);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, descricao, peso, tipo_de_carga, frete);
    }
}
