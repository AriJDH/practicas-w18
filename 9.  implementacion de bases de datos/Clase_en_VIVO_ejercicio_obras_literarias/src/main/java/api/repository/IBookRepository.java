package api.repository;

import api.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IBookRepository extends ElasticsearchRepository<Book, String> {
    List<Book> findAll();

    List<Book> findAllByAuthorLike(String keyword);

    List<Book> findByNameLike(String keyword);

    List<Book> findByPageQuantityGreaterThan(String keyword);


    List<Book> findByPublicationYearBetween(String dateStart, String dateEnd);


    List<Book> findByEditorialIs(String keyword);

}
