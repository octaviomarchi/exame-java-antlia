package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.MovimentoManualConverter;
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

    @Autowired
    MovimentoManualConverter movimentoManualConverter;

    @Override
    public MovimentoManualResponseDTO salvarMovimentoManual(MovimentoManualRequestDTO movimentoManualRequestDTO) {
        // converter aqui
        MovimentoManual movimentoManual = movimentoManualConverter.movimentoManualRequestDTOToEntity(movimentoManualRequestDTO);

        Long numeroLancamentosMes = movimentoManualRepository.getNumeroLancamentosMes(
                movimentoManual.getDatMes(),
                movimentoManual.getDatAno()
        );

        movimentoManual.setNumLancamento(numeroLancamentosMes + 1);

        MovimentoManual movimentoManualSaved = movimentoManualRepository.save(movimentoManual);

        MovimentoManualResponseDTO movimentoManualResponseDTO = movimentoManualConverter.movimentoManualToMovimentoManualResponseDTO(movimentoManualSaved);

        return movimentoManualResponseDTO;
    }
}
