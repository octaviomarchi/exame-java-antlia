package dev.octaviomarchi.backend.service.impl;

import dev.octaviomarchi.backend.dtos.ProductDTO;
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

    public List<ProductDTO> getProductsForDropdown() {
        List<Produto> produtos = produtoRepository.findAll();
        List<ProductDTO> productDTOS = produtos.stream().map(ProductDTO::new).collect(Collectors.toList());
        return productDTOS;
    }
}
