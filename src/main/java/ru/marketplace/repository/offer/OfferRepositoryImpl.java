package ru.marketplace.repository.offer;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Repository;
import org.springframework.util.Assert;
import ru.marketplace.model.Offer;
import ru.marketplace.repository.OfferRepository;
import ru.marketplace.repository.rootcategory.CrudRootCategoryRepository;
import ru.marketplace.repository.user.CrudUserRepository;

import java.util.List;

@Repository
public class OfferRepositoryImpl implements OfferRepository {
    private static final Sort SORT_REGISTERED = Sort.by(Sort.Direction.ASC, "registered");

    private final CrudOfferRepository crudOfferRepository;
    private final CrudUserRepository crudUserRepository;
    private final CrudRootCategoryRepository crudRootCategoryRepository;

    @Autowired
    public OfferRepositoryImpl(CrudOfferRepository crudOfferRepository, CrudUserRepository crudUserRepository, CrudRootCategoryRepository crudRootCategoryRepository) {
        this.crudOfferRepository = crudOfferRepository;
        this.crudUserRepository = crudUserRepository;
        this.crudRootCategoryRepository = crudRootCategoryRepository;
    }

    @Override
    public Offer save(Offer offer, int userId, int categoryId) {
        if (!offer.isNew() && getByUser(offer.getId(), userId) == null) {
            return null;
        }
        offer.setUser(crudUserRepository.getOne(userId));
        offer.setCategory(crudRootCategoryRepository.getOne(categoryId));

        return crudOfferRepository.save(offer);
    }

    @Override
    public boolean delete(int id, int userId) {
        return crudOfferRepository.delete(id, userId) != 0;
    }

    @Override
    public Offer get(int id) {
        return crudOfferRepository.findById(id).orElse(null);
    }

    @Override
    public List<Offer> getByName(String name) {
        return crudOfferRepository.findByNameStartingWith(name);
    }

    @Override
    public List<Offer> getByCategory(String category) {
        return crudOfferRepository.getByCategory(category);
    }

    public Offer getByUser(int id, int userId) {
        return crudOfferRepository.findById(id).filter(offer -> offer.getUser().getId() == userId).orElse(null);
    }

    @Override
    public Offer getWithUser(int id) {
        return crudOfferRepository.getWithUser(id);
    }

    @Override
    public List<Offer> getAll() {
        return crudOfferRepository.findAll(SORT_REGISTERED);
    }

    @Override
    public List<Offer> getAllByUser(int userId) {
        return crudOfferRepository.getAllByUserId(userId);
    }
}
