package kg.java.purchases.core.mappers;

import kg.java.purchases.core.models.dtos.product.CreateProductDto;
import kg.java.purchases.core.models.dtos.product.ProductDto;
import kg.java.purchases.core.models.dtos.product.UpdateProductDto;
import kg.java.purchases.core.models.entities.ProductEntity;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

@Mapper
public interface ProductMapper {
    ProductMapper PRODUCT_MAPPER = Mappers.getMapper(ProductMapper.class);

    ProductDto toDomain(ProductEntity model);
    ProductEntity fromDomain(CreateProductDto model);
    ProductEntity fromDomain(UpdateProductDto model);
}
