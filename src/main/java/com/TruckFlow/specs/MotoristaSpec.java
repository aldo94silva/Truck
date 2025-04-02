package com.TruckFlow.specs;

import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Motorista;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class MotoristaSpec {

    private static final String MSG_ID = "Caminhão não encontrado";
    private static final String MSG_CPF = "CPF já cadastrado com o motorista: %s";
    private static final String MSG_CNH = "CNH cadastrada com o motorista: %s";
    private static final String MSG_TELEFONE = "Telefone cadastrado com o motorista: %s";


    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessExeption(MSG_ID);

    }

    public void verificarSeExisteDuplicidade(Motorista existente, MotoristaDTO novoMotorista) {
        if (existente.getCpf().equals(novoMotorista.getCpf())) {
            throw new BusinessExeption(String.format(MSG_CPF, existente.getNome()));
        }
        if (existente.getCnh().equals(novoMotorista.getCnh())) {
            throw new BusinessExeption(String.format(MSG_CNH, existente.getNome()));
        }
        if (existente.getTelefone().equals(novoMotorista.getTelefone())) {
            throw new BusinessExeption(String.format(MSG_TELEFONE, existente.getNome()));
        }
    }


//    public void verificarPlacaEmUso(Caminhao caminhao, CaminhaoDTO caminhaoDTO) {
//        boolean alterouPlaca = (!(caminhao.getPlaca().equals(caminhaoDTO.getPlaca())));
//
//        if ((alterouPlaca) && (nonNull(caminhaoDTO.findByPlaca(caminhaoDTO.getPlaca())))) {
//            throw new BusinessExeption(
//                    String.format(MSG_PLACA, caminhaoDTO.getPlaca()));
//        }
//
//    }
}
