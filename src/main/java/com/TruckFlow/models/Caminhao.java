package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;

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

    @ManyToOne(optional = true)
    @JoinColumn(name = "motorista_id", nullable = true)
    private Motorista motorista;

    @OneToMany(mappedBy = "caminhao")
    private List<Frete> fretes;

    public Caminhao() {
    }

    public Caminhao(Long id, String marca, String placa, String modelo, String cor, String capacidade,
                    Motorista motorista, List<Frete> fretes) {
        this.id = id;
        this.marca = marca;
        this.placa = placa;
        this.modelo = modelo;
        this.cor = cor;
        this.capacidade = capacidade;
        this.motorista = motorista;
        this.fretes = fretes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public List<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }

    public Motorista getMotorista() {
        return motorista;
    }

    public void setMotorista(Motorista motorista) {
        this.motorista = motorista;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Caminhao caminhao = (Caminhao) o;
        return Objects.equals(id, caminhao.id) && Objects.equals(marca, caminhao.marca) && Objects.equals(placa, caminhao.placa) && Objects.equals(modelo, caminhao.modelo) && Objects.equals(cor, caminhao.cor) && Objects.equals(capacidade, caminhao.capacidade) && Objects.equals(motorista, caminhao.motorista) && Objects.equals(fretes, caminhao.fretes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, marca, placa, modelo, cor, capacidade, motorista, fretes);
    }
}
