package com.TruckFlow.dtos;

import com.TruckFlow.models.Frete;
import lombok.Data;

import java.util.List;

@Data
public class EnderecoDTO {

    private Long id;

    private String cep;

    private String rua;

    private String bairro;

    private String cidade;

    private String uf;

    private String complemento;

    private String numero;

    private List<FreteDTO> fretes;
}
