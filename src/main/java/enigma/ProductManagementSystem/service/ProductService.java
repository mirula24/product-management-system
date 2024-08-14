package enigma.ProductManagementSystem.service;

import enigma.ProductManagementSystem.model.Product;
import enigma.ProductManagementSystem.util.dto.ProductDto;
import enigma.ProductManagementSystem.util.response.ProductResponse;

import java.util.List;

public interface ProductService {
    ProductResponse create(ProductDto request);

    List<Product> getAll();

    ProductResponse getOne(Long id);

    ProductResponse update(Long id, ProductDto request);

    void delete (Long id);
}
