package excepciones.repository;

import excepciones.entity.Book;

import java.util.List;

public interface IBookRepository {
    public List<Book> traerTodos();
    public Book findById(Long id);
}
