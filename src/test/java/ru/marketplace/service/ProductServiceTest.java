package ru.marketplace.service;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import ru.marketplace.model.Product;
import ru.marketplace.util.exception.NotFoundException;

import static org.junit.jupiter.api.Assertions.*;
import static ru.marketplace.testdata.ProductTestData.*;
import static ru.marketplace.testdata.ProductTestData.getUpdate;
import static ru.marketplace.testdata.ProductTestData.getNew;
import static ru.marketplace.testdata.RootCategoryTestData.ROOT_CATEGORY_ID;
import static ru.marketplace.testdata.UserTestData.*;

class ProductServiceTest extends AbstractServiceTest {

    @Autowired
    private ProductService service;

    @Test
    void create() {
        Product newProduct = getNew();
        Product created = service.create(newProduct, ADMIN_ID, ROOT_CATEGORY_ID);
        Integer newId = created.getId();
        PRODUCT_MATCHERS.assertMatch(created, newProduct);
        PRODUCT_MATCHERS.assertMatch(service.get(newId), newProduct);
    }

    @Test
    void update() {
        Product updateProduct = getUpdate();
        service.update(updateProduct, ADMIN_ID, ROOT_CATEGORY_ID);
        PRODUCT_MATCHERS.assertMatch(service.get(PRODUCT_ID), updateProduct);
    }

    @Test
    void delete() {
        service.delete(PRODUCT_ID, ADMIN_ID);
        assertThrows(NotFoundException.class, () ->
                service.get(PRODUCT_ID));
    }

    @Test
    void get() {
        Product product = service.get(PRODUCT_ID);
        PRODUCT_MATCHERS.assertMatch(product, PRODUCT1);
    }

    @Test
    void getNotFound() {
        assertThrows(NotFoundException.class, () ->
                service.get(1));
    }

    @Test
    void getWithUser() {
        Product product = service.getWithUser(PRODUCT_ID);
        PRODUCT_MATCHERS.assertMatch(product, PRODUCT1);
        USER_MATCHERS.assertMatch(product.getUser(), ADMIN1);
    }

    @Test
    void getAll() {
        PRODUCT_MATCHERS.assertMatch(service.getAll(), PRODUCTS);
    }

    @Test
    void getAllByUser() {
        PRODUCT_MATCHERS.assertMatch(service.getAllByUser(SELLER_ID), PRODUCTS_SELLER);
    }
}