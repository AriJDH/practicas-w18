package api.controller;

import api.dto.response.ResponseDTO;
import api.dto.request.ProductRequestDTO;
import api.service.IProductService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;


@RestController
@RequestMapping("/api/products")
public class ProductController {

    private IProductService iProductService;

    public ProductController(IProductService iProductService) {
        this.iProductService = iProductService;
    }


    @GetMapping("")
    public ResponseEntity<?> getProducts() {
        return new ResponseEntity<>(iProductService.getProducts(), HttpStatus.OK);
    }


    @PostMapping("/create")
    public ResponseEntity<ResponseDTO> create(@RequestBody ProductRequestDTO request) {
        return new ResponseEntity<>(iProductService.create(request), HttpStatus.OK);
    }

    @PutMapping("/update/{id}")
    public ResponseEntity<ResponseDTO> update(@PathVariable String id, @RequestBody ProductRequestDTO request) {
        return new ResponseEntity<>(iProductService.update(id, request), HttpStatus.OK);
    }
}
