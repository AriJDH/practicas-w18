public class PracticaExcepciones {
    private int a = 0;
    private int b = 300;
    public PracticaExcepciones() {
    }

    public PracticaExcepciones(int a,
                               int b) {
        this.a = a;
        this.b = b;
    }

    public double calcular(){
        return b/a;
    }
}
