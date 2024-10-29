package com.example.fabio.animaisapi;

import com.example.fabio.animaisapi.model.Usuario;

import static builders.UsuarioBuilder.umUsuario;
import static org.junit.jupiter.api.Assertions.assertEquals;
// import org.junit.jupiter.api.Assertions;
import com.example.fabio.animaisapi.model.exceptions.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.CsvSource;

@DisplayName("Domínio: Usuário")
public class UsuarioTest {

    @Test
    @DisplayName("Deve criar um usuário válido")
    public void deveCriarUsuarioValido() {
        Usuario usuario = umUsuario().agora();
        Assertions.assertAll("Usuario",
                () -> assertEquals(1L, usuario.getId()),
                () -> assertEquals("Usuário Válido", usuario.getNome()),
                () -> assertEquals("user@mail.com", usuario.getEmail()),
                () -> assertEquals("1234", usuario.getSenha()),
                () -> assertEquals("adm", usuario.getTipo())
        );
    }

    @Test
    public void deveRejeitarUsuarioSemNome() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                umUsuario().comNome(null).agora());
        assertEquals("Nome é obrigatório", ex.getMessage());
    }

    @Test
    public void deveRejeitarUsuarioSemEmail() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                umUsuario().comEmail(null).agora());
        assertEquals("E-mail é obrigatório", ex.getMessage());
    }

    @Test
    public void deveRejeitarUsuarioSemSenha() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                umUsuario().comSenha(null).agora());
        assertEquals("Senha é obrigatória", ex.getMessage());
    }

    @Test
    public void deveRejeitarUsuarioSemTipo() {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                umUsuario().comTipo(null).agora());
        assertEquals("Tipo é obrigatório", ex.getMessage());
    }

    @ParameterizedTest(name = "[{index}] - {5}")
    @CsvFileSource(files = "src/test/resources/camposObrigatoriosUsuario.csv", nullValues = "NULL", numLinesToSkip = 1)
//    @ParameterizedTest
//    @CsvFileSource(files = "src/test/resources/camposObrigatoriosUsuario.csv", nullValues = "NULL", useHeadersInDisplayName = true)
    public void deveValidarCamposObrigatorios(Long id, String nome, String email, String senha, String tipo, String mensagem) {
        ValidationException ex = Assertions.assertThrows(ValidationException.class, () ->
                umUsuario().comId(id).comNome(nome).comEmail(email).comSenha(senha).comTipo(tipo).agora());
        assertEquals(mensagem, ex.getMessage());
    }

}