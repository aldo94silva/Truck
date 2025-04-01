package com.TruckFlow.controller;


import com.TruckFlow.dtos.EnderecoDTO;
import com.TruckFlow.repository.EnderecoRepository;
import com.TruckFlow.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/enderecos")
public class EnderecoController {

    @Autowired
    EnderecoService enderecoService;

    @GetMapping()
    public List<EnderecoDTO> listarEnderecos() {
        return enderecoService.listarEnderecos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<EnderecoDTO> buscarEnderecoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(enderecoService.buscarEnderecoPorId(id));
    }

    @PostMapping()
    public ResponseEntity<EnderecoDTO> createEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        EnderecoDTO endereco = enderecoService.cadastarEndereco(enderecoDTO);
        return ResponseEntity.ok(endereco);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteEndereco(@PathVariable Long id) {
        enderecoService.deleteEndereco(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> updateEnderecos(@PathVariable Long id, @RequestBody EnderecoDTO EnderecoDTO) {
        EnderecoDTO enderecoAtualizado = enderecoService.updateEndereco(id, EnderecoDTO);
        return ResponseEntity.ok(enderecoAtualizado);
    }
}
