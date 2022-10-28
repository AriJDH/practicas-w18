public class Main {
    public static void main(String[] args) {
        FiguraGeometrica triangle = new Triangulo(1, 2, 3, 7);
        System.out.println(triangle.calcularArea());
        // aca no puedo llamar a triangle.testingT() porque es una FiguraGeometrica instanciado como triangulo.

        Circulo cicle = new Circulo(1, 2, 5);
        System.out.println(cicle.calcularArea());
        System.out.println(cicle.testingC());

        triangle = new Circulo(1, 2, 5);
        System.out.println(triangle.calcularArea());
    }
}