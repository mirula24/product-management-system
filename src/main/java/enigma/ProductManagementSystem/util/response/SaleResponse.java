package enigma.ProductManagementSystem.util.response;

import enigma.ProductManagementSystem.model.Sale;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.time.LocalDateTime;
import java.time.ZoneId;
import java.util.Date;

@Data
@Builder
@AllArgsConstructor
@NoArgsConstructor
public class SaleResponse {
    private Long id;
    private Long product_id;

    private Long shop_id;

    private Double amount;

    private Integer quantity;

    private LocalDateTime dateTransaction;
    public SaleResponse(Sale sale){
        this.id = sale.getId();
        this.product_id = sale.getProduct().getId();
        this.shop_id = sale.getShop().getId();
        this.amount = sale.getAmount();
        this.quantity = sale.getQuantity();
        this.dateTransaction = sale.getDateTransaction();
    }
}
