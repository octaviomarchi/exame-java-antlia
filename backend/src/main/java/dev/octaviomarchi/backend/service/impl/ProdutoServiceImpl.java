package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.ProdutoConverter;
import dev.octaviomarchi.backend.dtos.ProdutoDTO;
import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.repository.ProdutoRepository;
import dev.octaviomarchi.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoConverter produtoConverter;

    public List<ProdutoDTO> getProdutosParaDropdown() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> produtoDTOS = this.produtoConverter.convertEntityListToProdutoDTOList(produtos);
        return produtoDTOS;
    }
}
