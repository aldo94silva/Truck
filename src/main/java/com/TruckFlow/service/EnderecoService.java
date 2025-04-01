package com.TruckFlow.service;

import com.TruckFlow.dtos.EnderecoDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Endereco;
import com.TruckFlow.repository.EnderecoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class EnderecoService {

    private static final String MSG_PLACA = "Placa já cadastrada com caminhão: %s";
    private static final String MSG_CAMINHAO = "Caminhão não encontrado";

    @Autowired
    EnderecoRepository enderecoRepository;


    public EnderecoDTO cadastarEndereco(EnderecoDTO enderecoDTO){

        Endereco endereco = converterEnderecoDTO(enderecoDTO);
        endereco = enderecoRepository.save(endereco);
        return converterEndereco(endereco);
    }

    public EnderecoDTO converterEndereco(Endereco enderecos) {
        EnderecoDTO enderecoDTO = new EnderecoDTO();
        enderecoDTO.setId(enderecos.getId());
        enderecoDTO.setCep(enderecos.getCep());
        enderecoDTO.setRua(enderecos.getRua());
        enderecoDTO.setBairro(enderecos.getBairro());
        enderecoDTO.setCidade(enderecos.getCidade());
        enderecoDTO.setUf(enderecos.getUf());
        enderecoDTO.setComplemento(enderecos.getComplemento());
        enderecoDTO.setNumero(enderecos.getNumero());
        return enderecoDTO;
    }


    public Endereco converterEnderecoDTO(EnderecoDTO enderecoDTO) {
        Endereco endereco = new Endereco();
        endereco.setId(enderecoDTO.getId());
        endereco.setCep(enderecoDTO.getCep());
        endereco.setRua(enderecoDTO.getRua());
        endereco.setBairro(enderecoDTO.getBairro());
        endereco.setCidade(enderecoDTO.getCidade());
        endereco.setUf(enderecoDTO.getUf());
        endereco.setComplemento(enderecoDTO.getComplemento());
        endereco.setNumero(enderecoDTO.getNumero());
        return endereco;
    }

    public void deleteEndereco(Long id){
        enderecoRepository.deleteById(id);
    }

    public EnderecoDTO updateEndereco(Long id, EnderecoDTO enderecoDTO) {
      Endereco enderecoAtualizado = converterEnderecoDTO(enderecoDTO);
      enderecoAtualizado.setId(id);
      enderecoRepository.save(enderecoAtualizado);
      return converterEndereco(enderecoAtualizado);

    }

    public List<EnderecoDTO> listarEnderecos() {
        return enderecoRepository.findAll().stream().map(endereco -> converterEndereco(endereco)).collect(Collectors.toList());
    }

    public EnderecoDTO buscarEnderecoPorId(Long id) {
        Endereco endereco = enderecoRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_CAMINHAO));

        return converterEndereco(endereco);
    }

}
