package ru.marketplace.repository;

import ru.marketplace.model.User;

import java.util.List;

public interface UserRepository {

    User save(User user, int cityId);

    boolean delete(int id);

    User get(int id);

    List<User> getAll();

    User getByEmail(String email);

    User getWithProduct(int id);
}
