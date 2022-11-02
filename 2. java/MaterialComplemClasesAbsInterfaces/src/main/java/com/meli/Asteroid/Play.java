package com.meli.Asteroid;

import java.util.List;

public class Play {

    private int[] endCoordinate = new int[2];
    private List<Player> players;

    public Play(List<Player> players) {
        this.endCoordinate[0] = 0;
        this.endCoordinate[1] = 0;
        this.players = players;
    }

    public void setEndCoordinate(int x, int y) {
        this.endCoordinate[0] = x;
        this.endCoordinate[1] = y;
    }

    public int[] getEndCoordinate() {
        return this.endCoordinate;
    }

    public void run(int partidas) {

        boolean flag = true;
        int cont = 1;
        double winningDistance = -1;
        Player champion = this.players.get(0);
        while (cont <= partidas) {

            for (Player player : this.players) {

                double distance;
                double z;
                double r;
                int random;
                var spaceShipI = player.getSpaceship();

                if (spaceShipI.isSimple()) {

                    LeafSpaceship leafSpaceship = (LeafSpaceship) spaceShipI;
                    random = leafSpaceship.getX() + (int) ((Math.random() * 5) - 1);
                    leafSpaceship.setX(random);
                    leafSpaceship.setY(random);
                    z = (Math.pow(leafSpaceship.getX() - this.endCoordinate[0], 2));
                    r = (Math.pow(leafSpaceship.getY() - this.endCoordinate[1], 2));
                    distance = Math.sqrt((z + r));

                    System.out.println("------------------------------------------");
                    System.out.println("Jugador: " + player.getNickName());
                    System.out.println("Tipo de nave: Simple");
                    System.out.println("Ubicación de la nave (" + leafSpaceship.getName() + "): [" + leafSpaceship.getX() + "," + leafSpaceship.getY() + "]");
                    System.out.println("Distancia total desde la ubicación hasta el final: " + distance);
                    System.out.println("------------------------------------------");

                } else {

                    ComposeSpaceship composeSpaceship = (ComposeSpaceship) spaceShipI;
                    double average = 0;

                    for (var compose : composeSpaceship.getSpaceships()) {
                        compose = (LeafSpaceship) compose;
                        //movimiento lineal
                        random = compose.getX() + (int) ((Math.random() * 5) - 1);
                        compose.setX(random);
                        compose.setY(random);
                        z = (Math.pow(compose.getX() - this.endCoordinate[0], 2));
                        r = (Math.pow(compose.getY() - this.endCoordinate[1], 2));
                        distance = Math.sqrt((z + r));
                        average += distance;
                    }

                    average = average / composeSpaceship.getSpaceships().size();
                    distance = average;

                    System.out.println("------------------------------------------");
                    System.out.println("Jugador: " + player.getNickName());
                    System.out.println("Tipo de nave: Compuesta");
                    for (var leafSpaceship : composeSpaceship.getSpaceships()) {
                        leafSpaceship = (LeafSpaceship) leafSpaceship;
                        System.out.println("Ubicacion de la nave (" + leafSpaceship.getName() + "): [" + leafSpaceship.getX() + "," + leafSpaceship.getY() + "]");

                    }

                    System.out.println("Distancia promedio desde la ubicación hasta el final: " + distance);
                    System.out.println("------------------------------------------");
                }

                if (winningDistance == -1) {
                    winningDistance = distance;
                    champion = player;
                } else {
                    if (winningDistance > distance) {
                        winningDistance = distance;
                        champion = player;
                    }
                }
            }

            cont++;
        }
        System.out.println("------------------------------------------");
        System.out.println("GANADOR:" + champion.getNickName());
        System.out.println("------------------------------------------");
    }

}
