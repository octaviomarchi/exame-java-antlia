package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.converter.ProdutoCosifMapper;
import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.model.Produto;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import dev.octaviomarchi.backend.repository.ProdutoRepository;
import dev.octaviomarchi.backend.service.ProdutoCosifService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProdutoCosifServiceImpl implements ProdutoCosifService {

    @Autowired
    ProdutoRepository produtoRepository;

    @Override
    public List<ProdutoCosifDTO> getProdutoCosifListDoProduto(String codigoProduto) {
        Produto produto = produtoRepository.getById(codigoProduto);
        List<ProdutoCosif> produtoCosifList = produto.getProdutoCosifList();
        List<ProdutoCosifDTO> produtoCosifDTOList = ProdutoCosifMapper.INSTANCE.convertEntityListToProdutoCosifDTOList(produtoCosifList);
        return produtoCosifDTOList;
    }
}
