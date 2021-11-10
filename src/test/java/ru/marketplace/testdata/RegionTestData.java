package ru.marketplace.testdata;

import ru.marketplace.TestMatchers;
import ru.marketplace.model.Region;

import java.util.List;

import static ru.marketplace.model.AbstractBaseEntity.START_SEQ;

public class RegionTestData {
    public static final int REGION_ID = START_SEQ + 3;

    public static final Region REGION1 = new Region(REGION_ID, "Челябинская область");
    public static final Region REGION2 = new Region(REGION_ID + 1, "Свердловская область");

    public static final List<Region> REGIONS = List.of(REGION2, REGION1);

    public static Region getNew() {
        return new Region(null, "Созданный регион");
    }

    public static Region updateRegion() {
        return new Region(REGION_ID, "Обновленный регион");
    }


    public static final TestMatchers<Region> REGION_MATCHERS = TestMatchers.useFieldsComparator(Region.class, "cities");
}
