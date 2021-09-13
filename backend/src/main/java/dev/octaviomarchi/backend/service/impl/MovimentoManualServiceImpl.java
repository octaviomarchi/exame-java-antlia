package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.MovimentoConverter;
import dev.octaviomarchi.backend.dtos.MovimentoDTO;
import dev.octaviomarchi.backend.dtos.MovimentoRespostaDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import dev.octaviomarchi.backend.model.MovimentoManualId;
import dev.octaviomarchi.backend.model.ProdutoCosif;
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

        int numeroMovimento = movimentoManualRepository.getNumeroLancamentos(
                movimentoManual.getDatMes(),
                movimentoManual.getDatAno()
        );

        log.info("Numero de Lancamentos: " + numeroMovimento);

        movimentoManual.setNumLancamento((long) (numeroMovimento + 1));

        MovimentoManual movimentoManualSaved = movimentoManualRepository.save(movimentoManual);

        MovimentoRespostaDTO movimentoRespostaDTO = movimentoConverter.movimentoManualToMovimentoRespostaDTO(movimentoManualSaved);

        return movimentoRespostaDTO;

    }
}
