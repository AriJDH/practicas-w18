package Universidad.Clases;

public class Main {
    public static void main(String[] args) {

        Tutor tutor = new Tutor("Cristiano Ronaldo", 33, "Ingenieria Sistema", 6);
        tutor.tutoria();
        EstudianteTecnico estudianteTecnico = new EstudianteTecnico("Lionel Messi", 34, "Derecho", 10);
        estudianteTecnico.soporte();
    }
}
