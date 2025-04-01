package com.TruckFlow.service;

import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.dtos.CargaDTO;
import com.TruckFlow.dtos.FreteDTO;
import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Carga;
import com.TruckFlow.repository.CaminhaoRepository;
import com.TruckFlow.repository.CargaRepository;
import com.TruckFlow.spec.CargaSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.nonNull;

@Service
public class CargaService {

    private static final String MSG_CARGA = "Carga não encontrada";
   ;

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private FreteService freteService;

    @Autowired
    private CargaSpec cargaSpec;


    public CargaDTO cadastarCarga(CargaDTO cargaDTO){
        Carga carga = converterCargaDTO(cargaDTO);
        carga = cargaRepository.save(carga);
        return converterCarga(carga);
    }

    public CargaDTO converterCarga(Carga carga) {
        CargaDTO cargaDTO = new CargaDTO();
        cargaDTO.setId(carga.getId());
        cargaDTO.setDescricao(carga.getDescricao());
        cargaDTO.setPeso(carga.getPeso());
        cargaDTO.setTipo_de_carga(carga.getTipo_de_carga());

        cargaDTO.setFrete(carga.getFrete() != null ?
                freteService.buscarFretePorId(carga.getFrete().getId()) : null);

        return cargaDTO;
    }


    public Carga converterCargaDTO(CargaDTO cargaDTO) {
        Carga carga = new Carga();
        carga.setId(cargaDTO.getId());
        carga.setDescricao(cargaDTO.getDescricao());
        carga.setPeso(cargaDTO.getPeso());
        carga.setTipo_de_carga(cargaDTO.getTipo_de_carga());

        carga.setFrete(cargaDTO.getFrete() != null ?
                freteService.converterFreteDTO(cargaDTO.getFrete()) : null);

        return carga;
    }

    public void deleteCarga(Long id){
        cargaRepository.deleteById(id);
    }


    public CargaDTO updateCarga(Long id, CargaDTO cargaDTO) {
      cargaSpec.verificarCampoIdNulo(id);


      Carga cargaAtualizado = converterCargaDTO(cargaDTO);
      cargaAtualizado.setId(id);
        Carga carga = cargaRepository.findById(cargaDTO.getId())
                .orElseThrow(() -> new BusinessExeption(MSG_CARGA));
      cargaRepository.save(cargaAtualizado);
      return converterCarga(cargaAtualizado);
    }

    public List<CargaDTO> listarCargas() {
        return cargaRepository.findAll().stream().map(carga -> converterCarga(carga)).collect(Collectors.toList());
    }

    public CargaDTO buscarCargaPorId(Long id) {

        Carga carga = cargaRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_CARGA));

        return converterCarga(carga);
    }
}



