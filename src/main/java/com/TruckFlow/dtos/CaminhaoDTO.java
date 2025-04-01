package com.TruckFlow.dtos;

import com.TruckFlow.models.Frete;
import com.TruckFlow.models.Motorista;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;


@JsonInclude(JsonInclude.Include.NON_NULL)
public class CaminhaoDTO {

    private Long id;

    private String marca;

    private String placa;

    private String modelo;

    private String cor;

    private String capacidade;

    private MotoristaDTO motorista;

    private List<FreteDTO> fretes;

    public Object findByPlaca(String placa) {
        return null;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getMarca() {
        return marca;
    }

    public void setMarca(String marca) {
        this.marca = marca;
    }

    public String getPlaca() {
        return placa;
    }

    public void setPlaca(String placa) {
        this.placa = placa;
    }

    public String getModelo() {
        return modelo;
    }

    public void setModelo(String modelo) {
        this.modelo = modelo;
    }

    public String getCor() {
        return cor;
    }

    public void setCor(String cor) {
        this.cor = cor;
    }

    public String getCapacidade() {
        return capacidade;
    }

    public void setCapacidade(String capacidade) {
        this.capacidade = capacidade;
    }

    public MotoristaDTO getMotorista() {
        return motorista;
    }

    public void setMotorista(MotoristaDTO motorista) {
        this.motorista = motorista;
    }

    public List<FreteDTO> getFretes() {
        return fretes;
    }

    public void setFretes(List<FreteDTO> fretes) {
        this.fretes = fretes;
    }
}
