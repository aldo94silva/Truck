package com.TruckFlow.specs;

import com.TruckFlow.exceptions.BusinessExeption;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;

@Service
public class FreteSpec {

    private static final String MSG_ID = "Frete não encontrado";



    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessExeption(MSG_ID);

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
