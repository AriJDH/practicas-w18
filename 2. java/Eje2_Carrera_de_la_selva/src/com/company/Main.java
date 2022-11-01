package com.company;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

public class Main {

    public static void main(String[] args) {
        Main ini = new Main();
	    ini.MenuInicial();
    }
    HashMap<String,String> inscritos1 = new HashMap<>(); //Circuito chico
    HashMap<String,String> inscritos2 = new HashMap<>(); // Circuito medio
    HashMap<String,String> inscritos3 = new HashMap<>(); // Circuito avanzado

    Scanner entrada = new Scanner(System.in);
    int id = 0;
    private  void inscribir_part(){


        entrada.nextLine();
        System.out.println("Ingrese DNI");
        String dni = entrada.nextLine();

        System.out.println("Ingrese Nombres");
        String nombres = entrada.nextLine();

        System.out.println("Ingrese apellidos");
        String apellidos = entrada.nextLine();

        System.out.println("Ingrese edad");
        String edad = entrada.nextLine();

        System.out.println("Ingrese celular");
        String celular = entrada.nextLine();

        System.out.println("Ingrese numero de emergencia");
        String num_emergencia = entrada.nextLine();

        System.out.println("Ingrese grupo sanguineo");
        String rh = entrada.nextLine();



        boolean esvalido = false;
        int circuito = 0;
        while(!esvalido) {
            System.out.println("Escoja una de las siguientes opciones");
            System.out.println("1. Circuito chico\n 2.Circuito medio\n 3. Circuito avanzado");
            circuito = entrada.nextInt();
            if (Integer.parseInt(edad) < 18  && circuito == 3){
                esvalido = false;
                System.out.println("Circuito no permitido para menores de 18 años");
            }
            else {
                esvalido = true;
            }


        }
        int monto = determinar_monto(Integer.parseInt(edad), circuito);
        id += 1;
        String inscrito = dni + "," + nombres + "," + apellidos + "," + edad + "," +
                celular + "," + num_emergencia + "," + rh + "," + monto;
        if (circuito == 1){
            inscritos1.put(Integer.toString(id),inscrito);
        }
        else if (circuito == 2){
            inscritos2.put(Integer.toString(id),inscrito);
        }
        else {
            inscritos3.put(Integer.toString(id),inscrito);
        }

        System.out.println("Ha quedado inscrito, el monto a abonar es: "+ monto);
        MenuInicial();


    }


    private int determinar_monto( int edad, int tipo_circ){
        int monto = 0;
        if (edad < 18 && tipo_circ == 1){
            return 1300;
        }
        else if (edad < 18 && tipo_circ == 2){
            return 2000;
        }
        else if (edad > 18 && tipo_circ == 1){
            return 1500;
        }
        else if (edad > 18 && tipo_circ == 2){
            return 2300;
        }
        return 2800;

        }

    private void desinscribir_part(){
        System.out.println("Ingrese categoria en la que va a desinscribir");
        System.out.println("1. Circuito chico\n 2.Circuito medio\n 3. Circuito avanzado");
        int cat_esc = entrada.nextInt();
        System.out.println("Ingrese Numero de inscripcion del participante");
        String num_ins = entrada.next();
        if(cat_esc == 1){
            inscritos1.remove(num_ins);
        }
        else if (cat_esc == 2){
            inscritos2.remove(num_ins);
        }
        else {
            inscritos3.remove(num_ins);
        }

        System.out.println("Se ha desinscrito correctamente");
        MenuInicial();

    }
    private void mostrar_part(){
        System.out.println("Ingrese la categoria a mostrar");
        System.out.println("1. Circuito chico\n 2.Circuito medio\n 3. Circuito avanzado");
        int opc_esc = entrada.nextInt();
        if(opc_esc == 1){
            for (Map.Entry<String,String> entry:inscritos1.entrySet()){
                System.out.println("Numero de inscripción: "+ entry.getKey());
                String[] datos = entry.getValue().split(",");
                System.out.println("Dni: "+ datos[0]);
                System.out.println("Nombre: "+ datos[1]);
                System.out.println("Apellidos: " + datos[2]);
                System.out.println("Edad: "+ datos[3]);
                System.out.println("Celular: "+ datos[4]);
                System.out.println("Numero emergencia: "+ datos[5]);
                System.out.println("Grupo sanguineo " + datos[6]);
                System.out.println("");
            }
        }
        else if (opc_esc == 2){
            for (Map.Entry<String,String> entry:inscritos2.entrySet()){
                System.out.println("Numero de inscripción: "+ entry.getKey());
                String[] datos = entry.getValue().split(",");
                System.out.println("Dni: "+ datos[0]);
                System.out.println("Nombre: "+ datos[1]);
                System.out.println("Apellidos: " + datos[2]);
                System.out.println("Edad: "+ datos[3]);
                System.out.println("Celular: "+ datos[4]);
                System.out.println("Numero emergencia: "+ datos[5]);
                System.out.println("Grupo sanguineo " + datos[6]);
                System.out.println("");
            }
        }
        else {
            for (Map.Entry<String,String> entry:inscritos3.entrySet()){
                System.out.println("Numero de inscripción: "+ entry.getKey());
                String[] datos = entry.getValue().split(",");
                System.out.println("Dni: "+ datos[0]);
                System.out.println("Nombre: "+ datos[1]);
                System.out.println("Apellidos: " + datos[2]);
                System.out.println("Edad: "+ datos[3]);
                System.out.println("Celular: "+ datos[4]);
                System.out.println("Numero emergencia: "+ datos[5]);
                System.out.println("Grupo sanguineo " + datos[6]);
                System.out.println("");
            }
        }
        entrada.nextLine();
        System.out.println("Presione ENTER para volver al menú inicial");
        MenuInicial();
    }

    private void MenuInicial(){
        System.out.println("1. Inscribir un nuevo participante");
        System.out.println("2. Mostrar inscritos");
        System.out.println("3. Desinscribir participante");
        int opcion = entrada.nextInt();
        if (opcion == 1){
            inscribir_part();
        }
        else if (opcion == 2){
            mostrar_part();
        }
        else {
            desinscribir_part();
        }
    }

    }

