package com.meli.be_java_hisp_w18_g9.unit.repository;

import com.meli.be_java_hisp_w18_g9.exception.NotFoundException;
import com.meli.be_java_hisp_w18_g9.model.entity.Product;
import com.meli.be_java_hisp_w18_g9.repository.IProductRepository;
import com.meli.be_java_hisp_w18_g9.repository.ProductRepository;
import org.junit.jupiter.api.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
class ProductRepositoryTest {

    // ? =============== Attributes =============== ?

    @Autowired
    private ProductRepository productRepository;

    // ? =============== Before =============== ?

    @BeforeEach
    public void setUp() {

        productRepository.save(new Product(1, "Product 1", "Type 1", "Brand 1", "Black", "XL"));
        productRepository.save(new Product(2, "Product 2", "Type 2", "Brand 2", "White", "L"));
        productRepository.save(new Product(3, "Product 3", "Type 3", "Brand 3", "Red", "M"));

    }


    // ? =============== Tests =============== ?

    @Test
    @DisplayName("Find all products")
    void findAll() {

        assertTrue(productRepository.findAll().size() > 0);
        assertNotNull(productRepository.findAll().get(0));
        assertFalse(productRepository.findAll().isEmpty());
        assertEquals(3, productRepository.findAll().size());

    }

    // * =============== *

    @Test
    @DisplayName("Find product by Id")
    void findById() {

        assertNotNull(productRepository.findById(1));
        assertEquals(1, productRepository.findById(1).getProductId());
        assertEquals("Product 1", productRepository.findById(1).getProductName());
        assertEquals("Type 1", productRepository.findById(1).getType());
        assertEquals("Brand 1", productRepository.findById(1).getBrand());

    }

    // * =============== *

    @Test
    @DisplayName("Find product by Id - Not found")
    void findByIdNotFound() {
        assertThrows(NotFoundException.class, () -> productRepository.findById(4));
    }

    // * =============== *

    @Test
    @DisplayName("Save a product")
    void save() {

        Product product = new Product(4, "Product 4", "Type 4", "Brand 4", "Blue", "S");
        productRepository.save(product);

        assertEquals(4, productRepository.findAll().size());
        assertEquals(4, productRepository.findById(4).getProductId());
        assertEquals("Product 4", productRepository.findById(4).getProductName());
        assertEquals("Type 4", productRepository.findById(4).getType());
        assertEquals("Brand 4", productRepository.findById(4).getBrand());

    }

    // * =============== *

    @Test
    @DisplayName("Update a product")
    void update() {

        Product product = new Product(null, "Product 1 Updated", "Type 1 Updated", "Brand 1 Updated", "Black Updated", "XL Updated");
        productRepository.update(1, product);

        assertEquals(3, productRepository.findAll().size());
        assertEquals(1, productRepository.findById(1).getProductId());
        assertEquals("Product 1 Updated", productRepository.findById(1).getProductName());
        assertEquals("Type 1 Updated", productRepository.findById(1).getType());
        assertEquals("Brand 1 Updated", productRepository.findById(1).getBrand());
        assertEquals("Black Updated", productRepository.findById(1).getColor());
        assertEquals("XL Updated", productRepository.findById(1).getNotes());

    }

    // * =============== *

    @Test
    @DisplayName("Update a product - Not found")
    void updateNotFound() {
        Product product = new Product(null, "Product 1 Updated", "Type 1 Updated", "Brand 1 Updated", "Black Updated", "XL Updated");
        assertThrows(NotFoundException.class, () -> productRepository.update(4, product));
    }

    // * =============== *

    @Test
    @DisplayName("Delete a product")
    void deleteById() {
        productRepository.deleteById(1);
        assertEquals(2, productRepository.findAll().size());
    }

    // * =============== *

    @Test
    @DisplayName("Delete a product - Not found")
    void deleteByIdNotFound() {
        assertThrows(NotFoundException.class, () -> productRepository.deleteById(4));
    }

    // ? =============== After =============== ?

    @AfterEach
    public void tearDown() {
        productRepository.findAll().removeIf(product -> product.getProductId() != null);
    }
}