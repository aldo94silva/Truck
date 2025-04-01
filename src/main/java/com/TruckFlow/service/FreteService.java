package com.TruckFlow.service;

import com.TruckFlow.dtos.*;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Frete;
import com.TruckFlow.repository.EnderecoRepository;
import com.TruckFlow.repository.FreteRepository;
import com.TruckFlow.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class FreteService {

    private static final String MSG_CAMINHAO = "Caminhão não encontrado";

    @Autowired
    FreteRepository freteRepository;

    @Autowired
    CaminhaoService caminhaoService;

    @Autowired
    ClienteService clienteService;

    @Autowired
    EnderecoService enderecoService;


    public FreteDTO cadastarFrete(FreteDTO freteDTO) {
        Frete frete = converterFreteDTO(freteDTO);
        frete = freteRepository.save(frete);
        return converterFrete(frete);
    }

    public FreteDTO converterFrete(Frete frete) {
        FreteDTO freteDTO = new FreteDTO();
        freteDTO.setId(frete.getId());
        freteDTO.setOrigem(frete.getOrigem());
        freteDTO.setDestino(frete.getDestino());
        freteDTO.setData_saida(frete.getData_saida());
        freteDTO.setData_chegada(frete.getData_chegada());
        freteDTO.setPeso_carga(frete.getPeso_carga());
        freteDTO.setValor_frete(frete.getValor_frete());

        freteDTO.setCaminhao(frete.getCaminhao() != null ?
                caminhaoService.buscarCaminhaoPorId(frete.getCaminhao().getId()) : null);

        freteDTO.setCliente(frete.getCliente() != null ?
                clienteService.buscarClientePorId(frete.getCliente().getId()) : null);

        freteDTO.setEndereco(frete.getEndereco() != null ?
                enderecoService.buscarEnderecoPorId(frete.getEndereco().getId()) : null);

        return freteDTO;
    }

    public Frete converterFreteDTO(FreteDTO freteDTO) {
        Frete frete = new Frete();
        frete.setId(freteDTO.getId());
        frete.setOrigem(freteDTO.getOrigem());
        frete.setDestino(freteDTO.getDestino());
        frete.setData_saida(freteDTO.getData_saida());
        frete.setData_chegada(freteDTO.getData_chegada());
        frete.setPeso_carga(freteDTO.getPeso_carga());
        frete.setValor_frete(freteDTO.getValor_frete());

        frete.setCaminhao(freteDTO.getCaminhao() != null ?
                caminhaoService.converterCaminhaoDTO(freteDTO.getCaminhao()) : null);

        frete.setCliente(freteDTO.getCliente() != null ?
                clienteService.converterClienteDTO(freteDTO.getCliente()) : null);

        frete.setEndereco(freteDTO.getEndereco() != null ?
                enderecoService.converterEnderecoDTO(freteDTO.getEndereco()) : null);

        return frete;
    }

    public void deleteFrete(FreteDTO freteDTO) {
        if (isNull(freteDTO.getId())) {
            throw new BusinessExeption("Frete não encontrado");
        }
        freteRepository.deleteById(freteDTO.getId());
    }

    public FreteDTO updateFrete(Long id, FreteDTO freteDTO) {
        Frete freteAtualizado = converterFreteDTO(freteDTO);
        freteAtualizado.setId(id);
        freteRepository.save(freteAtualizado);
        return converterFrete(freteAtualizado);

    }

    public List<FreteDTO> listarFrete() {
        return freteRepository.findAll().stream().map(frete -> converterFrete(frete))
                .collect(Collectors.toList());
    }

    public FreteDTO buscarFretePorId(Long id) {
        Frete frete = freteRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_CAMINHAO));

        return converterFrete(frete);
    }

}
