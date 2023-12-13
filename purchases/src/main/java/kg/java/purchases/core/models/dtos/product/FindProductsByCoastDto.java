package kg.java.purchases.core.models.dtos.product;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class FindProductsByCoastDto {
    private Long minCoast;
    private Long maxCoast;
}
