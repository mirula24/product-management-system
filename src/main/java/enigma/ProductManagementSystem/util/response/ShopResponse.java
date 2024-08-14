package enigma.ProductManagementSystem.util.response;

import enigma.ProductManagementSystem.model.Shop;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class ShopResponse {
    private String name ;

    private String city;
    private String address;
    public  ShopResponse(Shop shop){
        this.name = shop.getName();
        this.address = shop.getAddress();
        this.city = shop.getCity();
    }
}
