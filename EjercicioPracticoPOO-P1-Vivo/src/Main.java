public class Main {
    public static void main(String[] args) {
        Persona persona0 = new Persona();
        Persona persona1 = new Persona("mayra", 21, "dni123");
        Persona persona2 = new Persona("jose",24,"dni12345",102.1,1.82);
        persona0.calcularIMC();
        System.out.println( persona0.calcularIMC());

    }
}