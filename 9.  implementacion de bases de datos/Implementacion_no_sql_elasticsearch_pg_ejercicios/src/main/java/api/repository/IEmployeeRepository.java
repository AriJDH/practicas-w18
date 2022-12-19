package api.repository;

import api.entity.Employee;
import api.entity.Product;
import org.springframework.data.elasticsearch.repository.ElasticsearchRepository;

import java.util.List;

public interface IEmployeeRepository extends ElasticsearchRepository<Employee, String> {
    List<Employee> findAll();
}
