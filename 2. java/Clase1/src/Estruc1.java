public class Estruc1 {

    static final int INCENTIVO = 5000;
    public static void main(String[] args) {
        int ventas = 19000;
        int objetivo = 20000;
        if (ventas>objetivo){
            System.out.println("Satisfactoria " + INCENTIVO);
        } else {
            System.out.println("No llegó a objetivo.");
        }
    }
}
