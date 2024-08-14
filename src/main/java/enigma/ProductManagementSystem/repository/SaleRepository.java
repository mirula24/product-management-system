package enigma.ProductManagementSystem.repository;

import enigma.ProductManagementSystem.model.Product;
import enigma.ProductManagementSystem.model.Sale;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface SaleRepository extends JpaRepository<Sale,Long> {
    Optional<Sale> findById(Long id);

}
