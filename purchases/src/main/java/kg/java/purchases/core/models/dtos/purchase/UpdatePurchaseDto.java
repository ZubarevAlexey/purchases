package kg.java.purchases.core.models.dtos.purchase;


import kg.java.purchases.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdatePurchaseDto extends BaseDto {
    private Long buyerId;
    private Long productId;
    private Date datePurchases;
}
