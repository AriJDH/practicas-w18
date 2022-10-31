public class Main {

    public static void main(String[] args) {
        Persona personaSinParam=new Persona();
        Persona personaConAlgunosParam=new Persona("Juan",22,"23028333");
        Persona personaConTodosLosParam=new Persona("Pedro",12,"30765987",80.,1.8);

        if (personaConTodosLosParam.calcularIMC()==-1){
            System.out.println("Hola "+personaConTodosLosParam.getNombre()+". Tu IMC Indica un Bajo Peso.");
        }else if (personaConTodosLosParam.calcularIMC()==0){
            System.out.println("Hola "+personaConTodosLosParam.getNombre()+". Tu IMC Indica un Peso saludable.");
        }else{
            System.out.println("Hola "+personaConTodosLosParam.getNombre()+". Tu IMC Indica un Sobrepeso.");
        }


        if (personaConTodosLosParam.esMayorDeEdad()){
            System.out.println("Hola "+personaConTodosLosParam.getNombre()+
                    " . Tu edad es: "+personaConTodosLosParam.getEdad()+". Eres mayor de edad");
        }else {
            System.out.println("Hola "+personaConTodosLosParam.getNombre()+
                    " . Tu edad es: "+personaConTodosLosParam.getEdad()+". Eres menor de edad");
        }

        System.out.print("Tu información completa es: ");
        System.out.println(personaConTodosLosParam);

    }
}
