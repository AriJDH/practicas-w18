import java.util.*;

public class Main {

    public static void main(String[] args) {

        Map<Integer,Map<String,String>> circuitoChico = new HashMap<>();
        Map<Integer,Map<String,String>> circuitoMedio = new HashMap<>();
        Map<Integer,Map<String,String>> circuitoAvanzado = new HashMap<>();
        int contador = 1;
        int accion = 0;
        int circuito = 0;
        boolean bandera = true;
        boolean continuar = true;

        Scanner input = new Scanner(System.in);

        while (continuar == true){

            System.out.println("\nBienvenida/o a la carrera de la Selva");

            System.out.println("\nElija que acción desea realizar: ");
            System.out.println("\n1.Inscribir participante \n2.Eliminar participante \n3.Listar participantes \n4.Monto a abonar \n5.Salir");


            System.out.println("\nEligió la opción:");
            accion = input.nextInt();

            switch (accion){
                case 1:

                    bandera = true;

                    System.out.println("\nA continuación vamos a solicitarle algunos datos necesarios para poder inscribirse ");

                    Map<String, String> participante = new HashMap<>();

                    System.out.println("Ingrese DNI:");
                    participante.put("dni", input.next());
                    /*System.out.println("Ingrese nombre:");
                    participante.put("nombre", input.next());
                    System.out.println("Ingrese apellido:");
                    participante.put("apellido", input.next());*/
                    System.out.println("Ingrese edad:");
                    participante.put("edad", input.next());
                    /*System.out.println("Ingrese celular:");
                    participante.put("celular", input.next());
                    System.out.println("Ingrese número de emergencia:");
                    participante.put("numeroEmergencia", input.next());
                    System.out.println("Ingrese grupo sanguíneo:");
                    participante.put("grupoSanguineo", input.next());*/


                    
                    while(bandera == true){

                        System.out.println("\nIngrese el circuito en el que se desea inscribir ");
                        System.out.println("\n1.Circuito Chico \n2.Circuito Medio \n3.Circuito Avanzado");
                        System.out.println("\nEligió el:");
                        circuito = input.nextInt();

                        if(Integer.valueOf(participante.get("edad")) < 18){
                            switch (circuito){
                                case 1:
                                    System.out.println("\nSu número de participante es: " + contador);
                                    System.out.println("Felicitaciones, ya está inscripta/o. El valor de la inscripción es $1300");
                                    participante.put("valor", "$1300");
                                    circuitoChico.put(contador,participante);
                                    bandera = false;
                                    break;
                                case 2:
                                    System.out.println("\nSu número de participante es: " + contador);
                                    System.out.println("Felicitaciones, ya está inscripta/o. El valor de la inscripción es $2000");
                                    participante.put("valor", "$2000");
                                    circuitoMedio.put(contador,participante);
                                    bandera = false;
                                    break;
                                case 3:
                                    System.out.println("No puede inscribirse a este circuito siendo menor de edad");
                                    break;
                                default:
                                    System.out.println("Ingrese una opción correcta");
                                    break;
                            }
                        }else{
                            switch (circuito){
                                case 1:
                                    System.out.println("\nSu número de participante es: " + contador);
                                    System.out.println("Felicitaciones, ya está inscripta/o. El valor de la inscripción es $1500");
                                    participante.put("valor", "$1500");
                                    circuitoChico.put(contador,participante);
                                    bandera = false;
                                    break;
                                case 2:
                                    System.out.println("\nSu número de participante es: " + contador);
                                    System.out.println("Felicitaciones, ya está inscripta/o. El valor de la inscripción es $2300");
                                    participante.put("valor", "$2300");
                                    circuitoMedio.put(contador,participante);
                                    bandera = false;
                                    break;
                                case 3:
                                    System.out.println("\nSu número de participante es: " + contador);
                                    System.out.println("Felicitaciones, ya está inscripta/o. El valor de la inscripción es $2800");
                                    participante.put("valor", "$2800");
                                    circuitoAvanzado.put(contador,participante);
                                    bandera = false;
                                    break;
                                default:
                                    System.out.println("Ingrese una opción correcta");
                                    break;
                            }
                        }
                    }

                    System.out.println("\nDesea continuar? ");
                    System.out.println("\n1.Si \n2.No");
                    System.out.println("\nEligió el:");
                    continuar = input.nextInt() == 1 ? true : false;

                    contador += 1;

                    break;
                case 2:

                    System.out.println("\nIngrese el circuito en el que se desea eliminar el participante ");
                    System.out.println("\n1.Circuito Chico \n2.Circuito Medio \n3.Circuito Avanzado");
                    System.out.println("\nEligió la opción:");
                    circuito = input.nextInt();

                    System.out.println("\nIngrese el número de participante ");
                    int numeroParticipante = input.nextInt();

                    if(circuito == 1){

                        circuitoChico.remove(numeroParticipante);
                        System.out.println("El participante número "+numeroParticipante+ " ha sido eliminado");

                    }else if(circuito == 2){

                        circuitoMedio.remove(numeroParticipante);
                        System.out.println("El participante número "+numeroParticipante+ " ha sido eliminado");

                    }else if(circuito == 3){

                        circuitoAvanzado.remove(numeroParticipante);
                        System.out.println("El participante número "+numeroParticipante+ " ha sido eliminado");

                    }else{
                        System.out.println("No ingresó una opción válida");
                    }

                    System.out.println("\nDesea continuar? ");
                    System.out.println("\n1.Si \n2.No");
                    System.out.println("\nEligió el:");
                    continuar = input.nextInt() == 1 ? true : false;

                    break;

                case 3:

                    System.out.println("\nIngrese el circuito del cual desea ver los participantes ");
                    System.out.println("\n1.Circuito Chico \n2.Circuito Medio \n3.Circuito Avanzado");
                    System.out.println("\nEligió la opción:");
                    circuito = input.nextInt();


                    if(circuito == 1){

                        for (var entry : circuitoChico.entrySet()) {
                            System.out.println("Inscripto número " + entry.getKey() + ": " + entry.getValue());
                        }

                    }else if(circuito == 2){

                        for (var entry : circuitoMedio.entrySet()) {
                            System.out.println("Inscripto número " + entry.getKey() + ": " + entry.getValue());
                        }

                    }else if(circuito == 3){
                        for (var entry : circuitoAvanzado.entrySet()) {
                            System.out.println("Inscripto número " + entry.getKey() + ": " + entry.getValue());
                        }

                    }else{
                        System.out.println("No ingresó una opción válida");
                    }

                    System.out.println("\nDesea continuar? ");
                    System.out.println("\n1.Si \n2.No");
                    System.out.println("\nEligió el:");
                    continuar = input.nextInt() == 1 ? true : false;

                    break;

                case 4:

                    System.out.println("\nIngrese el circuito donde se encuentra el participante ");
                    System.out.println("\n1.Circuito Chico \n2.Circuito Medio \n3.Circuito Avanzado");
                    System.out.println("\nEligió la opción:");
                    circuito = input.nextInt();

                    System.out.println("\nIngrese el número de participante ");
                    numeroParticipante = input.nextInt();

                    if(circuito == 1){

                        System.out.println("El montó abonado por el participante fue :" + circuitoChico.get(numeroParticipante).get("valor"));

                    }else if(circuito == 2){

                        System.out.println("El montó abonado por el participante fue :" + circuitoMedio.get(numeroParticipante).get("valor"));

                    }else if(circuito == 3){

                        System.out.println("El montó abonado por el participante fue :" + circuitoAvanzado.get(numeroParticipante).get("valor"));

                    }else{
                        System.out.println("No ingresó una opción válida");
                    }

                    System.out.println("\nDesea continuar? ");
                    System.out.println("\n1.Si \n2.No");
                    System.out.println("\nEligió el:");
                    continuar = input.nextInt() == 1 ? true : false;

                    break;
                case 5:
                    continuar = false;
                    break;
                default:
                    System.out.println("No ingresó una opción válida");
                    break;
            }


        }

        System.out.println("\nQue tenga un buen día!");
    }

}


