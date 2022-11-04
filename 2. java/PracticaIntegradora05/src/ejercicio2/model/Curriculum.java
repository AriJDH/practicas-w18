package ejercicio2.model;

public class Curriculum extends Documento {

    @Override
    public void imprimir() {

        System.out.println("Nombre: Juan");
        System.out.println("Apellido: Lopez");
        System.out.println("Edad: 45");
        System.out.println("Email: juan.lopez@email.com");
        System.out.println("Habilidad 1: Excel");
        System.out.println("Habilidad 2: Paint");
        System.out.println("Habilidad 3: Word");
        System.out.println();
    }
}
