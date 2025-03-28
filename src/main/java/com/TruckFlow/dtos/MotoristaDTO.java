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

}
