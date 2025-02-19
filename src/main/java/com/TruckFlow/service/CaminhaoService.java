package com.TruckFlow.service;

import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CaminhaoService {

    @Autowired
    CaminhaoRepository caminhaoRepository;

    public CaminhaoDTO cadastarCaminhao(CaminhaoDTO caminhaoDTO){
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



}
