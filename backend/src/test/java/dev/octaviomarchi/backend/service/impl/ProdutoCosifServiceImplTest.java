package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import dev.octaviomarchi.backend.repository.ProdutoRepository;
import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.api.extension.ExtendWith;
import org.mockito.InjectMocks;
import org.mockito.Mockito;
import org.mockito.junit.jupiter.MockitoExtension;
import org.springframework.boot.test.mock.mockito.MockBean;
import org.springframework.test.context.junit.jupiter.SpringExtension;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@ExtendWith(MockitoExtension.class)
@ExtendWith(SpringExtension.class)
class ProdutoCosifServiceImplTest {

    @InjectMocks
    private ProdutoCosifServiceImpl produtoCosifService;

    @MockBean
    private ProdutoRepository produtoRepository;

    @Test
    void getProdutoCosifListDoProduto() {
        Produto produto = new Produto("AAA", "desc", "A");
        ProdutoCosif produtoCosif = new ProdutoCosif("0101", "PCA", "A", produto);
        produto.setProdutoCosifList(Arrays.asList(produtoCosif));

        Mockito.when(produtoRepository.getById(produto.getCodProduto()))
                .thenReturn(produto);

        List<ProdutoCosifDTO> response = produtoCosifService.getProdutoCosifListDoProduto("AAA");
        assertNotNull(response);
        assertEquals("0101", response.get(0).getCodigoCosif());
        assertEquals("PCA", response.get(0).getClassificacao());
    }
}