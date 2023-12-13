package kg.java.purchases.domain.facades;

import jakarta.transaction.Transactional;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.contracts.facades.ProductFacade;
import kg.java.purchases.core.contracts.services.ProductService;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@Transactional
public class ProductFacadeImpl implements ProductFacade {
    private final ProductService productService;

    public ProductFacadeImpl(ProductService productService) {
        this.productService = productService;
    }

    @Override
    public ProductDto add(CreateProductDto model) throws EntityDuplicateException {
        return productService.add(model);
    }

    @Override
    public ProductDto update(UpdateProductDto model) throws EntityNotFoundException {
        return productService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        return productService.delete(model);
    }

    @Override
    public ProductDto findById(FindByIdProductDto model) throws EntityNotFoundException {
        return productService.findById(model);
    }

    @Override
    public List<ProductDto> findByCoast(FindProductsByCoastDto model) {
        return productService.findByCoast(model);
    }
}
