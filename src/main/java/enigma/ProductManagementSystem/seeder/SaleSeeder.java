package enigma.ProductManagementSystem.seeder;

import enigma.ProductManagementSystem.model.Product;
import enigma.ProductManagementSystem.model.Sale;
import enigma.ProductManagementSystem.model.Shop;
import enigma.ProductManagementSystem.repository.ProductRepository;
import enigma.ProductManagementSystem.repository.SaleRepository;
import enigma.ProductManagementSystem.repository.ShopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.time.LocalDateTime;
import java.util.Arrays;
import java.util.List;
import java.util.Random;

@Configuration
public class SaleSeeder {
    private final SaleRepository saleRepository;
    private final ProductRepository productRepository;
    private final ShopRepository shopRepository;

    public SaleSeeder(SaleRepository saleRepository, ProductRepository productRepository, ShopRepository shopRepository) {
        this.saleRepository = saleRepository;
        this.productRepository = productRepository;
        this.shopRepository = shopRepository;
    }

    public void seed() {
        Random random = new Random();
            List<Product> products = productRepository.findAll();
            List<Shop> shops = shopRepository.findAll();

            if (products.isEmpty() || shops.isEmpty()) {
                throw new RuntimeException("Products or Shops not found. Please run Product and Shop seeders first.");
            }

            List<Sale> sales = Arrays.asList(
                    createRandomSale(products, shops, random),
                    createRandomSale(products, shops, random),
                    createRandomSale(products, shops, random),
                    createRandomSale(products, shops, random),
                    createRandomSale(products, shops, random)
            );

            saleRepository.saveAll(sales);
        };


    private Sale createRandomSale(List<Product> products, List<Shop> shops, Random random) {
        Product randomProduct = products.get(random.nextInt(products.size()));
        Shop randomShop = shops.get(random.nextInt(shops.size()));
        int quantity = random.nextInt(1, 6);
        double amount = randomProduct.getPrice() * quantity;

        return Sale.builder()
                .product(randomProduct)
                .shop(randomShop)
                .amount(amount)
                .quantity(quantity)
                .dateTransaction(LocalDateTime.now().minusDays(random.nextInt(30)))
                .build();
    }
}
