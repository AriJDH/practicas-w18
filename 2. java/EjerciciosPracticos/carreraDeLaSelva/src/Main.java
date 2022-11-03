import java.util.ArrayList;
import java.util.Scanner;


public class Main {
    public static void main(String[] args) {
        //Presentación de la Carrera
        System.out.println("-----------------------------------------------------------------");
        System.out.println("-----------Software Inscripción Carrera de la Selva--------------");
        System.out.println("-----------------------------------------------------------------");

        //Presentación de las categorias
        System.out.println("  ");
        System.out.println("--------------------------------------");
        System.out.println("----------- Categorías  --------------");
        System.out.println("--------------------------------------");
        System.out.println("Circuito chico : 2 km por selva y arroyos.");
        System.out.println("Circuito medio : 5 km por selva , arroyos y barro.");
        System.out.println("Circuito avanzado : 10 km por selva ,arroyos, barro y escalada en piedra.");
        System.out.println("  ");

        //Costos
        System.out.println("  ");
        System.out.println("------------------------------------------------");
        System.out.println("----------- Costos de inscripción --------------");
        System.out.println("------------------------------------------------");
        System.out.println("Circuito chico : Menores de 18 años $1300. Mayores de 18 años $1500.");
        System.out.println("Circuito medio : Menores de 18 años $2000. Mayores de 18 años $2300.");
        System.out.println("Circuito avanzado : No se permite inscripciones a menores de 18 años. Mayores de 18 años $2800");
        System.out.println("  ");


        //Inscripción del participante
        System.out.println("Desea inscribir un participante? \n 1.Si \n 2.No" );
        Scanner opcion =new Scanner(System.in);             //Texto para escanear respuesta.
        String op= opcion.nextLine();                       //Variable que almacena la respuesta.

        //Listas para cada circuito
        ArrayList<Participante> listChico = new ArrayList<>();          //Circuito Chico
        ArrayList<Participante> listMedio = new ArrayList<>();          //Circuito Medio
        ArrayList<Participante> listAvanzado = new ArrayList<>();       //Circuito Avanzado


        //Lógica de inscripción
        if (op.equals("1")){

            //Variable para condición del while
            boolean salir= false;

            //Ciclo para ingresar participantes
            while (salir==false) {

                System.out.println("Ingrese la categoria a la cual se desea inscribir: \n 1.Chico \n 2.Medio \n 3.Avanzado");       //Presento opciones de categoria
                Scanner rta = new Scanner(System.in);                   //Escaneo respuesta
                String cat = rta.nextLine();                            //Almaceno respuesta

                //Inscripción a categoria chico
                if (cat.equals("1")) {

                    //Variables de lecturas ingreso
                    Scanner sdni = new Scanner(System.in);
                    Scanner snom= new Scanner(System.in);
                    Scanner sape= new Scanner(System.in);
                    Scanner sedad= new Scanner(System.in);
                    Scanner scel= new Scanner(System.in);
                    Scanner snroemer= new Scanner(System.in);
                    Scanner srh= new Scanner(System.in);

                    //Solicitud y almacenamiento de información
                    System.out.println("Ingrese DNI: ");
                    double dn = sdni.nextDouble();

                    System.out.println("Ingrese nombre: ");
                    String n = snom.nextLine();

                    System.out.println("Ingrese apellido: ");
                    String ap = sape.nextLine();

                    System.out.println("Ingrese edad: ");
                    int e = sedad.nextInt();

                    System.out.println("Ingrese celular: ");
                    double c = scel.nextDouble();

                    System.out.println("Ingrese número de emergencia: ");
                    double ne = snroemer.nextDouble();

                    System.out.println("Ingrese grupo sanguineo: ");
                    String rh = srh.nextLine();

                    //Creación del nuevo participante en la lista
                    Participante p = new Participante(dn, n, ap, e, c, ne, rh);
                    listChico.add(p);

                    //Condicional para abono
                    if (e <= 18) {
                        System.out.println("El monto a abonar es :$13.000 \n");
                    } else {
                        System.out.println("El monto a abonar es :$15.000 \n");
                    }

                    //Confirmación de inscripción
                    System.out.println(" -------> Participante ingresado al circuito  Chico \n");
                }
                if (cat.equals("2")) {

                    //Variable de lecturas ingreso
                    Scanner sdni1 = new Scanner(System.in);
                    Scanner snom1= new Scanner(System.in);
                    Scanner sape1= new Scanner(System.in);
                    Scanner sedad1= new Scanner(System.in);
                    Scanner scel1= new Scanner(System.in);
                    Scanner snroemer1= new Scanner(System.in);
                    Scanner srh1= new Scanner(System.in);

                    //Solicitud y almacenamiento de información
                    System.out.println("Ingrese DNI: ");
                    double dn = sdni1.nextDouble();

                    System.out.println("Ingrese nombre: ");
                    String n = snom1.nextLine();

                    System.out.println("Ingrese apellido: ");
                    String ap = sape1.nextLine();

                    System.out.println("Ingrese edad: ");
                    int e = sedad1.nextInt();

                    System.out.println("Ingrese celular: ");
                    double c = scel1.nextDouble();

                    System.out.println("Ingrese número de emergencia: ");
                    double ne = snroemer1.nextDouble();

                    System.out.println("Ingrese grupo sanguineo: ");
                    String rh = srh1.nextLine();

                    //Creación del participante en la lista
                    Participante p1 = new Participante(dn, n, ap, e, c, ne, rh);
                    listMedio.add(p1);

                    //Condicional para abono
                    if (e <= 18) {
                        System.out.println("El monto a abonar es :$20.000 \n");
                    } else {
                        System.out.println("El monto a abonar es :$23.000 \n");
                    }

                    //Confirmación de inscripción
                    System.out.println("    Participante ingresado a Medio ");
                }
                if (cat.equals("3")) {

                    //Variable de lecturas ingreso
                    Scanner sdni2 = new Scanner(System.in);
                    Scanner snom2= new Scanner(System.in);
                    Scanner sape2= new Scanner(System.in);
                    Scanner sedad2= new Scanner(System.in);
                    Scanner scel2= new Scanner(System.in);
                    Scanner snroemer2= new Scanner(System.in);
                    Scanner srh2= new Scanner(System.in);

                    //Solicitud de edad para verificación de cumplimiento por normativa
                    System.out.println("Ingrese edad: ");
                    int e = sedad2.nextInt();

                    if (e >= 18) {

                        //Diligenciamiento de información
                        System.out.println("Ingrese DNI: ");
                        double dn = sdni2.nextDouble();

                        System.out.println("Ingrese nombre: ");
                        String n = snom2.nextLine();

                        System.out.println("Ingrese apellido: ");
                        String ap = sape2.nextLine();

                        System.out.println("Ingrese celular: ");
                        double c = scel2.nextDouble();

                        System.out.println("Ingrese número de emergencia: ");
                        double ne = snroemer2.nextDouble();

                        System.out.println("Ingrese grupo sanguineo: ");
                        String rh = srh2.nextLine();

                        //Creación del participante en la lista
                        Participante p2 = new Participante(dn, n, ap, e, c, ne, rh);
                        listAvanzado.add(p2);

                        //Confirmación de inscripción
                        System.out.println(" -------> Participante ingresado al circuito  Avanzado ");

                    } else {
                        System.out.println(" El participante puede ser inscrito en el circuito. ");
                    }
                }

                System.out.println(" Desea ingresar otro participante? \n Presione: 1.Si 2.No");
                Scanner respuesta = new Scanner(System.in);
                String rtas=respuesta.nextLine();
                if(rtas.equals("1")){
                    salir=false;
                }else {
                    salir=true;
                }
            }
        }

        //Cuando selecciona opción inválida
        if (op.equals("2")){
            System.out.println("    Inscripción anulada ");
        }

        //Muestro los listados de cada categoria de circuitos
        System.out.println("\n");
        System.out.println("-------Listados de participante en la Carrera de la Selva--------");
        System.out.println("\n");



        System.out.println("-----------------------------------------------------------------");
        System.out.println("--------------------Listado circuito chico --------------------");
        System.out.println("-----------------------------------------------------------------");

        for (Participante participante : listChico) {

            System.out.println("Inscripción número:" + listChico.indexOf(participante) );
            System.out.println("Nombre:" + participante.nombre+"\n"+" Apellido: "+ participante.apellido+"\n"+ " Edad: " + participante.edad+"\n"+" RH: "+participante.RH );
            System.out.printf("Celular: %.0f " , participante.celular  );
            System.out.printf( " Número de emergencia: %.0f", participante.numEmergencia);
            System.out.println("\n");

        }


        System.out.println("-----------------------------------------------------------------");
        System.out.println("--------------------Listado circuito medio --------------------");
        System.out.println("-----------------------------------------------------------------");

        for (Participante participante : listMedio) {

            System.out.println("Inscripción número:" + listMedio.indexOf(participante) );
            System.out.println("Nombre:" + participante.nombre+"\n"+" Apellido: "+ participante.apellido+"\n"+ " Edad: " + participante.edad+"\n"+" RH: "+participante.RH );
            System.out.printf("Celular: %.0f " , participante.celular  );
            System.out.printf( " Número de emergencia: %.0f", participante.numEmergencia);
            System.out.println("\n");

        }


        System.out.println("-----------------------------------------------------------------");
        System.out.println("--------------------Listado circuito avanzado --------------------");
        System.out.println("-----------------------------------------------------------------");

        for (Participante participante : listAvanzado) {

            System.out.println("Inscripción número:" + listAvanzado.indexOf(participante) );
            System.out.println("Nombre:" + participante.nombre+"\n"+" Apellido: "+ participante.apellido+"\n"+ " Edad: " + participante.edad+"\n"+" RH: "+participante.RH );
            System.out.printf("Celular: %.0f " , participante.celular  );
            System.out.printf( " Número de emergencia: %.0f", participante.numEmergencia);
            System.out.println("\n");
        }


        //Opción para eliminar participante
        System.out.println("Desea eliminar un participante? \n 1.Si \n 2.No " );
        Scanner eliminar= new Scanner(System.in);
        String eli=eliminar.nextLine();

        boolean salir1=false;

        if(eli.equals("1")){
            while( salir1==false){
                System.out.println("Ingrese la categoria de la  cual  desea eliminar el participante: \n 1.Chico \n 2.Medio \n 3.Avanzado");       //Presento opciones de categoria
                Scanner rta1 = new Scanner(System.in);                   //Escaneo respuesta
                String cat1 = rta1.nextLine();                            //Almaceno respuesta

                //Eliminar del circuito chico
                if (cat1.equals("1")){
                    System.out.println("Ingrese el número del participante que desea eliminar:");
                    Scanner pt = new Scanner(System.in);                   //Escaneo respuesta
                    int p1 = pt.nextInt();                            //Almaceno respuesta

                    //Elimino participante
                    listChico.remove(p1);

                    //Informo que elimine el participante
                    System.out.println("Participante eliminado.");

                }
                //Eliminar del circuito medio
                if (cat1.equals("2")){
                    System.out.println("Ingrese el número del participante que desea eliminar:");
                    Scanner pt1 = new Scanner(System.in);                   //Escaneo respuesta
                    int p2 = pt1.nextInt();                            //Almaceno respuesta

                    //Elimino participante
                    listMedio.remove(p2);

                    //Informo que elimine el participante
                    System.out.println("Participante eliminado.");

                }
                //Eliminar del circuito avanzado
                if (cat1.equals("3")){
                    System.out.println("Ingrese el número del participante que desea eliminar:");
                    Scanner pt2 = new Scanner(System.in);                   //Escaneo respuesta
                    int p3 = pt2.nextInt();                            //Almaceno respuesta

                    //Elimino participante
                    listMedio.remove(p3);

                    //Informo que elimine el participante
                    System.out.println("Participante eliminado.");

                }

                System.out.println("Desea eliminar otro participante? \n Presione: 1.Si 2.No");
                Scanner respuesta1 = new Scanner(System.in);
                String rta2=respuesta1.nextLine();
                if(rta2.equals("1")){
                    salir1=false;
                }else {
                    salir1=true;
                }
            }
        }

    }
}