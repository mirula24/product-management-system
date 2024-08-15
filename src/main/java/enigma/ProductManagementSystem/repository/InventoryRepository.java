package enigma.ProductManagementSystem.repository;

import enigma.ProductManagementSystem.model.Inventory;
import enigma.ProductManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface InventoryRepository extends JpaRepository<Inventory,Long> {
    Optional<Inventory> findById(Long id);

    @Query(value = "SELECT * FROM inventories AS inv WHERE inv.name = :nameParam" , nativeQuery = true)
    Optional<Inventory> findByName(@Param("nameParam") String nameParam );
}
