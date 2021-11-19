package ru.marketplace.repository;

import ru.marketplace.model.Offer;

import java.util.List;

public interface OfferRepository {

    Offer save(Offer offer, int userId, int categoryId);

    boolean delete(int id, int userId);

    Offer get(int id);

    List<Offer> getByName(String name);

    List<Offer> getByCategory(String category);

    Offer getWithUser(int id);

    List<Offer> getAll();

    List<Offer> getAllByUser(int userId);

}
