import java.util.*;

public class Main {
    static Scanner keyboard = new Scanner(System.in);
    static int numParticipante = 1;
    static ArrayList<HashMap<String,String>> CircuitoChico = new ArrayList<>();
    static ArrayList<HashMap<String,String>> CircuitoMedio = new ArrayList<>();

    static ArrayList<HashMap<String,String>> CircuitoAvanzado = new ArrayList<>();


    //{"dni", "nombre", "apellido", "edad", "celular", "celular", "numEmergencia"}

    public static void inscribirParticipante(){
        HashMap<String,String> participanteInfo = new HashMap<>();
        ArrayList<String> caracteristicasParticipante = new ArrayList<String>();
        caracteristicasParticipante.add("dni");
        caracteristicasParticipante.add("nombre");
        caracteristicasParticipante.add("apellido");
        caracteristicasParticipante.add("edad");
        caracteristicasParticipante.add("celular");
        caracteristicasParticipante.add("numEmergencia");
        caracteristicasParticipante.add("GrupoSanguineo");
        participanteInfo.put("numParticipante",String.valueOf(numParticipante));
        numParticipante++;

        for (String caracteristica : caracteristicasParticipante) {
            System.out.println("Ingrese "+caracteristica+": " );
            String caracteristicaIngresada = keyboard.next();
            participanteInfo.put(caracteristica,caracteristicaIngresada);
        }
        System.out.println("¿A que circuito quiere inscribirse?: \n 1- Circuito Chico \n 2- Circuito Medio\n 3-Circuito Avanzado");
        int circuitoElegido = keyboard.nextInt();

        int valorAPagar = 0;

        switch (circuitoElegido){
            case 1:
                if (Integer.parseInt(participanteInfo.get("edad"))<18){
                    valorAPagar = 1300;
                }else{
                    valorAPagar = 1500;
                }
                CircuitoChico.add(participanteInfo);
                break;
            case 2:
                if (Integer.parseInt(participanteInfo.get("edad"))<18){
                    valorAPagar = 2000;
                }else{
                    valorAPagar = 2500;
                }
                CircuitoMedio.add(participanteInfo);
                break;
            case 3:
                if (Integer.parseInt(participanteInfo.get("edad"))<18){
                    System.out.println("EL participante no esta apto para este circuito");
                }else{
                    valorAPagar = 2800;
                    CircuitoAvanzado.add(participanteInfo);
                }
                break;
            default:
                System.out.println("Numero ingresado incorrectamente");
        }
        System.out.println("valor a pagar "+valorAPagar);
    }

    public static void listarParticipantes( ArrayList<HashMap<String,String>> listaParticipante){
        for (HashMap<String,String> participante: listaParticipante){
            for (Map.Entry<String,String> participanteItem : participante.entrySet()){
                System.out.println(participanteItem.getKey()+" - "+participanteItem.getValue());
            }
        }

    }

    public static void mostrarParticipantesPorcircuito(){
        System.out.println("Que lista de Circuito quiere ver: \n1-Circuito Chico\n2-Circuito Medio \n3-Circuito Avanzado");
        int opcion = keyboard.nextInt();

        switch (opcion){
            case 1:
                listarParticipantes(CircuitoChico);
                break;
            case 2:
                listarParticipantes(CircuitoMedio);
                break;
            case 3:
                listarParticipantes(CircuitoAvanzado);
                break;
            default:
                System.out.println("Ha elegido una opcion incorrecta");
        }
    }

    public static void borrarParticipante (){

        try{
            System.out.println("Ingrese el numero del participante");
            String numDeParticipanteABorrar = keyboard.next();
            CircuitoChico.removeIf(persona -> persona.get("ID").equals(numDeParticipanteABorrar));
            CircuitoMedio.removeIf(persona -> persona.get("ID").equals(numDeParticipanteABorrar));
            CircuitoAvanzado.removeIf(persona -> persona.get("ID").equals(numDeParticipanteABorrar));
        } catch(Exception e){
            System.out.println(e);
        }
    }

    
    
    public static void main(String[] args) {


        while (true){
            System.out.println("elige lo que quieres hacer\n1-Inscribirse\n2-Listar participante por circuito\n3-Borrar Participante");
            int accionAElegir = keyboard.nextInt();
            System.out.println(accionAElegir);
            switch (accionAElegir) {
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarParticipantesPorcircuito();
                    break;
                case 3:
                    borrarParticipante();
                    break;
                default:
                    System.out.println("escogiste mal idioto");
            }
        }


    }
}
