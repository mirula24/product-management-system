package enigma.ProductManagementSystem.seeder;

import enigma.ProductManagementSystem.model.Inventory;
import enigma.ProductManagementSystem.repository.InventoryRepository;
import org.springframework.boot.CommandLineRunner;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.Arrays;
import java.util.List;

@Configuration
public class InventorySeeder {

    private final InventoryRepository repository;

    public InventorySeeder(InventoryRepository repository) {
        this.repository = repository;
    }

    public void seed() {
            List<Inventory> inventories = Arrays.asList(
                    Inventory.builder()
                            .name("CPU Storage")
                            .city("Jakarta")
                            .address("Jl. Processor No. 1")
                            .build(),
                    Inventory.builder()
                            .name("GPU Warehouse")
                            .city("Surabaya")
                            .address("Jl. Graphics Card No. 2")
                            .build(),
                    Inventory.builder()
                            .name("RAM Depot")
                            .city("Bandung")
                            .address("Jl. Memory Lane No. 3")
                            .build(),
                    Inventory.builder()
                            .name("Motherboard Center")
                            .city("Medan")
                            .address("Jl. Main Board No. 4")
                            .build(),
                    Inventory.builder()
                            .name("SSD & HDD Hub")
                            .city("Makassar")
                            .address("Jl. Storage Drive No. 5")
                            .build()
            );

            repository.saveAll(inventories);
        }

}