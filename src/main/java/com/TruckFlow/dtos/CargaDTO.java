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

}
