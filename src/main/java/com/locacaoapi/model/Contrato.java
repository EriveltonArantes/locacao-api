package com.locacaoapi.model;

import jakarta.persistence.*;

@Entity
@Table(name = "contratos")
public class Contrato {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "cliente_id")
    private Cliente cliente;
    @ManyToOne
    @JoinColumn(name = "equipamento_id")
    private Equipamento equipamento;
    private java.time.LocalDateTime dataInicio;
    private java.time.LocalDateTime dataFim;
    private Double valorTotal;
    private Double caucao;
    @Column(nullable = false)
    private String status;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }

    public Cliente getCliente() { return cliente; }
    public void setCliente(Cliente cliente) { this.cliente = cliente; }
    public Equipamento getEquipamento() { return equipamento; }
    public void setEquipamento(Equipamento equipamento) { this.equipamento = equipamento; }
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
