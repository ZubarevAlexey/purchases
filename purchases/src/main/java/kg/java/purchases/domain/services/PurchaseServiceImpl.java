package kg.java.purchases.domain.services;

import jakarta.transaction.Transactional;
import kg.java.purchases.core.contracts.services.PurchaseService;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.mappers.PurchaseMapper;
import kg.java.purchases.core.models.dtos.purchase.*;
import kg.java.purchases.data.BuyerRepository;
import kg.java.purchases.data.ProductRepository;
import kg.java.purchases.data.PurchaseRepository;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.stream.Collectors;

@Service
@Transactional
public class PurchaseServiceImpl implements PurchaseService {
    private final PurchaseRepository purchaseRepository;
    private final BuyerRepository buyerRepository;
    private final ProductRepository productRepository;

    public PurchaseServiceImpl(PurchaseRepository purchaseRepository,
                               BuyerRepository buyerRepository, ProductRepository productRepository) {
        this.purchaseRepository = purchaseRepository;
        this.buyerRepository = buyerRepository;
        this.productRepository = productRepository;
    }

    @Override
    public PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException {
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        var entity = PurchaseMapper.PURCHASE_MAPPER.fromDomain(model);
        entity.setBuyer(buyer);
        entity.setProduct(product);
        purchaseRepository.save(entity);
        return PurchaseMapper.PURCHASE_MAPPER.toDomain(entity);
    }

    @Override
    public PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        var buyer = buyerRepository.findById(model.getBuyerId()).orElseThrow(EntityNotFoundException::new);
        var product = productRepository.findById(model.getProductId()).orElseThrow(EntityNotFoundException::new);
        var entity = purchase.toBuilder()
                .id(model.getId())
                .datePurchase(model.getDatePurchases())
                .buyer(buyer)
                .product(product)
                .build();
        purchaseRepository.save(entity);
        return PurchaseMapper.PURCHASE_MAPPER.toDomain(entity);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        purchaseRepository.delete(purchase);
        return HttpStatus.OK;
    }

    @Override
    public PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException {
        var purchase = purchaseRepository.findById(model.getId()).orElseThrow(EntityNotFoundException::new);
        return PurchaseMapper.PURCHASE_MAPPER.toDomain(purchase);
    }

    @Override
    public List<PurchaseDto> findByBuyerName(FindPurchasesByBuyerNameDto model) {
        var purchases = purchaseRepository.findByBuyerName(model.getBuyerName());
        return purchases.stream().map(PurchaseMapper.PURCHASE_MAPPER::toDomain).collect(Collectors.toList());
    }

}
