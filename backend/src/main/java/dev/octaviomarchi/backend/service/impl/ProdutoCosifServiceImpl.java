package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.ProdutoCosifConverter;
import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import dev.octaviomarchi.backend.repository.ProdutoRepository;
import dev.octaviomarchi.backend.service.ProdutoCosifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
public class ProdutoCosifServiceImpl implements ProdutoCosifService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Autowired
    ProdutoCosifConverter produtoCosifConverter;

    @Override
    public List<ProdutoCosifDTO> getProdutoCosifListDoProduto(String codigoProduto) {
        Produto produto = produtoRepository.getById(codigoProduto);
        List<ProdutoCosif> produtoCosifList = produto.getProdutoCosifList();
        List<ProdutoCosifDTO> produtoCosifDTOList = produtoCosifConverter.convertEntityListToProdutoCosifDTOList(produtoCosifList);
        return produtoCosifDTOList;
    }
}
