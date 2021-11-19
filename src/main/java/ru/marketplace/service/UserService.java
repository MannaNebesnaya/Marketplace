package ru.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.marketplace.model.User;
import ru.marketplace.repository.UserRepository;

import java.util.List;

import static ru.marketplace.util.ValidationUtil.checkNotFoundWithId;

@Service
public class UserService {

    private final UserRepository repository;

    @Autowired
    public UserService(UserRepository repository) {
        this.repository = repository;
    }

    public User create(User user, int cityId){
        Assert.notNull(user, "user must not be null");
        return repository.save(user, cityId);
    }

    public void update(User user, int cityId){
        Assert.notNull(user, "user must not be null");
        checkNotFoundWithId(repository.save(user, cityId), user.getId());
    }

    public void delete(int id) {
        checkNotFoundWithId(repository.delete(id), id);
    }

    public User get(int id){
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<User> getAll() {
        return repository.getAll();
    }

    public User getWithOffer(int id){
        return repository.getWithOffer(id);
    }
}
