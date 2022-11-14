public class Gato extends Animal implements Carnivoros{


    @Override
    public void comer(){
        System.out.println("Me alimento de carne.");
    }

    @Override
    public String toString(){
        return "Gato";
    }

    @Override
    public void comerCarne(){
        System.out.println("Me alimento de carne.");
    }


    @Override
    public void hacerSonido(){
        System.out.println("Miaaau!");
    }


}
