package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import org.springframework.stereotype.Component;

import java.util.List;
import java.util.stream.Collectors;

@Component
public class ProdutoCosifConverter {

    public List<ProdutoCosifDTO> convertEntityListToProdutoCosifDTOList(List<ProdutoCosif> produtoCosifList) {
        return produtoCosifList.stream().map(ProdutoCosifDTO::new).collect(Collectors.toList());
    }
}
