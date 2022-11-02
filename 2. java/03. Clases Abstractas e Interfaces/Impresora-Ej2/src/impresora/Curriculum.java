package impresora;

import java.util.Arrays;
import java.util.List;

public class Curriculum extends Documento{
    private Persona persona;
    private List<String> habilidades;

    public Curriculum(Persona persona, String... habilidades) {
        this.persona = persona;
        this.habilidades = Arrays.asList(habilidades);
    }

    @Override
    public void imprimir() {
        System.out.println(this.persona);
        habilidades.forEach(System.out::println);
    }
}
