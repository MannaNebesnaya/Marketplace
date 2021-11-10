package ru.marketplace.repository.city;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Modifying;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.transaction.annotation.Transactional;
import ru.marketplace.model.City;


import java.util.List;

@Transactional(readOnly = true)
public interface CrudCityRepository extends JpaRepository<City, Integer> {

    @Override
    @Transactional
    City save(City item);


    @Modifying
    @Query("SELECT c FROM City c WHERE c.region.id=:regionId")
    List<City> findAllByRegion(@Param("regionId") int regionId);
}
