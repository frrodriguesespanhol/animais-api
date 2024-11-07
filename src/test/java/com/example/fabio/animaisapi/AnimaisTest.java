package com.example.fabio.animaisapi;
import builders.AnimalBuilder;
import static builders.AnimalBuilder.umAnimal;
import com.example.fabio.animaisapi.model.Animais;
import com.example.fabio.animaisapi.model.exceptions.ValidationException;
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;
import org.junit.jupiter.params.ParameterizedTest;
import org.junit.jupiter.params.provider.Arguments;
import org.junit.jupiter.params.provider.CsvFileSource;
import org.junit.jupiter.params.provider.MethodSource;

import java.util.Date;
import java.util.stream.Stream;


public class AnimaisTest {

    @Test
    public void deveCriarAnimalValido() {
        Animais animais = AnimalBuilder.umAnimal().agora();
        Assertions.assertAll("Animais",
                () -> Assertions.assertEquals(1L, animais.getId()),
                () -> Assertions.assertEquals(new Date().getYear(), animais.getData().getYear()),
                () -> Assertions.assertEquals(new Date().getMonth(), animais.getData().getMonth()),
                () -> Assertions.assertEquals(new Date().getDay(), animais.getData().getDay()),
                () -> Assertions.assertEquals("José", animais.getCadastradopor()),
                () -> Assertions.assertEquals("comentário", animais.getComentario()),
                () -> Assertions.assertEquals("email@user.com", animais.getEmail()),
                () -> Assertions.assertEquals("espécie", animais.getEspecie()),
                () -> Assertions.assertEquals("localização", animais.getLocalizacao()),
                () -> Assertions.assertEquals("estado", animais.getEstado())
        );
    }

    @ParameterizedTest
    //@MethodSource(value = "dataProvider")  ->>>> não deu certo
    @CsvFileSource(files = "src/test/resources/camposObrigatoriosAnimal.csv", nullValues = "NULL", numLinesToSkip = 1)
    public void deveRejeitarAnimalInvalido(Long id, String cadastradoPor, String especie, String localizacao, String mensagem) {
        String errorMessage = Assertions.assertThrows(ValidationException.class, () ->
                umAnimal().comId(id).comCadastradopor(cadastradoPor).comEspecie(especie).comLocalizacao(localizacao).agora()).getMessage();
        Assertions.assertEquals(mensagem, errorMessage);
    }

    //essa parte não deu certo
//    private static Stream<Arguments> dataProvider() {
//        return Stream.of(
//                Arguments.of(1L, null, "espécie", "localização", "Cadastrado por é obrigatório"),
//                Arguments.of(1L, "José", null, "localização", "Espécie é obrigatória"),
//                Arguments.of(1L, "José", "espécie", null, "Localização é obrigatória")
//        );
//    }

}
