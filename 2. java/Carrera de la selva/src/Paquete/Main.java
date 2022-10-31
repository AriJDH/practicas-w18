package Paquete;

import java.util.*;

public class Main {
    int tipoCircuito;
    ArrayList<String> datos;
    int ordenChico;
    int ordenMedio;
    int ordenAvanzado;
    int opcion=0;
    int monto;

//    Creo hashmaps que me dejen meter una lista de datos como el valor
    HashMap<Integer,ArrayList<String>> chico= new HashMap<Integer,ArrayList<String>>();
    HashMap<Integer,ArrayList<String>> medio= new HashMap<Integer,ArrayList<String>>();
    HashMap<Integer,ArrayList<String>> avanzado= new HashMap<Integer,ArrayList<String>>();

    Scanner entrada=new Scanner(System.in);

//    Metodo para seleccionar que metodo ejecutar
    public void opciones()
    {
        do {
            System.out.println("---------");
            System.out.println("OPCIONES:");
            System.out.println("1. Incripcion a un circuito y pagar ");
            System.out.println("2. Listar todos los inscritos a una categoria");
            System.out.println("3. Desisnscribir un participante");
            System.out.println("5. Salir ");
            System.out.println("");
            System.out.println("Ingrese el numero correspondiente a la opcion que desea: ");
            opcion=entrada.nextInt();
            switch(opcion) {
                case 1: inscribir();
                break;
                case 2: imprimir();
                break;
                case 3: desinscribir();
                break;
            }


        } while (opcion != 5);
        System.out.println("Hasta luego");
    }

//    Metodo para inscribir
    public void inscribir() {
        System.out.println("Ingrese el tipo de competencia a la que desea inscribirse: ");
        System.out.println("1. Circuito chico");
        System.out.println("2. Circuito medio");
        System.out.println("3. Circuito avanzado");
        tipoCircuito = entrada.nextInt();

        if (tipoCircuito==1) {
//            Crea un elemento del hashmap
            chico.put(ordenChico, new ArrayList<String>());
//            Saca el value asociado a la key, en este caso es un array list que se va a llenar con los datos
            datos=chico.get(ordenChico);
        } else {
            if (tipoCircuito==2) {
                medio.put(ordenMedio, new ArrayList<String>());
                datos=medio.get(ordenMedio);
            } else {
                avanzado.put(ordenAvanzado, new ArrayList<String>());
                datos=avanzado.get(ordenAvanzado);
            }
        }

        //            Ingresa los datos de cada uno en el array
        System.out.println("Ingrese su dni: ");
        String dni = entrada.next();
        datos.add(dni);
        System.out.println("Ingrese su nombre: ");
        String nombre = entrada.next();
        datos.add(nombre);
        System.out.println("Ingrese su apellido: ");
        String apellido = entrada.next();
        datos.add(apellido);
        System.out.println("Ingrese su edad: ");
        String edad = entrada.next();
        datos.add(edad);
        System.out.println("Ingrese su celular: ");
        String celular = entrada.next();
        datos.add(celular);
        System.out.println("Ingrese su numero de emergencia: ");
        String numero = entrada.next();
        datos.add(numero);
        System.out.println("Ingrese su grupo sanguineo: ");
        String sangre = entrada.next();
        datos.add(sangre);

        if (tipoCircuito==1) {
//            Mete el array ya lleno nuevamente en el hashmap
            chico.put(ordenChico,datos);
//            Para que el nuevo tenga un numero de inscripcion consecuente
            ordenChico++;
//            Determinar cuanto debe pagar segun la edad
            if (Integer.parseInt(edad)<18){
                monto=1300;
            }else{
                monto=1500;
            }
            System.out.println(" ");
            System.out.println("Participante inscrito, debe pagar "+monto);

        } else {
            if (tipoCircuito==2) {
                medio.put(ordenMedio,datos);
                ordenMedio++;
                if (Integer.parseInt(edad)<18){
                    monto=2000;
                }else{
                    monto=2300;
                }
                System.out.println(" ");
                System.out.println("Participante inscrito, debe pagar "+monto);

            } else {
                avanzado.put(ordenAvanzado,datos);
                if (Integer.parseInt(edad)<18){
//                    No puede inscribirse, se borra y no aumenta el orden
                    System.out.println("No se permite la inscripcion de menores de 18 a esta categoria");
                    avanzado.remove(ordenAvanzado);
                }else{
                    monto=2800;
                    System.out.println(" ");
                    System.out.println("Participante inscrito, debe pagar "+monto);
                    ordenAvanzado++;
                }

            }
        }
        }
//      Metodo para mostrar la info de cada categoria
    public void imprimir() {
        System.out.println("Acerca de cual categoria desea ver los inscritos?: ");
        System.out.println("1. Circuito chico");
        System.out.println("2. Circuito medio");
        System.out.println("3. Circuito avanzado");
        tipoCircuito = entrada.nextInt();
        HashMap<Integer, ArrayList<String>> seleccionada = new HashMap<Integer, ArrayList<String>>();
        if (tipoCircuito==1) {
            seleccionada = chico;

        } else {
            if (tipoCircuito==2) {
                seleccionada = medio;
            } else {
                seleccionada = avanzado;
            }
        }
        for (Map.Entry<Integer, ArrayList<String>> entry : seleccionada.entrySet()) {
            List<String> info = entry.getValue();
            System.out.println("");
            System.out.println("----------------------");
            System.out.println("Numero de inscripcion: " + entry.getKey());
            System.out.println("----------------------");
            System.out.println("dni: " + info.get(0));
            System.out.println("Nombre: " + info.get(1));
            System.out.println("Apellido: " + info.get(2));
            System.out.println("Edad: " + info.get(3));
            System.out.println("Celular: " + info.get(4));
            System.out.println("Numero de contacto: " + info.get(5));
            System.out.println("Grupo sanguineo: " + info.get(6));
            System.out.println("");
            System.out.println("----------------------");
            System.out.println("");
            System.out.println("");


        }
    }
//Metodo para desinscribir
    public void desinscribir(){
        System.out.println("De cual categoria desea desinscribir el participante? ");
        System.out.println("1. Circuito chico");
        System.out.println("2. Circuito medio");
        System.out.println("3. Circuito avanzado");
        tipoCircuito = entrada.nextInt();
        System.out.println("Cual es el numero de inscripcion del participante?");
        opcion = entrada.nextInt();
        if (tipoCircuito==1) {
            chico.remove(opcion);
        } else {
            if (tipoCircuito==2) {
                medio.remove(opcion);
            } else {
                avanzado.remove(opcion);
            }
        }
        System.out.println("Participante " +opcion+ " desinscrito");
    }

    public static void main(String[] args) {
           new Main().opciones();
    }
}
