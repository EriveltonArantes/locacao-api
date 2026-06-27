package com.locacaoapi.dto;

public class EquipamentoResponseDTO {

    private Long id;
    private String nome;
    private String categoria;
    private String marca;
    private String modelo;
    private String numeroserie;
    private Double valorDiaria;
    private Boolean disponivel;

    public Long getId() { return id; }
    public void setId(Long id) { this.id = id; }
    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCategoria() { return categoria; }
    public void setCategoria(String categoria) { this.categoria = categoria; }
    public String getMarca() { return marca; }
    public void setMarca(String marca) { this.marca = marca; }
    public String getModelo() { return modelo; }
    public void setModelo(String modelo) { this.modelo = modelo; }
    public String getNumeroserie() { return numeroserie; }
    public void setNumeroserie(String numeroserie) { this.numeroserie = numeroserie; }
    public Double getValorDiaria() { return valorDiaria; }
    public void setValorDiaria(Double valorDiaria) { this.valorDiaria = valorDiaria; }
    public Boolean getDisponivel() { return disponivel; }
    public void setDisponivel(Boolean disponivel) { this.disponivel = disponivel; }
}
