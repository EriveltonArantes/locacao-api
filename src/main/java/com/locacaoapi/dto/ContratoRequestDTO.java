package com.locacaoapi.dto;

import jakarta.validation.constraints.*;

public class ContratoRequestDTO {

    @NotNull(message = "ClienteId é obrigatório")
    @Positive(message = "ClienteId deve ser um ID válido (positivo)")
    private Long clienteId;
    @NotNull(message = "EquipamentoId é obrigatório")
    @Positive(message = "EquipamentoId deve ser um ID válido (positivo)")
    private Long equipamentoId;
    @FutureOrPresent(message = "data inicio não pode ser retroativo")
    @NotNull(message = "data inicio não pode ser nulo")
    private java.time.LocalDateTime dataInicio;
    @FutureOrPresent(message = "data fim não pode ser retroativo")
    @NotNull(message = "data fim não pode ser nulo")
    private java.time.LocalDateTime dataFim;
    @DecimalMin(value = "0.0", message = "valor total não pode ser negativo")
    @NotNull(message = "valor total não pode ser nulo")
    private Double valorTotal;
    @NotNull(message = "caucao não pode ser nulo")
    private Double caucao;
    @NotBlank(message = "status não pode estar em branco")
    private String status;

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
