package com.locacaoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "manutencoes")
public class Manutencao {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;
    private java.time.LocalDateTime dataEntrada;
    @Column(columnDefinition = "TEXT", nullable = false)
    private String descricao;
    private java.math.BigDecimal custo;
    @Column(nullable = false)
    private String status;
    private java.time.LocalDateTime dataRetorno;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Equipamento getEquipamento() { return equipamento; }
    public void setEquipamento(Equipamento equipamento) { this.equipamento = equipamento; }
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
