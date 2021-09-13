package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.MovimentoManualRequestDTO;
import dev.octaviomarchi.backend.dtos.MovimentoManualResponseDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import org.springframework.stereotype.Component;

@Component
public class MovimentoManualConverter {

    public MovimentoManualResponseDTO movimentoManualToMovimentoRespostaDTO(MovimentoManual movimentoManual) {
        MovimentoManualResponseDTO movimentoManualResponseDTO = new MovimentoManualResponseDTO();
        movimentoManualResponseDTO.setAno(movimentoManual.getDatAno());
        movimentoManualResponseDTO.setMes(movimentoManual.getDatMes());
        movimentoManualResponseDTO.setCodigoProduto(movimentoManual.getProdutoCosif().getProduto().getCodProduto());
        movimentoManualResponseDTO.setDescricaoProduto(movimentoManual.getProdutoCosif().getProduto().getDesProduto());
        movimentoManualResponseDTO.setDescricao(movimentoManual.getDesDescricao());
        movimentoManualResponseDTO.setValor(movimentoManual.getValValor());
        movimentoManualResponseDTO.setLancamento(movimentoManual.getNumLancamento());
        return movimentoManualResponseDTO;
    }

    public MovimentoManual movimentoManualRequestDTOToEntity(MovimentoManualRequestDTO movimentoManualRequestDTO) {
        return new MovimentoManual(
                Long.valueOf(movimentoManualRequestDTO.getMes()),
                Long.valueOf(movimentoManualRequestDTO.getAno()),
                movimentoManualRequestDTO.getDescricao(),
                movimentoManualRequestDTO.getValor(),
                new ProdutoCosif(movimentoManualRequestDTO.getCosif())
        );
    }
}
