package kg.java.purchases.core.contracts.facades;

import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;

import java.util.List;

public interface PurchaseFacade {
    PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException;
    HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException;
    List<PurchaseDto> findByBuyerName(FindPurchasesByBuyerNameDto model);
    List<PurchaseDto> findByProductName(FindPurchasesByProductNameDto model);

}
