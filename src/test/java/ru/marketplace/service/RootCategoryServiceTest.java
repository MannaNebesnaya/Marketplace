package ru.marketplace.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.marketplace.model.RootCategory;

import java.util.List;

import static ru.marketplace.testdata.ProductTestData.*;
import static ru.marketplace.testdata.RootCategoryTestData.*;
import static ru.marketplace.testdata.RootCategoryTestData.getNew;
import static ru.marketplace.testdata.RootCategoryTestData.getUpdate;

class RootCategoryServiceTest extends AbstractServiceTest {

    @Autowired
    private RootCategoryService service;

    @Test
    void create() {
        RootCategory newCategory = getNew();
        RootCategory created = service.create(newCategory);
        ROOT_CATEGORY_MATCHERS.assertMatch(created, newCategory);
        ROOT_CATEGORY_MATCHERS.assertMatch(service.get(created.getId()), newCategory);

    }

    @Test
    void update() {
        RootCategory updateCategory = getUpdate();
        service.update(updateCategory);
        ROOT_CATEGORY_MATCHERS.assertMatch(service.get(updateCategory.getId()), updateCategory);
    }

    @Test
    void get() {
        RootCategory category = service.get(ROOT_CATEGORY_ID);
        ROOT_CATEGORY_MATCHERS.assertMatch(category, ROOT_CATEGORY1);

    }

    @Test
    void getWithProducts() {
        RootCategory category = service.getWithProducts(ROOT_CATEGORY_ID);
        ROOT_CATEGORY_MATCHERS.assertMatch(category, ROOT_CATEGORY1);
        PRODUCT_MATCHERS.assertMatch(category.getProducts(), PRODUCT1, PRODUCT2, PRODUCT5, PRODUCT7);

    }

    @Test
    void getAll() {
        List<RootCategory> categories = service.getAll();
        ROOT_CATEGORY_MATCHERS.assertMatch(categories, ROOT_CATEGORIES);
    }

    @Test
    void getAllWithProducts() {
        List<RootCategory> categories = service.getAllWithProducts();
        ROOT_CATEGORY_MATCHERS.assertMatch(categories, ROOT_CATEGORIES);
    }
}