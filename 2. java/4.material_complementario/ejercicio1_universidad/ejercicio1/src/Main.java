public class Main {
    public static void main(String[] args) {

        EstudianteTecnico estudianteTecnico = new EstudianteTecnico("Sofia","Moansterio",10.00,"Abogacia");
        Tutor tutor = new Tutor("Lucas","Monasterio", 9.00,"Ing industrial");

        estudianteTecnico.soyEstudianteTecnico();
        tutor.soyTutor();
    }
}