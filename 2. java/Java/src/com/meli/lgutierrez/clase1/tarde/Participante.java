package com.meli.lgutierrez.clase1.tarde;

import java.util.*;

public class Participante {
    Integer dni, edad, celular, numeroEmergencia, valorInscripcion, consecutivo;
    String nombre, apellido, grupoSanguineo, categoria;

    List<List<String>>listadoChico = new ArrayList<>();
    List<List<String>>listadoMedio = new ArrayList<>();
    List<List<String>>listadoAvanzado = new ArrayList<>();

    public void inscribirParticipante() {
        Scanner teclado = new Scanner(System.in);
        String respuesta;

        do {
            System.out.println("Escriba el DNI del participante:");
            dni = Integer.parseInt(teclado.nextLine());
            System.out.println("Escriba el nombre del participante:");
            nombre = teclado.nextLine();
            System.out.println("Escriba el apellido del participante:");
            apellido = teclado.nextLine();
            System.out.println("Escriba la edad del participante:");
            edad = Integer.parseInt(teclado.nextLine());
            System.out.println("Escriba el celular del participante:");
            celular = Integer.parseInt(teclado.nextLine());
            System.out.println("Escriba el Número de emergencia del participante:");
            numeroEmergencia = Integer.parseInt(teclado.nextLine());
            System.out.println("Escriba el grupo sanguineo del participante:");
            grupoSanguineo = teclado.nextLine();

            System.out.println("Escriba el concurso al cual va a participar (ej: chico, medio, avanzado):");
            String concurso = teclado.nextLine();
            while (!concurso.toLowerCase().equals("chico") && !concurso.toLowerCase().equals("medio") && !concurso.toLowerCase().equals("avanzado")) {
                System.out.println("ERROR: Escriba el concurso al cual va a participar (ej: chico, medio, avanzado):");
                concurso = teclado.nextLine();
            }

            categoria = concurso.toLowerCase();

            valorInscripcion = calcularValorInscripcion();
            if (valorInscripcion == 0) {
                System.out.println("No se pudo realizar la inscripción.");
            } else {
                List<String> participante = new ArrayList<>();
                participante.add(String.valueOf(dni));
                participante.add(nombre);
                participante.add(apellido);
                participante.add(String.valueOf(edad));
                participante.add(String.valueOf(celular));
                participante.add(String.valueOf(numeroEmergencia));
                participante.add(grupoSanguineo);
                participante.add(String.valueOf(valorInscripcion));

                if (categoria.equals("chico")) {
                    consecutivo = listadoChico.size() + 1;
                    participante.add(String.valueOf(consecutivo));
                    listadoChico.add(participante);
                } else if (categoria.equals("medio")) {
                    consecutivo = listadoMedio.size() + 1;
                    participante.add(String.valueOf(consecutivo));
                    listadoMedio.add(participante);
                } else if (categoria.equals("avanzado")) {
                    consecutivo = listadoAvanzado.size() + 1;
                    participante.add(String.valueOf(consecutivo));
                    listadoAvanzado.add(participante);
                } else {
                    System.out.println("No se pudo realizar la inscripción.");
                }
            }
            System.out.println("Deseas inscribir otro participante (Si/No)");
            respuesta = teclado.next();
            teclado.nextLine();

        } while (respuesta.toLowerCase().equals("si"));
        teclado.close();
    }

    public void desinscribirParticipante(String categoria, Integer DNI){
        switch (categoria.toLowerCase()) {
            case "chico":
                for (List<String> inscrito: listadoChico) {
                    if (inscrito.get(0) == String.valueOf(DNI)){
                        listadoChico.remove(inscrito);
                    }
                }
            case "medio":
                for (List<String> inscrito: listadoMedio) {
                    if (inscrito.get(0) == String.valueOf(DNI)){
                        listadoMedio.remove(inscrito);
                    }
                }
            case "avanzado":
                for (List<String> inscrito: listadoAvanzado) {
                    if (inscrito.get(0) == String.valueOf(DNI)){
                        listadoAvanzado.remove(inscrito);
                    }
                }
        }
    }

    public void mostrarParticipantes(String categoria){

        switch (categoria.toLowerCase()) {
            case "chico":
                for (List<String> inscrito: listadoChico) {
                    System.out.println(
                                    "Consecutivo: \t" + inscrito.get(8) + "\n" +
                                    "DNI: \t" + inscrito.get(0) + "\n" +
                                    "Nombre: \t" + inscrito.get(1) + "\n" +
                                    "Apellido: \t" + inscrito.get(2) + "\n" +
                                    "Edad: \t" + inscrito.get(3) + "\n" +
                                    "Celular: \t" + inscrito.get(4) + "\n" +
                                    "Número de emergencia: \t" + inscrito.get(5) + "\n" +
                                    "Grupo sanguineo: \t" + inscrito.get(6) + "\n" +
                                    "Valor de la inscripción: \t" + inscrito.get(7) + "\n\n"
                    );
                }
            case "medio":
                for (List<String> inscrito: listadoMedio) {
                    System.out.println(
                                    "Consecutivo: \t" + inscrito.get(8) + "\n" +
                                    "DNI: \t" + inscrito.get(0) + "\n" +
                                    "Nombre: \t" + inscrito.get(1) + "\n" +
                                    "Apellido: \t" + inscrito.get(2) + "\n" +
                                    "Edad: \t" + inscrito.get(3) + "\n" +
                                    "Celular: \t" + inscrito.get(4) + "\n" +
                                    "Número de emergencia: \t" + inscrito.get(5) + "\n" +
                                    "Grupo sanguineo: \t" + inscrito.get(6) + "\n" +
                                    "Valor de la inscripción: \t" + inscrito.get(7) + "\n\n"
                    );
                }
            case "avanzado":
                for (List<String> inscrito: listadoAvanzado) {
                    System.out.println(
                                    "Consecutivo: \t" + inscrito.get(8) + "\n" +
                                    "DNI: \t" + inscrito.get(0) + "\n" +
                                    "Nombre: \t" + inscrito.get(1) + "\n" +
                                    "Apellido: \t" + inscrito.get(2) + "\n" +
                                    "Edad: \t" + inscrito.get(3) + "\n" +
                                    "Celular: \t" + inscrito.get(4) + "\n" +
                                    "Número de emergencia: \t" + inscrito.get(5) + "\n" +
                                    "Grupo sanguineo: \t" + inscrito.get(6) + "\n" +
                                    "Valor de la inscripción: \t" + inscrito.get(7) + "\n"
                    );
                }
        }
    }

    public Integer calcularValorInscripcion() {
        Integer valor = 0;
        if (categoria == null) {
            System.out.println("El participante no tiene un concurso asignado");
        } else if (categoria.equals("avanzado")) {
            if (edad < 18) {
                System.out.println("Lo sentimos, no puede realizar inscripción");
            } else {
                valor = 2800;
            }
        } else if (categoria.equals("medio")) {
            if (edad < 18) {
                valor = 2000;
            } else {
                valor = 2300;
            }
        } else if (categoria.equals("chico")) {
            if (edad < 18) {
                valor = 1300;
            } else {
                valor = 1500;
            }
        }
        return valor;
    }

    public static void main(String[] args) {
        Participante participante = new Participante();
        participante.inscribirParticipante();
        participante.mostrarParticipantes("chico");
        participante.desinscribirParticipante("chico", 445);
        participante.mostrarParticipantes("chico");

    }
}
