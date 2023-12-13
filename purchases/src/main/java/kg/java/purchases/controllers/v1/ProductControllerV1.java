package kg.java.purchases.controllers.v1;

import kg.java.purchases.core.exceptions.EntityNotFoundException;
import kg.java.purchases.core.contracts.facades.ProductFacade;
import kg.java.purchases.core.exceptions.EntityDuplicateException;
import kg.java.purchases.core.models.dtos.product.*;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1/product")
public class ProductControllerV1 {
    private final ProductFacade productFacade;

    public ProductControllerV1(ProductFacade productFacade) {
        this.productFacade = productFacade;
    }
    @PostMapping("/add")
    public ResponseEntity<ProductDto> register(@RequestBody CreateProductDto model){
        try {
            return ResponseEntity.ok(productFacade.add(model));
        }catch (EntityDuplicateException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/update")
    public ResponseEntity<ProductDto> update(@RequestBody UpdateProductDto model){
        try {
            return ResponseEntity.ok(productFacade.update(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/delete")
    public ResponseEntity<HttpStatus> delete(@RequestBody DeleteProductDto model){
        try {
            return ResponseEntity.ok(productFacade.delete(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
    @PostMapping("/id")
    public ResponseEntity<ProductDto> findById(@RequestBody FindByIdProductDto model){
        try {
            return ResponseEntity.ok(productFacade.findById(model));
        }catch (EntityNotFoundException e){
            return ResponseEntity.badRequest().build();
        }
        catch (Exception e){
            return ResponseEntity.internalServerError().build();
        }
    }
}
