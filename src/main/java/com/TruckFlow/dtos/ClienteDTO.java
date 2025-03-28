package com.TruckFlow.dtos;


import com.TruckFlow.models.Frete;
import lombok.Data;

import java.util.List;


@Data
public class ClienteDTO {

    private Long id;

    private String nome;

    private String cnpj_cpf;

    private String telefone;

    private List<FreteDTO> fretes;
}
