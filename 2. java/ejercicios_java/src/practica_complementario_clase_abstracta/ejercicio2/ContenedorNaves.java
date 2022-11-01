package practica_complementario_clase_abstracta.ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContenedorNaves implements INave {

    private List<INave> flotaNaves = new ArrayList<>();

    public ContenedorNaves(INave... naves) {
        add(naves);
    }

    public void add(INave iNave) {
        this.flotaNaves.add(iNave);
    }

    public void add(INave... iNaves) {
        flotaNaves.addAll(Arrays.asList(iNaves));
    }

    @Override
    public double calcularDistancia(int x, int y) {

        int puntuacion = 0;

        double distancia = 0.0;

        for (int i = 0; i < flotaNaves.size(); i++) {

            distancia += flotaNaves.get(i).calcularDistancia(x, y);

        }

        return distancia / flotaNaves.size();
    }

    @Override
    public int getPuntuacion() {
        return 0;
    }

    public List<INave> getFlotaNaves() {
        return flotaNaves;
    }

    @Override
    public String toString() {
        return "ContenedorNaves{" +
                "flotaNaves=" + flotaNaves +
                '}';
    }
}
