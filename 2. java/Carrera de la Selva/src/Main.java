import java.util.*;

public class Main {
    public static Scanner input = new Scanner(System.in);
    public static void main(String[] args) {
        String dni = null;
        char cir = 0;

        Map<Integer, String[]> participantes = new HashMap<>();


        List<String> circuitoChico = new ArrayList<>();
        List<String> circuitoMedio = new ArrayList<>();
        List<String> circuitoAvanzado = new ArrayList<>();

        int numId = 0;

        System.out.println("Buenas tardes, por favor ingrese DNI, o F para salir");
                System.out.print("DNI : ");
                dni = input.nextLine();
                while(!dni.toUpperCase().equals("F")){
                    numId++;
                    participantes.put(numId, solicitarDatos(input, dni));

                    System.out.println("Elija circuito, C (chico), M (mediano), A(Avanzado)");
                    cir = input.nextLine().charAt(0);
                    System.out.println("Gracias por participar");
                    System.out.println("Buenas tardes, por favor ingrese DNI, o F para salir");
                    System.out.print("DNI : ");
                    dni = input.nextLine();
                }


        for (Map.Entry<Integer, String[]> entrada : participantes.entrySet()) {
            Integer clave = entrada.getKey();
            String valor = null;
            System.out.println("La clave es:"  + clave + " El valor es: ");
            mostrarDatos(entrada.getValue());
        }



        input.close();





    }

    public static String[] solicitarDatos(Scanner input, String dni){

        System.out.print("NOMBRE : ");
        String nombre = input.nextLine();
        System.out.print("APELLIDO : ");
        String apellido = input.nextLine();
        System.out.print("EDAD : ");
        String edad = input.nextLine();
        System.out.print("CELULAR : ");
        String celular = input.nextLine();
        System.out.print("NUMERO DE EMERGENCIA : ");
        String numeroEm = input.nextLine();
        System.out.print("GRUPO SANGUINEO : ");
        String grupoSan = input.nextLine();

        String datos[] = {
                nombre, apellido, edad, celular, numeroEm, grupoSan
        };

        return datos;
    }

    public static void mostrarDatos(String[] datos){
        int i = 0;
        while(i < datos.length){
            System.out.print("DNI: " + datos[i]);
            System.out.print(" NOMBRE: " + datos[i++]);
            System.out.print(" APELLIDO: " + datos[i++]);
            System.out.print(" EDAD: " + datos[i++]);
            System.out.print(" CELULAR: " + datos[i++]);
            System.out.print(" NUMERO EMERGENCIA: " + datos[i++]);
            System.out.print(" GRUPO SANGUINEO: " + datos[i++]);

        }
    }

}