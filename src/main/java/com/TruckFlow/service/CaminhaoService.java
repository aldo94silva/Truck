package com.TruckFlow.service;

import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.repository.CaminhaoRepository;
import com.TruckFlow.repository.MotoristaRepository;
import com.TruckFlow.spec.CaminhaoSpec;
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
    private CaminhaoSpec caminhaoSpec;

    @Autowired
    private MotoristaService motoristaService;

    @Autowired
    private MotoristaRepository motoristaRepository;


    public CaminhaoDTO cadastarCaminhao(CaminhaoDTO caminhaoDTO){

        Caminhao placaExistente = caminhaoRepository.findByPlaca(caminhaoDTO.getPlaca());
        caminhaoSpec.verificarSeExistePlacaDuplicada(placaExistente);

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

        // Verifica se o caminhão tem motorista antes de buscar
        caminhaoDTO.setMotorista(caminhaos.getMotorista() != null ?
                motoristaService.buscarmotoristaPorId(caminhaos.getMotorista().getId()) : null);

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
        return caminhaoRepository.findAll().stream().map(caminhao -> converterCaminhao(caminhao)).
                collect(Collectors.toList());
    }

    public CaminhaoDTO buscarCaminhaoPorId(Long id) {
        Caminhao caminhao = caminhaoRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_CAMINHAO));

        return converterCaminhao(caminhao);
    }

}
