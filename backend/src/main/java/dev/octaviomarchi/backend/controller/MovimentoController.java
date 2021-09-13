package dev.octaviomarchi.backend.controller;

import dev.octaviomarchi.backend.dtos.MovimentoDTO;
import dev.octaviomarchi.backend.dtos.MovimentoRespostaDTO;
import dev.octaviomarchi.backend.service.MovimentoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/movements")
public class MovimentoController {

    @Autowired
    MovimentoManualService movimentoManualService;

    @PostMapping()
    @CrossOrigin(origins = "http://localhost:4200/")
    public ResponseEntity<MovimentoRespostaDTO> criarMovimentoManual(@RequestBody MovimentoDTO movimentoDTO) {
        return ResponseEntity.created(null).body(movimentoManualService.salvarMovimentoManual(movimentoDTO));
    }
}
