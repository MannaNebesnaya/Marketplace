package ru.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.marketplace.model.City;
import ru.marketplace.repository.CityRepository;


import static ru.marketplace.util.ValidationUtil.*;

import java.util.List;

@Service
public class CityService {

    private CityRepository repository;

    @Autowired
    public CityService(CityRepository repository) {
        this.repository = repository;
    }

    public City create(City city, int regionId) {
        Assert.notNull(city, "city must not be null");
        return repository.save(city, regionId);
    }

    public void update(City city, int regionId) {
        Assert.notNull(city, "city must not be null");
       checkNotFoundWithId(repository.save(city, regionId), city.getId());
    }

    public City get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<City> getAll() {
        return repository.getAll();
    }

    public List<City> getAllByRegion(int id) {
        return repository.getAllByRegion(id);
    }
}
