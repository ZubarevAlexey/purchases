package kg.java.purchases.core.models.dtos.product;

import kg.java.purchases.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateProductDto extends BaseDto {
    private String name;
    private Long coast;
}
