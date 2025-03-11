package com.TruckFlow.dtos;


import lombok.Data;

@Data
public class CargaDTO {


    private Long id;

    private String descricao;

    private String peso;

    private String tipo_de_carga;

}
