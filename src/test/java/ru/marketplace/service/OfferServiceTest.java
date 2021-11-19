package ru.marketplace.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.marketplace.model.Offer;
import ru.marketplace.util.exception.NotFoundException;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;
import static ru.marketplace.testdata.OfferTestData.*;
import static ru.marketplace.testdata.OfferTestData.getUpdate;
import static ru.marketplace.testdata.OfferTestData.getNew;
import static ru.marketplace.testdata.RootCategoryTestData.ROOT_CATEGORY_ID;
import static ru.marketplace.testdata.UserTestData.*;

class OfferServiceTest extends AbstractServiceTest {

    @Autowired
    private OfferService service;

    @Test
    void create() {
        Offer newOffer = getNew();
        Offer created = service.create(newOffer, ADMIN_ID, ROOT_CATEGORY_ID);
        Integer newId = created.getId();
        OFFER_MATCHERS.assertMatch(created, newOffer);
        OFFER_MATCHERS.assertMatch(service.get(newId), newOffer);
    }

    @Test
    void update() {
        Offer updateOffer = getUpdate();
        service.update(updateOffer, ADMIN_ID, ROOT_CATEGORY_ID);
        OFFER_MATCHERS.assertMatch(service.get(OFFER_ID), updateOffer);
    }

    @Test
    void delete() {
        service.delete(OFFER_ID, ADMIN_ID);
        assertThrows(NotFoundException.class, () ->
                service.get(OFFER_ID));
    }

    @Test
    void get() {
        Offer offer = service.get(OFFER_ID);
        OFFER_MATCHERS.assertMatch(offer, OFFER_1);
    }

    @Test
    void getByName() {
        List<Offer> offer = service.getByName(OFFER_1.getName());
        OFFER_MATCHERS.assertMatch(offer, OFFER_1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(1));
    }


    @Test
    void getWithUser() {
        Offer offer = service.getWithUser(OFFER_ID);
        OFFER_MATCHERS.assertMatch(offer, OFFER_1);
        USER_MATCHERS.assertMatch(offer.getUser(), ADMIN1);
    }

    @Test
    void getAll() {
        OFFER_MATCHERS.assertMatch(service.getAll(), OFFERS);
    }

    @Test
    void getAllByUser() {
        OFFER_MATCHERS.assertMatch(service.getAllByUser(SELLER_ID), OFFERS_SELLER);
    }
}