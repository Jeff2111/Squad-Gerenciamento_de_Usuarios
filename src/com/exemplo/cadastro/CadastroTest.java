package com.exemplo.cadastro;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import static org.junit.jupiter.api.Assertions.*;

import java.time.LocalDate;

public class CadastroTest {

    private Cadastro usuario;

    @BeforeEach
    public void setup() {
        usuario = new Cadastro();
    }


    @Test
    public void naoDeveAceitarNomeCompletoValido() {
        usuario.setNomeCompleto("Jeferson Nascimento");
        assertEquals("Jeferson Nascimento", usuario.getNomeCompleto());
    }

    @Test
    public void naoDeveAceitarNomeCompletoEmBranco() {
        usuario.setNomeCompleto("Jeferson Nascimento");
        assertEquals("Jeferson Nascimento", usuario.getNomeCompleto());
    }

    @Test
    public void naoDeveAceitarEmailSemArroba() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->  usuario.setEmail("usuarioemail.com"));

        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    public void naoDeveAceitarEmailComEspacos() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->  usuario.setEmail("usuario @email.com"));

        assertEquals("Email inválido", exception.getMessage());
    }

    @Test
    public void naoDeveAceitarSenhaComEspacosSomente() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->  usuario.setSenha("      "));

        assertEquals("Senha invalida", exception.getMessage());
    }

    @Test
    public void aceitarSenhaComMinimoDeCaracteres() {
        usuario.setSenha("estofraco123");
        assertEquals("estofraco123", usuario.getSenha());
    }

    @Test
    public void naoDeveAceitarSenhaMuitoCurta() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->
                usuario.setSenha("fraco"));

        assertEquals("Senha invalida", exception.getMessage());
    }

    @Test
    public void aceitarDataNascimentoValida() {
        LocalDate data = LocalDate.of(1998, 5, 10);
        usuario.setDataNascimento(data);
        assertEquals(data, usuario.getDataNascimento());
    }

    @Test
    public void aceitarTipoUsuarioValido() {
        usuario.setTipoUsuario("Professor");
        assertEquals("Professor", usuario.getTipoUsuario());
    }

    @Test
    public void naoDeveAceitarTipoUsuarioInvalido() {
        Exception exception = assertThrows(IllegalArgumentException.class, () -> usuario.setTipoUsuario("Visitante"));

        assertEquals("Tipo de usuário inválido", exception.getMessage());
    }

    @Test
    public void aceitarEnderecoNaoVazio() {
        usuario.setEndereco("Av Caxangá, 100");
        assertEquals("Av Caxangá, 100", usuario.getEndereco());
    }

    @Test
    public void naoDeveAceitarEnderecoEmBranco() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->  usuario.setEndereco(""));

        assertEquals("O seu endereço não pode estar em branco", exception.getMessage());
    }

    @Test
    public void naoDeveAceitarSenhaVazia() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->  usuario.setSenha(""));

        assertEquals("Senha invalida", exception.getMessage());
    }

    @Test
    public void naoDeveAceitarTipoUsuarioVazio() {
        Exception exception = assertThrows(IllegalArgumentException.class, () ->  usuario.setTipoUsuario(""));

        assertEquals("Tipo de usuário inválido", exception.getMessage());
    }

}
