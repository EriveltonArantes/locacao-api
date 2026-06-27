package com.locacaoapi.mapper;

import com.locacaoapi.dto.ClienteRequestDTO;
import com.locacaoapi.dto.ClienteResponseDTO;
import com.locacaoapi.model.Cliente;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;

@Mapper(componentModel = "spring")
public interface ClienteMapper {

    Cliente toEntity(ClienteRequestDTO dto);

    ClienteResponseDTO toResponseDTO(Cliente entity);
}
