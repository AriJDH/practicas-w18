import java.sql.SQLOutput;
import java.util.*;

public class Main {
    Map<String,String> persona;
    Scanner ingreso = new Scanner(System.in);
    //Lista para guardar las personas
    List<Map<String, String>> listaPersonas = new ArrayList<Map<String,String>>();
    List<String> circuitoChico = new ArrayList<String>();
    List<String> circuitoMedio = new ArrayList<String>();
    List<String> circuitoAvanzado = new ArrayList<String>();

    //Proceso para guardar personas
    public void altaPersona(){
        ingreso.nextLine();
        persona = new HashMap<>();
        //Carga de datos
        System.out.println("Ingrese el nombre de la persona: ");
        persona.put("Nombre", ingreso.nextLine());
        System.out.println("Ingrese el apellido de la persona: ");
        persona.put("Apellido", ingreso.nextLine());
        System.out.println("Ingrese el DNI de la persona: ");
        persona.put("DNI", ingreso.nextLine());
        System.out.println("Ingrese la edad de la persona: ");
        persona.put("Edad", ingreso.nextLine());
        System.out.println("Ingrese el celular de la persona: ");
        persona.put("Celular", ingreso.nextLine());
        System.out.println("Ingrese el numero de emergencia de la persona: ");
        persona.put("Nro Emergencia", ingreso.nextLine());
        System.out.println("Ingrese el grupo sanguineo de la persona: ");
        persona.put("Grupo Sanguineo", ingreso.nextLine());

        listaPersonas.add(persona);
        System.out.println("Se cargaron los siguientes datos de la persona: " + persona.toString());
    }

    //Inscripcion de personas a la carrera
    public void inscribirPersonaCircuitoChico(String documento){
        circuitoChico.add(documento);
    }

    public void inscribirPersonaCircuitoMedio(String documento){
        circuitoMedio.add(documento);
    }

    public void inscribirPersonaCircuitoAvanzado(String documento){
        circuitoAvanzado.add(documento);
    }

    //Buscador del ID de la persona por el numero del documento
    public int getIDPersona(String documento){
        int resultado = -1;
        for(Map<String,String> personaBuscada:listaPersonas){
            if(personaBuscada.containsValue(documento)){
                resultado= listaPersonas.indexOf(personaBuscada);
            }
        }
        return resultado;
    }

    //Buscador de persona por el numero del documento
    public Map<String,String> getPersona(String documento){
        Map<String,String> retorno = null;
        for(Map<String,String> personaBuscada:listaPersonas) {
            if (personaBuscada.containsValue(documento)) {
                retorno = listaPersonas.get(getIDPersona(documento));
            }
        }
        return retorno;
    }

    //Eliminar una persona de una carrera
    public void desinscribirPersona(int carrera, String documento){
        switch (carrera){
            case 1:
                circuitoChico.remove(getIDPersona(documento));
                break;
            case 2:
                circuitoMedio.remove(getIDPersona(documento));
                break;
            case 3:
                circuitoAvanzado.remove(getIDPersona(documento));
                break;
            default:
                System.out.println("Carrera no encontrada");
        }
    }

    public int determinarCosto(int carrera, String documento){
        int precio;
        switch (carrera){
            case 1:
                precio = Integer.parseInt(getPersona(documento).get("Edad")) < 18 && Integer.parseInt(getPersona(documento).get("Edad")) != 0 ? 1300 : 1500;
                break;
            case 2:
                precio = Integer.parseInt(getPersona(documento).get("Edad")) < 18 ? 2000 : 2300;
                break;
            case 3:
                precio = 2800;
                break;
            default:
                System.out.println("Carrera no encontrada");
                precio = -1;
        }
        return precio;
    }

    //Mostrar todos los participantes de una carrera
    public void listarInscriptos(int carrera){
        switch (carrera){
            case 1:
                for (String persona:circuitoChico) System.out.println(getPersona(persona.toString()));
                break;
            case 2:
                for (String persona:circuitoMedio) System.out.println(getPersona(persona.toString()));
                break;
            case 3:
                for (String persona:circuitoAvanzado) System.out.println(getPersona(persona.toString()));
                break;
            default:
                System.out.println("Carrera no encontrada");
        }
    }

    public static void main(String[] args) {
        Main carreraSelva = new Main();
        int i = -1;
        while(i != 0){
            System.out.println("Ingrese la tarea que desea realizar");
            System.out.println("1-Inscribir una nueva persona");
            System.out.println("2-Listar inscriptos");
            System.out.println("3-Desenscribir a una persona");
            System.out.println("4-Consultar monto de inscripcion");
            System.out.println("0-Salir del programa");
            i = carreraSelva.ingreso.nextInt();
            int carrera = -1;
            String documento;

            switch (i) {
                case 1: //Alta de persona
                    carreraSelva.altaPersona();
                    System.out.println("Ingrese la carrera que desea consultar (1: CHICA - 2: MEDIANA - 3:AVANZADA");
                    carrera = carreraSelva.ingreso.nextInt();
                    carreraSelva.ingreso.nextLine();
                    if (carrera == 1) {
                        carreraSelva.inscribirPersonaCircuitoChico(carreraSelva.persona.get("DNI"));
                    }
                    if (carrera == 2) {
                        carreraSelva.inscribirPersonaCircuitoMedio(carreraSelva.persona.get("DNI"));
                    }
                    if (carrera == 3){
                    carreraSelva.inscribirPersonaCircuitoAvanzado(carreraSelva.persona.get("DNI"));
                    }
                    break;
                case 2: //Listar personas de una carrera
                    System.out.println("Ingrese la carrera que desea consultar (1: CHICA - 2: MEDIANA - 3:AVANZADA)");
                    carrera = carreraSelva.ingreso.nextInt();
                    carreraSelva.ingreso.nextLine();
                    carreraSelva.listarInscriptos(carrera);
                    break;
                case 3: //Eliminar a una persona de una carrera
                    System.out.println("Ingrese la carrera que desea consultar (1: CHICA - 2: MEDIANA - 3:AVANZADA)");
                    carrera = carreraSelva.ingreso.nextInt();
                    carreraSelva.ingreso.nextLine();
                    System.out.println("Ingrese el numero de documento de la persona: ");
                    documento = carreraSelva.ingreso.nextLine();
                    carreraSelva.ingreso.nextLine();
                    carreraSelva.desinscribirPersona(carrera,documento );
                    break;
                case 4: //Consultar monto de inscripcion
                    System.out.println("Ingrese la carrera que desea consultar (1: CHICA - 2: MEDIANA - 3:AVANZADA)");
                    carreraSelva.ingreso.nextLine(); //limpia el buffer
                    carrera = carreraSelva.ingreso.nextInt();
                    carreraSelva.ingreso.nextLine();
                    System.out.println("Ingrese el numero de documento de la persona: ");
                    documento = carreraSelva.ingreso.nextLine();
                    System.out.println("El monto de la inscripcion es: " + carreraSelva.determinarCosto(carrera, documento));
                    break;
                case 5: //FIN DEL PROGRAMA
                    i = 0;
                default:
                    System.out.println("Ingrese un valor valido");
            }

        }

    }
}