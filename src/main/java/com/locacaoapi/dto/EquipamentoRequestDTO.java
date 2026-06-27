package com.locacaoapi.dto;

import jakarta.validation.constraints.*;

public class EquipamentoRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "categoria não pode estar em branco")
    private String categoria;
    @NotBlank(message = "marca não pode estar em branco")
    private String marca;
    @NotBlank(message = "modelo não pode estar em branco")
    private String modelo;
    @NotBlank(message = "numeroserie não pode estar em branco")
    private String numeroserie;
    @DecimalMin(value = "0.0", message = "valor diaria não pode ser negativo")
    @NotNull(message = "valor diaria não pode ser nulo")
    private Double valorDiaria;
    @NotNull(message = "disponivel não pode ser nulo")
    private Boolean disponivel;

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
