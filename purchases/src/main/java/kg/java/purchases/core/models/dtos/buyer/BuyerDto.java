package kg.java.purchases.core.models.dtos.buyer;


import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;


@Data
@AllArgsConstructor
@NoArgsConstructor
@Builder(toBuilder = true)
public class BuyerDto {
    private Long id;
    private String name;
    private String email;

}
