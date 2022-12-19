package api.repository;

import api.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IProductRepository extends ElasticsearchRepository<Product, String> {
    List<Product> findAll();

}
