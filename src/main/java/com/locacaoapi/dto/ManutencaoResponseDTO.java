package com.locacaoapi.dto;

public class ManutencaoResponseDTO {

    private Long id;
    private Long equipamentoId;
    private java.time.LocalDateTime dataEntrada;
    private String descricao;
    private java.math.BigDecimal custo;
    private String status;
    private java.time.LocalDateTime dataRetorno;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
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
