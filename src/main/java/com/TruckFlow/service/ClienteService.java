package com.TruckFlow.service;

import com.TruckFlow.dtos.ClienteDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Cliente;
import com.TruckFlow.repository.ClienteRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class ClienteService {


    private static final String MSG_cliente = "Cliente não encontrado";

    @Autowired
    ClienteRepository clienteRepository;

//    @Autowired
//    private ClienteSpec clienteSpec;

    public ClienteDTO cadastarCliente(ClienteDTO clienteDTO) {

        Cliente cliente = converterClienteDTO(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return converterCliente(cliente);
    }

    public ClienteDTO converterCliente(Cliente clientes) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clientes.getId());
        clienteDTO.setNome(clientes.getNome());
        clienteDTO.setCnpj_cpf(clientes.getCnpj_cpf());
        clienteDTO.setTelefone(clientes.getTelefone());
        return clienteDTO;
    }

    public Cliente converterClienteDTO(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCnpj_cpf(clienteDTO.getCnpj_cpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        return cliente;
    }

    public void deleteCliente(ClienteDTO clienteDTO) {
        if (isNull(clienteDTO.getId())) {
            throw new BusinessExeption("Cliente não encontrado");
        }
        clienteRepository.deleteById(clienteDTO.getId());
    }

    public ClienteDTO updateCliente(Long id, ClienteDTO clienteDTO) {
        Cliente clienteAtualizado = converterClienteDTO(clienteDTO);
        clienteAtualizado.setId(id);
        clienteRepository.save(clienteAtualizado);
        return converterCliente(clienteAtualizado);

    }

    public List<ClienteDTO> listarClientes() {
        return clienteRepository.findAll().stream().map(cliente -> converterCliente(cliente))
                .collect(Collectors.toList());
    }

    public ClienteDTO buscarClientePorId(Long id) {
        Cliente cliente = clienteRepository.findById(id)
                .orElseThrow(() -> new BusinessExeption(MSG_cliente));

        return converterCliente(cliente);
    }

}
