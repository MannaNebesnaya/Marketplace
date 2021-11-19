package ru.marketplace.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.marketplace.model.User;
import ru.marketplace.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.marketplace.testdata.CityTestData.CITY_ID;
import static ru.marketplace.testdata.OfferTestData.OFFERS_SELLER;
import static ru.marketplace.testdata.OfferTestData.OFFER_MATCHERS;
import static ru.marketplace.testdata.UserTestData.*;

class UserServiceTest extends AbstractServiceTest {

    @Autowired
    private UserService service;

    @Test
    void create() {
        User newUser = getNew();
        User created = service.create(newUser, CITY_ID);
        Integer newId = created.getId();
        USER_MATCHERS.assertMatch(created, newUser);
        USER_MATCHERS.assertMatch(service.get(newId), newUser);
    }

    @Test
    void update() {
        User updateUser = getUpdate();
        service.update(updateUser, CITY_ID);
        USER_MATCHERS.assertMatch(service.get(ADMIN_ID), updateUser);
    }

    @Test
    void delete() {
        service.delete(SELLER_ID);
        assertThrows(NotFoundException.class, () ->
                service.get(SELLER_ID));
    }

    @Test
    void get() {
        User user = service.get(ADMIN_ID);
        USER_MATCHERS.assertMatch(user, ADMIN1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(1));
    }

    @Test
    void getWithOffer() {
        User user = service.getWithOffer(SELLER_ID);
        USER_MATCHERS.assertMatch(user, SELLER1);
        OFFER_MATCHERS.assertMatch(user.getOffers(), OFFERS_SELLER);
    }

    @Test
    void getAll() {
        USER_MATCHERS.assertMatch(service.getAll(), USERS);
    }


}