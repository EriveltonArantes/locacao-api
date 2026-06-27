package com.locacaoapi.controller;

import com.locacaoapi.dto.EquipamentoRequestDTO;
import com.locacaoapi.dto.EquipamentoResponseDTO;
import com.locacaoapi.service.EquipamentoService;
import jakarta.validation.Valid;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.web.bind.annotation.*;
import java.util.List;

@Tag(name = "Equipamento", description = "Gerenciamento de equipamentos")
@RestController
@RequestMapping("/api/equipamentos")
public class EquipamentoController {

    @Autowired
    private EquipamentoService service;

    @Operation(summary = "Listar todos os Equipamento")
    @GetMapping
    public List<EquipamentoResponseDTO> listar(@RequestParam(required = false) String nome) {
        List<EquipamentoResponseDTO> resultado = service.listar();
        if (nome != null && !nome.isBlank()) {
            resultado = resultado.stream().filter(item -> item.getNome() != null &&
                item.getNome().toLowerCase().contains(nome.toLowerCase()))
                .collect(java.util.stream.Collectors.toList());
        }
        return resultado;
    }

    @Operation(summary = "Buscar Equipamento por ID")
    @GetMapping("/{id}")
    public EquipamentoResponseDTO buscar(@PathVariable Long id) { return service.buscar(id); }

    @Operation(summary = "Criar Equipamento")
    @PostMapping
    public ResponseEntity<EquipamentoResponseDTO> criar(@Valid @RequestBody EquipamentoRequestDTO equipamento) {
        return ResponseEntity.status(HttpStatus.CREATED).body(service.criar(equipamento));
    }

    @Operation(summary = "Atualizar Equipamento")
    @PutMapping("/{id}")
    public EquipamentoResponseDTO atualizar(@PathVariable Long id, @Valid @RequestBody EquipamentoRequestDTO equipamento) {
        return service.atualizar(id, equipamento);
    }

    @PreAuthorize("hasRole('ADMIN')")
    @Operation(summary = "Excluir Equipamento")
    @DeleteMapping("/{id}")
    public ResponseEntity<Void> deletar(@PathVariable Long id) {
        service.deletar(id);
        return ResponseEntity.noContent().build();
    }
}
