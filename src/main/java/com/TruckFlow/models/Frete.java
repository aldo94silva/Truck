package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.time.LocalDate;
import java.util.List;
import java.util.Objects;


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

    @ManyToOne(optional = true)
    @JoinColumn(name = "cliente_id", nullable = true)
    private Cliente cliente;

    @ManyToOne(optional = true)
    @JoinColumn(name = "endereco_id", nullable = true)
    private Endereco endereco;

    public Frete() {
    }

    public Frete(Long id, String origem, String destino, LocalDate data_saida, LocalDate data_chegada,
                 String peso_carga, String valor_frete, Caminhao caminhao, List<Carga> cargas,
                 Cliente cliente, Endereco endereco) {
        this.id = id;
        this.origem = origem;
        this.destino = destino;
        this.data_saida = data_saida;
        this.data_chegada = data_chegada;
        this.peso_carga = peso_carga;
        this.valor_frete = valor_frete;
        this.caminhao = caminhao;
        this.cargas = cargas;
        this.cliente = cliente;
        this.endereco = endereco;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getOrigem() {
        return origem;
    }

    public void setOrigem(String origem) {
        this.origem = origem;
    }

    public String getDestino() {
        return destino;
    }

    public void setDestino(String destino) {
        this.destino = destino;
    }

    public LocalDate getData_saida() {
        return data_saida;
    }

    public void setData_saida(LocalDate data_saida) {
        this.data_saida = data_saida;
    }

    public LocalDate getData_chegada() {
        return data_chegada;
    }

    public void setData_chegada(LocalDate data_chegada) {
        this.data_chegada = data_chegada;
    }

    public String getPeso_carga() {
        return peso_carga;
    }

    public void setPeso_carga(String peso_carga) {
        this.peso_carga = peso_carga;
    }

    public String getValor_frete() {
        return valor_frete;
    }

    public void setValor_frete(String valor_frete) {
        this.valor_frete = valor_frete;
    }

    public Caminhao getCaminhao() {
        return caminhao;
    }

    public void setCaminhao(Caminhao caminhao) {
        this.caminhao = caminhao;
    }

    public List<Carga> getCargas() {
        return cargas;
    }

    public void setCargas(List<Carga> cargas) {
        this.cargas = cargas;
    }

    public Cliente getCliente() {
        return cliente;
    }

    public void setCliente(Cliente cliente) {
        this.cliente = cliente;
    }

    public Endereco getEndereco() {
        return endereco;
    }

    public void setEndereco(Endereco endereco) {
        this.endereco = endereco;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Frete frete = (Frete) o;
        return Objects.equals(id, frete.id) && Objects.equals(origem, frete.origem)
                && Objects.equals(destino, frete.destino) && Objects.equals(data_saida, frete.data_saida)
                && Objects.equals(data_chegada, frete.data_chegada)
                && Objects.equals(peso_carga, frete.peso_carga)
                && Objects.equals(valor_frete, frete.valor_frete)
                && Objects.equals(caminhao, frete.caminhao) && Objects.equals(cargas, frete.cargas)
                && Objects.equals(cliente, frete.cliente) && Objects.equals(endereco, frete.endereco);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, origem, destino, data_saida, data_chegada, peso_carga, valor_frete, caminhao, cargas, cliente, endereco);
    }
}
