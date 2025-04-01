package com.TruckFlow.spec;

import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Motorista;
import com.TruckFlow.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class MotoristaSpec {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    private static final String MSG_ID = "Id não pode ser nulo";
    private static final String MSG_CPF = "CPF já cadastrado com o motorista: %s";
    private static final String MSG_CNH = "CNH cadastrada com o motorista: %s";
    private static final String MSG_TELEFONE = "Telefone cadastrado com o motorista: %s";


    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessExeption(MSG_ID);

    }

    public void verificarSeExisteCpfDuplicada(Motorista motorista) {
        if (nonNull(motorista)) {
            throw new BusinessExeption(
                    String.format(MSG_CPF, motorista.getCpf()));
        }
    }

    public void verificarSeExisteCnhDuplicada(Motorista motorista) {
        if (nonNull(motorista)) {
            throw new BusinessExeption(
                    String.format(MSG_CNH, motorista.getCnh()));
        }
    }

    public void verificarSeExisteTelefoneDuplicada(Motorista motorista) {
        if (nonNull(motorista)) {
            throw new BusinessExeption(
                    String.format(MSG_CNH, motorista.getTelefone()));
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
