package enigma.ProductManagementSystem.util.dto;


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
public class SaleDto {
    private Long product_id;

    private Long shop_id;

    private Integer quantity;

    private LocalDateTime dateTransaction = LocalDateTime.now(ZoneId.of("Asia/Jakarta"));
}
