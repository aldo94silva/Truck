package com.TruckFlow.controller;


import com.TruckFlow.dtos.ClienteDTO;
import com.TruckFlow.repository.ClienteRepository;
import com.TruckFlow.service.ClienteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/clientes")
public class ClienteController {

    @Autowired
    ClienteService clienteService;

    @GetMapping()
    public List<ClienteDTO> listarClientes() {
        return clienteService.listarClientes();
    }

    @GetMapping("/{id}")
    public ResponseEntity<ClienteDTO> buscarClientePorId(@PathVariable Long id) {
        ClienteDTO cliente = clienteService.buscarClientePorId(id);
        return ResponseEntity.ok(cliente);
    }

    @PostMapping()
    public ResponseEntity<ClienteDTO> createCliente(@RequestBody ClienteDTO clienteDTO) {
        ClienteDTO cliente = clienteService.cadastarCliente(clienteDTO);
        return ResponseEntity.ok(cliente);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCliente(@PathVariable Long id) {
        clienteService.deleteCliente(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<ClienteDTO> updateCliente(@PathVariable Long id, @RequestBody ClienteDTO clienteDTO) {
        ClienteDTO clienteAtualizado = clienteService.updateCliente(id, clienteDTO);
        return ResponseEntity.ok(clienteAtualizado);
    }
}
