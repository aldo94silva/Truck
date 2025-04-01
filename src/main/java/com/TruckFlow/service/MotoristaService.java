package com.TruckFlow.service;

import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Motorista;
import com.TruckFlow.repository.MotoristaRepository;
import com.TruckFlow.spec.MotoristaSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class MotoristaService {


    private static final String MSG_MOTORISTA = "Caminhão não encontrado";

    @Autowired
    MotoristaRepository motoristaRepository;

    @Autowired
    MotoristaSpec motoristaSpec;


    public MotoristaDTO cadastrarMotorista(MotoristaDTO motoristaDTO) {
        Optional<Motorista> motoristaExistente = motoristaRepository
                .findByCpfOrCnhOrTelefone(motoristaDTO.getCpf(), motoristaDTO.getCnh(),
                        motoristaDTO.getTelefone());

        if (motoristaExistente.isPresent()) {
            motoristaSpec.verificarSeExisteDuplicidade(motoristaExistente.get(), motoristaDTO);
        }

        Motorista motorista = converterMotoristaDTO(motoristaDTO);
        motorista = motoristaRepository.save(motorista);
        return converterMotorista(motorista);
    }


    public MotoristaDTO converterMotorista(Motorista motoristas) {
        MotoristaDTO motoristaDTO = new MotoristaDTO();
        motoristaDTO.setId(motoristas.getId());
        motoristaDTO.setNome(motoristas.getNome());
        motoristaDTO.setCpf(motoristas.getCpf());
        motoristaDTO.setCnh(motoristas.getCnh());
        motoristaDTO.setTelefone(motoristas.getTelefone());
        return motoristaDTO;
    }

    public Motorista converterMotoristaDTO(MotoristaDTO motoristaDTO) {
        Motorista motorista = new Motorista();
        motorista.setId(motoristaDTO.getId());
        motorista.setNome(motoristaDTO.getNome());
        motorista.setCpf(motoristaDTO.getCpf());
        motorista.setCnh(motoristaDTO.getCnh());
        motorista.setTelefone(motoristaDTO.getTelefone());
        return motorista;
    }

    public void deletemotorista(MotoristaDTO motoristaDTO) {
        if (isNull(motoristaDTO.getId())) {
            throw new BusinessExeption("Caminhão não encontrado");
        }
        motoristaRepository.deleteById(motoristaDTO.getId());
    }

    public MotoristaDTO updatemotorista(MotoristaDTO motoristaDTO) {
        Motorista motoristaAtualizado = converterMotoristaDTO(motoristaDTO);
        motoristaAtualizado.setId(motoristaDTO.getId());
        motoristaRepository.save(motoristaAtualizado);
        return converterMotorista(motoristaAtualizado);
    }

    public List<MotoristaDTO> listarmotoristas() {
        return motoristaRepository.findAll().stream().map(motorista -> converterMotorista(motorista))
                .collect(Collectors.toList());
    }

    public MotoristaDTO buscarmotoristaPorId(Long id) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_MOTORISTA));

        return converterMotorista(motorista);
    }
}
