package com.TruckFlow.controller;



import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.dtos.CargaDTO;
import com.TruckFlow.repository.CaminhaoRepository;
import com.TruckFlow.repository.CargaRepository;
import com.TruckFlow.service.CaminhaoService;
import com.TruckFlow.service.CargaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/cargas")
public class CargaController {

    @Autowired
    private CargaRepository cargaRepository;

    @Autowired
    private CargaService cargaService;

    @GetMapping()
    public List<CargaDTO> listarCargas() {
        return cargaService.listarCargas();
    }

    @GetMapping("/{id}")
    public ResponseEntity<CargaDTO> buscarCargaPorId (@PathVariable Long id){
        return ResponseEntity.ok(cargaService.buscarCargaPorId(id));
    }

    @PostMapping()
    public ResponseEntity<CargaDTO> createCarga (@RequestBody CargaDTO cargaDTO){
        CargaDTO cargaDTO1 = cargaService.cadastarCarga(cargaDTO);
            return ResponseEntity.ok(cargaDTO);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteCarga (@PathVariable Long id){
            cargaService.deleteCarga(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<CargaDTO> updateCarga (@PathVariable Long id, @RequestBody CargaDTO cargaDTO){
            CargaDTO cargaAtualizada = cargaService.updateCarga(id, cargaDTO);
            return ResponseEntity.ok(cargaAtualizada);
    }
}
