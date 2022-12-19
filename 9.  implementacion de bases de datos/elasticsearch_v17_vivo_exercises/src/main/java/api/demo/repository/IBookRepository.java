package api.demo.repository;

import api.entity.Book;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IBookRepository extends ElasticsearchRepository<Book, String> {

    List<Book> findAll();

}
