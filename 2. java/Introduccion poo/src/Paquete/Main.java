package Paquete;

public class Main {

    public static void main(String[] args) {
	    Persona persona1 = new Persona();
	    Persona persona2 = new Persona("Maria", 23,"1152468321");
	    Persona persona3 = new Persona("Paula",24,"11111111111",70,1.65);

		System.out.println(persona3.toString());

		if (persona3.esMayorDeEdad()){
			System.out.println(persona3.getNombre() +" es mayor de edad");
		} else {
			System.out.println(persona3.getNombre() + " no es mayor de edad");
		}

	    if (persona3.calcularIMC() == -1){
			System.out.println("Su indice de masa corporal está por debajo de 20, está bajo de peso");
		} else {
			if (persona3.calcularIMC() == 0) {
				System.out.println("Su indice de masa corporal está entre 20 y 25, tiene un peso saludable");
			} else {
				System.out.println("Su indice de masa corporal es mayor a 25, tiene sobrepeso");
			}
		};

    }
}
