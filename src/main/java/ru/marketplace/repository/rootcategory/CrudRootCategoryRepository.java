package ru.marketplace.repository.rootcategory;

import org.springframework.data.jpa.repository.EntityGraph;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.marketplace.model.Region;
import ru.marketplace.model.RootCategory;

import javax.persistence.criteria.Root;
import java.util.List;

@Transactional(readOnly = true)
public interface CrudRootCategoryRepository extends JpaRepository<RootCategory, Integer> {


    @Override
    @Transactional
    RootCategory save(RootCategory rootCategory);


//    @EntityGraph(attributePaths = {"offers"}, type = EntityGraph.EntityGraphType.LOAD)
//    @Query("SELECT r FROM Region r WHERE r.id=:id")
    @Query("SELECT r FROM RootCategory r LEFT JOIN FETCH r.offers WHERE r.id=:id")
    RootCategory getWithOffers(@Param("id") int id);


    @Query("SELECT DISTINCT r FROM RootCategory r JOIN FETCH r.offers ORDER BY r.id")
    List<RootCategory> getAllWithOffers();
}
