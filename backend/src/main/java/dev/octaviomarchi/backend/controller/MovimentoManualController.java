package dev.octaviomarchi.backend.controller;

import dev.octaviomarchi.backend.dtos.MovimentoManualRequestDTO;
import dev.octaviomarchi.backend.dtos.MovimentoManualResponseDTO;
import dev.octaviomarchi.backend.service.MovimentoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movimentos-manuais")
@CrossOrigin(origins = "http://localhost:4200/")
public class MovimentoManualController {

    @Autowired
    MovimentoManualService movimentoManualService;

    @PostMapping()
    public ResponseEntity<MovimentoManualResponseDTO> criarMovimentoManual(@RequestBody MovimentoManualRequestDTO movimentoManualRequestDTO) {
        return ResponseEntity.created(null).body(movimentoManualService.salvarMovimentoManual(movimentoManualRequestDTO));
    }
}
