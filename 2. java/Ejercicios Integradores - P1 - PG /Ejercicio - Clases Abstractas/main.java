public class main {
    public static void main(String[] args){

        Prototipo s1 = new SerieDos();
        System.out.println("Serie progresiva de 2 en 2:");
        s1.valorInicial(1);
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());

        System.out.println("Reinicio la serie:");
        s1.reiniciarSerie();
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());
        System.out.println(s1.valorSiguiente());

        System.out.println("Serie Progresiva de 3 en 3:");
        Prototipo s2 = new SerieTres();
        s2.valorInicial(4);
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());

        System.out.println("Reinicio la serie:");
        s2.reiniciarSerie();
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());
        System.out.println(s2.valorSiguiente());


    }
}
