package metodosOrdenamiento;

public class Main {
    public static void main(String[] args) {

    int[] array = {1,10,5,2,3};

        System.out.println("Desordenado");
        for (int a: array) {
            System.out.println(a);
        }


    int[] arrayOrdenado = burbuja(array);
        System.out.println("Ordenado forma creciente");
        for (int a: arrayOrdenado) {
            System.out.println(a);
        }

        System.out.println("Ordenado forma decreciente");
        for(int i = (arrayOrdenado.length-1); i >= 0; i--){
            System.out.println(arrayOrdenado[i]);
        }

    }

    /*El método de ordenamiento burbuja
    * El objetivo es preguntar si el número actual es mayor al siguiente
    * y en caso afirmativo, lo intercambiamos de lugar.
    *
    * Tiene dos for anidados, el primer for sirve para indicar
    * cuántas iteraciones dar.
    *
    * Con el for anidado recorremos el array y lo ordenamos.
    *
    * Es necesaria una variable aux para realizar el intercambio de números.
    * */


    public static int[] burbuja(int[] array) {
        int aux;

        for(int i = 0; i < array.length -1; i++){
            for(int j = 0; j < array.length -1; j++){
                if(array[j] > array[j+1]){
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }
        return array;
    }
}
