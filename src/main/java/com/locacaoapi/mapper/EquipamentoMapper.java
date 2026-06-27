package com.locacaoapi.mapper;

import com.locacaoapi.dto.EquipamentoRequestDTO;
import com.locacaoapi.dto.EquipamentoResponseDTO;
import com.locacaoapi.model.Equipamento;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface EquipamentoMapper {

    Equipamento toEntity(EquipamentoRequestDTO dto);

    EquipamentoResponseDTO toResponseDTO(Equipamento entity);
}
