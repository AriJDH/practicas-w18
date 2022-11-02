package ejercicio3;

public class Carnivoro implements GustoAlimenticio{

    @Override
    public String gustoAlimenticio(String comida) {
        return "Como: "+comida;
    }
    public void comer(){
        System.out.println("Soy carnivoro");
    }

    @Override
    public void comerAnimal(Animal animal) {
        System.out.println("Comi a: "+animal.getClass().getName());
    }
}
