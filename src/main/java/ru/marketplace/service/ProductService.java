package ru.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.marketplace.model.Product;
import ru.marketplace.repository.ProductRepository;

import static ru.marketplace.util.ValidationUtil.checkNotFoundWithId;

import java.util.List;

@Service
public class ProductService {

    private final ProductRepository repository;

    @Autowired
    public ProductService(ProductRepository repository) {
        this.repository = repository;
    }

    public Product create(Product product, int userId, int categoryId) {
        Assert.notNull(product, "product must not be null");
        return repository.save(product, userId, categoryId);
    }

    public void update(Product product, int userId, int categoryId) {
        Assert.notNull(product, "product must not be null");
        checkNotFoundWithId(repository.save(product, userId, categoryId), product.getId());
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public Product get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public Product getWithUser(int id) {
        return checkNotFoundWithId(repository.getWithUser(id), id);
    }

    public List<Product> getAll() {
        return repository.getAll();
    }

    public List<Product> getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

}
