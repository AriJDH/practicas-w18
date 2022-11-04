package clase4_a_EjerciciosIntegrador.Ej2_Series_Numericas;

public class Test {
    public static void main(String[] args) {


        System.out.println("-------------------INICIO DOUBLE SERIE 2----------------------------");
        Serie<Double> s2Double = new Serie2<>();
        for (int i =0 ; i< 4; i++){
            System.out.println(s2Double.valorSiguiente());
        }
        s2Double.reiniciar();
        System.out.println("-------------------SE REINICIA---------------------------------------");
        for (int i =0 ; i< 2; i++){
            System.out.println(s2Double.valorSiguiente());
        }
        s2Double.setValorInicial(10.0);
        System.out.println("-------------------CON VALOR INICIAL---------------------------------");
        for (int i =0 ; i< 5; i++){
            System.out.println(s2Double.valorSiguiente());
        }
        System.out.println("-------------------FIN DOUBLE SERIE 2-------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------INICIO INTEGER SERIE 3---------------------------");
        Serie<Integer> s3Integer = new Serie3<>();
        int entero = s3Integer.valorSiguiente();
        System.out.println(entero);
        for (int i =0 ; i< 4; i++){
            System.out.println(s3Integer.valorSiguiente());
        }
        s3Integer.reiniciar();
        System.out.println("-------------------SE REINICIA--------------------------------------");
        for (int i =0 ; i< 2; i++){
            System.out.println(s3Integer.valorSiguiente());
        }
        s3Integer.setValorInicial(10);
        System.out.println("-------------------CON VALOR INICIAL--------------------------------");
        for (int i =0 ; i< 5; i++){
            System.out.println(s3Integer.valorSiguiente());
        }
        System.out.println("-------------------FIN INTEGER SERIE 3------------------------------");
        System.out.println("--------------------------------------------------------------------");
        System.out.println("-------------------INICIO LONG SERIE 3------------------------------");
        Serie<Long> s3Long = new Serie3<>();
        for (int i =0 ; i< 4; i++){
            System.out.println(s3Long.valorSiguiente());
        }
        s3Long.reiniciar();
        System.out.println("-------------------SE REINICIA--------------------------------------");
        for (int i =0 ; i< 2; i++){
            System.out.println(s3Long.valorSiguiente());
        }
        s3Long.setValorInicial(99999L);
        System.out.println("-------------------CON VALOR INICIAL--------------------------------");
        for (int i =0 ; i< 5; i++){
            System.out.println(s3Long.valorSiguiente());
        }
        System.out.println("-------------------FIN LONG SERIE 3---------------------------------");


    }
}
