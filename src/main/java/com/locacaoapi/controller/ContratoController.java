package com.locacaoapi.controller;

import com.locacaoapi.dto.ContratoRequestDTO;
import com.locacaoapi.dto.ContratoResponseDTO;
import com.locacaoapi.service.ContratoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Contrato", description = "Gerenciamento de contratos")
@RestController
@RequestMapping("/api/contratos")
public class ContratoController {

    @Autowired
    private ContratoService service;

    @Operation(summary = "Listar todos os Contrato")
    @GetMapping
    public List<ContratoResponseDTO> listar(@RequestParam(required = false) Long clienteId, @RequestParam(required = false) Long equipamentoId) {
        List<ContratoResponseDTO> resultado = service.listar();
        if (clienteId != null) {
            resultado = resultado.stream().filter(item -> clienteId.equals(item.getClienteId())).collect(java.util.stream.Collectors.toList());
        }
        if (equipamentoId != null) {
            resultado = resultado.stream().filter(item -> equipamentoId.equals(item.getEquipamentoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Contrato por ID")
    @GetMapping("/{id}")
    public ContratoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Contrato")
    @PostMapping
    public ResponseEntity<ContratoResponseDTO> criar(@Valid @RequestBody ContratoRequestDTO contrato) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(contrato));
    }

    @Operation(summary = "Atualizar Contrato")
    @PutMapping("/{id}")
    public ContratoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ContratoRequestDTO contrato) {
        return service.atualizar(id, contrato);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Contrato")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
