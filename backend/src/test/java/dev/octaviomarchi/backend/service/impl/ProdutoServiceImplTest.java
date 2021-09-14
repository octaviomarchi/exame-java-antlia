package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.dtos.ProdutoDTO;
import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.repository.ProdutoRepository;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertEquals;
import static org.junit.jupiter.api.Assertions.assertNotNull;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ProdutoServiceImplTest {

    @InjectMocks
    private ProdutoServiceImpl service;

    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    void getProdutosParaDropdown() {
        Mockito.when(produtoRepository.findAll())
                .thenReturn(Arrays.asList(new Produto("ABCD", "descricao", "A")));

        List<ProdutoDTO> response = service.getProdutosParaDropdown();
        assertNotNull(response);
        assertEquals(1, response.size());
        assertEquals("ABCD", response.get(0).getCodigo());
        assertEquals("descricao", response.get(0).getDescricao());
    }
}