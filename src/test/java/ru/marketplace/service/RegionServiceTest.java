package ru.marketplace.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.marketplace.model.City;
import ru.marketplace.model.Region;
import ru.marketplace.testdata.RegionTestData;

import java.util.List;

import static ru.marketplace.testdata.CityTestData.*;
import static ru.marketplace.testdata.RegionTestData.*;
import static ru.marketplace.testdata.RegionTestData.getNew;

class RegionServiceTest extends AbstractServiceTest {

    @Autowired
    private RegionService service;


    @Test
    void create() {
        Region newRegion = getNew();
        Region created = service.create(newRegion);
        REGION_MATCHERS.assertMatch(created, newRegion);
        REGION_MATCHERS.assertMatch(service.get(created.getId()), newRegion);
    }

    @Test
    void update() {
        Region updateRegion = updateRegion();
        service.update(updateRegion);
        REGION_MATCHERS.assertMatch(service.get(updateRegion.getId()), updateRegion);
    }

    @Test
    void get() {
        Region region = service.get(REGION_ID);
        REGION_MATCHERS.assertMatch(region, REGION1);
    }

    @Test
    void getWithCities() {
        Region region = service.getWithCities(REGION_ID);
        REGION_MATCHERS.assertMatch(region, REGION1);
        List<City> actualCities = region.getCities();
        CITY_MATCHERS.assertMatch(actualCities, CITY1, CITY2, CITY3);

    }

    @Test
    void getAll() {
        REGION_MATCHERS.assertMatch(service.getAll(), REGIONS);
    }

    @Test
    void getAllWithCities() {
        List<Region> allWithCities = service.getAllWithCities();
        REGION_MATCHERS.assertMatch(allWithCities, REGIONS);
    }
}