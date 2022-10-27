import java.util.ArrayList;
import java.util.Scanner;

public class Carrera_Selva {
    static Scanner teclado = new Scanner(System.in);
    static ArrayList<String[]> circuito_chico = new ArrayList<>();
    static ArrayList<String[]> circuito_medio = new ArrayList<>();
    static ArrayList<String[]> circuito_avanzado = new ArrayList<>();

    public static void menu() {
        int opcion = 0;

        System.out.println("==========MENU==========");
        System.out.println("1) Inscribir nuevo participante a una categoria.");
        System.out.println("2) Mostrar todos los participantes de una categoria.");
        System.out.println("3) Desinscribir a un participante de una categoria");
        System.out.println("4) Determinar el monto a abonar.");
        System.out.println("5) Salir.");

        while (opcion != 5) {
            System.out.println("Elige una opcion: ");
            opcion = teclado.nextInt();

            switch (opcion) {
                case 1: {
                    inscribir();
                    break;
                }

                case 2:
                    mostrar_todo();
                    break;

                case 3:
                    desinscribir();
                    break;

                case 4:
                    monto_pagar();
                    break;

                case 5: System.exit(0);

                default: {
                    System.out.println("Ingrese una opcion correcta!");
                    opcion = teclado.nextInt();
                }

            }
        }


    }

    public static void inscribir() {
        int opcion;
        String dni, nombre, apellido, edad, celular, numero_emergencia, grupo_sanguineo;

        System.out.println("Ingresa el dni: ");
        dni = teclado.next();
        System.out.println("Ingresa el nombre: ");
        nombre = teclado.next();
        System.out.println("Ingresa el apellido: ");
        apellido = teclado.next();
        System.out.println("Ingresa la edad: ");
        edad = teclado.next();
        System.out.println("Ingresa el celular: ");
        celular = teclado.next();
        System.out.println("Ingresa el numero de emergencia: ");
        numero_emergencia = teclado.next();
        System.out.println("Ingresa el grupo sanguineo: ");
        grupo_sanguineo = teclado.next();

        System.out.println("\nSeleccione el circuito al que se quiere inscribir: ");
        System.out.println("1) Circuito chico.");
        System.out.println("2) Circuito medio.");
        System.out.println("3) Circuito avanzado.");
        opcion = teclado.nextInt();
        switch (opcion) {
            case 1: {
                String[] persona = {dni, nombre, apellido, edad, celular, numero_emergencia, grupo_sanguineo};
                circuito_chico.add(persona);
                menu();
            }
            case 2: {
                String[] persona = {dni, nombre, apellido, edad, celular, numero_emergencia, grupo_sanguineo};
                circuito_medio.add(persona);
                menu();
            }
            case 3: {
                String[] persona = {dni, nombre, apellido, edad, celular, numero_emergencia, grupo_sanguineo};
                circuito_avanzado.add(persona);
                menu();
            }
            default:
                System.out.println("Seleccione una opcion correcta!");
                menu();
            }
        }

