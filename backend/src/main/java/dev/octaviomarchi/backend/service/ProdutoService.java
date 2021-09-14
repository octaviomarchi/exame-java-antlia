package dev.octaviomarchi.backend.service;

import dev.octaviomarchi.backend.dtos.ProdutoDTO;

import java.util.List;

public interface ProdutoService {

    List<ProdutoDTO> getProdutosParaDropdown();
}
