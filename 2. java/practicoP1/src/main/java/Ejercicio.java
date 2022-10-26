import java.util.Scanner;

public class Ejercicio {
    public static void main(String[] args) {
        Ejercicio prueba = new Ejercicio();
        prueba.ingresarCiudad();
        prueba.ingresarTemperaturas();
        prueba.obtenerTemperaturas();
    }
        String ciudades[] = new String[10];
        int temp[][] = new int[10][2];

        public void ingresarCiudad(){
            Scanner city = new Scanner(System.in);
            for (int i = 0; i < 10; i++) {
                System.out.println("Ingrese la ciudad correspondiente a la posicion: " + i);
                ciudades[i] = city.nextLine();
            }

        }
        public void ingresarTemperaturas() {
            Scanner tempe = new Scanner(System.in);
            for (int x = 0; x < temp.length; x++) {
                for (int y = 0; y < temp[x].length; y++) {
                    System.out.println("Ingrese la temperatura mínima y máxima respectivamente para la ciudad:" + ciudades[x]);
                    temp[x][y] = tempe.nextInt();

                }
            }


        }

        public void obtenerTemperaturas(){
            int mayor = temp[0][0];
            int menor = temp[0][0];
            int mayPos = 0;
            int menPos = 0;
            for (int m = 0; m < temp.length; m++) {
                for (int b = 0; b < temp[m].length; b++) {
                    if (temp[m][b] > mayor) {
                        mayor = temp[m][b];
                        mayPos = m;
                    }
                    if (temp[m][b] < menor) {
                        menor = temp[m][b];
                        menPos = m;
                    }

                }
            }
            System.out.println("La temperatura mínima fue " + menor + " en la ciudad " + ciudades[menPos]);
            System.out.println("La temperatura máxima fue " + mayor + " en la ciudad " + ciudades[mayPos]);
        }


        }


