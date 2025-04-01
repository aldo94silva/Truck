package com.TruckFlow.controller;


import com.TruckFlow.dtos.EnderecoDTO;
import com.TruckFlow.service.EnderecoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
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
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(endereco);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteEndereco(@RequestBody EnderecoDTO enderecoDTO) {
        enderecoService.deleteEndereco(enderecoDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<EnderecoDTO> updateEndereco(@PathVariable Long id, @RequestBody EnderecoDTO EnderecoDTO) {
        EnderecoDTO enderecoAtualizado = enderecoService.updateEndereco(id, EnderecoDTO);
        return ResponseEntity.ok(enderecoAtualizado);
    }
}
