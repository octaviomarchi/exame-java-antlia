package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.MovimentoRespostaDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import org.springframework.stereotype.Component;

@Component
public class MovimentoConverter {

    public MovimentoRespostaDTO movimentoManualToMovimentoRespostaDTO(MovimentoManual movimentoManual) {
        MovimentoRespostaDTO movimentoRespostaDTO = new MovimentoRespostaDTO();
        movimentoRespostaDTO.setAno(movimentoManual.getDatAno());
        return movimentoRespostaDTO;
    }
}
