import SerieNumerica.SerieDos;

public class Main {
    public static void main(String[] args) {
        System.out.println("************ Serie de Dos **********");
        SerieDos serieDos = new SerieDos(2.0);
        System.out.println("Serie con los 10 primeros elementos");
        for (int i=0; i<10; i++){
            System.out.println(serieDos.getNextvalue());
        }
        System.out.println("\n Resetear la serie");
        serieDos.resetSerie();
        System.out.println("\n Imprimir la serie");
        System.out.println(serieDos.getNextvalue());
        serieDos.defineNewInitialValue(5);
        System.out.println("Serie con los 6 primeros elementos");
        for (int i=0;i<6;i++){

        }

    }
}
