package com.TruckFlow.dtos;


import com.TruckFlow.models.Frete;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class ClienteDTO {

    private Long id;

    private String nome;

    private String cnpj_cpf;

    private String telefone;

    private List<FreteDTO> fretes;

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

    public List<FreteDTO> getFretes() {
        return fretes;
    }

    public void setFretes(List<FreteDTO> fretes) {
        this.fretes = fretes;
    }
}
