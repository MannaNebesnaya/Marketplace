package ru.marketplace.repository.city;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.marketplace.model.City;
import ru.marketplace.model.Region;
import ru.marketplace.repository.CityRepository;
import ru.marketplace.repository.region.CrudRegionRepository;

import java.util.List;

@Repository
public class CityRepositoryImpl implements CityRepository {

    private final CrudCityRepository crudCityRepository;
    private final CrudRegionRepository crudRegionRepository;

    @Autowired
    public CityRepositoryImpl(CrudCityRepository crudCityRepository, CrudRegionRepository crudRegionRepository) {
        this.crudCityRepository = crudCityRepository;
        this.crudRegionRepository = crudRegionRepository;
    }

    @Override
    public City save(City city, int regionId) {
       /* Region region = crudRegionRepository.findById(regionId).orElse(null);
        if (!city.isNew() && region == null) {
            return null;
        }*/
        city.setRegion(crudRegionRepository.getOne(regionId));
        return crudCityRepository.save(city);
    }

    @Override
    public City get(int id) {
        return crudCityRepository.findById(id).orElse(null);
    }

    @Override
    public List<City> getAll() {
        return crudCityRepository.findAll();
    }

    @Override
    public List<City> getAllByRegion(int regionId) {
        return crudCityRepository.findAllByRegion(regionId);
    }
}
