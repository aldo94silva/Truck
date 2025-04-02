package com.TruckFlow.controllers;


import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.services.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
public class MotoristaController {

    @Autowired
    MotoristaService motoristaService;

    @GetMapping()
    public List<MotoristaDTO> listarMotoristas() {
        return motoristaService.listarmotoristas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDTO> buscarMotoristaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(motoristaService.buscarmotoristaPorId(id));
    }

    @PostMapping()
    public ResponseEntity<MotoristaDTO> createMotorista(@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO motorista = motoristaService.cadastrarMotorista(motoristaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(motorista);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteMotorista(@RequestBody MotoristaDTO motoristaDTO) {
        motoristaService.deletemotorista(motoristaDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<MotoristaDTO> updateMotoristas(@RequestBody MotoristaDTO motoristaDTO) {
        MotoristaDTO motoristaAtualizado = motoristaService.updatemotorista(motoristaDTO);
        return ResponseEntity.ok(motoristaAtualizado);
    }
}
