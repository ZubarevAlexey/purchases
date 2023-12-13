package kg.java.purchases.core.mappers;

import kg.java.purchases.core.models.dtos.purchase.CreatePurchaseDto;
import kg.java.purchases.core.models.dtos.purchase.PurchaseDto;
import kg.java.purchases.core.models.dtos.purchase.UpdatePurchaseDto;
import kg.java.purchases.core.models.entities.PurchaseEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface PurchaseMapper {
    PurchaseMapper PURCHASE_MAPPER = Mappers.getMapper(PurchaseMapper.class);

    PurchaseDto toDomain(PurchaseEntity model);

    PurchaseEntity fromDomain(CreatePurchaseDto model);

    PurchaseEntity fromDomain(UpdatePurchaseDto model);
}
