package com.TruckFlow.controller;


import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/caminhoes")
public class CaminhaoController {

    @Autowired
    CaminhaoService caminhaoService;

    @GetMapping()
    public List<CaminhaoDTO> listarCaminhaos() {
        return caminhaoService.listarCaminhaos();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CaminhaoDTO> buscarCaminhaoPorId(@PathVariable Long id) {
        return ResponseEntity.ok(caminhaoService.buscarCaminhaoPorId(id));
    }

    @PostMapping()
    public ResponseEntity<CaminhaoDTO> createCaminhao(@RequestBody CaminhaoDTO caminhaoDTO) {
        CaminhaoDTO caminhao = caminhaoService.cadastarCaminhao(caminhaoDTO);
        return ResponseEntity.status(HttpStatus.CREATED)
                .body(caminhao);
    }

    @DeleteMapping()
    public ResponseEntity<Void> deleteCaminhao(@RequestBody CaminhaoDTO caminhaoDTO) {
        caminhaoService.deleteCaminhao(caminhaoDTO);
        return ResponseEntity.noContent().build();
    }

    @PutMapping
    public ResponseEntity<CaminhaoDTO> updateCaminhao(@RequestBody CaminhaoDTO caminhaoDTO) {
        return ResponseEntity.ok(caminhaoService.updateCaminhao(caminhaoDTO));
    }

}
