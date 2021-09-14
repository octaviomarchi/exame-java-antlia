package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.ProdutoDTO;
import dev.octaviomarchi.backend.model.Produto;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdutoMapper {

    ProdutoMapper INSTANCE = Mappers.getMapper(ProdutoMapper.class);

    List<ProdutoDTO> convertEntityListToProdutoDTOList(List<Produto> produtoList);

    @Mappings({
            @Mapping(source = "codProduto", target = "codigo"),
            @Mapping(source = "desProduto", target = "descricao")
    })
    ProdutoDTO convertEntityToProdutoDTO(Produto produtoList);

}
