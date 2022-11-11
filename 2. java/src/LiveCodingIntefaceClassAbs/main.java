package LiveCodingIntefaceClassAbs;

public class main {
    public static void main(String[] args){

        // Aca instanciamos un triangulo como una FiguraGeometrica. (No instanciamos una figura geometrica).
        // La forma correcta de decirlo seria: f es una figura gemotrica instanciada como un triangulo.
        FiguraGeometrica f = new Triangulo(2,2);
        System.out.println(f.calcularArea());

        Circulo c = new Circulo(1,2,5);
        System.out.println(c.calcularArea());

        //Puedo cambiarle el timpo de instancia en el momento que yo quiera; porque f es de TipoFiguraGeometrica.
        f = new Circulo(1,2,5);
        System.out.println(f.calcularArea());

        //LOS METODOS DENTRO DE TRIANGUNO NO PODRAN USARSE CUANDO SE ESTE TRATANDO COMO UNA INSTANCIA DE FIGURAGEOMETRICA.

    }
}
