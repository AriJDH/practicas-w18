import java.lang.reflect.*;
import java.util.HashMap;
import java.util.InputMismatchException;
import java.util.Scanner;
import java.util.ArrayList;
import java.util.List;

public class Ejercicio2 {

    static HashMap<String, String> categorias = new HashMap<String, String>();
    static List<Participante> chicoList = new ArrayList<Participante>();
    static List<Participante> medioList = new ArrayList<Participante>();
    static List<Participante> avanzadoList = new ArrayList<Participante>();

    public static void main(String[] args) {
        System.out.println("............Carrera de la Selva............");
        System.out.println("............Desea incribirse?............");
        Scanner sn = new Scanner(System.in);
        boolean exit = false;
        int opcion = 0;
        while(!exit){
            System.out.println("1. Inscripción");
            System.out.println("2. Salir");
            
            try
            {
                System.out.println("Elije una opción");
                opcion = sn.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("Has probado ser fuerte, Bienvenido a la Carrera de la Selva");
                        Inscripcion();
                        exit = true;
                        break;
                    case 2:
                        System.out.println("Pero me daba miedo seguir adelante....");
                        exit = true;
                        break;
                    default:
                        System.out.println("Elije una opción entre 1 y 2");
                }
            }
            catch (InputMismatchException e)
            {
                System.out.println("Debes ingresar un dato nùmerico");
                sn.next();
            }            
        }        
        sn.close();
    }

    private static void Inscripcion() {
        LlenarCategorias();
        System.out.println("Agrega un participante");

        boolean exit = false;
        Scanner sn2 = new Scanner(System.in);
        int opcion = 0;

        while(!exit) {
            System.out.println("Debes seleccionar una categoría");
            System.out.println("1. chico "+ categorias.get("chico"));
            System.out.println("2. medio "+ categorias.get("medio"));
            System.out.println("3. avanzado "+ categorias.get("avanzado"));
            System.out.println("4. Salir");

            try{

                System.out.println("Elije una opción");
                opcion = sn2.nextInt();

                switch (opcion) {
                    case 1:
                        System.out.println("En hora buena, bienvenido al circuito chico");
                        LlenarListas(opcion);
                        break;
                    case 2:
                        System.out.println("Oh nivel DIOS, bienvenido al circuito medio");
                        LlenarListas(opcion);
                        break;
                    case 3:
                        System.out.println("Cuantos años edad tienes ?");
                        var edad =  sn2.nextInt();

                        if(edad < 18){
                            System.out.println("No te puedes inscribir en este circuito");
                        }else{
                        System.out.println("Así que eres un SAYAYIN, bienvenido al circuito Avanzado");
                        LlenarListas(opcion);
                        }
                        break;
                    case 4:
                        System.out.println("Te ha dado miedo al final");
                        exit = true;
                        break;
                    default:
                        System.out.println("Elije una opción entre 1 y 2");
                }

            }catch (InputMismatchException e){
                System.out.println("Debes ingresar un dato nùmerico");
                sn2.next();
            }
        }

        sn2.close();
    }

    private static void LlenarListas(int nroLista) {
        System.out.println("Ingresa la información solicitada");
        boolean exit = false;
        Scanner sn3 = new Scanner(System.in);
        Participante participante = new Participante();

        System.out.println("1. Ingrese su DNI ");
        participante.Dni = sn3.next();
        System.out.println("2. Ingrese su Nombre");
        participante.Nombre = sn3.next();
        System.out.println("3. Ingrese su Apellido");
        participante.Apellido = sn3.next();
        System.out.println("4. Ingrese su Edad");
        participante.Edad = sn3.nextInt();
        System.out.println("5. Ingrese su celular");
        participante.Celular = sn3.next();
        System.out.println("6. Ingrese un número de emergencia");
        participante.NumeroDeEmergencias = sn3.next();
        System.out.println("7. Ingrese su grupo sanguineo");
        participante.GrupoSanguineo = sn3.next();

        switch (nroLista){
            case 1:
                if(chicoList.stream().count()>0){
                   participante.Consecutivo = chicoList.stream().count() + 1;
                }else{
                    participante.Consecutivo = 1;
                }
                CalcularValorPagar(participante, nroLista);
                break;
            case 2:
                if(medioList.stream().count()>0){
                    participante.Consecutivo = medioList.stream().count() + 1;
                }else{
                    participante.Consecutivo = 1;
                }

                CalcularValorPagar(participante, nroLista);
                break;
            case 3:
                if(avanzadoList.stream().count()>0){
                    participante.Consecutivo = avanzadoList.stream().count() + 1;
                }else{
                    participante.Consecutivo = 1;
                }
                CalcularValorPagar(participante, nroLista);
                break;
        }
    }

    private static void CalcularValorPagar(Participante participante, int nroLista) {

        String circuito = "";

        switch (nroLista){
            case 1:
                if(participante.Edad<18)
                    participante.ValorPagar = 1300;
                else
                    participante.ValorPagar = 1500;
                circuito = "Circuito chico";
                chicoList.add(participante);
                break;
            case 2:
                if(participante.Edad<18)
                    participante.ValorPagar = 2000;
                else
                    participante.ValorPagar = 2300;
                circuito = "Circuito medio";
                medioList.add(participante);
                break;
            case 3:
                participante.ValorPagar = 2800;
                circuito = "Circuito avanzado";
                avanzadoList.add(participante);
                break;
        }

        System.out.println("Participante "+participante.Nombre + " Consecutivo "+ participante.Consecutivo);
        System.out.println("Debes cancelar "+ participante.ValorPagar +"Para quedar inscripto en el circuito "+ circuito);

    }

    private static void LlenarCategorias() {
        categorias.put("chico","2 km por selva y arroyos");
        categorias.put("medio","5 km por selva, arroyos y barro");
        categorias.put("avanzado","10 km por selva, arroyos, barro y escalada en piedra");
    }
}


