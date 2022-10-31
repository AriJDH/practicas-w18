import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        // Listado de participantes
        Map<Integer, Map<String, String>> participantes = new HashMap<>();
        ingresoAlSistema(participantes);
    }
    private static void ingresoAlSistema(Map<Integer, Map<String, String>> participantes) {
        // Input por consola
        Scanner input = new Scanner(System.in);
        // Sistema para "Carrera de la selva"
        System.out.println("¿Qué deseas hacer? \n 1) Ingresar participante \n 2) Ver participantes \n 3) Ver cantidad de inscriptos por categoría") ;
        // TODO pendiente de realizar el método de cantidad de inscriptos por categoría y refactorizar la parte del circuito avanzado para menores.
        int opcionElegida = Integer.parseInt(input.nextLine());


        // Elección de la opción
        if (opcionElegida == 1) {
            System.out.println("Ingresá el nº de DNI: ");
            Integer dni = input.nextInt();
            ingresarParticipante(dni, participantes);
        } else if (opcionElegida == 2) {
            verParticipantes(participantes);
        }
    }

    private static void ingresarParticipante(Integer dni, Map<Integer, Map<String, String>> participantes) {
        // Input por consola
        Scanner input = new Scanner(System.in);
        System.out.println(participantes.containsKey(dni));
        // Participante
        if (participantes.containsKey(dni)) {
            System.out.println("El participante ya está registrado.");
            ingresoAlSistema(participantes);
        } else {
            // Ingreso de datos
            System.out.println("Para poder registrarte ingresá los siguientes datos: ");
            System.out.println("Nombre: ");
            String nombre = input.nextLine();
            System.out.println("Apellido: ");
            String apellido = input.nextLine();
            System.out.println("Edad: ");
            int edad = Integer.parseInt(input.nextLine());
            System.out.println("Celular: ");
            String celular = input.nextLine();
            System.out.println("Número de emergencia: ");
            String numeroEmergencia = input.nextLine();
            System.out.println("Grupo Sanguíneo: ");
            String grupoSanguineo = input.nextLine();
            System.out.println("Circuito (1=Chico, 2=Medio, 3=Grande) Ingresá 1, 2 o 3 según el circuito que elijas:  ");
            int circuito = Integer.parseInt(input.nextLine());
            String valor = calcularValor(edad,circuito);

            // Guardamos los datos en el participante
            Map<String, String> participante = new HashMap<>();
            participante.put("DNI", String.valueOf(dni));
            participante.put("Nombre", nombre);
            participante.put("Apellido", apellido);
            participante.put("Edad", String.valueOf(edad));
            participante.put("Celular", celular);
            participante.put("Numero de Emergencia", numeroEmergencia);
            participante.put("Grupo Sanguineo", grupoSanguineo);
            participante.put("Circuito", String.valueOf(circuito));
            participante.put("Valor Inscripción", valor);
            System.out.println(participante.toString());
            participantes.put(dni, participante);
            System.out.println(participantes);
            ingresoAlSistema(participantes);
        }
    }

    static String calcularValor(int edad, int circuito){
        String valor = "";
        if(edad <18 && circuito == 1){
            valor = "$ 1.300";
        } else if(edad > 18 && circuito == 1){
            valor = "$ 1.500";
        }else if(edad < 18 && circuito == 2){
            valor = "$ 2.000";
        }else if(edad > 18 && circuito == 2){
            valor = "$ 2.300";
        }else if(edad > 18 && circuito == 3){
            valor = "$ 2.800";
        } else if(edad <18 && circuito == 3){
            valor="No se admitió su inscripción";
        }
        return valor;
    }
    static void verParticipantes(Map<Integer, Map<String, String>> participantes) {
        System.out.println(participantes);
        ingresoAlSistema(participantes);
    }
}
