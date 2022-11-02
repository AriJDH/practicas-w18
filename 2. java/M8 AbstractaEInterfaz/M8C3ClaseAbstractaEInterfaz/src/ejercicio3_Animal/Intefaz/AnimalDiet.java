package ejercicio3_Animal.Intefaz;

public interface AnimalDiet {
     void diet();

     static <Animal> void eatAnimal(Animal animal){
          if(animal instanceof Carnivorous){
               ((Carnivorous<?>) animal).diet();
          }
          if (animal instanceof Herbivorous){
               ((Herbivorous<?>) animal).diet();
          }
     }

}
