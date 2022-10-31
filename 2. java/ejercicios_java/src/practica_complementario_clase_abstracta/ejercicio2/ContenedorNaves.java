package practica_complementario_clase_abstracta.ejercicio2;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class ContenedorNaves extends NaveSimple {

    private List<INave> flotaNaves = new ArrayList<>();

    public ContenedorNaves(INave... naves) {
        super("nave1",0,0);
        add(naves);
    }

    public void add(INave iNave) {
        this.flotaNaves.add(iNave);
    }

    public void add(INave... iNaves) {
        flotaNaves.addAll(Arrays.asList(iNaves));
    }

    @Override
    public double acumularPuntos(int x, int y) {

        int puntuacion = 0;

        for (INave nave : flotaNaves) {

            puntuacion += nave.acumularPuntos(x, y);
        }

        return puntuacion;
    }
}
