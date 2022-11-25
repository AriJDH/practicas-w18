package CarreraColections;

import org.w3c.dom.ls.LSOutput;

import java.sql.SQLOutput;
import java.util.*;

public class Carrera {


    List<Map<Integer, ArrayList<String>>> circuitoChico = new ArrayList();
    List<Map<Integer, ArrayList<String>>> circuitoMedio = new ArrayList();
    List<Map<Integer, ArrayList<String>>> circuitoAvanzado = new ArrayList();

    String circuitos[] = {"chico", "medio", "avanzado"};

    private Map<List<String>, Map<Integer, List<String>>> listadosInscriptos = new HashMap<>();
    Scanner teclado = new Scanner(System.in);

    public List<String> crearPersona(String dni, String nombre, String apellido, String edad, String celular,
                             String nroEmergencia, String grupoSang){
        List<String> persona = new ArrayList<>();
        persona.add(dni);
        persona.add(nombre);
        persona.add(apellido);
        persona.add(edad);
        persona.add(celular);
        persona.add(nroEmergencia);
        persona.add(grupoSang);

        return persona;
    }

    public boolean estaInscripto(String dni, ){
        return (dni.equals(per))
    }

    public boolean puedeParticipar(String opcion, boolean mayoriaDeEdad){
        return (opcion.toLowerCase() != circuitos[2] || mayoriaDeEdad);
    }

    public void incribirParticipante(List<String> participante, String circuito){

        Map<Integer, List<String>> listadoPorCircuito =

    }
//dni.put(numeroDeParticipante, Integer.parseInt(in.nextLine()));

    public static void main(String[] args) {

        Carrera carrera = new Carrera;
        Scanner teclado = new Scanner(System.in);

        int option = 0, numDoc = 0, IdInscriptos = 0;

        do {
            // Salida por Consola
            System.out.println("Ingrese el número del menú: ");
            System.out.println(" 1- Inscribir un participante. \n" +
                    " 2- Mostrar Inscriptos a una categoria. \n" +
                    " 3- Borrar Inscripto. \n" +
                    " 4- Mostrar Total a Pagar. \n" +
                    " 5- Salir");

            option = teclado.nextInt();
            teclado.nextLine();

            switch(option){
                case 1: carrera.inscribirParticipante();
                        break;
                case 2: mostrarInscriptos();
                        break;
                case 3: borrarInscripto();
                        break;
                case 4: calcularTotalAPagar();
                        break;
                case 5: System.out.println("Ud salio del programa");
                        break;
                default: System.out.println("No es un valor valido, ingrese del 1 al 5");

            }
        } while(option != 5);

    }
    public String inscribirParticipante(){
        ID ++;
        System.out.println("ingrese los Datos del participante");
        System.out.println("Nombre: ");
        name = teclado.nextLine();

    }


}
