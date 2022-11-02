package ejercicio3;

public class Hervivoro implements GustoAlimenticio{
    @Override
    public String gustoAlimenticio(String comida) {
        return "Como: "+comida;
    }

    public void comer(){
        System.out.println("Soy hervivoro");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("No como animales.");
    }

}
