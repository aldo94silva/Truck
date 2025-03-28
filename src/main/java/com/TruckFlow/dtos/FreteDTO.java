package com.TruckFlow.dtos;

import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Carga;
import com.TruckFlow.models.Cliente;
import com.TruckFlow.models.Endereco;
import lombok.Data;
import java.time.LocalDate;
import java.util.List;

@Data
public class FreteDTO {

    private Long id;

    private String origem;

    private String destino;

    private LocalDate data_saida;

    private LocalDate data_chegada;

    private String peso_carga;

    private String valor_frete;

    private CaminhaoDTO caminhao;

    private List<CargaDTO> cargas;

    private ClienteDTO cliente;

    private EnderecoDTO endereco;
}
