package kg.java.purchases.domain.facades;

import kg.java.purchases.core.contracts.facades.PurchaseFacade;
import kg.java.purchases.core.contracts.services.PurchaseService;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PurchaseFacadeImpl implements PurchaseFacade {
    private final PurchaseService purchaseService;

    public PurchaseFacadeImpl(PurchaseService purchaseService) {
        this.purchaseService = purchaseService;
    }

    @Override
    public PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException {
        return purchaseService.add(model);
    }

    @Override
    public PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException {
        return purchaseService.update(model);
    }

    @Override
    public HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException {
        return purchaseService.delete(model);
    }

    @Override
    public PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException {
        return purchaseService.findById(model);
    }

    @Override
    public List<PurchaseDto> findByBuyerName(FindPurchasesByBuyerNameDto model) {
        return purchaseService.findByBuyerName(model);
    }
}
