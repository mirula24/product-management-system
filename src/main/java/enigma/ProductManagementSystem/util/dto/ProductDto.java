package enigma.ProductManagementSystem.util.dto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductDto {
    private Long inventory_id;

    private String name;

    private String category;

    private Double price;

    private Integer stock;
}
