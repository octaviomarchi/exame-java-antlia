package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.MovimentoRespostaDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import org.springframework.stereotype.Component;

@Component
public class MovimentoConverter {

    public MovimentoRespostaDTO movimentoManualToMovimentoRespostaDTO(MovimentoManual movimentoManual) {
        MovimentoRespostaDTO movimentoRespostaDTO = new MovimentoRespostaDTO();
        movimentoRespostaDTO.setAno(movimentoManual.getDatAno());
        movimentoRespostaDTO.setMes(movimentoManual.getDatMes());
        movimentoRespostaDTO.setCodigoProduto(movimentoManual.getProdutoCosif().getProduto().getCodProduto());
        movimentoRespostaDTO.setDescricaoProduto(movimentoManual.getProdutoCosif().getProduto().getDesProduto());
        movimentoRespostaDTO.setDescricao(movimentoManual.getDesDescricao());
        movimentoRespostaDTO.setValor(movimentoManual.getValValor());
        movimentoRespostaDTO.setLancamento(movimentoManual.getNumLancamento());
        return movimentoRespostaDTO;
    }
}
