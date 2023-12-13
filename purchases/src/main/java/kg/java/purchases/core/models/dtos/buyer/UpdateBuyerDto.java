package kg.java.purchases.core.models.dtos.buyer;


import kg.java.purchases.core.models.dtos.base.BaseDto;
import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class UpdateBuyerDto extends BaseDto {
    private String name;
    private String email;
}
