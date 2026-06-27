package com.locacaoapi.dto;

public class ContratoResponseDTO {

    private Long id;
    private Long clienteId;
    private Long equipamentoId;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataFim;
    private Double valorTotal;
    private Double caucao;
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public Long getClienteId() { return clienteId; }
    public void setClienteId(Long clienteId) { this.clienteId = clienteId; }
    public Long getEquipamentoId() { return equipamentoId; }
    public void setEquipamentoId(Long equipamentoId) { this.equipamentoId = equipamentoId; }
    public java.time.LocalDateTime getDataInicio() { return dataInicio; }
    public void setDataInicio(java.time.LocalDateTime dataInicio) { this.dataInicio = dataInicio; }
    public java.time.LocalDateTime getDataFim() { return dataFim; }
    public void setDataFim(java.time.LocalDateTime dataFim) { this.dataFim = dataFim; }
    public Double getValorTotal() { return valorTotal; }
    public void setValorTotal(Double valorTotal) { this.valorTotal = valorTotal; }
    public Double getCaucao() { return caucao; }
    public void setCaucao(Double caucao) { this.caucao = caucao; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
}
