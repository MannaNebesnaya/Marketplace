package ru.marketplace.repository.region;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.marketplace.model.Region;
import ru.marketplace.repository.RegionRepository;

import java.util.List;

@Repository
public class RegionRepositoryImpl implements RegionRepository {
    private static final Sort SORT_NAME = Sort.by(Sort.Direction.ASC, "name");

    private final CrudRegionRepository crudRegionRepository;

    @Autowired
    public RegionRepositoryImpl(CrudRegionRepository crudRegionRepository) {
        this.crudRegionRepository = crudRegionRepository;
    }

    @Override
    public Region save(Region region) {
        return crudRegionRepository.save(region);
    }

    @Override
    public Region get(int id) {
        return crudRegionRepository.findById(id).orElse(null);
    }

    @Override
    public Region getWithCities(int id) {
        return crudRegionRepository.getWithCities(id);
    }

    @Override
    public List<Region> getAll() {
        return crudRegionRepository.findAll(SORT_NAME);
    }

    @Override
    public List<Region> getAllWithCities() {
        return crudRegionRepository.getAllWithCities();
    }
}
