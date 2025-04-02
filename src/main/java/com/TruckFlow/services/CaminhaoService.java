package com.TruckFlow.services;

import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.repositories.CaminhaoRepository;
import com.TruckFlow.specs.CaminhaoSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;


@Service
public class CaminhaoService {

    private static final String MSG_CAMINHAO = "Caminhão não encontrado";

    @Autowired
    CaminhaoRepository caminhaoRepository;

    @Autowired
    CaminhaoSpec caminhaoSpec;

    @Autowired
    MotoristaService motoristaService;


    public CaminhaoDTO cadastarCaminhao(CaminhaoDTO caminhaoDTO) {

        Caminhao placaExistente = caminhaoRepository.findByPlaca(caminhaoDTO.getPlaca());
        caminhaoSpec.verificarSeExistePlacaDuplicada(placaExistente);

        Caminhao caminhao = converterCaminhaoDTO(caminhaoDTO);
        caminhao = caminhaoRepository.save(caminhao);
        return converterCaminhao(caminhao);
    }

    public CaminhaoDTO converterCaminhao(Caminhao caminhoes) {
        CaminhaoDTO caminhaoDTO = new CaminhaoDTO();
        caminhaoDTO.setId(caminhoes.getId());
        caminhaoDTO.setMarca(caminhoes.getMarca());
        caminhaoDTO.setPlaca(caminhoes.getPlaca());
        caminhaoDTO.setModelo(caminhoes.getModelo());
        caminhaoDTO.setCor(caminhoes.getCor());
        caminhaoDTO.setCapacidade(caminhoes.getCapacidade());

        // Verifica se o caminhão tem motorista antes de buscar
        caminhaoDTO.setMotorista(caminhoes.getMotorista() != null ?
                motoristaService.buscarmotoristaPorId(caminhoes.getMotorista().getId()) : null);

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

        caminhao.setMotorista(caminhaoDTO.getMotorista() != null ?
                motoristaService.converterMotoristaDTO(caminhaoDTO.getMotorista()) : null);

        return caminhao;
    }

    public void deleteCaminhao(CaminhaoDTO caminhaoDTO) {
        caminhaoSpec.verificarCampoIdNulo(caminhaoDTO.getId());
        caminhaoRepository.deleteById(caminhaoDTO.getId());
    }

    public CaminhaoDTO updateCaminhao(CaminhaoDTO caminhaoDTO) {
        caminhaoSpec.verificarCampoIdNulo(caminhaoDTO.getId());
        Caminhao caminhaoAtualizado = converterCaminhaoDTO(caminhaoDTO);
        caminhaoRepository.save(caminhaoAtualizado);
        return converterCaminhao(caminhaoAtualizado);
    }

    public List<CaminhaoDTO> listarCaminhaos() {
        return caminhaoRepository.findAll().stream().map(caminhao -> converterCaminhao(caminhao)).
                collect(Collectors.toList());
    }

    public CaminhaoDTO buscarCaminhaoPorId(Long id) {
        Caminhao caminhao = caminhaoRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_CAMINHAO));

        return converterCaminhao(caminhao);
    }

}
