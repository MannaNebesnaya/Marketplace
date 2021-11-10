package ru.marketplace.repository;

import ru.marketplace.model.City;

import java.util.List;


public interface CityRepository {

    City save(City city, int regionId);

    City get(int id);

    List<City> getAll();

    List<City> getAllByRegion(int regionId);


}
