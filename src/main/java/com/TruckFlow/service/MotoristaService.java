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
import java.util.stream.Collectors;

@Service
public class MotoristaService {


    private static final String MSG_motorista = "Caminhão não encontrado";

    @Autowired
    MotoristaRepository motoristaRepository;

    @Autowired
    MotoristaSpec motoristaSpec;


    public MotoristaDTO cadastarMotorista(MotoristaDTO motoristaDTO) {
        Motorista cpfExistente = motoristaRepository.findByCpf(motoristaDTO.getCpf());
        motoristaSpec.verificarSeExisteCpfDuplicada(cpfExistente);

        Motorista cnhExistente = motoristaRepository.findByCnh(motoristaDTO.getCnh());
        motoristaSpec.verificarSeExisteCnhDuplicada(cnhExistente);

        Motorista telefoneExistente = motoristaRepository.findBytelefone(motoristaDTO.getTelefone());
        motoristaSpec.verificarSeExisteTelefoneDuplicada(telefoneExistente);

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

    public void deletemotorista(Long id) {
        motoristaRepository.deleteById(id);
    }

    public MotoristaDTO updatemotorista(Long id, MotoristaDTO motoristaDTO) {
        Motorista motoristaAtualizado = converterMotoristaDTO(motoristaDTO);
        motoristaAtualizado.setId(id);
        motoristaRepository.save(motoristaAtualizado);
        return converterMotorista(motoristaAtualizado);

    }

    public List<MotoristaDTO> listarmotoristas() {


        return motoristaRepository.findAll().stream().map(motorista -> converterMotorista(motorista)).collect(Collectors.toList());
    }

    public MotoristaDTO buscarmotoristaPorId(Long id) {
        Motorista motorista = motoristaRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_motorista));

        return converterMotorista(motorista);
    }
}
