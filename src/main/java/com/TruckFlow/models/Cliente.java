package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;


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

    public Cliente() {
    }

    public Cliente(Long id, String nome, String cnpj_cpf, String telefone, List<Frete> fretes) {
        this.id = id;
        this.nome = nome;
        this.cnpj_cpf = cnpj_cpf;
        this.telefone = telefone;
        this.fretes = fretes;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getNome() {
        return nome;
    }

    public void setNome(String nome) {
        this.nome = nome;
    }

    public String getCnpj_cpf() {
        return cnpj_cpf;
    }

    public void setCnpj_cpf(String cnpj_cpf) {
        this.cnpj_cpf = cnpj_cpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
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
        Cliente cliente = (Cliente) o;
        return Objects.equals(id, cliente.id) && Objects.equals(nome, cliente.nome)
                && Objects.equals(cnpj_cpf, cliente.cnpj_cpf)
                && Objects.equals(telefone, cliente.telefone) && Objects.equals(fretes, cliente.fretes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cnpj_cpf, telefone, fretes);
    }
}
