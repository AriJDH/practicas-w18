import Classes.SimpleSeries;

public class Main {
    public static void main(String[] args) {
        System.out.println("Si se crea una serie de 2...");
        SimpleSeries simpleSeries1 = new SimpleSeries(2, 0);
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println("Si por ejemplo se emplea el método para establecer un valor inicial 1...");
        simpleSeries1.setInitialValue(1);
        simpleSeries1.restartSeries();
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println("De igual forma si es una serie de 3...");
        simpleSeries1 = new SimpleSeries(3, 0);
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
        System.out.println(simpleSeries1.nextValue());
    }
}