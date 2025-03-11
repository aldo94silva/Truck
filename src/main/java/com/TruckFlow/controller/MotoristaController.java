package com.TruckFlow.controller;


import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.repository.MotoristaRepository;
import com.TruckFlow.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motorista")
public class MotoristaController {

    @Autowired
    private MotoristaRepository motoristaRepository;

    @Autowired
    private MotoristaService motoristaService;

    @GetMapping()
    public List<MotoristaDTO> listarMotoristas() {
        return motoristaService.listarmotoristas();
    }
    @GetMapping("/{id}")
    public ResponseEntity<MotoristaDTO> buscarMotoristaPorId (@PathVariable Long id){
        return ResponseEntity.ok(motoristaService.buscarmotoristaPorId(id));
    }

    @PostMapping()
    public ResponseEntity<MotoristaDTO> createMotorista (@RequestBody MotoristaDTO MotoristaDTO){
            MotoristaDTO caminhao = motoristaService.cadastarmotorista(MotoristaDTO);
            return ResponseEntity.ok(MotoristaDTO);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMotorista (@PathVariable Long id){
            motoristaService.deleteMotorista(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<MotoristaDTO> updateMotoristas (@PathVariable Long id, @RequestBody MotoristaDTO MotoristaDTO){
            MotoristaDTO motoristaAtualizado = motoristaService.updatemotorista(id, MotoristaDTO);
            return ResponseEntity.ok(motoristaAtualizado);
    }
}
