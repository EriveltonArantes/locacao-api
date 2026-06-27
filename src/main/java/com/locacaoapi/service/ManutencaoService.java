package com.locacaoapi.service;

import com.locacaoapi.dto.ManutencaoRequestDTO;
import com.locacaoapi.dto.ManutencaoResponseDTO;
import com.locacaoapi.exception.ResourceNotFoundException;
import com.locacaoapi.mapper.ManutencaoMapper;
import com.locacaoapi.model.Manutencao;
import com.locacaoapi.repository.ManutencaoRepository;
import com.locacaoapi.repository.EquipamentoRepository;
import com.locacaoapi.model.Equipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ManutencaoService {

    @Autowired
    private ManutencaoRepository repository;

    @Autowired
    private ManutencaoMapper mapper;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Transactional(readOnly = true)
    public List<ManutencaoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ManutencaoResponseDTO buscar(Long id) {
        Manutencao entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Manutencao não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ManutencaoResponseDTO criar(ManutencaoRequestDTO dto) {
        Manutencao entity = mapper.toEntity(dto);
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + dto.getEquipamentoId()));
        entity.setEquipamento(equipamento);
        Manutencao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ManutencaoResponseDTO atualizar(Long id, ManutencaoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Manutencao não encontrado com id: " + id);
        }
        Manutencao entity = mapper.toEntity(dto);
        entity.setId(id);
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + dto.getEquipamentoId()));
        entity.setEquipamento(equipamento);
        Manutencao salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Manutencao não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
