package ejercicio2;

public class Pantalla {

    public static void main(String[] args){
        Persona juan= new Persona("Juan Perez", 27, "Ingeniero");
        Documento documento = new Curriculum(juan);
        System.out.println(documento.imprimirContenido());
    }
}
