package ru.marketplace.testdata;


import ru.marketplace.TestMatchers;
import ru.marketplace.model.RootCategory;

import java.util.List;

import static ru.marketplace.service.AbstractServiceTest.START_SEQ;


public class RootCategoryTestData {
    public static final int ROOT_CATEGORY_ID = START_SEQ;

    public static final RootCategory ROOT_CATEGORY1 = new RootCategory(ROOT_CATEGORY_ID, "buy_sell");
    public static final RootCategory ROOT_CATEGORY2 = new RootCategory(ROOT_CATEGORY_ID + 1, "services");
    public static final RootCategory ROOT_CATEGORY3 = new RootCategory(ROOT_CATEGORY_ID + 2, "real_estate");

    public static final List<RootCategory> ROOT_CATEGORIES = List.of(ROOT_CATEGORY1, ROOT_CATEGORY2, ROOT_CATEGORY3);

    public static RootCategory getNew() {
        return new RootCategory(null, "Созданная категория");
    }

    public static RootCategory getUpdate() {
        return new RootCategory(ROOT_CATEGORY1.getId(), "Обновлённая категория");
    }

    public static final TestMatchers<RootCategory> ROOT_CATEGORY_MATCHERS = TestMatchers.useFieldsComparator(RootCategory.class, "products");
}
