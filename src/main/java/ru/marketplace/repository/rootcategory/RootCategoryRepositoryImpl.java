package ru.marketplace.repository.rootcategory;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import ru.marketplace.model.RootCategory;
import ru.marketplace.repository.RootCategoryRepository;

import java.util.List;

@Repository
public class RootCategoryRepositoryImpl implements RootCategoryRepository {

    private final CrudRootCategoryRepository crudRootCategoryRepository;

    @Autowired
    public RootCategoryRepositoryImpl(CrudRootCategoryRepository crudRootCategoryRepository) {
        this.crudRootCategoryRepository = crudRootCategoryRepository;
    }

    @Override
    public RootCategory save(RootCategory category) {
        return crudRootCategoryRepository.save(category);
    }

    @Override
    public RootCategory get(int id) {
        return crudRootCategoryRepository.findById(id).orElse(null);
    }

    @Override
    public RootCategory getWithOffers(int id) {
        return crudRootCategoryRepository.getWithOffers(id);
    }

    @Override
    public List<RootCategory> getAll() {
        return crudRootCategoryRepository.findAll();
    }

    @Override
    public List<RootCategory> getAllWithOffer() {
        return crudRootCategoryRepository.getAllWithOffers();
    }
}
