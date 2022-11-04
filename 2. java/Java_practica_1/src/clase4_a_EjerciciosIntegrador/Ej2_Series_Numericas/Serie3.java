package clase4_a_EjerciciosIntegrador.Ej2_Series_Numericas;

public class Serie3<N extends Number> extends Serie<N>{
    public N valorSiguiente() {
        this.valor = this.valor.doubleValue() + 3;
        return (N) this.valor;
    }
}
