package InterfacesYClaseAbstractas.serierNumericas;

public class Main {
    public static void main(String[] args) {
        Prototipo secuencia = new Secuencia();
        secuencia.iniciarSecuencia(2);
        System.out.println(secuencia.retornarNumero());
    }
}
