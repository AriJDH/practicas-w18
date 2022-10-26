package com.company;

import com.company.domain.Participante;

import java.util.HashMap;
import java.util.Map;
import java.util.Scanner;

import java.util.List;
import java.util.stream.Collectors;

public class UI {
    private Map<Integer, List<Participante>> categorias;
    private Scanner teclado=new Scanner(System.in);
    private int contadorInscriptos=0;

    public UI(List<Participante> circuitoChico, List<Participante> circuitoMediano, List<Participante> circuitoGrande) {
        categorias=new HashMap<Integer, List<Participante>>();
        categorias.put(1, circuitoChico);
        categorias.put(2, circuitoMediano);
        categorias.put(3,  circuitoGrande);
    }

    private int ingresarCategoria(){
        int op;
        do {
            System.out.println("Ingrese la categoría (1-circuito chico, 2-circuito mediano, 3-circuito grande):");
            op= teclado.nextInt();
            teclado.nextLine();
        }while(op<1 || op>3);
        return op;
    }


    private void agregarACategoria(int categoria, Participante participante){
        if(categoria==3 && participante.getEdad()<18)
            System.out.println("No puede inscribirse un menor de 18 años al circuito grande.");
        else
            categorias.get(categoria).add(participante);


    }

    private void inscribirParticipante(){
        System.out.println("----------------------DATOS DEL PARTICIPANTE----------------------");
        int categoria=ingresarCategoria();
        System.out.println("Ingrese el dni:");
        int dni=teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el nombre:");
        String nombre=teclado.nextLine();
        System.out.println("Ingrese el apellido:");
        String apellido=teclado.nextLine();
        System.out.println("Ingrese la edad:");
        int edad=teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el número de celular:");
        int celular=teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el número de emergencia:");
        int numeroEmergencia=teclado.nextInt();
        teclado.nextLine();
        System.out.println("Ingrese el grupo sanguíneo:");
        String grupoSanguineo=teclado.nextLine();
        contadorInscriptos++;
        Participante participante = new Participante(dni,nombre,apellido,edad,celular,numeroEmergencia,grupoSanguineo, contadorInscriptos);
        agregarACategoria(categoria,participante);
    }

    private void mostrarInscriptos(){
        int categoria=ingresarCategoria();
        List<Participante> inscriptos = categorias.get(categoria);
        if(inscriptos.size()==0)
            System.out.println("No hay inscriptos en esta categoría.");
        for(int i=0;i<inscriptos.size();i++){
            int numInscripcion = i+1;
            System.out.println("----------------------------------------");
            inscriptos.get(i).print();
        }

    }

    private void desincribirParticipante(){
        int categoria=ingresarCategoria();
        List<Participante> inscriptos = categorias.get(categoria);
        System.out.println("----------------------------------------");
        if(inscriptos.size()==0)
            System.out.println("No hay inscriptos en esta categoría.");
        else{
            System.out.println("Seleccione el participante a eliminar:");
            for(int i=0; i<inscriptos.size();i++){
                Participante currentInscripto = inscriptos.get(i);
                System.out.println(i+"-"+currentInscripto.getNombre()+" "+currentInscripto.getApellido());
            }
            int indexAEliminar = teclado.nextInt();
            teclado.nextLine();
            if(indexAEliminar>0 && indexAEliminar<inscriptos.size())
                inscriptos.remove(indexAEliminar);
            else
                System.out.println("El id ingresado no es válido.");
        }

    }

    private double monto(Participante participante, int categoria){
        boolean mayorDe18 = participante.getEdad()>=18;
        switch (categoria){
            case 1:
                return mayorDe18?1500:1300;
            case 2:
                return mayorDe18?2300:2000;
            default:
                return 2800;
        }
    }

    public void mostrarDeudas(){
        System.out.println("----------------------------------------");
        List<List<Participante>> cats = categorias.values().stream().collect(Collectors.toList());
        for(int i=1; i<=cats.size();i++){
            List<Participante> currentCat = cats.get(i-1);
            int finalI = i;
            currentCat.stream().forEach(inscripto-> System
                    .out.println("-El inscripto "+inscripto.getNombre()+" "+inscripto.getApellido()+" de la categoría "+ finalI +" debe $"+monto(inscripto,finalI)));
        }

    }

    public void exec(){
        while(true){
            System.out.println("----------------------MENÚ----------------------");
            System.out.println("Ingrese alguna de las siguientes opciones para continuar:");
            System.out.println("1- Inscribir nuevo participante.");
            System.out.println("2- Mostrar inscriptos.");
            System.out.println("3- Desinscribir participante.");
            System.out.println("4- Calcular monto a abonar por cada participante.");
            int opcion = teclado.nextInt();
            teclado.nextLine();
            switch (opcion){
                case 1:
                    inscribirParticipante();
                    break;
                case 2:
                    mostrarInscriptos();
                    break;
                case 3:
                    desincribirParticipante();
                    break;
                case 4:
                    mostrarDeudas();
                    break;
                default:
                    break;

            }

        }
    }
}
