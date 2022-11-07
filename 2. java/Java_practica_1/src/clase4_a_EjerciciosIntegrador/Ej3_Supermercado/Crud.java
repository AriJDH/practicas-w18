package clase4_a_EjerciciosIntegrador.Ej3_Supermercado;

public interface Crud<T> {
    public void nuevo(T t);
    public void eliminar(T t);
    public void modificar(T t);
    public void consultar(T t);
}
