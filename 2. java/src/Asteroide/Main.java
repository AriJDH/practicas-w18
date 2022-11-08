package Asteroide;

import Asteroide.Clases.FlotaDeNaves;
import Asteroide.Clases.NaveSiemple;
import Asteroide.Shapes.IEstructuraNave;

import java.util.ArrayList;
import java.util.List;
import java.util.Random;

public class Main {
    public static void main(String[] args) {
        Random random = new Random();
        List<Float> listaDistancias = new ArrayList<>();
        List<IEstructuraNave> listaJugadores = new ArrayList<>();

        //region Coordenadas Asteroide
        List<Integer> coordenadasAsteroide = new ArrayList<>();
        coordenadasAsteroide.add(random.nextInt(300));
        coordenadasAsteroide.add(random.nextInt(300));
        //endregion

        //region Nave Simple
        IEstructuraNave naveSimple1 = new NaveSiemple();
        naveSimple1.setNombreNave("la pinta");
        naveSimple1.setCordenadasAsteroide(coordenadasAsteroide);
        List<Integer> cordenadasNaveSimple1 = new ArrayList<>();
        cordenadasNaveSimple1.add(random.nextInt(300));
        cordenadasNaveSimple1.add(random.nextInt(300));
        naveSimple1.setCordenadasNave(cordenadasNaveSimple1);

        listaJugadores.add(naveSimple1);
        //endregion

        //region Flota de Naves
        IEstructuraNave flotaNaves = new FlotaDeNaves();

        IEstructuraNave naveSimple2 = new NaveSiemple();
        naveSimple2.setNombreNave("la niña");
        naveSimple2.setCordenadasAsteroide(coordenadasAsteroide);
        List<Integer> coordenadasNaveSimple2 = new ArrayList<>();
        coordenadasNaveSimple2.add(random.nextInt(300));
        coordenadasNaveSimple2.add(random.nextInt(300));
        naveSimple2.setCordenadasNave(coordenadasNaveSimple2);

        flotaNaves.setCordenadasAsteroide(coordenadasAsteroide);
        flotaNaves.setCordenadasNave(coordenadasNaveSimple2);
        flotaNaves.setNombreNave("Flota de naves");
        flotaNaves.agregarNave(naveSimple2);

        IEstructuraNave naveSimple3 = new NaveSiemple();
        naveSimple3.setNombreNave("la santa María");
        naveSimple3.setCordenadasAsteroide(coordenadasAsteroide);
        List<Integer> coordenadasNaveSimple3 = new ArrayList<>();
        coordenadasNaveSimple3.add(random.nextInt(300));
        coordenadasNaveSimple3.add(random.nextInt(300));
        naveSimple3.setCordenadasNave(coordenadasNaveSimple3);

        flotaNaves.setCordenadasAsteroide(coordenadasAsteroide);
        flotaNaves.setCordenadasNave(coordenadasNaveSimple3);
        flotaNaves.setNombreNave("Flota de naves");
        flotaNaves.agregarNave(naveSimple3);

        listaJugadores.add(flotaNaves);

        //endregion

        //region Nave Simple
        IEstructuraNave naveSimple4 = new NaveSiemple();
        naveSimple4.setNombreNave("Hope");
        naveSimple4.setCordenadasAsteroide(coordenadasAsteroide);
        List<Integer> cordenadasNaveSimple4 = new ArrayList<>();
        cordenadasNaveSimple4.add(random.nextInt(300));
        cordenadasNaveSimple4.add(random.nextInt(300));
        naveSimple4.setCordenadasNave(cordenadasNaveSimple4);

        listaJugadores.add(naveSimple4);
        //endregion

        for(IEstructuraNave nave : listaJugadores){
            System.out.println("Distancia de Nave "+nave.getNombreNave()+": "+nave.calcularDistancia());
            listaDistancias.add(nave.calcularDistancia());
        }

        float distanciaMasCorta = listaDistancias.get(0);
        int indice = 0;

        for(int i=0; i<listaDistancias.size(); i++){
            if(distanciaMasCorta > listaDistancias.get(i)){
                distanciaMasCorta = listaDistancias.get(i);
                indice = i;
            }
        }

        System.out.println("La nave mas cerca al asteroide fue: "+listaJugadores.get(indice).getNombreNave()+" Puntuacion +1!!");
        listaJugadores.get(indice).setPuntuacion();
        System.out.println("--Tabla de puntaje--");
        for(IEstructuraNave naves : listaJugadores){
            System.out.println(naves.getNombreNave()+": "+naves.getPuntaje()+" Puntos!");
        }

    }
}
