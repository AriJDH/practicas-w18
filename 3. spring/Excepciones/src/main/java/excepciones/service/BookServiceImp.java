package excepciones.service;

import excepciones.entity.Book;
import excepciones.exceptions.NotFoudException;
import excepciones.repository.BookRespositoryImp;
import excepciones.repository.IBookRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BookServiceImp implements IBookService{

    private IBookRepository bookRespositoryImp;

    public BookServiceImp(IBookRepository bookRespositoryImp) {
        this.bookRespositoryImp = bookRespositoryImp;
    }

    @Override
    public List<Book> traerTodos() {
        return bookRespositoryImp.traerTodos();
    }

    @Override
    public Book findById(Long id) {
        Book libroEncontrado = bookRespositoryImp.findById(id);
        if(libroEncontrado == null){
            throw new NotFoudException("El libre con id: " + id + " no fue encontrado.");
        }
        return libroEncontrado;
    }
}
