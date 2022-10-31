package org.example;

import org.example.domain.SingleSpaceship;
import org.example.domain.SpacePoint;
import org.example.domain.SpaceshipComponent;
import org.example.domain.SpaceshipGroup;

import java.util.*;

public class Game {
    private static Map<SpacePoint, SpaceshipComponent> destroyedAsteroids = new HashMap<>();
    private static List<SpacePoint> asteroidLocations = new ArrayList<>();
    private static List<SpaceshipComponent> playerBase = new ArrayList<>();
    private static Scanner keyboard = new Scanner(System.in);
    public static SingleSpaceship singleSpaceshipInput(){
        String name;
        int x;
        int y;
        System.out.println("Inserte el nombre de la nave");
        name = keyboard.nextLine();
        return new SingleSpaceship(spacePointInput(), name);
    }

    public static SpacePoint spacePointInput(){
        int x;
        int y;
        System.out.println("Inserte la ubicación en X:");
        x = keyboard.nextInt();
        keyboard.nextLine();
        System.out.println("Inserte la ubicación en Y:");
        y = keyboard.nextInt();
        keyboard.nextLine();
        return new SpacePoint(x,y);
    }

    public static SpaceshipGroup spaceshipGroupInput(){
        SpaceshipGroup spaceshipGroup = new SpaceshipGroup();
        boolean next;
        int i = 1;
        do{
            System.out.println("-------------DATOS DE LA NAVE "+ i+ "-------------");
            SingleSpaceship singleSpaceship = singleSpaceshipInput();
            spaceshipGroup.addSpaceshipComponent(singleSpaceship);
            System.out.println("¿Desea agregar otra nave? (1-Sí   2-No)");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            next= response==1;
            i++;
        }while(next);
        return spaceshipGroup;
    }

    public static void main(String[] args) {
        System.out.println("-------------INGRESO DE ASTEROIDES-------------");
        int i=1;
        boolean next;
        do{
            System.out.println("Asteroide "+i+":");
            asteroidLocations.add(spacePointInput());
            System.out.println("¿Desea agregar otro asteroide? (1-Sí   2-No)");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            next= response==1;
            i++;
        }while(next);

        System.out.println("-------------INGRESO DE JUGADORES-------------");
        i=1;
        do{
            System.out.println("Jugador "+i+":");
            System.out.println("¿Desea ingresar una nave o una flota? (1-Nave   2-Flota)");
            int response = keyboard.nextInt();
            keyboard.nextLine();
            if(response==1)
                playerBase.add(singleSpaceshipInput());
            else
                playerBase.add(spaceshipGroupInput());

            System.out.println("¿Desea agregar otro jugador? (1-Sí   2-No)");
            response = keyboard.nextInt();
            keyboard.nextLine();
            next= response==1;
            i++;
        }while(next);

        asteroidLocations.stream().forEach(asteroidLoc->{
           double minDistance = playerBase.stream().mapToDouble(player-> player.calculateDistance(asteroidLoc)).min().getAsDouble();
           SpaceshipComponent winner = playerBase.stream().filter(player->player.calculateDistance(asteroidLoc)==minDistance).findFirst().get();
           winner.addPoint();
           destroyedAsteroids.put(asteroidLoc,winner);
        });

        int maxPoints = playerBase.stream().mapToInt(player->player.getPoints()).max().getAsInt();

        System.out.println("-------------GANADORES-------------");
        playerBase.stream().filter(player->player.getPoints()==maxPoints).forEach(player->{
            System.out.println("-------------");
            System.out.println(player.getName());
        });
        System.out.println("-------------REGISTRO DE DESTRUCCION DE ASTEROIDES-------------");
        destroyedAsteroids.forEach((asteroidLoc,player)->{
            System.out.println("-------------");
            System.out.println("El asteroide de la ubicación ("+asteroidLoc.getX()+", "+ asteroidLoc.getY()+") fue destruido por: ");
            System.out.println(player.getName());
        });
    }
}