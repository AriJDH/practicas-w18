public class Main {
    public static void main(String[] args) {

        Persona personaSinDatos = new Persona();
        Persona personaNombreEdadDni = new Persona("Pepe", 20, "12345abc");
        Persona personaConTodosLosAtributos = new Persona("julio", 21, "45678", 50.90f, 1.70f);

        System.out.println(personaConTodosLosAtributos.calcularIMC());

        int imc = personaConTodosLosAtributos.calcularIMC();
        switch (imc){
            case -1:
                System.out.println("Bajo peso");
                break;
            case 1:
                System.out.println("Peso saludable");
                break;
            default:
                System.out.println("Sobrepeso");
                break;
        }
    }
}