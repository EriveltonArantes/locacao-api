package com.locacaoapi.dto;

import jakarta.validation.constraints.*;

public class ManutencaoRequestDTO {

    @NotNull(message = "EquipamentoId é obrigatório")
    @Positive(message = "EquipamentoId deve ser um ID válido (positivo)")
    private Long equipamentoId;
    @NotNull(message = "data entrada não pode ser nulo")
    private java.time.LocalDateTime dataEntrada;
    @NotBlank(message = "descricao não pode estar em branco")
    private String descricao;
    @DecimalMin(value = "0.0", message = "custo não pode ser negativo")
    @NotNull(message = "custo não pode ser nulo")
    private java.math.BigDecimal custo;
    @NotBlank(message = "status não pode estar em branco")
    private String status;
    @NotNull(message = "data retorno não pode ser nulo")
    private java.time.LocalDateTime dataRetorno;

    public Long getEquipamentoId() { return equipamentoId; }
    public void setEquipamentoId(Long equipamentoId) { this.equipamentoId = equipamentoId; }
    public java.time.LocalDateTime getDataEntrada() { return dataEntrada; }
    public void setDataEntrada(java.time.LocalDateTime dataEntrada) { this.dataEntrada = dataEntrada; }
    public String getDescricao() { return descricao; }
    public void setDescricao(String descricao) { this.descricao = descricao; }
    public java.math.BigDecimal getCusto() { return custo; }
    public void setCusto(java.math.BigDecimal custo) { this.custo = custo; }
    public String getStatus() { return status; }
    public void setStatus(String status) { this.status = status; }
    public java.time.LocalDateTime getDataRetorno() { return dataRetorno; }
    public void setDataRetorno(java.time.LocalDateTime dataRetorno) { this.dataRetorno = dataRetorno; }
}