        public static void mostrar_todo() {
        int opcion;
            System.out.println("Elige un circuito para ver sus participantes: ");
            System.out.println("1) Circuito chico.\n2) Circuito medio.\n3) Circuito avanzado.");
            System.out.println("//MOSTRAR TODO// Elige una opcion: ");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1:{
                    for(int i=0; i< circuito_chico.size(); i++){
                        System.out.println(circuito_chico.get(i)[0]+"-"+circuito_chico.get(i)[1]+"-"+circuito_chico.get(i)[2]+"-"+circuito_chico.get(i)[3]+"-"+circuito_chico.get(i)[4]+"-"+circuito_chico.get(i)[5]+"-"+circuito_chico.get(i)[6]+"- Posicion: "+i);
                    }
                    menu();
                }
                case 2:{
                    for(int i=0; i< circuito_medio.size(); i++){
                        System.out.println(circuito_medio.get(i)[0]+"-"+circuito_medio.get(i)[1]+"-"+circuito_medio.get(i)[2]+"-"+circuito_medio.get(i)[3]+"-"+circuito_medio.get(i)[4]+"-"+circuito_medio.get(i)[5]+"-"+circuito_medio.get(i)[6]+"- Posicion: "+i);
                    }
                    menu();
                }
                case 3:{
                    for(int i=0; i< circuito_avanzado.size(); i++){
                        System.out.println(circuito_avanzado.get(i)[0]+"-"+circuito_avanzado.get(i)[1]+"-"+circuito_avanzado.get(i)[2]+"-"+circuito_avanzado.get(i)[3]+"-"+circuito_avanzado.get(i)[4]+"-"+circuito_avanzado.get(i)[5]+"-"+circuito_avanzado.get(i)[6]+"- Posicion: "+i);
                    }
                    menu();
                }
                default:
                    System.out.println("Ingrese una opcion correcta!");
            }

        }

        public static void desinscribir() {
            int opcion, posicion;
            System.out.println("Elige un circuito para desinscribir a un participante: ");
            System.out.println("1) Circuito chico.\n2) Circuito medio.\n3) Circuito avanzado.");
            System.out.println("Elige una opcion: ");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1:{
                    System.out.println("Ingresa la posicion del participante que quieres desinscribir");
                    circuito_chico.remove(teclado.nextInt());
                    System.out.println("Participante eliminado correctamente!");
                    menu();
                }
                case 2:{
                    System.out.println("Ingresa la posicion del participante que quieres desinscribir");
                    circuito_medio.remove(teclado.nextInt());
                    System.out.println("Participante eliminado correctamente!");
                    menu();

                }
                case 3:{
                    System.out.println("Ingresa la posicion del participante que quieres desinscribir");
                    circuito_avanzado.remove(teclado.nextInt());
                    System.out.println("Participante eliminado correctamente!");
                    menu();
                }
                default:
                    System.out.println("Ingrese una opcion correcta!");
                    menu();
            }

        }

        public static void monto_pagar() {
            int opcion;
            System.out.println("\nSeleccione el circuito al que se quiere inscribir: ");
            System.out.println("1) Circuito chico.");
            System.out.println("2) Circuito medio.");
            System.out.println("3) Circuito avanzado.");
            opcion = teclado.nextInt();
            switch (opcion) {
                case 1: {
                    for(int i=0; i< circuito_chico.size(); i++){
                        if(Integer.parseInt(circuito_chico.get(i)[3]) < 18){
                            System.out.println(circuito_chico.get(i)[0]+"-"+circuito_chico.get(i)[1]+"-"+circuito_chico.get(i)[2]+"-"+circuito_chico.get(i)[3]+" Debe pagar: $1300");
                        }else if(Integer.parseInt(circuito_chico.get(i)[3]) > 18){
                            System.out.println(circuito_chico.get(i)[0]+"-"+circuito_chico.get(i)[1]+"-"+circuito_chico.get(i)[2]+"-"+circuito_chico.get(i)[3]+" Debe pagar: $1500");
                        }
                    }
                    menu();
                }
                case 2: {
                    for(int i=0; i< circuito_medio.size(); i++){
                        if(Integer.parseInt(circuito_medio.get(i)[3]) < 18){
                            System.out.println(circuito_medio.get(i)[0]+"-"+circuito_medio.get(i)[1]+"-"+circuito_medio.get(i)[2]+"-"+circuito_medio.get(i)[3]+" Debe pagar: $2000");
                        }else if(Integer.parseInt(circuito_medio.get(i)[3]) > 18){
                            System.out.println(circuito_medio.get(i)[0]+"-"+circuito_medio.get(i)[1]+"-"+circuito_medio.get(i)[2]+"-"+circuito_medio.get(i)[3]+" Debe pagar: $2300");
                        }
                    }
                    menu();
                }
                case 3: {
                    for(int i=0; i< circuito_avanzado.size(); i++){
                        if(Integer.parseInt(circuito_avanzado.get(i)[3]) < 18){
                            System.out.println(circuito_avanzado.get(i)[0]+"-"+circuito_avanzado.get(i)[1]+"-"+circuito_avanzado.get(i)[2]+"-"+circuito_avanzado.get(i)[3]+" No se puede inscribir a este circuito!!");
                        }else if(Integer.parseInt(circuito_avanzado.get(i)[3]) > 18){
                            System.out.println(circuito_avanzado.get(i)[0]+"-"+circuito_avanzado.get(i)[1]+"-"+circuito_avanzado.get(i)[2]+"-"+circuito_avanzado.get(i)[3]+" Debe pagar: $2800");
                        }
                    }
                    menu();
                }
                default:
                    System.out.println("Seleccione una opcion correcta!");
                    menu();
            }

        }

        public static void main (String[]args){
            menu();
        }
    }


