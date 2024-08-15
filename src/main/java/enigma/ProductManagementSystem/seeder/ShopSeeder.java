package enigma.ProductManagementSystem.seeder;

import enigma.ProductManagementSystem.model.Shop;
import enigma.ProductManagementSystem.repository.ShopRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class ShopSeeder {
private final ShopRepository shopRepository;

    public ShopSeeder(ShopRepository shopRepository) {
        this.shopRepository = shopRepository;
    }

   public void seed(){
            List<Shop> shops = Arrays.asList(
                    Shop.builder()
                            .name("TechMart")
                            .city("Jakarta")
                            .address("Jl. Sudirman No. 123")
                            .build(),
                    Shop.builder()
                            .name("CompuWorld")
                            .city("Surabaya")
                            .address("Jl. Pemuda No. 456")
                            .build(),
                    Shop.builder()
                            .name("Gadget Galaxy")
                            .city("Bandung")
                            .address("Jl. Asia Afrika No. 789")
                            .build(),
                    Shop.builder()
                            .name("Digital Dreams")
                            .city("Medan")
                            .address("Jl. Diponegoro No. 101")
                            .build(),
                    Shop.builder()
                            .name("Cyber Center")
                            .city("Makassar")
                            .address("Jl. Urip Sumoharjo No. 202")
                            .build()
            );

            shopRepository.saveAll(shops);

    }
}