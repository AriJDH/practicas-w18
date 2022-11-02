package practico1Poo;

import java.util.LinkedList;
import java.util.List;

public class Main {
	public static void main(String[] args) {
		
		Persona persona1 = new Persona("Jose", 27, "111111111", 70, 1.8f);
		
		Persona persona2 = new Persona("Juan", 22, "22222222");
		
		Persona persona3 = new Persona();
		
		System.out.println(persona1.toString());
		
		asignarValor();
		
	}
	
	public static void asignarValor() {
		List<String> mensajeStrings = new LinkedList<>();
	    //Mensaje final
	    String mensajeFinal = "Este es el último mensaje";

	    int[] numeros = new int[5];
        //Código que arroja excepción, escribi tu codigo aqui
        try{
           numeros[5] = 10;
        }catch(Exception ex){
        	System.out.println(ex.getMessage());
            for(String a : mensajeStrings){
            System.out.println(a);
            }

        }finally{
            System.out.println(mensajeFinal);
        }

        
    }

}
