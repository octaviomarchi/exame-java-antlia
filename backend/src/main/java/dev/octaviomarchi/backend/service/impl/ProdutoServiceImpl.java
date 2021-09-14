package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.ProdutoMapper;
import dev.octaviomarchi.backend.dtos.ProdutoDTO;
import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.repository.ProdutoRepository;
import dev.octaviomarchi.backend.service.ProdutoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoServiceImpl implements ProdutoService {

    @Autowired
    ProdutoRepository produtoRepository;

    public List<ProdutoDTO> getProdutosParaDropdown() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProdutoDTO> produtoDTOS = ProdutoMapper.INSTANCE.convertEntityListToProdutoDTOList(produtos);
        return produtoDTOS;
    }
}
