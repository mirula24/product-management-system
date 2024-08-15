package enigma.ProductManagementSystem.seeder;

import enigma.ProductManagementSystem.model.Inventory;
import enigma.ProductManagementSystem.model.Product;
import enigma.ProductManagementSystem.repository.InventoryRepository;
import enigma.ProductManagementSystem.repository.ProductRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ProductSeeder {
    private final ProductRepository productRepository;
    private final InventoryRepository inventoryRepository;

    public ProductSeeder(ProductRepository productRepository,InventoryRepository inventoryRepository) {
        this.productRepository = productRepository;
        this.inventoryRepository = inventoryRepository;

    }
    public void seed() {
            Inventory cpuStorage = inventoryRepository.findByName("CPU Storage").orElseThrow();
            Inventory gpuWarehouse = inventoryRepository.findByName("GPU Warehouse").orElseThrow();
            Inventory ramDepot = inventoryRepository.findByName("RAM Depot").orElseThrow();
            Inventory motherboardCenter = inventoryRepository.findByName("Motherboard Center").orElseThrow();
            Inventory storageHub = inventoryRepository.findByName("SSD & HDD Hub").orElseThrow();

            List<Product> products = Arrays.asList(
                    Product.builder()
                            .name("Intel Core i7-11700K")
                            .category("CPU")
                            .price(399.99)
                            .stock(50)
                            .inventory(cpuStorage)
                            .build(),
                    Product.builder()
                            .name("AMD Ryzen 9 5900X")
                            .category("CPU")
                            .price(549.99)
                            .stock(30)
                            .inventory(cpuStorage)
                            .build(),
                    Product.builder()
                            .name("NVIDIA GeForce RTX 3080")
                            .category("GPU")
                            .price(699.99)
                            .stock(20)
                            .inventory(gpuWarehouse)
                            .build(),
                    Product.builder()
                            .name("AMD Radeon RX 6800 XT")
                            .category("GPU")
                            .price(649.99)
                            .stock(25)
                            .inventory(gpuWarehouse)
                            .build(),
                    Product.builder()
                            .name("Corsair Vengeance LPX 32GB")
                            .category("RAM")
                            .price(159.99)
                            .stock(100)
                            .inventory(ramDepot)
                            .build(),
                    Product.builder()
                            .name("ASUS ROG Strix Z590-E Gaming")
                            .category("Motherboard")
                            .price(379.99)
                            .stock(40)
                            .inventory(motherboardCenter)
                            .build(),
                    Product.builder()
                            .name("Samsung 970 EVO Plus 1TB NVMe SSD")
                            .category("Storage")
                            .price(179.99)
                            .stock(75)
                            .inventory(storageHub)
                            .build()
            );

            productRepository.saveAll(products);
        }

}