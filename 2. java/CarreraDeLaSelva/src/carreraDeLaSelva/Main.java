package carreraDeLaSelva;

import java.util.*;

public class Main {

    public static void main(String[] args) {
        String menu = "y";
        Scanner teclado = new Scanner(System.in);
        Scanner teclado2 = new Scanner(System.in);
        Scanner teclado3 = new Scanner(System.in);
        int opcion;
        int cont = 0;
        List<Map> circuitoChico = new ArrayList<>();
        List<Map> circuitoMedio = new ArrayList<>();
        List<Map> circuitoAvanzado = new ArrayList<>();
        Map<String, String> persona = new HashMap<>();

        while (menu == "y") {

            System.out.println("Bienvenido a la Carrera de la Selva, que gestión desea realizar?");
            System.out.println("1) Inscripción");
            System.out.println("2) Mostrar inscritos");
            System.out.println("3) Eliminar inscripción");

            opcion = teclado.nextInt();

            if (opcion == 1) {
                int precio = 0;
                cont++;
                persona.put("Número participante", Integer.toString(cont));
                System.out.println("DNI:");
                persona.put("DNI", teclado2.nextLine());
                System.out.println("Nombre:");
                persona.put("Nombre", teclado2.nextLine());
                System.out.println("Apellido:");
                persona.put("Apellido", teclado2.nextLine());
                System.out.println("Edad:");
                persona.put("Edad", teclado2.nextLine());
                System.out.println("Celular:");
                persona.put("Celular", teclado2.nextLine());
                System.out.println("Número de emergencia:");
                persona.put("Numero de emergencia", teclado2.nextLine());
                System.out.println("RH:");
                persona.put("RH", teclado2.nextLine());
                System.out.println("Circuito:");
                persona.put("Circuito", teclado2.nextLine());

                switch (persona.get("Circuito").toLowerCase()) {
                    case "chico":
                        circuitoChico.add(persona);
                        if (Integer.parseInt(persona.get("Edad")) < 18) {
                            precio = 1300;
                        } else {
                            precio = 1500;
                        }
                        break;
                    case "medio":
                        circuitoMedio.add(persona);
                        if (Integer.parseInt(persona.get("Edad")) < 18) {
                            precio = 2000;
                        } else {
                            precio = 2300;
                        }
                        break;
                    case "avanzado":
                        if (Integer.parseInt(persona.get("Edad")) < 18) {
                            System.out.println("Las personas menores de 18 años no se pueden inscribir a este circuito");
                        } else {
                            circuitoAvanzado.add(persona);
                            precio = 2800;
                        }
                        break;
                }

                System.out.println(circuitoChico);
                System.out.println(circuitoMedio);
                System.out.println(circuitoAvanzado);
                System.out.println("Se ha inscrito con éxito y el precio que debe pagar es de $" + precio);
                teclado2.close();
                System.out.println("Desea regresar al menú inicial? (y/n)");
                menu = teclado3.nextLine().toLowerCase();

                if (menu == "n") {
                    System.out.println("El programa ha finalizado");
                    break;
                }



            }

        }





    }

}
