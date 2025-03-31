package com.TruckFlow.dtos;


import com.TruckFlow.models.Frete;
import lombok.Data;

@Data
public class CargaDTO {


    private Long id;

    private String descricao;

    private String peso;

    private String tipo_de_carga;

    private FreteDTO frete;

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

    public FreteDTO getFrete() {
        return frete;
    }

    public void setFrete(FreteDTO frete) {
        this.frete = frete;
    }
}
