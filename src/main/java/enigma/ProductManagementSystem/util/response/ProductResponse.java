package enigma.ProductManagementSystem.util.response;

import enigma.ProductManagementSystem.model.Product;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ProductResponse {
    private Long inventory_id;

    private String name;

    private String category;

    private Double price;

    private Integer stock;
    public ProductResponse(Product product){
        this.inventory_id = product.getInventory().getId();
        this.name = product.getName();
        this.category = product.getCategory();
        this.price = product.getPrice();
        this.stock = product.getStock();
    }
}
