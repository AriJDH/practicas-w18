import java.util.ArrayList;


public class Main {
    public static void main(String[] args) {

        Nave_Simple nave1 = new Nave_Simple(2,6,"nave1");
        Nave_Simple nave2 = new Nave_Simple(34,98,"nave2");
        Nave_Simple nave3 = new Nave_Simple(8,21,"nave3");
        Nave_Simple nave4 = new Nave_Simple(19,6,"nave4");
        Nave_Simple nave5 = new Nave_Simple(72,66,"nave5");
        Nave_Simple nave6 = new Nave_Simple(87,31,"nave6");
        Nave_Simple nave7 = new Nave_Simple(52,46,"nave7");
        ArrayList<Nave> naves1 = new ArrayList<>();
        naves1.add(nave1);
        naves1.add(nave2);
        naves1.add(nave3);
        naves1.add(nave4);
        Flota_Nave nave_comp = new Flota_Nave(naves1);

        int[] coordenadas = new int[]{2,5,6,3,2,90,76,43,21,17,47,32,65,19};
        ArrayList<Nave> participantes = new ArrayList<>();
        participantes.add(nave_comp);
        participantes.add(nave5);
        participantes.add(nave6);
        participantes.add(nave7);

        //Iniciamos el juego
        // Jugaran la nave 5, 6 y 7 como naves simple y la nave_comp compuesta por 4 naves simples
        ArrayList<Nave> ganadores = new ArrayList<>();
        for (int i=0;i<coordenadas.length;i+=2){
            Nave nave_menor = null;
            double menor_dist = Double.MAX_VALUE;
            for (Nave nave:participantes){
                double dist =  nave.distancia(coordenadas[i],coordenadas[i+1]);
                if (dist < menor_dist) {
                    menor_dist = dist;
                    nave_menor = nave;
                }
            }
            nave1.setPuntuacion();
            ganadores.add(nave_menor);
        }

        System.out.println("Los ganadores son");
        ganadores.stream().forEach(System.out::println);


    }

}
