package com.locacaoapi.controller;

import com.locacaoapi.dto.ManutencaoRequestDTO;
import com.locacaoapi.dto.ManutencaoResponseDTO;
import com.locacaoapi.service.ManutencaoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Manutencao", description = "Gerenciamento de manutencaos")
@RestController
@RequestMapping("/api/manutencaos")
public class ManutencaoController {

    @Autowired
    private ManutencaoService service;

    @Operation(summary = "Listar todos os Manutencao")
    @GetMapping
    public List<ManutencaoResponseDTO> listar(@RequestParam(required = false) String descricao, @RequestParam(required = false) Long equipamentoId) {
        List<ManutencaoResponseDTO> resultado = service.listar();
        if (descricao != null && !descricao.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getDescricao() != null &&
                item.getDescricao().toLowerCase().contains(descricao.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        if (equipamentoId != null) {
            resultado = resultado.stream().filter(item -> equipamentoId.equals(item.getEquipamentoId())).collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Manutencao por ID")
    @GetMapping("/{id}")
    public ManutencaoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Manutencao")
    @PostMapping
    public ResponseEntity<ManutencaoResponseDTO> criar(@Valid @RequestBody ManutencaoRequestDTO manutencao) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(manutencao));
    }

    @Operation(summary = "Atualizar Manutencao")
    @PutMapping("/{id}")
    public ManutencaoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody ManutencaoRequestDTO manutencao) {
        return service.atualizar(id, manutencao);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Manutencao")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
