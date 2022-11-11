package EstructurasDinamicas;

import java.util.*;

public class main {
    public static void main (String[] args){
        Scanner teclado = new Scanner(System.in);
        ArrayList<String[]> categoriaUnoList = new ArrayList<String[]>();
        ArrayList<String[]> categoriaDosList = new ArrayList<String[]>();
        ArrayList<String[]> categoriaTresList = new ArrayList<String[]>();
        Map<String,Integer> montos = new HashMap<String,Integer>(){{
            put("CatUnoMenor",1300);
            put("CatUnoMayor",1500);
            put("CatDosMenor",2000);
            put("CatDosMayor",2300);
            put("CatTresMayor",2800);
        }};
        int count = 0;
        System.out.printf("Ingresar numero de Documento ");
        String dni = teclado.next();
          if (dni.equals("0") == false){
            do {
                System.out.printf("Ingresar Edad ");
                int edad = teclado.nextInt();
                System.out.printf("Ingresar Categoria ");
                int categoria = teclado.nextInt();
                if (edad <= 18 && categoria == 3){
                    do {
                        System.out.printf("No se pueden inscribir menores de edad en esta categoria \n Ingresa otra Categoria ");
                        categoria = teclado.nextInt();
                    }while(categoria >= 3);
                }
                String[] participante = new String[9];
                count++;
                participante[0] = String.valueOf(count);
                participante[1] = dni;
                participante[4] = String.valueOf(edad);
                for (int i = 2; i < 8; i++){
                    String dato = new String();
                    switch (i){
                        case 2:
                            dato = "Nombre ";
                            break;
                        case 3:
                            dato = "Apellido ";
                            break;
                        case 4:
                            continue;
                        case 5:
                            dato = "Celular ";
                            break;
                        case 6:
                            dato = "Numero Emergencia ";
                            break;
                        case 7:
                            dato = "Grp. Sanguineo ";
                            break;
                    }
                    System.out.printf("Ingresar " + dato);
                    participante[i] = teclado.next();
                }
                if (edad <= 18){
                    switch (categoria){
                        case 1:
                            participante[8] = String.valueOf(montos.get("CatUnoMenor"));
                            break;
                        case 2:
                            participante[8] = String.valueOf(montos.get("CatDosMenor"));
                            break;
                    }
                }else{
                    switch (categoria){
                        case 1:
                            participante[8] = String.valueOf(montos.get("CatUnoMayor"));
                            break;
                        case 2:
                            participante[8] = String.valueOf(montos.get("CatDosMayor"));
                            break;
                        case 3:
                            participante[8] = String.valueOf(montos.get("CatTresMayor"));
                    }
                }
                switch (categoria){
                    case 1:
                        categoriaUnoList.add(participante);
                        break;
                    case 2:
                        categoriaDosList.add(participante);
                        break;
                    case 3:
                        categoriaTresList.add(participante);
                        break;
                }

                System.out.printf("Ingresar Numero de Documento ");
                dni = teclado.next();
            }while (dni.equals("0") == false);
        }
        //Mostrar Listas de participantes por Categoria
        for (String[] participante: categoriaUnoList ) {
            for (int i = 0; i < 9; i++){
                System.out.printf(participante[i]+"\n");
            }
        }
        for (String[] participante: categoriaDosList ) {
            for (int i = 0; i < 9; i++){
                System.out.printf(participante[i]+"\n");
            }
        }
        for (String[] participante: categoriaTresList) {
            for (int i = 0; i < 9; i++){
                System.out.printf(participante[i]+"\n");
            }
        }


        String nroDocRemove;
        int nroCatRemove;
        System.out.printf("Desea eliminar algun inscripto");
        if(teclado.next().equals("Si")){
            System.out.printf("Ingrese Nro de Documento del participante");
            nroDocRemove = teclado.next();
            System.out.printf("Ingrese la categoria de la cual desea eliminarlo");
            nroCatRemove = Integer.valueOf(teclado.next());
            switch (nroCatRemove) {
                case 1:
                    for (String[] participante: categoriaUnoList ) {
                        if (participante[1].equals(nroDocRemove)){
                            categoriaUnoList.remove(participante);
                        }
                    }
                    break;
                case 2:
                    for (String[] participante: categoriaDosList ) {
                        if (participante[1].equals(nroDocRemove)){
                            categoriaUnoList.remove(participante);
                        }
                    }
                    break;
                case 3:
                    for (String[] participante: categoriaTresList ) {
                        if (participante[1].equals(nroDocRemove)){
                            categoriaUnoList.remove(participante);
                        }
                    }
                    break;
            }
        }
    }
}
