package ru.marketplace.repository;

import ru.marketplace.model.RootCategory;

import java.util.List;

public interface RootCategoryRepository {

    RootCategory save(RootCategory category);

    RootCategory get(int id);

    RootCategory getWithOffers(int id);

    List<RootCategory> getAll();

    List<RootCategory> getAllWithOffer();
}
