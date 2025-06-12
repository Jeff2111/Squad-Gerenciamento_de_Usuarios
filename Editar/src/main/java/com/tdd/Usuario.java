package com.tdd;

import java.time.LocalDate;

public class Usuario {
    private String nomeCompleto;
    private String email;
    private LocalDate dataNascimento;
    private String endereco;
    private String senha;

    public Usuario(String nomeCompleto, String email, LocalDate dataNascimento, String endereco, String senha) {
        this.nomeCompleto = nomeCompleto;
        this.email = email;
        this.dataNascimento = dataNascimento;
        this.endereco = endereco;
        this.senha = senha;
    }

    public void editarNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome completo não pode ser vazio.");
        }
        this.nomeCompleto = nomeCompleto;
    }

    public void editarEmail(String email) {
        if (email == null || !email.matches("^[\\w.-]+@[\\w.-]+\\.\\w+$")) {
            throw new IllegalArgumentException("Email inválido.");
        }
        this.email = email;
    }

    public void editarDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null || dataNascimento.isAfter(LocalDate.now())) {
            throw new IllegalArgumentException("Data de nascimento inválida.");
        }
        this.dataNascimento = dataNascimento;
    }

    public void editarEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("Endereço não pode ser vazio.");
        }
        this.endereco = endereco;
    }

    public void editarSenha(String senha) {
        if (senha == null || senha.length() < 6) {
            throw new IllegalArgumentException("Senha deve conter ao menos 6 caracteres.");
        }
        this.senha = senha;
    }

    public String getNomeCompleto() { return nomeCompleto; }
    public String getEmail() { return email; }
    public LocalDate getDataNascimento() { return dataNascimento; }
    public String getEndereco() { return endereco; }
    public String getSenha() { return senha; }
}
