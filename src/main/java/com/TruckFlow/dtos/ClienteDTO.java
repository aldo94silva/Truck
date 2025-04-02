package com.TruckFlow.dtos;


import com.TruckFlow.models.Frete;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;
import java.util.Objects;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

    private Long id;

    private String nome;

    private String cnpjCpf;

    private String telefone;

    private List<FreteDTO> fretes;

    public ClienteDTO() {
    }

    public ClienteDTO(Long id, String nome, String cnpjCpf, String telefone, List<FreteDTO> fretes) {
        this.id = id;
        this.nome = nome;
        this.cnpjCpf = cnpjCpf;
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

    public String getCnpjCpf() {
        return cnpjCpf;
    }

    public void setCnpjCpf(String cnpjCpf) {
        this.cnpjCpf = cnpjCpf;
    }

    public String getTelefone() {
        return telefone;
    }

    public void setTelefone(String telefone) {
        this.telefone = telefone;
    }

    public List<FreteDTO> getFretes() {
        return fretes;
    }

    public void setFretes(List<FreteDTO> fretes) {
        this.fretes = fretes;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        ClienteDTO that = (ClienteDTO) o;
        return Objects.equals(id, that.id) && Objects.equals(nome, that.nome) && Objects.equals(cnpjCpf, that.cnpjCpf) && Objects.equals(telefone, that.telefone) && Objects.equals(fretes, that.fretes);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, nome, cnpjCpf, telefone, fretes);
    }
}
