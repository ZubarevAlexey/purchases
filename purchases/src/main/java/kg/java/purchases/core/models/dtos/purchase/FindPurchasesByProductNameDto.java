package kg.java.purchases.core.models.dtos.purchase;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindPurchasesByProductNameDto {
    private String productName;
}
