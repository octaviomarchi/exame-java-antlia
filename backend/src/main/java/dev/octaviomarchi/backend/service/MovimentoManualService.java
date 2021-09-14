package dev.octaviomarchi.backend.service;

import dev.octaviomarchi.backend.dtos.MovimentoManualRequestDTO;
import dev.octaviomarchi.backend.dtos.MovimentoManualResponseDTO;

public interface MovimentoManualService {

    MovimentoManualResponseDTO salvarMovimentoManual(MovimentoManualRequestDTO movimentoManualRequestDTO);
}
