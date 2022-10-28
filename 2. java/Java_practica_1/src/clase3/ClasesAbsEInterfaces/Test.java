package clase3.ClasesAbsEInterfaces;

import javax.swing.plaf.ComponentInputMapUIResource;

public class Test {
    public static void main(String[] args) {
        FiguraGeometrica f = new Triangulo(1,2,3,7);
        System.out.println(f.calcularArea());

        Circulo c = new Circulo(1, 2, 5);
        System.out.println("El area del circulo: " + c.calcularArea());
        System.out.println(c.otroMetodo());
        System.out.println(c.otroMetodo2());

        f = new Circulo(1,2,5);
        System.out.println(f.calcularArea());

    }
}
