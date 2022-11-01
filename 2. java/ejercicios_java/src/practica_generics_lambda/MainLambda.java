package practica_generics_lambda;

import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;

public class MainLambda {

    public static void main(String[] args) {

        Persona persona = new Persona();
        persona.setNombre("Dizzi");
        persona.setNumeroIdentificacion("1229282");
        persona.setCasado(true);
        persona.setCelular(23322);
        persona.setDinero(10000.0);

        Persona persona2 = new Persona();
        persona2.setNombre("Johan");
        persona2.setNumeroIdentificacion("342424");
        persona2.setCasado(true);
        persona2.setCelular(3100302);
        persona2.setDinero(20302.2);

        //Guardar personas
        List<Persona> personas = Arrays.asList(persona, persona2);

        //Imprimir personas
        personas.forEach(System.out::println);

        personas.stream().forEach(x -> {
            System.out.println(x.getNombre());
        });

        //Recorrer en paralelo
        personas.parallelStream().forEach(x -> {
            System.out.println(x.getNombre());
        });

        //Encontrar el primero
        Persona personaFiltro = personas.stream().filter(x -> x.getDinero() > 10000).findFirst().get();

        System.out.println(personaFiltro);

        //Obtener nueva lista a partir de otra
        List<String> nombres = personas.stream().map(Persona::getNombre).collect(Collectors.toList());

        System.out.println(nombres);
    }
}
