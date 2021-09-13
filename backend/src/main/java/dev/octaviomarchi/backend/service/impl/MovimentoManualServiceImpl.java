package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.MovimentoConverter;
import dev.octaviomarchi.backend.dtos.MovimentoDTO;
import dev.octaviomarchi.backend.dtos.MovimentoRespostaDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import dev.octaviomarchi.backend.model.MovimentoManualId;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import dev.octaviomarchi.backend.repository.MovimentoManualRepository;
import dev.octaviomarchi.backend.service.MovimentoManualService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class MovimentoManualServiceImpl implements MovimentoManualService {

    @Autowired
    MovimentoManualRepository movimentoManualRepository;

    @Autowired
    MovimentoConverter movimentoConverter;

    @Override
    public MovimentoRespostaDTO salvarMovimentoManual(MovimentoDTO movimentoDTO) {
        MovimentoManual movimentoManual = new MovimentoManual(
                Long.valueOf(movimentoDTO.getMes()),
                Long.valueOf(movimentoDTO.getAno()),
                movimentoDTO.getDescricao(),
                movimentoDTO.getValor(),
                new ProdutoCosif(movimentoDTO.getCosif())
        );

        MovimentoManual movimentoManualSaved = movimentoManualRepository.save(movimentoManual);

        return movimentoConverter.movimentoManualToMovimentoRespostaDTO(movimentoManualSaved);

    }
}
