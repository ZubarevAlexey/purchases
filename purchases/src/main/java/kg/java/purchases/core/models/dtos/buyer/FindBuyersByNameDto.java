package kg.java.purchases.core.models.dtos.buyer;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindBuyersByNameDto {
    private String name;
}
