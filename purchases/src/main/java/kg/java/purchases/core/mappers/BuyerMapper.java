package kg.java.purchases.core.mappers;

import kg.java.purchases.core.models.dtos.buyer.BuyerDto;
import kg.java.purchases.core.models.dtos.buyer.CreateBuyerDto;
import kg.java.purchases.core.models.dtos.buyer.UpdateBuyerDto;
import kg.java.purchases.core.models.entities.BuyerEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface BuyerMapper {
    BuyerMapper BUYER_MAPPER = Mappers.getMapper(BuyerMapper.class);

    BuyerDto toDomain(BuyerEntity model);
    BuyerEntity fromDomain(CreateBuyerDto model);
    BuyerEntity fromDomain(UpdateBuyerDto model);
}
