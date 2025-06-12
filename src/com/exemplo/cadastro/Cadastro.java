package com.exemplo.cadastro;

import java.time.LocalDate;

public class Cadastro {
    private String nomeCompleto;
    private String email;
    private String senha;
    private String endereco;
    private LocalDate dataNascimento;
    private String tipoUsuario;

    public void setNomeCompleto(String nomeCompleto) {
        if (nomeCompleto == null || nomeCompleto.trim().isEmpty()) {
            throw new IllegalArgumentException("Nome completo não pode estar em branco");
        }
        this.nomeCompleto = nomeCompleto.trim();
    }

    public String getNomeCompleto() {
        return nomeCompleto;
    }

    public void setEmail(String email) {
        if (email == null || email.trim().isEmpty() || !email.contains("@") || email.contains(" ")) {
            throw new IllegalArgumentException("Email inválido");
        }
        this.email = email.trim();
    }

    public String getEmail() {
        return email;
    }

    public void setSenha(String senha) {
        if (senha == null || senha.trim().length() < 6) {
            throw new IllegalArgumentException("Senha invalida");
        }
        this.senha = senha;
    }

    public String getSenha() {
        return senha;
    }

    public void setEndereco(String endereco) {
        if (endereco == null || endereco.trim().isEmpty()) {
            throw new IllegalArgumentException("O seu endereço não pode estar em branco");
        }
        this.endereco = endereco;
    }

    public String getEndereco() {
        return endereco;
    }

    public void setDataNascimento(LocalDate dataNascimento) {
        if (dataNascimento == null) {
            throw new IllegalArgumentException("Data de nascimento não pode ser nula");
        }
        this.dataNascimento = dataNascimento;
    }

    public LocalDate getDataNascimento() {
        return dataNascimento;
    }

    public void setTipoUsuario(String tipoUsuario) {
        if (tipoUsuario == null) {
            throw new IllegalArgumentException("Tipo de usuário não pode ser nulo");
        }

        String tipo = tipoUsuario.trim();
        if (!tipo.equalsIgnoreCase("Professor") &&
                !tipo.equalsIgnoreCase("Bibliotecário") &&
                !tipo.equalsIgnoreCase("Aluno")) {
            throw new IllegalArgumentException("Tipo de usuário inválido");
        }

        this.tipoUsuario = tipo;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
}
