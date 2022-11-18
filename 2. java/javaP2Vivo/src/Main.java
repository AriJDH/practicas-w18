import java.util.*;
import java.util.stream.Collectors;

import static java.lang.Integer.*;

public class Main {
    public static void main(String[] args) {
        System.out.println("---------------------------------------------------------------");
        System.out.println("BIENVENIDOS AL PORTAL DE LA CARRERA DE LA SELVA");
        System.out.println("---------------------------------------------------------------");
        System.out.println("Por favor ingrese el número de la opción deseada " +
                "\n1 - Inscribir un participante\n2 - Listar los participantes" +
                "\n3 - Desinscribir un participante\n4 - Determinar el monto de la inscripción");

        // Inscripción manual de participantes
        List<Map<String,String>> participantes = new ArrayList<>();
        Map<String,String> participante1 = new HashMap<>();
        participante1.put("Categoría","Circuito chico");
        participante1.put("Nombre completo","Mirtha Legrand");
        participante1.put("Edad","95");
        participante1.put("Celular","155106797");
        participante1.put("Grupo sanguíneo","A+");
        participantes.add(participante1);

        Map<String,String> participante2 = new HashMap<>();
        participante2.put("Categoría","Circuito medio");
        participante2.put("Nombre completo","Mauricio Macri");
        participante2.put("Edad","61");
        participante2.put("Celular","154777859");
        participante2.put("Grupo sanguíneo","0+");
        participantes.add(participante2);

        Map<String,String> participante3 = new HashMap<>();
        participante3.put("Categoría","Circuito medio");
        participante3.put("Nombre completo","Homero Simpson");
        participante3.put("Edad","45");
        participante3.put("Celular","156888797");
        participante3.put("Grupo sanguíneo","0-");
        participantes.add(participante3);

        Map<String,String> participante4 = new HashMap<>();
        participante4.put("Categoría","Circuito avanzado");
        participante4.put("Nombre completo","El Chavo");
        participante4.put("Edad","8");
        participante4.put("Celular","153777966");
        participante4.put("Grupo sanguíneo","AB+");
        participantes.add(participante4);

        Integer contador = 0;
        for(Map<String, String> elemento: participantes){
            contador++;
            elemento.put("Número de inscripción",contador.toString());
        }

        // Inscripción por teclado de un participante
        Scanner teclado = new Scanner(System.in);
        int ingresoUsuario = teclado.nextInt();
        switch (ingresoUsuario){
            case 1:
                Scanner scanner = new Scanner(System.in);System.out.println("Inscripción a la Carrera de la Selva");
                System.out.println("---------------------------------------------------------------");
                Map<String,String> participante = new HashMap<>();
                System.out.println("Ingrese la categoría");
                String ingresoCategoria = scanner.nextLine();
                participante.put("Categoría",ingresoCategoria);
                System.out.println("Ingrese nombre completo");
                String ingresoNombre = scanner.nextLine();
                participante.put("Nombre completo",ingresoNombre);
                System.out.println("Ingrese la edad");
                Integer ingresoEdad = scanner.nextInt();
                participante.put("Edad",ingresoEdad.toString());
                System.out.println("Ingrese su celular (solo números)");
                Integer ingresoCelular = scanner.nextInt();
                participante.put("Celular",ingresoCelular.toString());
                System.out.println("Ingrese su grupo sanguíneo");
                String ingresoGrupoSanguineo = scanner.next();
                participante.put("Grupo sanguíneo",ingresoGrupoSanguineo);
                System.out.println("Se inscribió a "+participante.get("Nombre completo")+". Edad: "+participante.get("Edad")+" años." +
                        "\nCelular de contacto: "+participante.get("Celular")+"." +
                        "\nGrupo Sanguíneo: "+participante.get("Grupo sanguíneo"));
                participantes.add(participante);
                contador = participantes.size();
                participante.put("Número de inscripción",contador.toString());
                System.out.println("El número de inscripción del partipante es: "+contador);
                System.out.println("---------------------------------------------------------------");
                scanner.close();
                break;
            case 2:
                System.out.println("Listado de los participantes a la Carrera de la Selva");
                System.out.println("---------------------------------------------------------------");
                System.out.println("Ingrese opción correspondiente a la categoría deseada\n" +
                        "1 - Circuito chico\n2 - Circuito medio\n3 - Circuito avanzado");
                System.out.println("---------------------------------------------------------------");
                Scanner scanner1 = new Scanner(System.in);
                int categoría = scanner1.nextInt();
                switch(categoría){
                    case 1:
                        System.out.println("Los participantes inscriptos en la categoría son: ");
                        participantes.stream().filter(el -> el.containsValue("Circuito chico")).map(el->el.get("Nombre completo")).forEach(System.out::println);
                        break;
                    case 2:
                        System.out.println("Los participantes inscriptos en la categoría son: ");
                        participantes.stream().filter(el -> el.containsValue("Circuito medio")).map(el->el.get("Nombre completo")).forEach(System.out::println);
                        break;
                    case 3:
                        System.out.println("Los participantes inscriptos en la categoría son: ");
                        participantes.stream().filter(el -> el.containsValue("Circuito avanzado")).map(el->el.get("Nombre completo")).forEach(System.out::println);
                        break;
                    default:
                        System.out.println("La opción ingresada es inválida");
                        scanner1.close();
                }
                System.out.println("---------------------------------------------------------------");
                break;
            case 3:
                System.out.println("Eliminación de la inscripción a la Carrera de la Selva");
                System.out.println("Ingrese el número de participante");
                Scanner scanner2 = new Scanner(System.in);
                Integer opcionUsuario = scanner2.nextInt();
                participantes.get(opcionUsuario-1);
                System.out.println("Eliminó al participante "+ participantes.get(opcionUsuario-1));
                participantes.remove(opcionUsuario-1);
                System.out.println("---------------------------------------------------------------");
                scanner2.close();
                break;
            case 4:
                System.out.println("Determinación del costo de inscripción a la Carrera de la Selva");
                System.out.println("Ingrese opción correspondiente a la categoría deseada\n" +
                        "1 - Circuito chico\n2 - Circuito medio\n3 - Circuito avanzado");
                Scanner scanner3 = new Scanner(System.in);
                Integer opcion = scanner3.nextInt();
                System.out.println("Ingrese su edad");
                Integer edad = scanner3.nextInt();
                scanner3.close();
                if (opcion==1 && edad>18){
                    System.out.println("El costo de inscripción es de $1500");
                } else if (opcion == 1 && edad< 18 && edad >0) {
                    System.out.println("El costo de inscripción es de $1300");
                } else if (opcion == 2 && edad>18) {
                    System.out.println("El costo de inscripción es de $2300");
                } else if (opcion == 2 && edad <18 && edad >0) {
                    System.out.println("El costo de inscripción es de $2000");
                } else if (opcion==3 && edad>0) {
                    System.out.println("El costo de inscripción es de $2800");
                } else if (opcion<0 || opcion>3 || edad<=0) {
                    System.out.println("Los datos ingresados son incorrectos");
                }
                System.out.println("---------------------------------------------------------------");
                break;
            default:
                System.out.println("La opción ingresada es inválida");
                System.out.println("---------------------------------------------------------------");
        }
    }
}
