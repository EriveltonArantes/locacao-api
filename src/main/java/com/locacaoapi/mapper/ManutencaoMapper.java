package com.locacaoapi.mapper;

import com.locacaoapi.dto.ManutencaoRequestDTO;
import com.locacaoapi.dto.ManutencaoResponseDTO;
import com.locacaoapi.model.Manutencao;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ManutencaoMapper {

    @Mapping(target = "equipamento", ignore = true)
    Manutencao toEntity(ManutencaoRequestDTO dto);

    @Mapping(target = "equipamentoId", source = "equipamento.id")
    ManutencaoResponseDTO toResponseDTO(Manutencao entity);
}
