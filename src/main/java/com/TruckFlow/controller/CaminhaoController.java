package com.TruckFlow.controller;


import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
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
        return ResponseEntity.ok(caminhao);
    }


    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaminhao(@PathVariable Long id) {
        caminhaoService.deleteCaminhao(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaminhaoDTO> updateCaminhao(@PathVariable Long id, @RequestBody CaminhaoDTO caminhaoDTO) {
        CaminhaoDTO caminhaoAtualizado = caminhaoService.updateCaminhao(id, caminhaoDTO);
        return ResponseEntity.ok(caminhaoAtualizado);
    }
}
