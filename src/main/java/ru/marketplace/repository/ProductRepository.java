package ru.marketplace.repository;

import ru.marketplace.model.Product;

import java.util.List;

public interface ProductRepository {

    Product save(Product product, int userId, int categoryId);

    boolean delete(int id, int userId);

    Product get(int id);

    Product getWithUser(int id);

    List<Product> getAll();

    List<Product> getAllByUser(int userId);

}
