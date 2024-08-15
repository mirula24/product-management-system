package enigma.ProductManagementSystem.seeder;

import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.core.annotation.Order;

@Configuration
public class DatabaseSeeder {

    @Bean
    @Order(1)
    CommandLineRunner initDatabase(InventorySeeder inventorySeeder,
                                   ProductSeeder productSeeder,
                                   ShopSeeder shopSeeder,
                                   SaleSeeder saleSeeder) {
        return args -> {
            inventorySeeder.seed();
            productSeeder.seed();
            shopSeeder.seed();
            saleSeeder.seed();
        };
    }
}
