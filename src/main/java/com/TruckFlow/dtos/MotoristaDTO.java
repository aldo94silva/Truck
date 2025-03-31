package com.TruckFlow.dtos;



import lombok.Data;

import java.util.List;


@Data
public class MotoristaDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String cnh;

    private String telefone;

    private List<CaminhaoDTO> caminhoes;

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

    public List<CaminhaoDTO> getCaminhoes() {
        return caminhoes;
    }

    public void setCaminhoes(List<CaminhaoDTO> caminhoes) {
        this.caminhoes = caminhoes;
    }
}
