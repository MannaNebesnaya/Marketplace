package ru.marketplace.repository.region;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.marketplace.model.Region;

import java.util.List;

@Transactional(readOnly = true)
public interface CrudRegionRepository extends JpaRepository<Region, Integer> {


//        @EntityGraph(attributePaths = {"cities"})
//    @Query("SELECT r FROM Region r WHERE r.id=:id")
    @Query("SELECT r FROM Region r JOIN FETCH r.cities WHERE r.id=:id")
    Region getWithCities(@Param("id") int id);


    @Query("SELECT DISTINCT r FROM Region r JOIN FETCH r.cities ORDER BY r.name")
    List<Region> getAllWithCities();

}
