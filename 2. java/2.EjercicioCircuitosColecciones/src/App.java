
import java.util.*;

public class App {

    int numeroDeParticipante = 0;

    Map<Integer,Integer> dni = new HashMap<>();
    Map<Integer,String> nombre = new HashMap<>();
    Map<Integer,String> apellido = new HashMap<>();
    Map<Integer,Integer> edad = new HashMap<>();
    Map<Integer,Long> celular = new HashMap<>();
    Map<Integer,Long> numeroDeEmergencia = new HashMap<>();
    Map<Integer,String> grupoSanguineo = new HashMap<>();
    Map<Integer,Integer> valorInscripcion = new HashMap<>();

    List<Integer> circuitoChico = new ArrayList<>();
    List<Integer> circuitoMediano = new ArrayList<>();
    List<Integer> circuitoAvanzado = new ArrayList<>();

    static Scanner in = new Scanner(System.in);

    public static void main(String[] args) {

        String opcion;
        App app = new App();

        do {
            System.out.println("A - Inscribirme");
            System.out.println("B - Mostrar participantes por circuito");
            System.out.println("C - Desinscribir participante");
            System.out.println("D - Determinar el monto de inscripcion");
            System.out.println("X - Salir");
            System.out.println("Ingrese una opcion");

            opcion = in.nextLine();

            switch (opcion){
                case "A":
                    app.inscribirParticipante();
                    break;

                case "B":
                    app.mostrarParticipantePorCircuito();
                    break;

                case "C":
                    app.desinscribirParticipante();
                    break;

                case "D":
                    app.calcularMonto();
                    break;

                case "X":
                    break;

                default:
                    System.out.println("Opcion incorrecta");
                    break;
            }



        } while (opcion.equals("A") || opcion.equals("B") || opcion.equals("C") || opcion.equals("D"));


    }

    public void inscribirParticipante(){

        String opcion = "";
        numeroDeParticipante = numeroDeParticipante + 1;

        System.out.println("Ingrese DNI");
        dni.put(numeroDeParticipante, Integer.parseInt(in.nextLine()));
        System.out.println("Ingrese Nombre");
        nombre.put(numeroDeParticipante, in.nextLine());
        System.out.println("Ingrese Apellido");
        apellido.put(numeroDeParticipante, in.nextLine());
        System.out.println("Ingrese Edad");
        edad.put(numeroDeParticipante, Integer.parseInt(in.nextLine()));
        System.out.println("Ingrese Celular");
        celular.put(numeroDeParticipante, Long.valueOf(in.nextLine()));
        System.out.println("Ingrese numero de Emergencia");
        numeroDeEmergencia.put(numeroDeParticipante, Long.valueOf(in.nextLine()));
        System.out.println("Ingrese grupo Sanguineo");
        grupoSanguineo.put(numeroDeParticipante, in.nextLine());

        System.out.println("A que carrera se quiere inscribir");
        System.out.println("A - Circuito Chico");
        System.out.println("B - Circuito Medio");
        System.out.println("C - Circuito Avanzado");

        do {


            opcion = in.nextLine();

            if (opcion.equals("A")) {

                if (edad.get(numeroDeParticipante) < 18) {
                    valorInscripcion.put(numeroDeParticipante, 1300);
                } else {
                    valorInscripcion.put(numeroDeParticipante, 1500);
                }
                circuitoChico.add(numeroDeParticipante);
                System.out.println("INSCRIPTO CON EXITO !");
            }

            if (opcion.equals("B")) {

                if (edad.get(numeroDeParticipante) < 18) {
                    valorInscripcion.put(numeroDeParticipante, 2000);
                } else {
                    valorInscripcion.put(numeroDeParticipante, 2300);
                }
                circuitoMediano.add(numeroDeParticipante);
                System.out.println("INSCRIPTO CON EXITO !");
            }

            if (opcion.equals("C")) {

                if (edad.get(numeroDeParticipante) < 18) {

                    System.out.println("No se Permiten menores en esta Categoria");
                    System.out.println("Inscribierse en otra Categoria");
                } else {
                    valorInscripcion.put(numeroDeParticipante, 2800);
                    circuitoAvanzado.add(numeroDeParticipante);
                    System.out.println("INSCRIPTO CON EXITO !");
                }
            }

        } while (opcion.equals("C") && (edad.get(numeroDeParticipante) < 18));
    }

    public void mostrarParticipantePorCircuito() {

        String opcion = "";

        System.out.println("Seleccionar que categoria mostrar");
        System.out.println("A - Circuito Chico");
        System.out.println("B - Circuito Medio");
        System.out.println("C - Circuito Avanzado");

        opcion = in.nextLine();
        List<Integer> lista = new ArrayList<>();

        if (opcion.equals("A")) {

            lista = circuitoChico;
        } else if (opcion.equals("B")) {

            lista = circuitoMediano;
        } else if (opcion.equals("C")) {

            lista = circuitoAvanzado;
        } else {

            System.out.println("Circuito incorrecto !");
        }

        for(Integer elemento : lista) {

            System.out.println("Numero de Inscripcion: " + elemento);

            System.out.println("DNI: " + dni.get(elemento));
            System.out.println("Nombre: " + nombre.get(elemento));
            System.out.println("Apellido: " + apellido.get(elemento));
            System.out.println("Edad: " + edad.get(elemento));
            System.out.println("Celular: " + celular.get(elemento));
            System.out.println("Numero de Emergencia: " + numeroDeEmergencia.get(elemento));
            System.out.println("Grupo Sanguineo: " + grupoSanguineo.get(elemento));

            System.out.println("");
        }
    }

    public void desinscribirParticipante() {

        Integer numeroParticipante;

        System.out.println("Ingrese el numero del Participante que quiere Desinscribir");

        numeroParticipante = Integer.parseInt(in.nextLine());

        circuitoChico.remove(numeroParticipante);
        circuitoMediano.remove(numeroParticipante);
        circuitoAvanzado.remove(numeroParticipante);

        dni.remove(numeroParticipante);
        nombre.remove(numeroParticipante);
        apellido.remove(numeroParticipante);
        edad.remove(numeroParticipante);
        celular.remove(numeroParticipante);
        numeroDeEmergencia.remove(numeroParticipante);
        grupoSanguineo.remove(numeroParticipante);

        System.out.println("Participante Eliminado !");
    }

    public void calcularMonto() {

        Integer numeroDeParticipante;
        System.out.println("Ingresar numero de Participante");

        numeroDeParticipante = Integer.parseInt(in.nextLine());

        System.out.println(nombre.get(numeroDeParticipante) + " tiene que abonar " + valorInscripcion.get(numeroDeParticipante));
    }

}