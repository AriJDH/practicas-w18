public class main {

    public static void main(String[] args) {

        int array[] = {4, 3, -7, 5, 1, 2};
        int aux;

        for(int i = 0; i < array.length; i++) {
            for (int j = 0; j < array.length - 1; j++) {
                if (array[j] > array[j+1]) {
                    aux = array[j];
                    array[j] = array[j+1];
                    array[j+1] = aux;
                }
            }
        }

        for (int i = 0; i < 5; i++) {
            System.out.println(array[i]);
        }

    }
}

