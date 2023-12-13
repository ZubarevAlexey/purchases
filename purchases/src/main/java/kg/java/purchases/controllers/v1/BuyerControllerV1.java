package kg.java.purchases.controllers.v1;

import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.contracts.facades.BuyerFacade;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.models.dtos.buyer.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/buyer")
public class BuyerControllerV1 {
    private final BuyerFacade buyerFacade;

    public BuyerControllerV1(BuyerFacade buyerFacade) {
        this.buyerFacade = buyerFacade;
    }
    @PostMapping("/signup")
    public ResponseEntity<BuyerDto> register(@RequestBody CreateBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.register(model));
        }catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<BuyerDto> update(@RequestBody UpdateBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<BuyerDto> findById(@RequestBody FindByIdBuyerDto model){
        try {
            return ResponseEntity.ok(buyerFacade.findById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
