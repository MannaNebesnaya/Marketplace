package ru.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.marketplace.model.Region;
import ru.marketplace.repository.RegionRepository;

import java.util.List;

import static ru.marketplace.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RegionService {

    private final RegionRepository repository;

    @Autowired
    public RegionService(RegionRepository repository) {
        this.repository = repository;
    }

    public Region create(Region region) {
        Assert.notNull(region, "region must not be null");
        return repository.save(region);
    }

    public void update(Region region) {
        Assert.notNull(region, "region must not be null");
        checkNotFoundWithId(repository.save(region), region.getId());
    }

    public Region get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Region getWithCities(int id) {
        return checkNotFoundWithId(repository.getWithCities(id), id);
    }

    public List<Region> getAll() {
        return repository.getAll();
    }

    public List<Region> getAllWithCities() {
        return repository.getAllWithCities();
    }
}
