package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.ProdutoCosifDTO;
import dev.octaviomarchi.backend.model.ProdutoCosif;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper
public interface ProdutoCosifMapper {
    ProdutoCosifMapper INSTANCE = Mappers.getMapper(ProdutoCosifMapper.class);

    List<ProdutoCosifDTO> convertEntityListToProdutoCosifDTOList(List<ProdutoCosif> produtoCosifList);

    @Mappings({
            @Mapping(source = "codCosif", target = "codigoCosif"),
            @Mapping(source = "codClassificacao", target = "classificacao")
    })
    ProdutoCosifDTO convertEntityToProdutoCosifDTO(ProdutoCosif produtoCosif);

}
