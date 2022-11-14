package excepciones.repository;

import excepciones.entity.Book;
import org.springframework.stereotype.Repository;

import java.util.ArrayList;
import java.util.List;

@Repository
public class BookRespositoryImp implements IBookRepository{

    List<Book> bookList = new ArrayList<>() {{
        add(new Book(1L, "El señor de los anillos", "Tolkien"));
        add(new Book(2L, "Las mil y una noches", "Anónimo"));
    }};

    @Override
    public List<Book> traerTodos() {
        return bookList;
    }

    @Override
    public Book findById(Long id) {
        return bookList.stream().filter(b-> b.getId().equals(id)).findFirst().orElse(null);
    }
}
