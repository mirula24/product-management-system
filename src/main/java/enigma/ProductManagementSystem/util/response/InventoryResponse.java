package enigma.ProductManagementSystem.util.response;

import enigma.ProductManagementSystem.model.Inventory;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class InventoryResponse {
    private String name ;

    private String city;

    private String address;
    public InventoryResponse(Inventory inventory){
        this.name = inventory.getName();
        this.city = inventory.getCity();
        this.address = inventory.getAddress();
    }
}
