package excepciones.controller;

import excepciones.entity.Book;
import excepciones.service.IBookService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class BookController {
    private IBookService bookService;

    public BookController(IBookService bookService) {
        this.bookService = bookService;
    }

    @GetMapping("/books")
    public List<Book> traerTodos(){
        return bookService.traerTodos();
    }

    @GetMapping("/books/{id}")
    public Book findById(@PathVariable Long id){
        return bookService.findById(id);
    }

}
