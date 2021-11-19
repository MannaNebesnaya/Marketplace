package ru.marketplace.service;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.Assert;
import ru.marketplace.model.Offer;
import ru.marketplace.repository.OfferRepository;

import static ru.marketplace.util.ValidationUtil.checkNotFoundWithId;

import java.util.List;

@Service
public class OfferService {

    private final OfferRepository repository;

    @Autowired
    public OfferService(OfferRepository repository) {
        this.repository = repository;
    }

    public Offer create(Offer offer, int userId, int categoryId) {
        Assert.notNull(offer, "offer must not be null");
        return repository.save(offer, userId, categoryId);
    }

    public void update(Offer offer, int userId, int categoryId) {
        Assert.notNull(offer, "offer must not be null");
        checkNotFoundWithId(repository.save(offer, userId, categoryId), offer.getId());
    }

    public void delete(int id, int userId) {
        checkNotFoundWithId(repository.delete(id, userId), id);
    }

    public Offer get(int id) {
        return checkNotFoundWithId(repository.get(id), id);
    }

    public List<Offer> getByName(String name) {
        Assert.notNull(name, "offer name must not be null");
        return repository.getByName(name);
    }

    public List<Offer> getByCategory(String name) {
        Assert.notNull(name, "offer name must not be null");
        return repository.getByCategory(name);
    }

    public Offer getWithUser(int id) {
        return checkNotFoundWithId(repository.getWithUser(id), id);
    }

    public List<Offer> getAll() {
        return repository.getAll();
    }

    public List<Offer> getAllByUser(int userId) {
        return repository.getAllByUser(userId);
    }

}
