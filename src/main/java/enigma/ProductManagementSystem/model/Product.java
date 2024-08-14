package enigma.ProductManagementSystem.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "products")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Product {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    @ManyToOne
    @JoinColumn(name = "inventory_id")
    private Inventory inventory;

    private String name;

    private String category;

    private Double price;

    private Integer stock;
}
