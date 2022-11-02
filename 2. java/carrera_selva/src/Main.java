import java.util.HashMap;
import java.util.Map;
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
        int opcion;
        int contador = 0;
        String seguirAgregando = "";

        Map<Integer,String[]> listaParticipanteChico = new HashMap<>();
        Map<Integer,String[]>listaParticipanteMedio = new HashMap<>();
        Map<Integer,String[]> listaParticipanteGrande = new HashMap<>();


        System.out.println("¡Bienvenido/a a la carrera de la selva!");
        System.out.println("Para inscribirse, por favor, ingrese los siguientes datos: ");

        //input de datos

        do{

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

            System.out.println("Elija una opción. Presione 1 para el circuito chico, 2 para el medio y 3 para el avanzado.");
            opcion = Integer.parseInt(input.next());

            String participante[] = {nombre, apellido, edad, dni, celular, celularContacto, grupoSanguineo};

            contador = contador + 1;

            switch (opcion) {

                case 1:

                    if (Integer.parseInt(edad) < 18) {
                        System.out.println("Usted debe abonar 1300 pesos.");
                    } else if (Integer.parseInt(edad) > 18) {
                        System.out.println("Usted debe abonar 1500 pesos.");
                    }

                    break;

                case 2:

                    if (Integer.parseInt(edad) < 18) {
                        System.out.println("Usted debe abonar 2000 pesos.");
                    } else if (Integer.parseInt(edad) > 18) {
                        System.out.println("Usted debe abonar 2300 pesos.");
                    }

                    break;

                case 3:

                    if (Integer.parseInt(edad) < 18) {
                        System.out.println("No se permite la inscripción.");
                    } else if (Integer.parseInt(edad) > 18) {
                        System.out.println("Usted debe abonar 2800 pesos.");
                    }

                    break;

                default: System.out.println("El número ingresado no es el correcto");

                    break;

            }

            listaParticipanteChico.put(contador, participante);

            System.out.println("Desea agregar otro participante? (si/no) ");
            seguirAgregando = input.next();

        } while (seguirAgregando.equalsIgnoreCase("si"));

        for(Map.Entry<Integer, String[] > entrada : listaParticipanteChico.entrySet()) {
            Integer clave = entrada.getKey();
            String[] valor = entrada.getValue();
            System.out.println("La id del participante es " + clave);
            System.out.println("La información del participante es: ");

            for(int i = 0; i < valor.length; i++){
                System.out.println(valor[i]);
            }
        }


    }

}
