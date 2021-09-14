package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.MovimentoManualMapper;
import dev.octaviomarchi.backend.dtos.MovimentoManualRequestDTO;
import dev.octaviomarchi.backend.dtos.MovimentoManualResponseDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import dev.octaviomarchi.backend.repository.MovimentoManualRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import static org.junit.jupiter.api.Assertions.assertNotNull;
import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.mockito.ArgumentMatchers.any;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class MovimentoManualServiceImplTest {

    @InjectMocks
    private MovimentoManualServiceImpl movimentoManualService;

    @MockBean
    private MovimentoManualRepository movimentoManualRepository;

    @Test
    void salvarMovimentoManual() {
        MovimentoManualRequestDTO movimentoManualRequestDTO = new MovimentoManualRequestDTO(
                "2",
                "2021",
                "AAAA",
                "AA01",
                Double.valueOf("150"),
                "descricao mm"
        );

        Produto produto = new Produto("AAAA", "desc", "A");
        ProdutoCosif produtoCosif = new ProdutoCosif("0101", "PCA", "A", produto);

        MovimentoManual movimentoManual = MovimentoManualMapper.INSTANCE
                .movimentoManualRequestDTOToEntity(movimentoManualRequestDTO);
        movimentoManual.setCodUsuario("TESTE");
        movimentoManual.setNumLancamento(1L);
        movimentoManual.setProdutoCosif(produtoCosif);

        Mockito
                .when(
                        movimentoManualRepository.getNumeroLancamentosMes(
                                Long.valueOf(movimentoManualRequestDTO.getMes()),
                                Long.valueOf(movimentoManualRequestDTO.getAno())
                        )
                ).thenReturn(0L);

        Mockito.when(movimentoManualRepository.save(any())).thenReturn(movimentoManual);

        MovimentoManualResponseDTO response = movimentoManualService.salvarMovimentoManual(movimentoManualRequestDTO);

        assertNotNull(response);
        assertEquals(2L, response.getMes());
        assertEquals(2021L, response.getAno());
        assertEquals("AAAA", response.getCodigoProduto());
        assertEquals("desc", response.getDescricaoProduto());
        assertEquals(1L, response.getLancamento());
        assertEquals(Double.valueOf("150"), response.getValor());
        assertEquals("descricao mm", response.getDescricao());
    }
}