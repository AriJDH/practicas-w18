package interfaces;

public interface Crud<T, Y>{
    public String alta(T obj);
    public String baja(Y id);
    public String modificacion(T obj);
    public T conuslta(Y id);
}
