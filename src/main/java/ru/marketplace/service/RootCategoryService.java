package ru.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.marketplace.model.RootCategory;
import ru.marketplace.repository.RootCategoryRepository;

import java.util.List;
import java.util.Set;

import static ru.marketplace.util.ValidationUtil.checkNotFoundWithId;

@Service
public class RootCategoryService {

    private final RootCategoryRepository repository;

    @Autowired
    public RootCategoryService(RootCategoryRepository repository) {
        this.repository = repository;
    }


    public RootCategory create(RootCategory category) {
        Assert.notNull(category, "root category must not be null");
        return repository.save(category);
    }

    public void update(RootCategory category) {
        Assert.notNull(category, "root category must not be null");
        repository.save(category);
    }

    public RootCategory get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public RootCategory getWithProducts(int id) {
        return checkNotFoundWithId(repository.getWithProducts(id), id);
    }

    public List<RootCategory> getAll() {
        return repository.getAll();
    }

    public List<RootCategory> getAllWithProducts() {
        return repository.getAllWithProduct();
    }
}
