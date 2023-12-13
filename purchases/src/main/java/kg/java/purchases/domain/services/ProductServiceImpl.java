package kg.java.purchases.domain.services;

import jakarta.transaction.Transactional;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.contracts.services.ProductService;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.mappers.ProductMapper;
import kg.java.purchases.core.models.dtos.product.*;
import kg.java.purchases.data.ProductRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class ProductServiceImpl implements ProductService {

    private final ProductRepository productRepository;

    public ProductServiceImpl(ProductRepository productRepository) {
        this.productRepository = productRepository;
    }

    @Override
    public ProductDto add(CreateProductDto model) throws EntityDuplicateException {
        var product = productRepository.findByName(model.getName());
        if (product.isPresent()) throw new EntityDuplicateException();
        var entity = productRepository.save(ProductMapper.PRODUCT_MAPPER.fromDomain(model)) ;
        return ProductMapper.PRODUCT_MAPPER.toDomain(entity);
    }

    @Override
    public ProductDto update(UpdateProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var entity = product.toBuilder()
                .id(model.getId())
                .name(model.getName())
                .coast(model.getCoast())
                .build();
        productRepository.save(entity);
        return ProductMapper.PRODUCT_MAPPER.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeleteProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        productRepository.delete(product);
        return HttpStatus.OK;
    }

    @Override
    public ProductDto findById(FindByIdProductDto model) throws EntityNotFoundException {
        var product = productRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return ProductMapper.PRODUCT_MAPPER.toDomain(product);
    }

    @Override
    public List<ProductDto> findByCoast(FindProductsByCoastDto model) {
        var products = productRepository.findByCoast(model.getMinCoast(), model.getMaxCoast());
        return products.stream().map(ProductMapper.PRODUCT_MAPPER::toDomain).collect(Collectors.toList());
    }
}
