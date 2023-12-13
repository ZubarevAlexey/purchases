package kg.java.purchases.core.contracts.facades;

import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;

public interface PurchaseFacade {
    PurchaseDto add(CreatePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto update(UpdatePurchaseDto model) throws EntityDuplicateException, EntityNotFoundException;
    HttpStatus delete(DeletePurchaseDto model) throws EntityNotFoundException;
    PurchaseDto findById(FindByIdPurchaseDto model) throws EntityNotFoundException;

}
