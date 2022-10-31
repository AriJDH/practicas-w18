package Ejercicio3.Util;

public class CheckAnimal {

    public static <T> boolean checkingAnimal(T t){
        if ("Dog".equals(t)) {
            return true;
        } else if ("Cat".equals(t)) {
            return true;
        } else {
            return false;
        }
    }
}
