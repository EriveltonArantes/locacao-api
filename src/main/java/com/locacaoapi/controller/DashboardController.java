package com.locacaoapi.controller;

import com.locacaoapi.model.Equipamento;
import com.locacaoapi.model.Cliente;
import com.locacaoapi.model.Contrato;
import com.locacaoapi.model.Manutencao;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.tags.Tag;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;

import java.util.LinkedHashMap;
import java.util.Map;

@Tag(name = "Dashboard", description = "KPIs e totais do sistema")
@RestController
@RequestMapping("/api/dashboard")
public class DashboardController {

    @Autowired
    private com.locacaoapi.repository.EquipamentoRepository equipamentoRepository;

    @Autowired
    private com.locacaoapi.repository.ClienteRepository clienteRepository;

    @Autowired
    private com.locacaoapi.repository.ContratoRepository contratoRepository;

    @Autowired
    private com.locacaoapi.repository.ManutencaoRepository manutencaoRepository;

    @Operation(summary = "Resumo com totais, somas e gráficos de status")
    @Transactional(readOnly = true)
    @GetMapping("/resumo")
    public Map<String, Object> resumo() {
        Map<String, Object> resumo = new LinkedHashMap<>();
        resumo.put("totalEquipamento", equipamentoRepository.count());
        resumo.put("somaValorDiariaEquipamento", equipamentoRepository.findAll().stream().filter(e -> e.getValorDiaria() != null).mapToDouble(e -> e.getValorDiaria()).sum());
        resumo.put("totalCliente", clienteRepository.count());
        resumo.put("totalContrato", contratoRepository.count());
        resumo.put("somaValorTotalContrato", contratoRepository.findAll().stream().filter(e -> e.getValorTotal() != null).mapToDouble(e -> e.getValorTotal()).sum());
        resumo.put("graficoContrato", contratoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        resumo.put("totalManutencao", manutencaoRepository.count());
        resumo.put("somaCustoManutencao", manutencaoRepository.findAll().stream().map(e -> e.getCusto()).filter(v -> v != null).reduce(java.math.BigDecimal.ZERO, java.math.BigDecimal::add));
        resumo.put("graficoManutencao", manutencaoRepository.findAll().stream()
            .collect(java.util.stream.Collectors.groupingBy(
                item -> String.valueOf(item.getStatus()),
                java.util.LinkedHashMap::new,
                java.util.stream.Collectors.counting())));
        return resumo;
    }
}
