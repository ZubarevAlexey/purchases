package kg.java.purchases.core.contracts.facades;

import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;

public interface BuyerFacade {
    BuyerDto register(CreateBuyerDto model) throws EntityDuplicateException;

    BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException;

    HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException;

    BuyerDto findById(FindByIdBuyerDto model) throws EntityNotFoundException;

}
