package ru.marketplace.testdata;

import ru.marketplace.TestMatchers;
import ru.marketplace.model.City;

import java.util.List;


import static ru.marketplace.service.AbstractServiceTest.START_SEQ;
import static ru.marketplace.testdata.RegionTestData.REGION1;

public class CityTestData {
    public static final int CITY_ID = START_SEQ + 5;

    public static final City CITY1 = new City(CITY_ID, "Челябинск");
    public static final City CITY2 = new City(CITY_ID + 1, "Южноуральск");
    public static final City CITY3= new City(CITY_ID + 2, "Кыштым");
    public static final City CITY4 = new City(CITY_ID + 3, "Екатеринбург");


    public static final List<City> CITIES = List.of(CITY1, CITY2, CITY3, CITY4);

    public static City getNew() {
        return new City(null, "Созданный город");
    }

    public static City getUpdate() {
        return new City(CITY1.getId(), "Обновлённый город");
    }

    public static final TestMatchers<City> CITY_MATCHERS = TestMatchers.useFieldsComparator(City.class, "region");

}
