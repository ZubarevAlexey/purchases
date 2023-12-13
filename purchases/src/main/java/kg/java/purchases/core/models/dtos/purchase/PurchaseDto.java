package kg.java.purchases.core.models.dtos.purchase;



import kg.java.purchases.core.models.dtos.buyer.BuyerDto;
import kg.java.purchases.core.models.dtos.product.ProductDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class PurchaseDto {
    private Long id;
    private BuyerDto buyer;
    private ProductDto product;
    private Date datePurchases;
}
