package enigma.ProductManagementSystem.service.implement;
import enigma.ProductManagementSystem.model.Inventory;
import enigma.ProductManagementSystem.model.Product;
import enigma.ProductManagementSystem.repository.InventoryRepository;
import enigma.ProductManagementSystem.repository.ProductRepository;
import enigma.ProductManagementSystem.service.ProductService;
import enigma.ProductManagementSystem.util.dto.ProductDto;
import enigma.ProductManagementSystem.util.response.ProductResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ProductServiceImpl implements ProductService {
    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;
    @Override
    public ProductResponse create(ProductDto request) {
        Inventory getInv = inventoryRepository.findById(request.getInventory_id()).orElseThrow(()->new RuntimeException("Inventory not found"));
        Product newProduct = Product.builder()
                .name(request.getName())
                .stock(request.getStock())
                .price(request.getPrice())
                .category(request.getCategory())
                .inventory(getInv)
                .build();
        productRepository.save(newProduct);
        return new ProductResponse(newProduct);
    }

    @Override
    public List<Product> getProductWithStockAbove(Integer stock) {
        return productRepository.findProductWithStockAbove(stock);
    }

    @Override
    public List<Product> getAll() {
        List<Product> productList = productRepository.findAll();
        return productList;
    }

    @Override
    public ProductResponse getProductWithMaxStock() {
        Product getTheProduct = productRepository.findProductWithMaxStock();
        return new ProductResponse(getTheProduct);
    }

    @Override
    public ProductResponse getOne(Long id) {
        Product getOne = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        return new ProductResponse(getOne);
    }

    @Override
    public ProductResponse update(Long id, ProductDto request) {
        Product updateProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        Inventory getInv = inventoryRepository.findById(request.getInventory_id()).orElseThrow(()->new RuntimeException("Inventory not found"));
        updateProduct.setCategory(request.getCategory());
        updateProduct.setStock(request.getStock());
        updateProduct.setName(request.getName());
        updateProduct.setInventory(getInv);
        productRepository.save(updateProduct);
        return new ProductResponse(updateProduct);
    }

    @Override
    public void delete(Long id) {
        Product delProduct = productRepository.findById(id).orElseThrow(()-> new RuntimeException("Product not found"));
        productRepository.delete(delProduct);

    }
}
