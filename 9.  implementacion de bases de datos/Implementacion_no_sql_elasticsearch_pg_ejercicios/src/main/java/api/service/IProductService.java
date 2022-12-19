package api.service;

import api.dto.request.ProductRequestDTO;
import api.dto.response.ResponseDTO;
import api.entity.Product;

import java.util.List;

public interface IProductService {
    List<Product> getProducts();

    ResponseDTO create(ProductRequestDTO request);
    ResponseDTO update(String id, ProductRequestDTO request);
}
