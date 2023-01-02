package com.example.frescos.dtos.response;

import com.example.frescos.dtos.ProductDTO;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class ProductsResponseDTO {
    List<ProductDTO> products;
}
