package api.service;

import api.dto.request.BookRequestDTO;
import api.dto.response.ResponseDTO;
import api.entity.Book;

import java.util.List;

public interface IBookService {
    List<Book> getBooks();
    List<Book> getBooksByFilter(String filter, String keyword);
    List<Book> getBooksByYear(String dateStart, String dateEnd);

    ResponseDTO create(BookRequestDTO request);
}
