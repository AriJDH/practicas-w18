package clase4_a_EjerciciosIntegrador.Ej3_Supermercado.repository;

import java.util.Optional;

public interface CRUDRepository<T> {
    public void nuevo(T t);
    public void mostrarTodos();
    public void eliminar(T t);
    public void nuevoConMenu();
    public void mostrarUno();
    public Optional<T> buscar(String s);
}
