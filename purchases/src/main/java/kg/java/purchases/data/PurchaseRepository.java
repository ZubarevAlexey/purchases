package kg.java.purchases.data;


import kg.java.purchases.core.models.entities.PurchaseEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;


@Repository
public interface PurchaseRepository extends JpaRepository<PurchaseEntity,Long> {
}
