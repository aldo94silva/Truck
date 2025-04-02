package com.TruckFlow.spec;

import com.TruckFlow.dtos.ClienteDTO;
import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Caminhao;
import com.TruckFlow.models.Cliente;
import com.TruckFlow.models.Motorista;
import com.TruckFlow.repository.CaminhaoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import static java.util.Objects.isNull;
import static java.util.Objects.nonNull;

@Service
public class ClienteSpec {

    private static final String MSG_ID = "Cleinte não encontrado";
    private static final String MSG_CPF = "CPF já cadastrado com o cliente: %s";
    private static final String MSG_TELEFONE = "Telefone cadastrado com o cliente: %s";


    public void verificarCampoIdNulo(Long id) {
        if (isNull(id)) throw new BusinessExeption(MSG_ID);

    }

    public void verificarSeExisteDuplicidade(Cliente existente, ClienteDTO novocliente) {
        if (existente.getCnpjCpf().equals(novocliente.getCnpjCpf())) {
            throw new BusinessExeption(String.format(MSG_CPF, existente.getNome()));
        }
        if (existente.getTelefone().equals(novocliente.getTelefone())) {
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
