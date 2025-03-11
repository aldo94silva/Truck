package com.TruckFlow.dtos;



import jakarta.persistence.Column;
import lombok.Data;

@Data
public class MotoristaDTO {

    private Long id;

    private String nome;

    private String cpf;

    private String cnh;

    private String telefone;
}
