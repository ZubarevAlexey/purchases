package kg.java.purchases.data;


import kg.java.purchases.core.models.entities.BuyerEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface BuyerRepository extends JpaRepository<BuyerEntity, Long> {
    Optional<BuyerEntity> findByName(String name);
    List<BuyerEntity> findBuyerEntitiesByNameContainsIgnoreCase(String name);
}
