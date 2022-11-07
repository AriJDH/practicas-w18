public class Main {
    public static void main(String[] args) {
        SerieDe2 serieDe2 = new SerieDe2(0);
        SerieDe3 serieDe3 = new SerieDe3(0);

        System.out.println(serieDe2.siguiente());
        System.out.println(serieDe2.siguiente());
        System.out.println(serieDe2.siguiente());
        System.out.println(serieDe2.siguiente());
        System.out.println(serieDe2.siguiente());
        System.out.println(serieDe2.siguiente());
        System.out.println(serieDe2.siguiente());
        serieDe2.reiniciar();
        System.out.println(serieDe2.siguiente());
        System.out.println(serieDe2.siguiente());
        System.out.println();

        System.out.println(serieDe3.siguiente());
        System.out.println(serieDe3.siguiente());
        System.out.println(serieDe3.siguiente());
        serieDe3.reiniciar();
        System.out.println(serieDe3.siguiente());
        System.out.println(serieDe3.siguiente());
        System.out.println(serieDe3.siguiente());



    }
}
