package com.TruckFlow.service;

import com.TruckFlow.dtos.FreteDTO;
import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Frete;
import com.TruckFlow.repository.FreteRepository;
import com.TruckFlow.repository.MotoristaRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class FreteService {

    private static final String MSG_PLACA = "Placa já cadastrada com caminhão: %s";
    private static final String MSG_CAMINHAO = "Caminhão não encontrado";

    @Autowired
    FreteRepository freteRepository;

    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private MotoristaRepository motoristaRepository;


    public FreteDTO cadastarFrete(FreteDTO freteDTO){
        Frete frete = converterFreteDTO(freteDTO);
        frete = freteRepository.save(frete);
        return converterFrete(frete);
    }

    public FreteDTO converterFrete(Frete fretes) {
        FreteDTO freteDTO = new FreteDTO();
        freteDTO.setId(fretes.getId());
        freteDTO.setOrigem(fretes.getOrigem());
        freteDTO.setDestino(fretes.getDestino());
        freteDTO.setData_saida(fretes.getData_saida());
        freteDTO.setData_chegada(fretes.getData_chegada());
        freteDTO.setPeso_carga(fretes.getPeso_carga());
        freteDTO.setValor_frete(fretes.getValor_frete());
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
        return frete;
    }

    public void deleteFrete(Long id){
        freteRepository.deleteById(id);
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
