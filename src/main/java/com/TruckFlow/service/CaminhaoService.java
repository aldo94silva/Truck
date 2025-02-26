package com.TruckFlow.service;

import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class CaminhaoService {

    private static final String MSG_PLACA = "Placa já cadastrada com caminhão: %s";

    @Autowired
    CaminhaoRepository caminhaoRepository;

    public CaminhaoDTO cadastarCaminhao(CaminhaoDTO caminhaoDTO){
        Caminhao placaExistente = caminhaoRepository.findByMarca(caminhaoDTO.getMarca());

        if(nonNull(placaExistente)){
            throw new BusinessExeption(String.format(MSG_PLACA, caminhaoDTO.getMarca()));
        }

        Caminhao caminhao = converterCaminhaoDTO(caminhaoDTO);
        caminhao = caminhaoRepository.save(caminhao);
        return converterCaminhao(caminhao);
    }

    public CaminhaoDTO converterCaminhao(Caminhao caminhaos) {
       CaminhaoDTO caminhaoDTO = new CaminhaoDTO();
       caminhaoDTO.setId(caminhaos.getId());
       caminhaoDTO.setMarca(caminhaos.getMarca());
       caminhaoDTO.setPlaca(caminhaos.getPlaca());
       caminhaoDTO.setModelo(caminhaos.getModelo());
       caminhaoDTO.setCor(caminhaos.getCor());
       caminhaoDTO.setCapacidade(caminhaos.getCapacidade());
       return caminhaoDTO;
    }

    public Caminhao converterCaminhaoDTO(CaminhaoDTO caminhaoDTO) {
        Caminhao caminhao = new Caminhao();
        caminhao.setId(caminhaoDTO.getId());
        caminhao.setMarca(caminhaoDTO.getMarca());
        caminhao.setPlaca(caminhaoDTO.getPlaca());
        caminhao.setModelo(caminhaoDTO.getModelo());
        caminhao.setCor(caminhaoDTO.getCor());
        caminhao.setCapacidade(caminhaoDTO.getCapacidade());
        return caminhao;
    }

    public void deleteCaminhao(Long id){
        caminhaoRepository.deleteById(id);
    }

    public CaminhaoDTO updateCaminhao(Long id, CaminhaoDTO caminhaoDTO) {
      Caminhao caminhaoAtualizado = converterCaminhaoDTO(caminhaoDTO);
      caminhaoAtualizado.setId(id);
      caminhaoRepository.save(caminhaoAtualizado);
      return converterCaminhao(caminhaoAtualizado);

    }

    public List<CaminhaoDTO> listarCaminhaos() {
        return caminhaoRepository.findAll().stream().map(caminhao -> converterCaminhao(caminhao)).collect(Collectors.toList());
    }

    public CaminhaoDTO buscarCaminhaoPorId(Long id) {
        Caminhao caminhao = caminhaoRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption("Caminhão não encontrado"));

        return converterCaminhao(caminhao);
    }

}
