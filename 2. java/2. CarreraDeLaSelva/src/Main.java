import java.util.*;

public class Main {

    static List<Map<String, String>> listOfParticipants = new ArrayList<>();

    public static void main(String[] args) {
        login();
    }

    public static void login() {
        Scanner input = new Scanner(System.in);
        int option = 0;
        int id = 0;
        while (true) {
            System.out.println(
                    "****** MENU: Seleccione una opción: \n " +
                            "1- Incribir Participante \n " +
                            "2- Eliminar Participante \n " +
                            "3- Ver Participantes \n " +
                            "4- Monto a pagar \n " +
                            "5- Salir");

            option = Integer.parseInt(input.nextLine());

            switch (option) {
                case 1:
                    System.out.println("Ingresá el nº de DNI: ");
                    Integer dni = Integer.parseInt(input.nextLine());
                    if (!isRegistered(dni)) {
                        id++;
                        Map<String, String> auxComp = registrateACompetitor(dni, id);
                        listOfParticipants.add(auxComp);
                        String value = calculateAmount(Integer.parseInt(auxComp.get("Edad")), Integer.parseInt(auxComp.get("Circuito")));
                        System.out.println("Se inscribio al circuito " + auxComp.get("Circuito") + ". El total " +
                                "a pagar es " + value + "\n");
                    } else {
                        System.out.println("Ya se encuentra registrado");
                    }
                    break;
                case 2:
                    System.out.println("Ingresá el ID del participante: ");
                    Integer auxId = Integer.parseInt(input.nextLine());
                    deleteCompetitor(auxId);
                    break;

                case 3:
                    System.out.println("Ingresa la categoria: \n 1- Cicruito chico\n"
                            + "2- Circuito Medio \n 3- Circuito Avanzado");
                    Integer auxId2 = Integer.parseInt(input.nextLine());
                    listParticipnts(auxId2);
                    break;

                case 4:
                    System.out.println("Ingrese Edad y nª circuito del competidor\n" +
                            "Edad: ");
                    Integer auxAge = Integer.parseInt(input.nextLine());
                    System.out.println("circuito: ");
                    Integer auxCircuit = Integer.parseInt(input.nextLine());
                    System.out.println("El monto es: " +
                            calculateAmount(auxAge, auxCircuit));
                    break;
                case 5:
                    System.exit(5);
            }
        }
    }

    public static boolean isRegistered(Integer dni) {
        boolean register = false;
        for(Map<String,String> person:listOfParticipants){
            if(Integer.parseInt(person.get("DNI")) == dni) {
                register = true;
            } else register = false;
        } return register;
    }

    public static Map<String, String> registrateACompetitor(int dni, Integer id) {
        Map<String,String> competitor = new HashMap<>();
        Scanner input = new Scanner(System.in);
        System.out.println("Ingrese los siguientes datos: ");
        System.out.println("Nombre: ");
        String name = input.nextLine();
        System.out.println("Apellido: ");
        String lastname = input.nextLine();
        System.out.println("Edad: ");
        String age = input.nextLine();
        System.out.println("Celular: ");
        String celular = input.nextLine();
        System.out.println("Número de emergencia: ");
        String emergencyNumber = input.nextLine();
        System.out.println("Grupo Sanguíneo: ");
        String bloodType = input.nextLine();
        String circuit = selectRace(Integer.parseInt(age)).toString();
        competitor.put("ID", id.toString());
        competitor.put("DNI", String.valueOf(dni));
        competitor.put("Nombre", name);
        competitor.put("Apellido", lastname);
        competitor.put("Edad", age);
        competitor.put("Circuito", circuit);
        competitor.put("Celular", celular);
        competitor.put("Numero de Emergencia", emergencyNumber);
        competitor.put("Grupo Sanguineo", bloodType);
        return competitor;
    }

    private static Integer selectRace(Integer age) {
        Scanner input = new Scanner(System.in);
        int option = 1;
        Integer circuit = 0;


        System.out.println(
                "Seleccione la Carrera:  \n " +
                        "1 - Circuito chico: 2 km por selva y arroyos.\n " +
                        "2 - Circuito medio: 5 km por selva, arroyos y barro.\n " +
                        "3 - Circuito Avanzado: 10 km por selva, arroyos, barro y escalada en piedra.\n");

        while (option == 1 || option == 2 || option == 3){
            option = Integer.parseInt(input.nextLine());
            switch(option){
                case 1:
                    circuit = 1;
                    option = 0;
                    break;
                case 2:
                    circuit = 2;
                    option = 0;
                    break;
                case 3: if(age >= 18){
                    circuit = 3;
                    option = 0;
                } else {
                    System.out.println("Es menor de edad, no esta permitido \n" +
                            "Elija otro circuito"); }
                    break;
            }
        }
        return circuit;
    }

    public static String calculateAmount(int age, int circuit) {
        String value = "";
        if (age < 18 && circuit == 1) {
            value = "$ 1.300";
        } else if (age > 18 && circuit == 1) {
            value = "$ 1.500";
        } else if (age < 18 && circuit == 2) {
            value = "$ 2.000";
        } else if (age > 18 && circuit == 2) {
            value = "$ 2.300";
        } else if (age > 18 && circuit == 3) {
            value = "$ 2.800";
        } else if (age < 18 && circuit == 3) {
            value = "No se admitió su inscripción";
        }
        return value;
    }

    private static void deleteCompetitor(Integer auxId) {
        int messaje = 1;
        for(Map<String, String> person:listOfParticipants) {
            if (Integer.parseInt(person.get("ID")) == auxId) {
                listOfParticipants.remove(person);
                System.out.println("competidor eliminado");
                messaje = 0;

            }
        }
        if(messaje == 1){
            {System.out.println("competidor no encontrado");}
        }
    }

    public static void listParticipnts(int auxId){
        for(Map<String, String> person:listOfParticipants) {
            for(Map.Entry<String,String> data: person.entrySet()){
                String clave = data.getKey();
                String val = data.getValue();
                System.out.println(clave + ": " + val + "\n");
            }
            System.out.println("---------------");
        }

    }


}
