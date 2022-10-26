package com.meli;

import java.util.*;

public class Main {


    public static void main(String[] args) {

        List<Map<String, String>> ListCompetitorsC = new ArrayList<Map<String, String>>();
        List<Map<String, String>> ListCompetitorsM = new ArrayList<Map<String, String>>();
        List<Map<String, String>> ListCompetitorsA = new ArrayList<Map<String, String>>();

        Scanner input = new Scanner(System.in);
        boolean exit = false;
        int response;
        int cont = 1;
        String dni;

        do {

            Map<String, String> competitor = new HashMap<>();
            System.out.println("\n---------------------------------------");
            System.out.println("\nBienvenido ingrese los siguientes datos");
            competitor.put("id", Integer.toString(cont));
            System.out.println("\nSu número de inscripción es:" + cont);

            while(true){
                System.out.println("\nIngrese DNI:");
                dni = input.next();
                if(GetParticipant(ListCompetitorsC,dni) == null && GetParticipant(ListCompetitorsM,dni) == null && GetParticipant(ListCompetitorsA,dni) == null){
                    competitor.put("dni", dni);
                    break;
                }else{
                    System.out.println("Debe volver a ingresar u nuevo DNI dado que el que ingreso ya existe en alguna de las listas.");
                }
            }

            System.out.println("\nIngrese nombre:");
            competitor.put("name", input.next());
            System.out.println("\nIngrese apellido:");
            competitor.put("last_name", input.next());
            System.out.println("\nIngrese edad:");
            competitor.put("age", input.next());
            System.out.println("\nIngrese celular:");
            competitor.put("phone", input.next());
            System.out.println("\nIngrese número de emergencia:");
            competitor.put("emergency_number", input.next());
            System.out.println("\nIngrese grupo sanguineo:");
            competitor.put("blood_type", input.next());

            while (true) {

                System.out.println("\nCircuito al que se quiere inscribir:");
                System.out.println("\n1.Chico\n2.Medio\n3.Avanzado");
                System.out.println("\nRespuesta:");
                response = input.nextInt();

                if ((Integer.parseInt(competitor.get("age"))) >= 18) {
                    if (response == 1) {
                        competitor.put("value_inscription", "1500");
                        ListCompetitorsC.add(competitor);
                        break;
                    } else if (response == 2) {
                        competitor.put("value_inscription", "2300");
                        ListCompetitorsM.add(competitor);
                        break;
                    } else if (response == 3) {
                        competitor.put("value_inscription", "2800");
                        ListCompetitorsA.add(competitor);
                        break;
                    } else {
                        System.out.println("\nIngrese una respuesta valida.");
                    }
                } else {
                    if (response == 1) {
                        competitor.put("value_inscription", "1300");
                        ListCompetitorsC.add(competitor);
                        break;
                    } else if (response == 2) {
                        competitor.put("value_inscription", "2000");
                        ListCompetitorsM.add(competitor);
                        break;
                    } else if (response == 3) {
                        System.out.println("\nNo se permite inscripciones a menores de edad al circuito avanzado, intente con otra respuesta.");
                    } else {
                        System.out.println("\nIngrese una respuesta valida.");
                    }
                }
            }

            System.out.println("\n----------------------------------------");
            System.out.println("\nQuiere seguir inscribiendo participantes:");
            System.out.println("\n1. Si\n2.No");
            System.out.println("\nRespuesta:");
            exit = (input.nextInt() == 1 ? true : false);

            cont++;
        } while (exit);

        exit = false;
        Map<String,String> participant;

        do{
            System.out.println("\n---------------------------------------");
            System.out.println("\nBienvenido al modulo de eliminación, estos son los participantes actuales:");

            ShowParticipants(ListCompetitorsC,ListCompetitorsM,ListCompetitorsA);

            System.out.println("\nDesea eliminar alguno:");
            System.out.println("\n1. Si\n2.No");
            System.out.println("\nRespuesta:");

            exit = (input.nextInt() == 1 ? true : false);

            if (!exit) break;

            System.out.println("\nIngrese DNI del participante a eliminar:");
            dni = input.next();

            participant= GetParticipant(ListCompetitorsC,dni);
            if(participant!=null) ListCompetitorsC.remove(participant);
            participant = GetParticipant(ListCompetitorsM,dni);
            if(participant!=null) ListCompetitorsM.remove(participant);
            participant = GetParticipant(ListCompetitorsA,dni);
            if(participant!=null) ListCompetitorsA.remove(participant);

            System.out.println("\n----------------------------------------");
            System.out.println("\nQuiere seguir eliminando participantes:");
            System.out.println("\n1. Si\n2.No");
            System.out.println("\nRespuesta:");
            exit = (input.nextInt() == 1 ? true : false);

        }while(exit);

        input.close();
        ShowParticipants(ListCompetitorsC,ListCompetitorsM,ListCompetitorsA);

    }
    public static Map<String,String> GetParticipant(List<Map<String, String>>  array, String dni){
        for( var par :  array){
            if(par.get("dni").equals(dni)){
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