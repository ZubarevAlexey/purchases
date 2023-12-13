package kg.java.purchases.data;


import kg.java.purchases.core.models.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import javax.swing.plaf.LabelUI;
import java.util.List;


@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {

    @Query("SELECT p FROM PurchaseEntity p " +
            "inner join BuyerEntity b " +
            "on b.id = p.buyer.id" +
            " where p.buyer.name=:buyerName")
    List<PurchaseEntity> findByBuyerName(@Param("buyerName")String buyerName);

    @Query("SELECT p FROM PurchaseEntity p " +
            "inner join ProductEntity pr " +
            "on pr.id = p.product.id" +
            " where p.product.name=:productName")
    List<PurchaseEntity> findByProductName(@Param("productName")String productName);
}
