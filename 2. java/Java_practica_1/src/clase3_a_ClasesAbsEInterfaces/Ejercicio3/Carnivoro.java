package clase3_a_ClasesAbsEInterfaces.Ejercicio3;

public interface Carnivoro {
    public void comerCarne();

    static void comerAnimal(Animal animal){
        animal.comer();
    }
}
