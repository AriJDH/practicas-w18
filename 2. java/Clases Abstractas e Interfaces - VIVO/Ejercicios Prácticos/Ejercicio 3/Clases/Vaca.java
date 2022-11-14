public class Vaca extends Animal implements Hervivoros{

    @Override
    public void comer(){
        System.out.println("Me alimento de hierbas.");
    }

    @Override
    public void comerHierba(){
        System.out.println("Me alimento de hierbas.");
    }

    @Override
    public String toString(){
        return "Vaca";
    }

    @Override
    public void hacerSonido(){
        System.out.println("Muuuuu!");
    }

}
