package api.service;

import api.dto.request.ProductRequestDTO;
import api.dto.response.ResponseDTO;
import api.entity.Product;
import api.repository.IProductRepository;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ProductService implements IProductService {

    private IProductRepository iProductRepository;

    public ProductService(IProductRepository iProductRepository) {
        this.iProductRepository = iProductRepository;
    }


    public List<Product> getProducts() {
        List<Product> list = iProductRepository.findAll();
        return list;
    }


    @Override
    public ResponseDTO create(ProductRequestDTO request) {

        Product product = new Product();

        product.setName(request.getName());
        product.setType(request.getType());
        product.setPriceOfCost(request.getPriceOfCost());
        product.setPriceOfSell(request.getPriceOfSell());
        product.setQuantityAvailable(request.getQuantityAvailable());

        iProductRepository.save(product);

        return new ResponseDTO("Product saved", 200);
    }

    @Override
    public ResponseDTO update(String id, ProductRequestDTO request) {

        Product product = iProductRepository.findById(id).orElse(null);

        product.setName(request.getName());
        product.setType(request.getType());
        product.setPriceOfCost(request.getPriceOfCost());
        product.setPriceOfSell(request.getPriceOfSell());
        product.setQuantityAvailable(request.getQuantityAvailable());

        iProductRepository.save(product);

        return new ResponseDTO("Product saved", 200);
    }
}
