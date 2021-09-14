package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.MovimentoManualMapper;
import dev.octaviomarchi.backend.dtos.MovimentoManualRequestDTO;
import dev.octaviomarchi.backend.dtos.MovimentoManualResponseDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import dev.octaviomarchi.backend.repository.MovimentoManualRepository;
import dev.octaviomarchi.backend.service.MovimentoManualService;
import lombok.extern.log4j.Log4j2;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
@Log4j2
public class MovimentoManualServiceImpl implements MovimentoManualService {

    @Autowired
    MovimentoManualRepository movimentoManualRepository;

    @Override
    public MovimentoManualResponseDTO salvarMovimentoManual(MovimentoManualRequestDTO movimentoManualRequestDTO) {

        MovimentoManual movimentoManual = MovimentoManualMapper.INSTANCE
                .movimentoManualRequestDTOToEntity(movimentoManualRequestDTO);

        Long numeroLancamentosMes = movimentoManualRepository.getNumeroLancamentosMes(
                movimentoManual.getDatMes(),
                movimentoManual.getDatAno()
        );

        movimentoManual.setNumLancamento(numeroLancamentosMes + 1);

        MovimentoManual movimentoManualSaved = movimentoManualRepository.save(movimentoManual);

        MovimentoManualResponseDTO movimentoManualResponseDTO = MovimentoManualMapper.INSTANCE
                .movimentoManualToMovimentoManualResponseDTO(movimentoManualSaved);

        return movimentoManualResponseDTO;
    }
}
