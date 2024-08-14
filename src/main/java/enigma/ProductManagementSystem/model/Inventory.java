package enigma.ProductManagementSystem.model;
import jakarta.persistence.*;
import lombok.*;
@Entity
@Table(name = "inventories")
@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
@Builder
public class Inventory {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String name ;

    private String city;

    private String address;
}
