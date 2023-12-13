package kg.java.purchases.core.contracts.services;


import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface ProductService {
    ProductDto add(CreateProductDto model) throws EntityDuplicateException;

    ProductDto update(UpdateProductDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException;

    ProductDto findById(FindByIdProductDto model) throws EntityNotFoundException;
    List<ProductDto> findByCoast(FindProductsByCoastDto model);
}
