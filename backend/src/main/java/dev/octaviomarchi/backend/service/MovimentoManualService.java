package dev.octaviomarchi.backend.service;

import dev.octaviomarchi.backend.dtos.MovimentoDTO;
import dev.octaviomarchi.backend.dtos.MovimentoRespostaDTO;

public interface MovimentoManualService {

    MovimentoRespostaDTO salvarMovimentoManual(MovimentoDTO movimentoDTO);
}
