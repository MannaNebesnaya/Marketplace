package ru.marketplace.service;

import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Disabled;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import ru.marketplace.model.City;

import static ru.marketplace.testdata.CityTestData.getNew;

import static ru.marketplace.testdata.CityTestData.*;
import static ru.marketplace.testdata.RegionTestData.REGION1;
import static ru.marketplace.testdata.RegionTestData.REGION_ID;

class CityServiceTest extends AbstractServiceTest {

    @Autowired
    CityService service;


    @Test
    void create() {
        City newCity = getNew();
        City created = service.create(newCity, REGION_ID);
        Integer newId = created.getId();
        newCity.setId(newId);
        CITY_MATCHERS.assertMatch(created, newCity);
        CITY_MATCHERS.assertMatch(service.get(newId), newCity);
    }

    @Test
    void update() {
        City updateCity = getUpdate();
        updateCity.setRegion(REGION1);
        service.update(updateCity, REGION_ID);
        CITY_MATCHERS.assertMatch(service.get(updateCity.getId()), updateCity);

    }

    @Test
    void get() {
        City city = service.get(CITY_ID);
        CITY_MATCHERS.assertMatch(city, CITY1);
    }

    @Test
    void getNotFound() throws Exception {

    }

    @Test
    void getAll() {
        CITY_MATCHERS.assertMatch(service.getAll(), CITIES);
    }

    @Test
    void getAllByRegion() {
        CITY_MATCHERS.assertMatch(service.getAllByRegion(REGION_ID), CITY1, CITY2, CITY3);

    }

}