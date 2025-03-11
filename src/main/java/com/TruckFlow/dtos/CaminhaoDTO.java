package com.TruckFlow.dtos;



import lombok.Data;

@Data
public class CaminhaoDTO {

    private Long id;

    private String marca;

    private String placa;

    private String modelo;

    private String cor;

    private String capacidade;

    public Object findByPlaca(String placa) {
        return null;
    }
}
