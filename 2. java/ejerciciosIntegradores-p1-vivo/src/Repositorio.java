import java.util.List;

public interface Repositorio <T> {
    List<T> buscarTodo();
    void aplicarDescuento();
    void agregar(T t);
}
