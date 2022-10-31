import java.util.*;

public class Main {

    public static void main(String[] args) {
        Scanner entrada = new Scanner(System.in);

        Map <Integer, List<String>> participantes = new HashMap<>();

        int inscripcion = 0;
        int continuarInscripcion = 0;
        int nroInscripcion = 0;
        String edad = "";
        int menuPrincipal = 0;

        while(menuPrincipal != 4){
            System.out.println("Introduzca la acción que desee realizar: ");
            System.out.println("1. Inscribir participante.");
            System.out.println("2. Desinscribir participante.");
            System.out.println("3. Mostrar participantes inscriptos.");
            System.out.println("4. Salir.");
            menuPrincipal = entrada.nextInt();
            switch (menuPrincipal) {
                case 1:{
                    while(continuarInscripcion != 2) {
                        System.out.println("Introduzca la opcion:");
                        System.out.println("1. Circuito chico.");
                        System.out.println("2. Circuito medio.");
                        System.out.println("3. Circuito avanzado.");
                        inscripcion = entrada.nextInt();
                        switch (inscripcion) {
                            case 1: {
                                List<String> listaParticipantes = new ArrayList<>();
                                nroInscripcion++;
                                System.out.println("Categoria chico");
                                System.out.println("Introduzca la edad del participante: ");
                                entrada.skip("\n");
                                edad = entrada.nextLine();
                                listaParticipantes.add(edad);
                                listaParticipantes.add("Circuito chico.");
                                participantes.put(nroInscripcion, listaParticipantes);

                                if(Integer.parseInt(edad)  >= 18){
                                    System.out.println("Para esta categoria el participante debera abonar: $" + 1500);
                                } else {
                                    System.out.println("Para esta categoria el participante debera abonar: $" + 1300);
                                }

                                break;
                            }

                            case 2: {
                                System.out.println("Categoria medio");
                                List<String> listaParticipantes = new ArrayList<>();
                                nroInscripcion++;
                                System.out.println("Introduzca la edad del participante: ");
                                entrada.skip("\n");
                                edad = entrada.nextLine();
                                listaParticipantes.add(edad);
                                listaParticipantes.add("Circuito medio.");
                                participantes.put(nroInscripcion, listaParticipantes);
                                if(Integer.parseInt(edad) >= 18){
                                    System.out.println("Para esta categoria el participante debera abonar: $" + 2300);
                                } else {
                                    System.out.println("Para esta categoria el participante debera abonar: $" + 2000);
                                }
                                break;
                            }

                            case 3: {
                                System.out.println("Categoria avanzado");
                                System.out.println("Introduzca la edad del participante: ");
                                entrada.skip("\n");
                                edad = entrada.nextLine();
                                if(Integer.parseInt(edad)  >= 18){
                                    List<String> listaParticipantes = new ArrayList<>();
                                    nroInscripcion++;
                                    listaParticipantes.add(edad);
                                    listaParticipantes.add("Circuito avanzado.");
                                    participantes.put(nroInscripcion, listaParticipantes);
                                    System.out.println("Para esta categoria el participante debera abonar: $" + 2800);
                                } else {
                                    System.out.println("No se permiten menores de 18 para esta categoria.");
                                }
                                break;
                            }
                            default: {
                                System.out.println("Opcion ingresada incorrecta.");
                                break;
                            }
                        }
                        System.out.println("¿Desea inscribir a otro participante?");
                        System.out.println("1. Si");
                        System.out.println("2. No");
                        continuarInscripcion = entrada.nextInt();
                    }
                    break;
                }

                case 2:{
                    System.out.println("Introduzca el numero de inscripcion del participante que desea eliminar:");
                    int eliminarParticipante = entrada.nextInt();
                    participantes.remove(eliminarParticipante);
                    System.out.println("El participante ha sido eliminado con exito!");
                    break;
                }

                case 3:{
                    System.out.println("Los participantes inscriptos son los siguientes: ");
                    for(Map.Entry<Integer, List<String>> elemento : participantes.entrySet()){
                        System.out.println("Numero de inscripción del participante: " + elemento.getKey());
                        System.out.println("Edad y categoria de inscripción: " + elemento.getValue());
                        System.out.println("");
                    }
                    break;
                }

                case 4:{
                    System.out.println("Hasta luego!.");
                    break;
                }

                default:{
                    System.out.println("La opción ingresada no es valida.");
                }
            }

        }

    }


}
