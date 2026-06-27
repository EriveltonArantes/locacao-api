package com.locacaoapi.dto;

import jakarta.validation.constraints.*;

public class ClienteRequestDTO {

    @NotBlank(message = "nome não pode estar em branco")
    private String nome;
    @NotBlank(message = "cpf não pode estar em branco")
    @Size(min = 11, max = 14, message = "cpf deve ter entre 11 e 14 dígitos")
    private String cpf;
    @NotBlank(message = "email não pode estar em branco")
    @Email(message = "email precisa ser um e-mail válido")
    private String email;
    @NotBlank(message = "telefone não pode estar em branco")
    private String telefone;
    @NotBlank(message = "endereco não pode estar em branco")
    private String endereco;
    @NotBlank(message = "cnpj não pode estar em branco")
    @Size(min = 14, max = 18, message = "cnpj deve ter entre 14 e 18 dígitos")
    private String cnpj;

    public String getNome() { return nome; }
    public void setNome(String nome) { this.nome = nome; }
    public String getCpf() { return cpf; }
    public void setCpf(String cpf) { this.cpf = cpf; }
    public String getEmail() { return email; }
    public void setEmail(String email) { this.email = email; }
    public String getTelefone() { return telefone; }
    public void setTelefone(String telefone) { this.telefone = telefone; }
    public String getEndereco() { return endereco; }
    public void setEndereco(String endereco) { this.endereco = endereco; }
    public String getCnpj() { return cnpj; }
    public void setCnpj(String cnpj) { this.cnpj = cnpj; }
}
