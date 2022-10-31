package imprimir;

public interface Imprimir {
    static void print(Imprimir p) {
        System.out.println(p);
    }
}
