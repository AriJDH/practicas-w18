import Documentos.Curriculum;
import Documentos.Informe;
import Documentos.LibroPDF;
import Interfaz.Interfaz;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        int opcion=0, edad=0, cantidadPaginas;
        String apellido, nombre, dni,titulo, genero, autor, revisor, habilidades[] = {"Habilidad1","habilidad2","habilidad3"};
        String texto = "This is a sample text...";

        Scanner teclado = new Scanner(System.in);

        while(true){
            System.out.println("\nIndica el tipo de documento que quieres imprimir: ");
            System.out.println("1) Curriculum.\n2) Libro PDF.\n3) Informes.\n4) Salir.");
            opcion = teclado.nextInt();

            switch(opcion){
                case 1:{
                    System.out.println("Ingresa el apellido: ");
                    teclado.nextLine();
                    apellido = teclado.nextLine();
                    System.out.println("Ingresa el nombre: ");
                    nombre = teclado.nextLine();
                    System.out.println("Ingresa la edad: ");
                    edad = teclado.nextInt();
                    System.out.println("Ingresa el DNI: ");
                    teclado.nextLine();
                    dni = teclado.nextLine();

                    Curriculum curriculum = new Curriculum(apellido, nombre, edad, dni, habilidades);
                    System.out.println("...Imprimiendo el Curriculum...");
                    Interfaz.imprimirDocumento(curriculum);
                }break;
                case 2:{
                    System.out.println("Ingresa el titulo: ");
                    teclado.nextLine();
                    titulo = teclado.nextLine();
                    System.out.println("Ingresa el genero: ");
                    genero = teclado.nextLine();
                    System.out.printf("Ingresa el nombre del autor: ");
                    autor = teclado.nextLine();
                    System.out.println("Ingresa la cantidad de paginas: ");
                    cantidadPaginas = teclado.nextInt();

                    LibroPDF libroPDF = new LibroPDF(cantidadPaginas, autor, titulo, genero);
                    System.out.println("...Imprimiendo el Libro PDF...");
                    Interfaz.imprimirDocumento(libroPDF);
                }break;
                case 3:{
                    System.out.println("Ingresa la cantidad de paginas: ");
                    cantidadPaginas = teclado.nextInt();
                    System.out.println("Ingresa el autor: ");
                    teclado.nextLine();
                    autor = teclado.nextLine();
                    System.out.println("Ingresa el revisor: ");
                    revisor = teclado.nextLine();

                    Informe informe = new Informe(texto, cantidadPaginas, autor, revisor);
                    System.out.println("...Imprimiendo informe...");
                    Interfaz.imprimirDocumento(informe);
                }break;
                case 4: {
                    System.out.println("Gracias por usar nuestra impresora!");
                    System.exit(0);
                }
                default:
                    System.out.println("Opcion incorrecta!");
            }
        }
    }
}