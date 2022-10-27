package ejercicio1;

public class Main {

    public static void main(String[] args) {

        Persona persona1 = new Persona();
        Persona persona2 = new Persona("Juan", 35, "1239833");
        Persona persona3 = new Persona("Camila", 50, "3495755", 60f, 180f);

        //Al intentar crear un objeto con un constructor no declarado, nos arroja error
        //Persona persona4 = new Persona("Laura", 70);

        imprimirMsj(persona3);
    }

    public static void imprimirMsj(Persona persona) {

        String msjEdad = "";
        String msjIMC = "El IMC es : ";

        switch (persona.calcularIMC()) {
            case -1:
                msjIMC = msjIMC + "Bajo Peso";
                break;
            case 0:
                msjIMC = msjIMC + "Peso Saludable";
                break;
            case 1:
                msjIMC = msjIMC + "Sobre Peso";
                break;
        }

        if (persona.esMayordeEdad()){
            msjEdad = "Es Mayor de Edad";
        } else {
            msjEdad = "Es Menot de Edad";
        }

        System.out.println(persona);
        System.out.println(msjIMC);
        System.out.println(msjEdad);
    }
}
