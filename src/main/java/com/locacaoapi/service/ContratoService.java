package com.locacaoapi.service;

import com.locacaoapi.dto.ContratoRequestDTO;
import com.locacaoapi.dto.ContratoResponseDTO;
import com.locacaoapi.exception.ResourceNotFoundException;
import com.locacaoapi.mapper.ContratoMapper;
import com.locacaoapi.model.Contrato;
import com.locacaoapi.repository.ContratoRepository;
import com.locacaoapi.repository.ClienteRepository;
import com.locacaoapi.model.Cliente;
import com.locacaoapi.repository.EquipamentoRepository;
import com.locacaoapi.model.Equipamento;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ContratoService {

    @Autowired
    private ContratoRepository repository;

    @Autowired
    private ContratoMapper mapper;

    @Autowired
    private ClienteRepository clienteRepository;

    @Autowired
    private EquipamentoRepository equipamentoRepository;

    @Transactional(readOnly = true)
    public List<ContratoResponseDTO> listar() {
        return repository.findAll().stream().map(mapper::toResponseDTO).collect(Collectors.toList());
    }

    @Transactional(readOnly = true)
    public ContratoResponseDTO buscar(Long id) {
        Contrato entity = repository.findById(id)
            .orElseThrow(() -> new ResourceNotFoundException("Contrato não encontrado com id: " + id));
        return mapper.toResponseDTO(entity);
    }

    public ContratoResponseDTO criar(ContratoRequestDTO dto) {
        Contrato entity = mapper.toEntity(dto);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + dto.getEquipamentoId()));
        entity.setEquipamento(equipamento);
        Contrato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public ContratoResponseDTO atualizar(Long id, ContratoRequestDTO dto) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Contrato não encontrado com id: " + id);
        }
        Contrato entity = mapper.toEntity(dto);
        entity.setId(id);
        Cliente cliente = clienteRepository.findById(dto.getClienteId())
            .orElseThrow(() -> new ResourceNotFoundException("Cliente não encontrado com id: " + dto.getClienteId()));
        entity.setCliente(cliente);
        Equipamento equipamento = equipamentoRepository.findById(dto.getEquipamentoId())
            .orElseThrow(() -> new ResourceNotFoundException("Equipamento não encontrado com id: " + dto.getEquipamentoId()));
        entity.setEquipamento(equipamento);
        Contrato salvo = repository.save(entity);
        return mapper.toResponseDTO(salvo);
    }

    public void deletar(Long id) {
        if (!repository.existsById(id)) {
            throw new ResourceNotFoundException("Contrato não encontrado com id: " + id);
        }
        repository.deleteById(id);
    }
}
