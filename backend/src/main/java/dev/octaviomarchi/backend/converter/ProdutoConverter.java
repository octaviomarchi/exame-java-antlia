package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.ProdutoDTO;
import dev.octaviomarchi.backend.model.Produto;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoConverter {

    public List<ProdutoDTO> convertEntityListToProdutoDTOList(List<Produto> produtoList) {
        return produtoList.stream().map(ProdutoDTO::new).collect(Collectors.toList());
    }
}
