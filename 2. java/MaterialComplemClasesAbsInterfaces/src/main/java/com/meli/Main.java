package com.meli;

import com.meli.Asteroid.*;
import com.meli.CourseSystem.People.Person;
import com.meli.CourseSystem.People.Student;
import com.meli.CourseSystem.People.Teacher;
import com.meli.CourseSystem.People.Tutor;

import java.util.ArrayList;

public class Main {
    public static void main(String[] args) {
        EjercicioUno();
        EjercicioDos();
    }

    public static void EjercicioUno() {
        System.out.println("EJERCICIO 1:");
        System.out.println("------------------------------------------");
        var tutor = new Tutor(new Student(new Person("123", "Juan")));
        System.out.println("Información personal: ");
        System.out.println("Dni: " + tutor.getStudent().getDni());
        System.out.println("Nombre: " + tutor.getStudent().getName());
        tutor.getStudent().toStudy();
        tutor.doTutoring();
        System.out.println("------------------------------------------");
        var teacher = new Teacher(new Person("1234", "Julian"));
        System.out.println("Información personal: ");
        System.out.println("Dni: " + teacher.getDni());
        System.out.println("Nombre: " + teacher.getName());
        teacher.toTeach();
        System.out.println("------------------------------------------");
    }

    public static void EjercicioDos() {
        System.out.println("EJERCICIO 2:");
        System.out.println("------------------------------------------");
        //Creación de naves para JUAN
        ComposeSpaceship composeSpaceshipJuan = new ComposeSpaceship();
        composeSpaceshipJuan.addSpaceships(new LeafSpaceship("Nave espacial de juan 1"));
        composeSpaceshipJuan.addSpaceships(new LeafSpaceship("Nave espacial de juan 2"));
        composeSpaceshipJuan.addSpaceships(new LeafSpaceship("Nave espacial de juan 3"));

        //Creación de naces para Luis
        ComposeSpaceship composeSpaceshipLuis = new ComposeSpaceship();
        composeSpaceshipLuis.addSpaceships(new LeafSpaceship("Nave espacial de luis 1"));
        composeSpaceshipLuis.addSpaceships(new LeafSpaceship("Nave espacial de luis 2"));
        composeSpaceshipLuis.addSpaceships(new LeafSpaceship("Nave espacial de luis 3"));

        //Creación de nave para Alberto
        LeafSpaceship leafSpaceshipAlberto = new LeafSpaceship("Nave de alberto");

        //Creación de jugadores
        Player playerJuan = new Player("Juan", composeSpaceshipJuan);
        Player playerLuis = new Player("Luis", composeSpaceshipLuis);
        Player playerAlberto = new Player("Alberto", leafSpaceshipAlberto);

        //Creación de ArrayList de jugadores para pasarla a la clase Juego
        ArrayList<Player> playerArrayList = new ArrayList<>();
        playerArrayList.add(playerJuan);
        playerArrayList.add(playerLuis);
        playerArrayList.add(playerAlberto);

        //Instancia de la clase Juego
        Play play = new Play(playerArrayList);
        play.setEndCoordinate(30, 30);
        play.run(10); //se inicia el juego con 10 partidas, cada partida es un tiempo "x" para recorrer "y" unidades de distancia
    }
}