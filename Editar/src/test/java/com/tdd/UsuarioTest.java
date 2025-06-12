package com.tdd;

import static org.junit.jupiter.api.Assertions.*;

import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;
import java.time.LocalDate;

public class UsuarioTest {

    private Usuario usuario;

    @BeforeEach
    public void setUp() {
        usuario = new Usuario("Thaynara Merick", "thayn123@gmail.com",
                LocalDate.of(2000, 12, 6), "Rua lajedo, 358", "blabla112");
    }

    @Test
    public void editarNome() {
        usuario.editarNomeCompleto("Thaynara Silva");
        assertEquals("Thaynara Silva", usuario.getNomeCompleto());
    }

    @Test
    public void naoPermitirNomeVazio() {
        assertThrows(IllegalArgumentException.class, () -> usuario.editarNomeCompleto(" "));
    }

    @Test
    public void EditarEmail() {
        usuario.editarEmail("thayn.silva@gmail.com");
        assertEquals("thayn.silva@gmail.com", usuario.getEmail());
    }

    @Test
    public void NaoPermitirEmailInvalido() {
        assertThrows(IllegalArgumentException.class, () -> usuario.editarEmail("emailinvalido"));
    }

    @Test
    public void EditarDataNascimento() {
        LocalDate novaData = LocalDate.of(2000, 12, 1);
        usuario.editarDataNascimento(novaData);
        assertEquals(novaData, usuario.getDataNascimento());
    }

    @Test
    public void naoPermitirDataNascimentoFutura() {
        assertThrows(IllegalArgumentException.class, () -> usuario.editarDataNascimento(LocalDate.now().plusDays(1)));
    }

    @Test
    public void deveEditarEndereco() {
        usuario.editarEndereco("Rua Agreste, 999");
        assertEquals("Rua Agreste, 999", usuario.getEndereco());
    }

    @Test
    public void naoDevePermitirEnderecoVazio() {
        assertThrows(IllegalArgumentException.class, () -> usuario.editarEndereco(""));
    }

    @Test
    public void EditarSenha() {
        usuario.editarSenha("nasa125");
        assertEquals("nasa125", usuario.getSenha());
    }

    @Test
    public void naoPermitirSenhaCurta() {
        assertThrows(IllegalArgumentException.class, () -> usuario.editarSenha("123"));
    }
}