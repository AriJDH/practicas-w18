import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.List;
import java.util.Scanner;

public class Carrera {

    public static void main(String[] args) {

        List<Map<String, String>> circuitoC = new ArrayList<Map<String, String>>();
        List<Map<String, String>> circuitoM = new ArrayList<Map<String, String>>();
        List<Map<String, String>> circuitoA = new ArrayList<Map<String, String>>();

        Scanner input = new Scanner(System.in);
        boolean salir = false;
        int respuesta;
        int cont = 1;
        String dni;

        do {

            Map<String, String> competitor = new HashMap<>();
            System.out.println("\n---------------------------------------");
            System.out.println("\nBienvenido a las inscripciones, por favor ingrese los siguientes datos: ");
            competitor.put("ID", Integer.toString(cont));
            System.out.println("\nSu número de inscripción es:" + cont);

            while(true){
                System.out.println("\nIngrese DNI:");
                dni = input.next();
                if(GetParticipant(circuitoC,dni) == null && GetParticipant(circuitoM,dni) == null && GetParticipant(circuitoA,dni) == null){
                    competitor.put("DNI", dni);
                    break;
                }else{
                    System.out.println("Su DNI ya esta inscripto.");
                }
            }

            System.out.println("\nIngrese nombre:");
            competitor.put("nombre", input.next());
            System.out.println("\nIngrese apellido:");
            competitor.put("apellido", input.next());
            System.out.println("\nIngrese edad:");
            competitor.put("edad", input.next());
            System.out.println("\nIngrese celular:");
            competitor.put("celular", input.next());
            System.out.println("\nIngrese número de emergencia:");
            competitor.put("numero_emergencia", input.next());
            System.out.println("\nIngrese grupo sanguineo:");
            competitor.put("grupo_sanguineo", input.next());

            while (true) {

                System.out.println("\nA que circuito se quiere inscribir? ");
                System.out.println("\n1.Chico\n2.Medio\n3.Avanzado");
                System.out.println("\nRespuesta:");
                respuesta = input.nextInt();

                if ((Integer.parseInt(competitor.get("edad"))) >= 18) {
                    if (respuesta == 1) {
                        competitor.put("valorDeInscripcion", "1500");
                        circuitoC.add(competitor);
                        break;
                    } else if (respuesta == 2) {
                        competitor.put("valorDeInscripcion", "2300");
                        circuitoM.add(competitor);
                        break;
                    } else if (respuesta == 3) {
                        competitor.put("valorDeInscripcion", "2800");
                        circuitoA.add(competitor);
                        break;
                    } else {
                        System.out.println("\nIngrese un numero entre el 1-3");
                    }
                } else {
                    if (respuesta == 1) {
                        competitor.put("valorDeInscripcion", "1300");
                        circuitoC.add(competitor);
                        break;
                    } else if (respuesta == 2) {
                        competitor.put("valorDeInscripcion", "2000");
                        circuitoM.add(competitor);
                        break;
                    } else if (respuesta == 3) {
                        System.out.println("\nNo admitimos menores de edad en nuestro circuito avanzado.");
                    } else {
                        System.out.println("\nIngrese una respuesta valida.");
                    }
                }
            }

            System.out.println("\n----------------------------------------");
            System.out.println("\nQuiere seguir inscribiendo participantes:");
            System.out.println("\n1. Si\n2.No");
            System.out.println("\nRespuesta:");
            salir = (input.nextInt() == 1 ? true : false);

            cont++;
        } while (salir);

        salir = false;
        Map<String,String> participant;

        do{
            System.out.println("\n---------------------------------------");
            System.out.println("\nBienvenido al modulo de eliminación, actualmente tenemos a los siguientes participantes:");

            ShowParticipants(circuitoC,circuitoM,circuitoA);

            System.out.println("\nDesea eliminar alguno:");
            System.out.println("\n1. Si\n2.No");
            System.out.println("\nRespuesta:");

            salir = (input.nextInt() == 1 ? true : false);

            if (!salir) break;

            System.out.println("\nIngrese DNI del participante a eliminar:");
            dni = input.next();

            participant= GetParticipant(circuitoC,dni);
            if(participant!=null) circuitoC.remove(participant);
            participant = GetParticipant(circuitoM,dni);
            if(participant!=null) circuitoM.remove(participant);
            participant = GetParticipant(circuitoA,dni);
            if(participant!=null) circuitoA.remove(participant);

            System.out.println("\n----------------------------------------");
            System.out.println("\nQuiere seguir eliminando participantes:");
            System.out.println("\n1. Si\n2.No");
            System.out.println("\nRespuesta:");
            salir = (input.nextInt() == 1 ? true : false);

        }while(salir);

        input.close();
        ShowParticipants(circuitoC,circuitoM,circuitoA);

    }
    public static Map<String,String> GetParticipant(List<Map<String, String>>  array, String dni){
        for( Map<String, String> par :  array){
            if(par.get("DNI").equals(dni)){
                return par;
            }
        }
        return null;
    }

    public static void ShowParticipants(List<Map<String, String>> ListCompetitorsC, List<Map<String, String>> ListCompetitorsM,List<Map<String, String>> ListCompetitorsA){
        System.out.println("\n---------------------------------------");
        System.out.println("\nAsi quedaron las listas:");
        System.out.println("\nLista chicos:");
        System.out.println(ListCompetitorsC.toString());
        System.out.println("\nLista medios:");
        System.out.println(ListCompetitorsM.toString());
        System.out.println("\nLista avanzados:");
        System.out.println(ListCompetitorsA.toString());
    }
}


