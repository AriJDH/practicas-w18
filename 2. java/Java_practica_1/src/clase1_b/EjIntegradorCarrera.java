package clase1_b;

import java.sql.SQLOutput;
import java.util.*;

public class EjIntegradorCarrera {
    public static void main(String[] args) {
        List<Map<Integer, ArrayList<String>>> circuitoChico = new ArrayList();
        List<Map<Integer, ArrayList<String>>> circuitoMedio = new ArrayList();
        List<Map<Integer, ArrayList<String>>> circuitoAvanzado = new ArrayList();
        List<List<Map<Integer, ArrayList<String>>>> circuitos = new ArrayList<>();
        circuitos.add(circuitoChico);
        circuitos.add(circuitoMedio);
        circuitos.add(circuitoAvanzado);
        Scanner teclado = new Scanner(System.in);
        String nombre, apellido, edad, celular, nroEmergencia, grupoSanguineo;
        int dni = 0, opcion = 0, categoria = 0, nroInscripcion = 0;
        boolean encontroParticipante = false;

        do{
            System.out.println("-----------------------------------------");
            System.out.println("Ingrese su opción:");
            System.out.println("-----------------------------------------\n");
            System.out.println("1 - Inscribir participante");
            System.out.println("2 - Mostrar participantes");
            System.out.println("3 - Desinscribir participante");
            System.out.println("0 - Salir");
            opcion = teclado.nextInt();
            teclado.nextLine();

            // Si elige inscribir participante
            if (opcion == 1){
                System.out.println("\nIngrese el DNI del participante a inscribir: ");
                dni = teclado.nextInt();
                teclado.nextLine();
                encontroParticipante = false;
                for (int i = 0; i < circuitos.size(); i++){
                    for (int j = 0; j < circuitos.get(i).size(); j ++){
                        if(circuitos.get(i).get(j).get(dni) != null){
                            encontroParticipante = true;
                            break;
                        }
                    }
                    if (encontroParticipante) break;
                }
                if(!encontroParticipante){
                    do {
                        System.out.println("\nIngrese el nro. de  categoría de carrera a competir: ");
                        System.out.println("1 - Circuito chico: 2 km por selva y arroyos.");
                        System.out.println("2 - Circuito medio: 5 km por selva, arroyos y barro.");
                        System.out.println("3 - Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra");
                        categoria = teclado.nextInt();
                        teclado.nextLine();
                    } while (categoria < 1 && categoria > 3);
                    System.out.println("Edad: ");
                    edad = teclado.nextLine();
                    if (!(Integer.parseInt(edad) < 18 && categoria == 3)){
                        System.out.println("Nombre: ");
                        nombre = teclado.nextLine();
                        System.out.println("Apellido: ");
                        apellido = teclado.nextLine();
                        System.out.println("Celular: ");
                        celular = teclado.nextLine();
                        System.out.println("Nro. de emergencia: ");
                        nroEmergencia = teclado.nextLine();
                        System.out.println("Grupo sanguíneo: ");
                        grupoSanguineo = teclado.nextLine();
                        System.out.print("\nIngreso realizado con éxito...el monto de la inscripción es de: $");
                        switch (categoria){
                            case 1:
                                if ((Integer.parseInt(edad) < 18)) System.out.println("1300");
                                    else System.out.println("1500");
                                break;
                            case 2:
                                if ((Integer.parseInt(edad) < 18)) System.out.println("2000");
                                    else System.out.println("2300");
                                break;
                            default:
                                System.out.println("2800");
                        }
                        ArrayList<String> datosParticipante = new ArrayList<>();
                        datosParticipante.add(String.valueOf(nroInscripcion));
                        datosParticipante.add(nombre);
                        datosParticipante.add(apellido);
                        datosParticipante.add(edad);
                        datosParticipante.add(celular);
                        datosParticipante.add(nroEmergencia);
                        datosParticipante.add(grupoSanguineo);
                        HashMap<Integer, ArrayList<String>> participante = new HashMap();
                        participante.put(dni, datosParticipante);
                        circuitos.get(categoria-1).add(participante);
                        nroInscripcion ++;
                        System.out.println("\nPresione una tecla para continuar...");
                        teclado.nextLine();
                    } else{
                        System.out.println("No se permiten participantes menores a 18 años para el Circuito Avanzado");
                        System.out.println("\nPresione una tecla para continuar...");
                        teclado.nextLine();
                    }
                } else {
                    System.out.println("El participante con DNI: " + dni + " ya se encuentra registrado");
                    System.out.println("\nPresione una tecla para continuar...");
                    teclado.nextLine();
                }
            }
            // si elige mostrar los participantes de una categoria
            else if (opcion == 2){
                do {
                    System.out.println("\n------------------------------------------------------------------------------------------------------------");
                    System.out.println("\nIngrese el nro. de  categoría del cual quiere conocer sus inscriptos: ");
                    System.out.println("------------------------------------------------------------------------------------------------------------");
                    System.out.println("1 - Circuito chico: 2 km por selva y arroyos.");
                    System.out.println("2 - Circuito medio: 5 km por selva, arroyos y barro.");
                    System.out.println("3 - Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra");
                    categoria = teclado.nextInt();
                    teclado.nextLine();
                } while (categoria < 1 && categoria > 3);

                System.out.println("\n------------------------------------------------------------------------------------------------------------");
                System.out.println("DNI\tNRO.INCRIPCION\tNOMBRE\tAPELLIDO\tEDAD\tCELULAR\tNRO.EMERGENCIA\tCELULAR\tGRUPO SANGUINEO");
                System.out.println("------------------------------------------------------------------------------------------------------------");
                for ( Map<Integer, ArrayList<String>> participante : circuitos.get(categoria-1) ) {
                    for ( Map.Entry infoParticipante : participante.entrySet()){
                        System.out.print(infoParticipante.getKey() + "\t");
                        System.out.println(infoParticipante.getValue());
                    }
                }
                System.out.println("\nPresione una tecla para continuar...");
                teclado.nextLine();
            // Si elige desinscribir participante
            } else if (opcion == 3){
                System.out.println("\nIngrese el DNI del participante a desinscribir: ");
                dni = teclado.nextInt();
                teclado.nextLine();
                encontroParticipante = false;
                for (int i = 0; i < circuitos.size(); i++){
                    for (int j = 0; j < circuitos.get(i).size(); j ++){
                        if(circuitos.get(i).get(j).get(dni) != null){
                            encontroParticipante = true;
                            circuitos.get(i).get(j).remove(dni);
                            System.out.println("\nDesinscripción realizada del participante con DNI " + dni);
                            break;
                        }
                    }
                    if (encontroParticipante) break;
                }
                if (!encontroParticipante) System.out.println("\nEl participante con DNI " + dni + " no se encuentra registrado en ninguna categoría.");
                System.out.println("\nPresione una tecla para continuar...");
                teclado.nextLine();
            // Si elige salir de la aplicación
            } else if (opcion == 0){
                System.out.println("\nPresione una tecla para salir...");
                teclado.nextLine();
            // Si elige un opción incorrecta
            } else {
                System.out.println("\nOpción incorrecta...");
            }
        } while(opcion != 0); // Si ejecuta el menú de opciones hasta que el usuario seleccione salir
        teclado.close();
    }
}
