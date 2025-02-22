package com.TruckFlow.controller;



import com.TruckFlow.dtos.CaminhaoDTO;
import com.TruckFlow.repository.CaminhaoRepository;
import com.TruckFlow.service.CaminhaoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/caminhao")
public class CaminhaoController {

    @Autowired
    private CaminhaoRepository ccaminhaoRepository;

    @Autowired
    private CaminhaoService caminhaoService;

    @GetMapping ()
    public String index(){
        return "TruckFLow";
    }

    @PostMapping()
    public ResponseEntity<CaminhaoDTO> createCaminhao(@RequestBody CaminhaoDTO caminhaoDTO){
        CaminhaoDTO caminhao = caminhaoService.cadastarCaminhao(caminhaoDTO);
        return ResponseEntity.ok(caminhaoDTO);
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deleteCaminhao(@PathVariable Long id){
        caminhaoService.deleteCaminhao(id);
        return ResponseEntity.noContent().build();
    }

    @PutMapping("/{id}")
    public ResponseEntity<CaminhaoDTO> updateCaminhao(@PathVariable Long id, @RequestBody CaminhaoDTO caminhaoDTO){
        CaminhaoDTO caminhaoAtualizado = caminhaoService.updateCaminhao(id, caminhaoDTO);
        return ResponseEntity.ok(caminhaoAtualizado);
    }
}
