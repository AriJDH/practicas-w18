public class Temperatura {

    public static void main(String[] args) {
        String ciudades[] = {"Londres", "Madrid", "Nueva York", "Buenos Aires", "Asunción", "Sao Paulo", "Lima", "Santiago de Chile", "Lisboa", "Tokio"};
        int temperaturas[][] = {{-2, 33}, {-3, 32}, {-8, 27}, {4, 37}, {6, 42}, {5, 43}, {0, 39}, {-7, 26}, {-1, 31}, {-10, 35}};

        int mayor = temperaturas[0][1];
        int menor = temperaturas[0][0];
        int indice = 0;
        int indice2 = 0;


        for (int x = 1; x < temperaturas.length; x++) {

            if (temperaturas[x][1] > mayor) {
                mayor = temperaturas[x][1];
                indice = x;
            }

            if (temperaturas[x][0] < menor) {
                menor = temperaturas[x][0];
                indice2 = x;
            }

        }

        System.out.println("Mayor temperatura: " + ciudades[indice] + " --> " + mayor);
        System.out.println("Menor temperatura: " + ciudades[indice2] + " --> " + menor);


    }

}
