package POO1P1Vivo;

// Ejercicio 3: Clase Main con su metodo main
public class Main {
    public static void main(String[] args) {
        String mensaje = "";
        Persona persona1 = new Persona(); // objeto persona1 del tipo Persona.
        Persona persona2 = new Persona("Luca", 0, "59999999"); //Igual que antes pero usando otro constructor
        Persona persona3 = new Persona("Jonas", 1, "65000000", 9, 0.71f);
        // Persona persona4 = new Persona("Pierino", 25); // Da error no existe constructor de esta forma

        int imc = persona3.calcularIMC();
        String mayoriaEdad = "";

// Aplico las referencias de la tabla
        switch (imc){
            case -1: mensaje = "Tiene Bajo Peso";
                     break;
            case 0: mensaje = "Tiene Peso Saludable";
                    break;
            case 1: mensaje = "Tiene Sobrepeso";
                    break;
        }
        if (persona3.esMayodDeEdad()){
            mayoriaEdad = "es Mayor de edad";
        } else {
            mayoriaEdad = "es Menor de Edad";
        }


        System.out.printf("La " + persona3 + "\n" + mensaje + " y " + mayoriaEdad);


    }

}
