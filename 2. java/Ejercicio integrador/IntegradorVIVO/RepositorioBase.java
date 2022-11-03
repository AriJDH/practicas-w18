package IntegradorVIVO;
import java.util.List;

public interface RepositorioBase{
    int getDescuento();
    List<String> getLocalizadores();
    void addLocalizador(String localizador);
    String toString();
    void setDescuento(int descuento);
}
