package ru.marketplace.repository.product;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import ru.marketplace.model.Product;
import ru.marketplace.repository.ProductRepository;
import ru.marketplace.repository.rootcategory.CrudRootCategoryRepository;
import ru.marketplace.repository.user.CrudUserRepository;

import java.util.List;

@Repository
public class ProductRepositoryImpl implements ProductRepository {
    private static final Sort SORT_REGISTERED = Sort.by(Sort.Direction.ASC, "registered");

    private final CrudProductRepository crudProductRepository;
    private final CrudUserRepository crudUserRepository;
    private final CrudRootCategoryRepository crudRootCategoryRepository;

    @Autowired
    public ProductRepositoryImpl(CrudProductRepository crudProductRepository, CrudUserRepository crudUserRepository, CrudRootCategoryRepository crudRootCategoryRepository) {
        this.crudProductRepository = crudProductRepository;
        this.crudUserRepository = crudUserRepository;
        this.crudRootCategoryRepository = crudRootCategoryRepository;
    }

    @Override
    public Product save(Product product, int userId, int categoryId) {
        if (!product.isNew() && getByUser(product.getId(), userId) == null) {
            return null;
        }
        product.setUser(crudUserRepository.getOne(userId));
        product.setCategory(crudRootCategoryRepository.getOne(categoryId));

        return crudProductRepository.save(product);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudProductRepository.delete(id, userId) != 0;
    }

    @Override
    public Product get(int id) {
        return crudProductRepository.findById(id).orElse(null);
    }

    public Product getByUser(int id, int userId) {
        return crudProductRepository.findById(id).filter(product -> product.getUser().getId() == userId).orElse(null);
    }

    @Override
    public Product getWithUser(int id) {
        return crudProductRepository.getWithUser(id);
    }

    @Override
    public List<Product> getAll() {
        return crudProductRepository.findAll(SORT_REGISTERED);
    }

    @Override
    public List<Product> getAllByUser(int userId) {
        return crudProductRepository.getAllByUserId(userId);
    }
}
