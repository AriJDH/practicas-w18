public class Main {
    public static void main(String[] args){
        //Casos de prueba:

        EstudianteTecnico estudianteTecnico = new EstudianteTecnico("Pedro", 24, "39.221.334");
        estudianteTecnico.colaborar();

        Tutor estudianteTutor = new Tutor("Jose", 20, "41.332.131");
        estudianteTutor.enseñar();

    }
}
