public class Main implements Carnivoro, Herviboro{
    Animal animal;

    public Animal getAnimal() {
        return animal;
    }

    public void setAnimal(Animal animal) {
        this.animal = animal;
    }

    public Main(){}

    public Main(Animal animal){
        this.animal = animal;
    }

    @Override
    public void comerCarne() {
        System.out.println("El animal come carne");
    }

    @Override
    public void comerHierva() {
        System.out.println("El animal come hierva");
    }

    public void comerAnimal(Animal animal){
        if(animal instanceof Vaca){
            comerHierva();
        }else{
            comerCarne();
        }
    }

}
