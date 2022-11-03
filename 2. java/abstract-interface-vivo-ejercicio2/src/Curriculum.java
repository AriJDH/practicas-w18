import java.util.ArrayList;

public class Curriculum extends Documento{
    ArrayList<String> listHabilidades;

    public Curriculum(int cantPaginas, String autor, ArrayList<String> listHabilidades) {
        super(cantPaginas, autor);
        this.listHabilidades = listHabilidades;
    }
}
