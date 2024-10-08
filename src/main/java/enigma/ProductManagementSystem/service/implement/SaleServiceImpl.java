package enigma.ProductManagementSystem.service.implement;
import enigma.ProductManagementSystem.model.Product;
import enigma.ProductManagementSystem.model.Sale;
import enigma.ProductManagementSystem.model.Shop;
import enigma.ProductManagementSystem.repository.ProductRepository;
import enigma.ProductManagementSystem.repository.SaleRepository;
import enigma.ProductManagementSystem.repository.ShopRepository;
import enigma.ProductManagementSystem.service.SaleService;
import enigma.ProductManagementSystem.util.dto.SaleDto;
import enigma.ProductManagementSystem.util.response.SaleResponse;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;

@Service
@RequiredArgsConstructor
public class SaleServiceImpl implements SaleService {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;
    @Override
    public SaleResponse create(SaleDto request) {
        Product getProduct = productRepository.findById(request.getProduct_id()).orElseThrow(()-> new RuntimeException("Product not found"));
        Shop getShop = shopRepository.findById(request.getShop_id()).orElseThrow(()->new RuntimeException("Shop not found"));
        Integer productStock =getProduct.getStock();
        if (request.getQuantity() > productStock){
            throw new RuntimeException("Product just " + getProduct.getStock() + " left");
        }
        Double amountCal = getProduct.getPrice() * request.getQuantity();
        Sale newSale = Sale.builder()
                .product(getProduct)
                .shop(getShop)
                .amount(amountCal)
                .quantity(request.getQuantity())
                .dateTransaction(request.getDateTransaction())
                .build();
        saleRepository.save(newSale);
        getProduct.setStock(productStock - request.getQuantity());
        productRepository.save(getProduct);
        return new SaleResponse(newSale);
    }

    @Override
    public List<SaleResponse> getAll() {
        List<Sale> saleList = saleRepository.findAll();
        List<SaleResponse> saleResponses = saleList.stream().map(SaleResponse::new).toList();
        return saleResponses;
    }

    @Override
    public List<SaleResponse> findShopWithHighestQuantity() {
        List<Sale> saleList = saleRepository.findAll();
        List<SaleResponse> saleResponses = saleList.stream().sorted((a,b) -> b.getQuantity() - a.getQuantity())
                .map(SaleResponse::new).toList();
        return saleResponses;
    }

    @Override
    public SaleResponse getOne(Long id) {
        Sale getOne = saleRepository.findById(id).orElseThrow(()->new RuntimeException("Data Sale not found"));
        return new SaleResponse(getOne);
    }

    @Override
    public SaleResponse update(Long id, SaleDto request) {
        Sale updateSale = saleRepository.findById(id).orElseThrow(()->new RuntimeException("Data Sale not found"));
        Product rollbackProduck = productRepository.findById(updateSale.getProduct().getId()).orElseThrow(()-> new RuntimeException("Product not found"));
        Integer storeBackStock = rollbackProduck.getStock() + updateSale.getQuantity();
        rollbackProduck.setStock(storeBackStock);

        productRepository.save(rollbackProduck);
        Shop getShop = shopRepository.findById(request.getShop_id()).orElseThrow(()->new RuntimeException("Shop not found"));
        Product getProduct = productRepository.findById(request.getProduct_id()).orElseThrow(()-> new RuntimeException("Product not found"));

        Integer productStock =getProduct.getStock();
        if (request.getQuantity() > productStock){
            throw new RuntimeException("Product just " + getProduct.getStock() + " left");
        }
        Double amountCal = getProduct.getPrice() * request.getQuantity();
        updateSale.setShop(getShop);
        updateSale.setProduct(getProduct);
        updateSale.setQuantity(request.getQuantity());
        updateSale.setAmount(amountCal);
        saleRepository.save(updateSale);
        return new SaleResponse(updateSale);
    }

    @Override
    public void delete(Long id) {
        Sale delSale = saleRepository.findById(id).orElseThrow(()->new RuntimeException("Data Sale not found"));
        saleRepository.delete(delSale);

    }
}
