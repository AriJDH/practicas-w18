package api.demo.service;

import api.demo.repository.IBookRepository;
import org.springframework.stereotype.Service;

import api.entity.Book;
import java.util.List;
@Service
public class BookService implements IBookService{

    private IBookRepository iBookRepository;

    public BookService(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }

    @Override
    public List<?> getBooks() {
        List<Book> list = iBookRepository.findAll();
        return list;
    }
}
