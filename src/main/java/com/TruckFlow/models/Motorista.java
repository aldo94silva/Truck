package com.TruckFlow.models;


import jakarta.persistence.*;
import lombok.Data;

import java.util.List;
import java.util.Objects;


@Entity
@Table(name = "tb_motorista")
public class Motorista {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @Column(nullable = true)
    private String nome;

    @Column(nullable = true, unique = true)
    private String cpf;

    @Column(nullable = true, unique = true)
    private String cnh;

    @Column(nullable = true)
    private String telefone;

    @OneToMany(mappedBy = "motorista")
    private List<Caminhao> caminhoes;

    public Motorista() {
    }

    public Motorista(Long id, String nome, String cpf, String cnh, String telefone, List<Caminhao> caminhoes) {
        this.id = id;
        this.nome = nome;
        this.cpf = cpf;
        this.cnh = cnh;
        this.telefone = telefone;
        this.caminhoes = caminhoes;
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

    public String getCpf() {
        return cpf;
    }

    public void setCpf(String cpf) {
        this.cpf = cpf;
    }

    public String getCnh() {
        return cnh;
    }

    public void setCnh(String cnh) {
        this.cnh = cnh;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<Caminhao> getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(List<Caminhao> caminhoes) {
        this.caminhoes = caminhoes;
    }

    @Override
    public boolean equals(Object o) {
        if (o == null || getClass() != o.getClass()) return false;
        Motorista motorista = (Motorista) o;
        return Objects.equals(id, motorista.id) && Objects.equals(nome, motorista.nome)
                && Objects.equals(cpf, motorista.cpf) && Objects.equals(cnh, motorista.cnh)
                && Objects.equals(telefone, motorista.telefone)
                && Objects.equals(caminhoes, motorista.caminhoes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cpf, cnh, telefone, caminhoes);
    }
}
