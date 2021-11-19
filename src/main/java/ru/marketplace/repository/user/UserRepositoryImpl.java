package ru.marketplace.repository.user;

import org.springframework.stereotype.Repository;
import ru.marketplace.model.User;
import ru.marketplace.repository.UserRepository;
import ru.marketplace.repository.city.CrudCityRepository;

import java.util.List;

@Repository
public class UserRepositoryImpl implements UserRepository {

    private final CrudUserRepository crudUserRepository;
    private final CrudCityRepository crudCityRepository;

    public UserRepositoryImpl(CrudUserRepository crudUserRepository, CrudCityRepository crudCityRepository) {
        this.crudUserRepository = crudUserRepository;
        this.crudCityRepository = crudCityRepository;
    }

    @Override
    public User save(User user, int cityId) {
        user.setCityAccommodation(crudCityRepository.getOne(cityId));

        return crudUserRepository.save(user);
    }

    @Override
    public boolean delete(int id) {
        return crudUserRepository.delete(id) != 0;
    }

    @Override
    public User get(int id) {
        return crudUserRepository.findById(id).orElse(null);
    }

    @Override
    public User getWithOffer(int id) {
        return crudUserRepository.getWithOffers(id);
    }

    @Override
    public User getByEmail(String email) {
        return null;
    }

    @Override
    public List<User> getAll() {
        return crudUserRepository.getAll();
    }

}
