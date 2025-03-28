package com.TruckFlow.dtos;

import com.TruckFlow.models.Frete;
import com.TruckFlow.models.Motorista;
import com.fasterxml.jackson.annotation.JsonInclude;
import lombok.Data;

import java.util.List;

@Data
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
}
