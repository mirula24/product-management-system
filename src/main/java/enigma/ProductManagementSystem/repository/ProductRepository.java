package enigma.ProductManagementSystem.repository;

import enigma.ProductManagementSystem.model.Product;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<Product,Long> {
    Optional<Product> findById(Long id);

    @Query(value = "SELECT * FROM products AS pr WHERE pr.stock > :st" , nativeQuery = true)
    List<Product> findProductWithStockAbove(@Param("st") Integer st );

    @Query(value = "SELECT * FROM products AS pr WHERE stock = (SELECT MAX(Stock) FROM products)" , nativeQuery = true)
    Product findProductWithMaxStock();
}
