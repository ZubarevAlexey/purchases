package kg.java.purchases.controllers.v1;

import kg.java.purchases.core.contracts.facades.PurchaseFacade;
import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.models.dtos.purchase.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/purchase")
public class PurchasesControllerV1 {
    private final PurchaseFacade purchaseFacade;

    public PurchasesControllerV1(PurchaseFacade purchaseFacade) {
        this.purchaseFacade = purchaseFacade;
    }

    @PostMapping("/add")
    public ResponseEntity<PurchaseDto> add(@RequestBody CreatePurchaseDto model) {
        try {
            return ResponseEntity.ok(purchaseFacade.add(model));
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/update")
    public ResponseEntity<PurchaseDto> update(@RequestBody UpdatePurchaseDto model) {
        try {
            return ResponseEntity.ok(purchaseFacade.update(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeletePurchaseDto model) {
        try {
            return ResponseEntity.ok(purchaseFacade.delete(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }

    @PostMapping("/id")
    public ResponseEntity<PurchaseDto> findById(@RequestBody FindByIdPurchaseDto model) {
        try {
            return ResponseEntity.ok(purchaseFacade.findById(model));
        } catch (EntityNotFoundException e) {
            return ResponseEntity.badRequest().build();
        } catch (Exception e) {
            return ResponseEntity.internalServerError().build();
        }
    }
}
