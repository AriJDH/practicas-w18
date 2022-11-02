import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class Main {

    static Scanner input = new Scanner(System.in);

    public static void main(String[] args) {

        String nombre;
        String apellido;
        String edad;
        String dni;
        String celular;
        String celularContacto;
        String grupoSanguineo;
        String seguirCargando;
        String circuito;

        System.out.println("¡Bienvenido/a a la carrera de la selva!");
        System.out.println("Elija una opción. Presione 1 para el circuito chico, 2 para el medio y 3 para el avanzado.");

        int opcion = 0;
        switch (opcion){

            case 1:     System.out.println("Usted ha seleccionado el circuito chico");
                        System.out.println("Para inscribirse, por favor, ingrese los siguientes datos: ");

                        //input de datos

                        System.out.println("Ingrese su Nombre: ");
                        nombre = input.next();
                        System.out.println("Ingrese su Apellido: ");
                        apellido = input.next();
                        System.out.println("Ingrese su Edad: ");
                        edad = input.next();
                        System.out.println("Ingrese su Dni: ");
                        dni = input.next();
                        System.out.println("Ingrese su Celular: ");
                        celular = input.next();
                        System.out.println("Ingrese su Celular de Contacto: ");
                        celularContacto = input.next();
                        System.out.println("Ingrese su Grupo sanguíneo: ");
                        grupoSanguineo = input.next();
                        System.out.println("Ingrese el tipo de circuito que desea (chico, medio, avanzado): ");
                        circuito = input.next();

                        String participante[] = {nombre, apellido, edad, dni, celular, celularContacto, grupoSanguineo, circuito};

                        if (Integer.parseInt(edad) < 18){
                            System.out.println("Usted debe abonar 1300 pesos.");
                        } else if (Integer.parseInt(edad) > 18){
                            System.out.println("Usted debe abonar 1500 pesos.");
                        }

                        List<String[]> listaParticipanteChico = new ArrayList<>();
                        listaParticipanteChico.add(participante);

            case 2:     System.out.println("Usted ha seleccionado el circuito medio");
                        System.out.println("Para inscribirse, por favor, ingrese los siguientes datos: ");

                        //input de datos

                        System.out.println("Ingrese su Nombre: ");
                        nombre = input.next();
                        System.out.println("Ingrese su Apellido: ");
                        apellido = input.next();
                        System.out.println("Ingrese su Edad: ");
                        edad = input.next();
                        System.out.println("Ingrese su Dni: ");
                        dni = input.next();
                        System.out.println("Ingrese su Celular: ");
                        celular = input.next();
                        System.out.println("Ingrese su Celular de Contacto: ");
                        celularContacto = input.next();
                        System.out.println("Ingrese su Grupo sanguíneo: ");
                        grupoSanguineo = input.next();
                        System.out.println("Ingrese el tipo de circuito que desea (chico, medio, avanzado): ");
                        circuito = input.next();

                        String participante2[] = {nombre, apellido, edad, dni, celular, celularContacto, grupoSanguineo, circuito};

                        if (Integer.parseInt(edad) < 18){
                            System.out.println("Usted debe abonar 2000 pesos.");
                        } else if (Integer.parseInt(edad) > 18){
                            System.out.println("Usted debe abonar 2300 pesos.");
                        }

                        List<String[]> listaParticipanteMedio = new ArrayList<>();
                        listaParticipanteMedio.add(participante2);


        }


            //for (String persona : participante1) {
           //     System.out.println("Participante: " + persona);
          //  }

    }

}
