package com.TruckFlow.controller;


import com.TruckFlow.dtos.MotoristaDTO;
import com.TruckFlow.repository.MotoristaRepository;
import com.TruckFlow.service.MotoristaService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/motoristas")
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
    public ResponseEntity<MotoristaDTO> createMotorista (@RequestBody MotoristaDTO motoristaDTO){
            MotoristaDTO motorista = motoristaService.cadastarMotorista(motoristaDTO);
            return ResponseEntity.ok(motorista);
        }


        @DeleteMapping("/{id}")
        public ResponseEntity<Void> deleteMotorista (@PathVariable Long id){
            motoristaService.deletemotorista(id);
            return ResponseEntity.noContent().build();
        }

        @PutMapping("/{id}")
        public ResponseEntity<MotoristaDTO> updateMotoristas (@PathVariable Long id, @RequestBody MotoristaDTO MotoristaDTO){
            MotoristaDTO motoristaAtualizado = motoristaService.updatemotorista(id, MotoristaDTO);
            return ResponseEntity.ok(motoristaAtualizado);
    }
}
