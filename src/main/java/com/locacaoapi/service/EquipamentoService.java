package com.locacaoapi.service;

import com.locacaoapi.dto.EquipamentoRequestDTO;
import com.locacaoapi.dto.EquipamentoResponseDTO;
import com.locacaoapi.exception.ResourceNotFoundException;
import com.locacaoapi.mapper.EquipamentoMapper;
import com.locacaoapi.model.Equipamento;
import com.locacaoapi.repository.EquipamentoRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class EquipamentoService {

    @Autowired
    private EquipamentoRepository repository;

    @Autowired
    private EquipamentoMapper mapper;

    @Transactional(readOnly = true)
    public List<EquipamentoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public EquipamentoResponseDTO buscar(Long id) {
        Equipamento entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public EquipamentoResponseDTO criar(EquipamentoRequestDTO dto) {
        Equipamento entity = mapper.toEntity(dto);
        Equipamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public EquipamentoResponseDTO atualizar(Long id, EquipamentoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Equipamento não encontrado com id: " + id);
        }
        Equipamento entity = mapper.toEntity(dto);
        entity.setId(id);
        Equipamento salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Equipamento não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
