package clase3_a_ClasesAbsEInterfaces.EjercicioEnClase;

public class Triangulo extends FiguraGeometrica{
    private double base;
    private double altura;

    public Triangulo(int posX, int posY) {
        super(posX, posY);
    }

    public Triangulo(int posX, int posY, double base, double altura) {
        super(posX, posY);
        this.base = base;
        this.altura = altura;
    }

    @Override
    public double calcularArea() {
        return (this.base * this.altura) / 2;
    }

    public String otroMetodo2(){
        return "Otro método desde el triangulo";
    }
}
