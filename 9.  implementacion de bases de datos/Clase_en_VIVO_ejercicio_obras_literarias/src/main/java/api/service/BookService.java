package api.service;

import api.dto.request.BookRequestDTO;
import api.dto.response.ResponseDTO;
import api.repository.IBookRepository;
import org.springframework.stereotype.Service;

import api.entity.Book;

import java.util.List;

@Service
public class BookService implements IBookService {

    private IBookRepository iBookRepository;

    public BookService(IBookRepository iBookRepository) {
        this.iBookRepository = iBookRepository;
    }


    public List<Book> getBooks() {

        List<Book> list = iBookRepository.findAll();
        ;

        return list;
    }


    @Override
    public List<Book> getBooksByFilter(String filter, String keyword) {

        List<Book> list;

        switch (filter) {
            case "author":
                list = iBookRepository.findAllByAuthorLike(keyword);
                break;
            case "name":
                list = iBookRepository.findByNameLike(keyword);
                break;

            case "morePagesThan":
                list = iBookRepository.findByPageQuantityGreaterThan(keyword);

                break;

            case "editorial":
                list = iBookRepository.findByEditorialIs(keyword);

                break;
            default:
                list = iBookRepository.findAll();
                break;
        }

        return list;
    }

    @Override
    public List<Book> getBooksByYear(String dateStart, String dateEnd) {

        List<Book> list = iBookRepository.findByPublicationYearBetween(dateStart, dateEnd);

        return list;
    }


    @Override
    public ResponseDTO create(BookRequestDTO request) {

        Book book = new Book();

        book.setEditorial(request.getEditorial());
        book.setAuthor(request.getAuthor());
        book.setName(request.getName());
        book.setPublicationYear(request.getPublicationYear());
        book.setPageQuantity(request.getPageQuantity());

        iBookRepository.save(book);

        return new ResponseDTO("Book saved", 200);
    }
}
