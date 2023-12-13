package kg.java.purchases.domain.facades;

import  kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.contracts.facades.BuyerFacade;
import kg.java.purchases.core.contracts.services.BuyerService;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;
import org.springframework.stereotype.Service;

@Service
public class BuyerFacadeImpl implements BuyerFacade {
    private final BuyerService buyerService;

    public BuyerFacadeImpl(BuyerService buyerService) {
        this.buyerService = buyerService;
    }

    @Override
    public BuyerDto register(CreateBuyerDto model) throws EntityDuplicateException {
        return buyerService.register(model);
    }

    @Override
    public BuyerDto update(UpdateBuyerDto model) throws EntityNotFoundException {
        return buyerService.update(model);
    }

    @Override
    public HttpStatus delete(DeleteBuyerDto model) throws EntityNotFoundException {
        return buyerService.delete(model);
    }

    @Override
    public BuyerDto findById(FindByIdBuyerDto model) throws EntityNotFoundException {
        return buyerService.findById(model);
    }
}
