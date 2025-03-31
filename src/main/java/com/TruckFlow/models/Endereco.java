package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;


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

    @OneToMany(mappedBy = "endereco")
    private List<Frete> fretes;

    public Endereco() {
    }

    public Endereco(Long id, String cep, String rua, String bairro, String cidade, String uf,
                    String complemento, String numero, List<Frete> fretes) {
        this.id = id;
        this.cep = cep;
        this.rua = rua;
        this.bairro = bairro;
        this.cidade = cidade;
        this.uf = uf;
        this.complemento = complemento;
        this.numero = numero;
        this.fretes = fretes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getCep() {
        return cep;
    }

    public void setCep(String cep) {
        this.cep = cep;
    }

    public String getRua() {
        return rua;
    }

    public void setRua(String rua) {
        this.rua = rua;
    }

    public String getBairro() {
        return bairro;
    }

    public void setBairro(String bairro) {
        this.bairro = bairro;
    }

    public String getCidade() {
        return cidade;
    }

    public void setCidade(String cidade) {
        this.cidade = cidade;
    }

    public String getUf() {
        return uf;
    }

    public void setUf(String uf) {
        this.uf = uf;
    }

    public String getComplemento() {
        return complemento;
    }

    public void setComplemento(String complemento) {
        this.complemento = complemento;
    }

    public String getNumero() {
        return numero;
    }

    public void setNumero(String numero) {
        this.numero = numero;
    }

    public List<Frete> getFretes() {
        return fretes;
    }

    public void setFretes(List<Frete> fretes) {
        this.fretes = fretes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Endereco endereco = (Endereco) o;
        return Objects.equals(id, endereco.id) && Objects.equals(cep, endereco.cep)
                && Objects.equals(rua, endereco.rua) && Objects.equals(bairro, endereco.bairro)
                && Objects.equals(cidade, endereco.cidade) && Objects.equals(uf, endereco.uf)
                && Objects.equals(complemento, endereco.complemento)
                && Objects.equals(numero, endereco.numero) && Objects.equals(fretes, endereco.fretes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, cep, rua, bairro, cidade, uf, complemento, numero, fretes);
    }
}
