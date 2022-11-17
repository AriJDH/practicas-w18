package series;

public class App {
    public static void main(String[] args) {
        Serie s = new SerieDe2();
        s.setValorInicial(1);
        s.reiniciar();
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());

        System.out.println("*********************");
        s = new SerieDe3();
        s.setValorInicial(5);
        s.reiniciar();
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());
        System.out.println(s.devolverNroSiguiente());

    }
}
