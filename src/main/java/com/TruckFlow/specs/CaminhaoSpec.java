package com.TruckFlow.specs;


import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class CaminhaoSpec {

    private static final String MSG_ID = "Id não pode ser nulo";
    private static final String MSG_PLACA = "Caminhão já cadastrado com esta placa: %s";


    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessExeption(MSG_ID);

    }

    public void verificarSeExistePlacaDuplicada(Caminhao caminhao) {
        if (nonNull(caminhao)) {
            throw new BusinessExeption(
                    String.format(MSG_PLACA, caminhao.getPlaca()));
        }
    }



//    public void verificarPlacaEmUso(Caminhao caminhao, CaminhaoDTO caminhaoDTO) {
//        boolean alterouPlaca = (!(caminhao.getPlaca().equals(caminhaoDTO.getPlaca())));
//
//        if ((alterouPlaca) && (nonNull(caminhaoDTO.findByPlaca(caminhaoDTO.getPlaca())))) {
//            throw new BusinessExeption(
//                    String.format(MSG_PLACA, caminhaoDTO.getPlaca()));
//        }
//    }
}
