package com.TruckFlow.controllers;


import com.TruckFlow.dtos.CargaDTO;
import com.TruckFlow.services.CargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargas")
public class CargaController {

    @Autowired
    CargaService cargaService;

    @GetMapping()
    public List<CargaDTO> listarCargas() {
        return cargaService.listarCargas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargaDTO> buscarCargaPorId(@PathVariable Long id) {
        return ResponseEntity.ok(cargaService.buscarCargaPorId(id));
    }

    @PostMapping()
    public ResponseEntity<CargaDTO> createCarga(@RequestBody CargaDTO cargaDTO) {
        CargaDTO carga = cargaService.cadastarCarga(cargaDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(carga);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteCarga(@RequestBody CargaDTO cargaDTO) {
        cargaService.deleteCarga(cargaDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping()
    public ResponseEntity<CargaDTO> updateCarga( @RequestBody CargaDTO cargaDTO) {
        CargaDTO cargaAtualizada = cargaService.updateCarga(cargaDTO);
        return ResponseEntity.ok(cargaAtualizada);
    }
}
