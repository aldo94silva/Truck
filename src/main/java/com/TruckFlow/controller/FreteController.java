package com.TruckFlow.controller;


import com.TruckFlow.dtos.FreteDTO;
import com.TruckFlow.service.FreteService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/fretes")
public class FreteController {

    @Autowired
    FreteService freteService;

    @GetMapping()
    public List<FreteDTO> listarFretes() {
        return freteService.listarFrete();
    }

    @GetMapping("/{id}")
    public ResponseEntity<FreteDTO> buscarFretePorId(@PathVariable Long id) {
        return ResponseEntity.ok(freteService.buscarFretePorId(id));
    }

    @PostMapping()
    public ResponseEntity<FreteDTO> createFrete(@RequestBody FreteDTO freteDTO) {
        FreteDTO frete = freteService.cadastarFrete(freteDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(frete);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteFrete(@RequestBody FreteDTO freteDTO) {
        freteService.deleteFrete(freteDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<FreteDTO> updateFretes(@PathVariable Long id, @RequestBody FreteDTO FreteDTO) {
        FreteDTO freteAtualizado = freteService.updateFrete(id, FreteDTO);
        return ResponseEntity.ok(freteAtualizado);
    }
}
