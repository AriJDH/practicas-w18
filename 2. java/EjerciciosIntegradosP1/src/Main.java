public class Main {
    public static void main(String[] args) {
       //------------------------------Ejercicio ordenamiento--------------------------------
        System.out.println("****---Ejercicio Ordenamiento---****");
        int[] array= {3,4,5,67,1,2,7};
        array = burbuja(array);
        for (Integer i: array){
            System.out.println(i);
        }

        //----------------------------Ejercicio Series numericas------------------------------
        System.out.println("****---Ejercicio Ordenamiento---****");
        Doble doble = new Doble(0,0);
        Triple triple = new Triple(0,0);
        System.out.println("Prueba con serie 2");
        doble.establecerInicial(1);
        System.out.println(doble.siguiente());
        System.out.println(doble.siguiente());
        System.out.println("Prueba con serie 3");
        System.out.println(triple.siguiente());
        System.out.println(triple.siguiente());
        System.out.println(triple.reiniciar());

    }

    public static int [] burbuja(int[] array){
        int aux =0;
        for (int j=0; j< array.length; j++){
            for(int i=0; i<array.length-1; i++){
                if(array[i] > array[i+1]){
                    aux = array[i];
                    array[i] = array[i+1];
                    array[i+1] = aux;
                }

            }
        }
        return array;
    }

}