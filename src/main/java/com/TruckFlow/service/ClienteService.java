package com.TruckFlow.service;

import com.TruckFlow.dtos.ClienteDTO;
import com.TruckFlow.exceptions.BusinessExeption;
import com.TruckFlow.models.Cliente;
import com.TruckFlow.models.Motorista;
import com.TruckFlow.repository.ClienteRepository;
import com.TruckFlow.spec.ClienteSpec;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

import static java.util.Objects.isNull;

@Service
public class ClienteService {


    private static final String MSG_cliente = "Cliente não encontrado";

    @Autowired
    ClienteRepository clienteRepository;

    @Autowired
    private ClienteSpec clienteSpec;

    public ClienteDTO cadastarCliente(ClienteDTO clienteDTO) {
        Optional<Cliente> clienteExistente = clienteRepository
                .findByCnpjCpfOrTelefone(clienteDTO.getCnpjCpf(),
                        clienteDTO.getTelefone());

        if (clienteExistente.isPresent()) {
            clienteSpec.verificarSeExisteDuplicidade(clienteExistente.get(), clienteDTO);
        }
        Cliente cliente = converterClienteDTO(clienteDTO);
        cliente = clienteRepository.save(cliente);
        return converterCliente(cliente);
    }

    public ClienteDTO converterCliente(Cliente clientes) {
        ClienteDTO clienteDTO = new ClienteDTO();
        clienteDTO.setId(clientes.getId());
        clienteDTO.setNome(clientes.getNome());
        clienteDTO.setCnpjCpf(clientes.getCnpjCpf());
        clienteDTO.setTelefone(clientes.getTelefone());
        return clienteDTO;
    }

    public Cliente converterClienteDTO(ClienteDTO clienteDTO) {
        Cliente cliente = new Cliente();
        cliente.setId(clienteDTO.getId());
        cliente.setNome(clienteDTO.getNome());
        cliente.setCnpjCpf(clienteDTO.getCnpjCpf());
        cliente.setTelefone(clienteDTO.getTelefone());
        return cliente;
    }

    public void deleteCliente(ClienteDTO clienteDTO) {
        clienteSpec.verificarCampoIdNulo(clienteDTO.getId());
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
