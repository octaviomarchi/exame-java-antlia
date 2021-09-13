package dev.octaviomarchi.backend.service;

import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;

import java.util.List;

public interface ProdutoCosifService {

    List<ProdutoCosifDTO> getProdutoCosifListDoProduto(String codigoProduto);
}
