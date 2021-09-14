package dev.octaviomarchi.backend.converter;

import dev.octaviomarchi.backend.dtos.MovimentoManualRequestDTO;
import dev.octaviomarchi.backend.dtos.MovimentoManualResponseDTO;
import dev.octaviomarchi.backend.model.MovimentoManual;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Mappings;
import org.mapstruct.factory.Mappers;

@Mapper
public interface MovimentoManualMapper {

    MovimentoManualMapper INSTANCE = Mappers.getMapper(MovimentoManualMapper.class);

    @Mappings({
            @Mapping(source = "mes", target = "datMes"),
            @Mapping(source = "ano", target = "datAno"),
            @Mapping(source = "produto", target = "produtoCosif.produto.codProduto"),
            @Mapping(source = "cosif", target = "produtoCosif.codCosif"),
            @Mapping(source = "valor", target = "valValor"),
            @Mapping(source = "descricao", target = "desDescricao")
    })
    MovimentoManual movimentoManualRequestDTOToEntity(MovimentoManualRequestDTO movimentoManualRequestDTO);

    @Mappings({
            @Mapping(source = "datMes", target = "mes"),
            @Mapping(source = "datAno", target = "ano"),
            @Mapping(source = "produtoCosif.produto.codProduto", target = "codigoProduto"),
            @Mapping(source = "produtoCosif.produto.desProduto", target = "descricaoProduto"),
            @Mapping(source = "numLancamento", target = "lancamento"),
            @Mapping(source = "desDescricao", target = "descricao"),
            @Mapping(source = "valValor", target = "valor"),
    })
    MovimentoManualResponseDTO movimentoManualToMovimentoManualResponseDTO(MovimentoManual movimentoManual);
}
