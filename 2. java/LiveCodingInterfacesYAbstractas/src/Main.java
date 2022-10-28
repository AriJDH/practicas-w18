import Clases.Circulo;
import Clases.FiguraGeometrica;
import Clases.Triangulo;

public class Main {
    public static void main(String[] args) {
        FiguraGeometrica fig1 = new Triangulo(1, 2, 3, 7);
        System.out.println(fig1.calcularArea());

        Circulo fig2 = new Circulo(1, 2, 5);
        System.out.println(fig2.calcularArea());

        FiguraGeometrica fig3 = new Circulo(1, 2, 10);
        System.out.println(fig3.calcularArea());

        //fig1.metodoExclusivoTriangulo();

        fig1.pintarAzul();
        fig2.pintarRojo();
    }


}