package builders;
import java.text.SimpleDateFormat;
import java.time.LocalDate;
import java.util.Date;
import com.example.fabio.animaisapi.model.Especie;
import com.example.fabio.animaisapi.model.Animais;

public class AnimalBuilder {
    private Long id;
    private Date data;
    private Especie idEspecieAnimal;
    private String especie;
    private String localizacao;
    private String cadastradopor;
    private String email;
    private String estado;
    private String comentario;
    private String foto1;
    private String foto2;

    private AnimalBuilder(){}

    public static AnimalBuilder umAnimal() {
        AnimalBuilder builder = new AnimalBuilder();
        inicializarDadosPadroes(builder);
        return builder;
    }

    private static void inicializarDadosPadroes(AnimalBuilder builder) {
        builder.id = 1L;
        builder.data = new Date();
        //builder.idEspecieAnimal = null;
        builder.especie = "espécie";
        builder.localizacao = "localização";
        builder.cadastradopor = "José";
        builder.email = "email@user.com";
        builder.estado = "estado";
        builder.comentario = "comentário";
        //builder.foto1 = "";
        //builder.foto2 = "";
    }

    public AnimalBuilder comId(Long id) {
        this.id = id;
        return this;
    }

    public AnimalBuilder comData(Date data) {
        this.data = data;
        return this;
    }

    public AnimalBuilder comIdEspecieAnimal(Especie idEspecieAnimal) {
        this.idEspecieAnimal = idEspecieAnimal;
        return this;
    }

    public AnimalBuilder comEspecie(String especie) {
        this.especie = especie;
        return this;
    }

    public AnimalBuilder comLocalizacao(String localizacao) {
        this.localizacao = localizacao;
        return this;
    }

    public AnimalBuilder comCadastradopor(String cadastradopor) {
        this.cadastradopor = cadastradopor;
        return this;
    }

    public AnimalBuilder comEmail(String email) {
        this.email = email;
        return this;
    }

    public AnimalBuilder comEstado(String estado) {
        this.estado = estado;
        return this;
    }

    public AnimalBuilder comComentario(String comentario) {
        this.comentario = comentario;
        return this;
    }

    public AnimalBuilder comFoto1(String foto1) {
        this.foto1 = foto1;
        return this;
    }

    public AnimalBuilder comFoto2(String foto2) {
        this.foto2 = foto2;
        return this;
    }

    public Animais agora() {
        return new Animais(id,data, idEspecieAnimal, especie, localizacao, cadastradopor, email, estado, comentario, foto1, foto2);
    }
}