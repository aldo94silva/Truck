package com.TruckFlow.spec;

import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class ClienteSpec {

    @Autowired
    private CaminhaoRepository caminhaoRepository;

    private static final String MSG_ID = "Id não pode ser nulo";
    private static final String MSG_PLACA = "Caminhão já cadastrado com esta placa: %s";


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
