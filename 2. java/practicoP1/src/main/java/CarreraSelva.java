import java.util.*;

public class CarreraSelva {
    public static void main(String[] args) {
        CarreraSelva prueba = new CarreraSelva();
        prueba.inscribirParticipante();
    }

    public void inscribirParticipante() {
        List<String> listaParticipantes = new ArrayList<String>();


        Scanner entrada = new Scanner(System.in);
        System.out.println("Ingrese el DNI del participante: ");
        String dni = entrada.nextLine();
        System.out.println("Ingrese nombre y apellido del participante: ");
        String nombre = entrada.nextLine();
        System.out.println("Ingrese la edad del participante:");
        String edad = entrada.nextLine();
        System.out.println("Ingrese el número de celular del participante:");
        String numCel = entrada.nextLine();
        System.out.println("Ingrese el contacto de emergencia del participante:");
        String numEmergencia = entrada.nextLine();
        System.out.println("Por último ingrese el grupo sanguíneo del participante: ");
        String gSangre = entrada.nextLine();
        listaParticipantes.add(dni);
        listaParticipantes.add(nombre);
        listaParticipantes.add(edad);
        listaParticipantes.add(numCel);
        listaParticipantes.add(numEmergencia);
        listaParticipantes.add(gSangre);


    }
}
