package com.locacaoapi.mapper;

import com.locacaoapi.dto.ContratoRequestDTO;
import com.locacaoapi.dto.ContratoResponseDTO;
import com.locacaoapi.model.Contrato;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ContratoMapper {

    @Mapping(target = "cliente", ignore = true)
    @Mapping(target = "equipamento", ignore = true)
    Contrato toEntity(ContratoRequestDTO dto);

    @Mapping(target = "clienteId", source = "cliente.id")
    @Mapping(target = "equipamentoId", source = "equipamento.id")
    ContratoResponseDTO toResponseDTO(Contrato entity);
}
