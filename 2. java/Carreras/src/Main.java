import java.util.*;

public class Main {
    public static void main(String[] args) {
        List <Integer> inscriptosChico = new ArrayList<Integer>();
        List <Integer> inscriptosMedio = new ArrayList<Integer>();
        List<Integer> inscriptosAvanzado = new ArrayList<Integer>();

        Map<Integer,String> participantes = new HashMap<>();

/*        participantes.put(0,"23456789-Juan Perez-24-112345678-112347863-A+");
        participantes.put(1,"23456789-Pedro Diaz-22-112345348-114343463-0+");
        participantes.put(2,"23456789-JuanA Lopez-26-112345656-112342363-H+");
*/
        Scanner entrada = new Scanner(System.in);
        int opcion;
        do{
            do{
                System.out.println("\t\t\t------Menu de Inscripciones------");
                System.out.println("\tOpciòn  1: Inscribir nuevo participante");
                System.out.println("\tOpciòn  2: Mostrar todos los participantes");
                System.out.println("\tOpciòn  3: Desinscribir un participante");
                System.out.println("\tOpciòn  4: Determinar monto a cobrar");
                System.out.println("\tOpciòn 99: Salir");
                opcion = entrada.nextInt();
                if(opcion<0 || opcion>5 && opcion!=99)
                    System.out.println("*Ingresò una opciòn incorrecta*");
            }while(opcion<0 || opcion>5 && opcion!=99);

            switch (opcion){
                case 1:{
                    System.out.println("Ingrese los datos del participante");
                    entrada.nextLine();
                    String datos = entrada.nextLine();
                    //participantes.put(participantes.size(),datos);
                    System.out.println("\t\t Elija la Categoria");
                    System.out.println("1- Circuito Chico");
                    System.out.println("2- Circuito Medio");
                    System.out.println("3- Circuito Avanzado");
                    int categoria  = entrada.nextInt();
                    inscribir(participantes, datos, categoria, inscriptosChico, inscriptosMedio, inscriptosAvanzado);
                    break;
                }
                case 2:{
                    mostrar(participantes);
                    break;
                }
                case 3:{
                    System.out.println("Ingrese el numero de participante que quiere desinscribir: ");
                    Integer participante = entrada.nextInt();
                    System.out.println("Elija la categoria a la que estaba inscripto");
                    System.out.println("1- Circuito Chico");
                    System.out.println("2- Circuito Medio");
                    System.out.println("3- Circuito Avanzado");
                    int categoria = entrada.nextInt();

                    desinscribir(participantes,participante,categoria,inscriptosChico, inscriptosMedio, inscriptosAvanzado);
                    break;
                }
                case 4:{
                    System.out.println("Ingrese el numero de participante");
                    Integer participante = entrada.nextInt();
                    System.out.println("Elija la categoria");
                    System.out.println("1- Circuito Chico");
                    System.out.println("2- Circuito Medio");
                    System.out.println("3- Circuito Avanzado");
                    int categoria = entrada.nextInt();
                    montoACobrar(participantes,participante,categoria,inscriptosChico, inscriptosMedio, inscriptosAvanzado);
                    break;
                }
                case 99:{
                    System.out.println("Salio del programa");
                    break;
                }
            }

        }while(opcion != 99 && opcion>0 && opcion<5);
        entrada.close();

    }

    public static void inscribir(Map<Integer, String> participantes,String datos, int categoria, List<Integer> inscriptosChico,List<Integer> inscriptosMedio,List<Integer> inscriptosAvanzado ){

        participantes.put(participantes.size(),datos);

        switch (categoria){
            case 1:{
                inscriptosChico.add(participantes.size()-1);
                break;
            }
            case 2:{
                inscriptosMedio.add(participantes.size()-1);
                break;
            }
            case 3:{
                inscriptosAvanzado.add(participantes.size()-1);
                break;
            }
        }

    }

    public static void mostrar(Map<Integer, String> participantes){

        if(!participantes.isEmpty()){
            System.out.println("Los participantes inscriptos son: ");
            System.out.println(participantes);
            System.out.println("\n");
        }
        else
            System.out.println("No hay inscriptos por el momento\n");

    }

    public static void desinscribir(Map<Integer, String> participantes, Integer participante, int categoria, List<Integer> inscriptosChico,List<Integer> inscriptosMedio,List<Integer> inscriptosAvanzado ){
        participantes.remove(participante);
        switch (categoria){
            case 1:{
                for(int i= 0; i<inscriptosChico.size(); i++){
                    if(inscriptosChico.get(i) == participante)
                        inscriptosChico.set(i,-1);
                }
                break;
            }
            case 2:{
                for(int i= 0; i<inscriptosMedio.size(); i++){
                    if(inscriptosMedio.get(i) == participante)
                        inscriptosMedio.set(i,-1);
                }
                break;
            }
            case 3:{
                for(int i= 0; i<inscriptosAvanzado.size(); i++){
                    if(inscriptosAvanzado.get(i) == participante)
                        inscriptosAvanzado.set(i,-1);
                }
                break;
            }
        }
    }

    public static void montoACobrar(Map<Integer, String> participantes,Integer participante, int categoria, List<Integer> inscriptosChico,List<Integer> inscriptosMedio,List<Integer> inscriptosAvanzado ){


        double precio = 0;
        String[] textoSeparado =  participantes.get(participante).split("-");
        switch (categoria){
            case 1:{

                if(Integer.parseInt(textoSeparado[3]) < 18 )
                    precio = 1300;
                else
                    precio = 1500;
                break;
            }
            case 2:{

                if(Integer.parseInt(textoSeparado[3]) < 18 )
                    precio = 2000;
                else
                    precio = 2300;
                break;
            }
            case 3:{

                if(Integer.parseInt(textoSeparado[3])< 18 )
                    System.out.println("No esta permitida la incripcion de menores de 18 años a este circuito\n");
                else
                    precio = 2800;
                break;
            }
        }

        System.out.println("El precio a abonar es: $" +precio);
        System.out.println("\n");
    }
}