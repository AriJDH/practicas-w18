package InterfacesYClaseAbstractas.Recapitulando.ejercicio1;

public class Ejercicio1 {

        public static int[] burbuja(int[] array) {
            for(int i = 0; i < array.length; i++)  {
                for(int j = 0; j < array.length -1 -i; j++) {
                    if(array[j] > array[j + 1] && ((j + 1) < array.length - 1)) {
                        int aux = array[j];
                        array[j]= array[j + 1];
                        array[j + 1] = aux;
                    }
                }
            }
            return array;
        }

}
