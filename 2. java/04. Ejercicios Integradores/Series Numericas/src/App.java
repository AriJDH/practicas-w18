import series.Serie;
import series.SerieDe2;

public class App {
    public static void main(String[] args) {
        Serie<Long> sl = new SerieDe2();
        System.out.println(sl.devolverNroSiguiente());
        System.out.println(sl.devolverNroSiguiente());
        System.out.println(sl.devolverNroSiguiente());
        System.out.println("*********************");
        Serie<Integer> si = new SerieDe2();
        //Integer i = si.devolverNroSiguiente();
        System.out.println(si.devolverNroSiguiente());
        System.out.println(si.devolverNroSiguiente());
        System.out.println(si.devolverNroSiguiente());
        System.out.println("*********************");
        Serie<Float> sf = new SerieDe2<>();
        System.out.println(sf.devolverNroSiguiente());
        System.out.println(sf.devolverNroSiguiente());
        System.out.println(sf.devolverNroSiguiente());
        System.out.println("*********************");
        Serie<Double> sd = new SerieDe2<>();
        System.out.println(sd.devolverNroSiguiente());
        System.out.println(sd.devolverNroSiguiente());
        System.out.println(sd.devolverNroSiguiente());


    }
}
