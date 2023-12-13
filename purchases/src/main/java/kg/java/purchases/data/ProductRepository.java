package kg.java.purchases.data;

import kg.java.purchases.core.models.entities.ProductEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;

import java.util.List;
import java.util.Optional;

@Repository
public interface ProductRepository extends JpaRepository<ProductEntity,Long> {
    Optional<ProductEntity> findByName(String name);
    @Query("select p from ProductEntity p " +
            "where p.coast>=:minCoast and p.coast<=:maxCoast" +
            " order by p.id")
    List<ProductEntity> findByCoast(@Param("minCoast")Long minCoast,
                                    @Param("maxCoast")Long maxCoast);
}
