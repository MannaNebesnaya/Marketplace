package ru.marketplace.repository;

import ru.marketplace.model.Region;

import java.util.List;

public interface RegionRepository {

    Region save(Region region);

    Region get(int id);

    Region getWithCities(int id);

    List<Region> getAll();

    List<Region> getAllWithCities();

}
