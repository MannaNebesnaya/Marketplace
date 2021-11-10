package ru.marketplace.testdata;

import ru.marketplace.TestMatchers;
import ru.marketplace.model.Product;

import java.util.List;

import static ru.marketplace.model.AbstractBaseEntity.START_SEQ;

public class ProductTestData {

    public static final int PRODUCT_ID = START_SEQ + 13;

    public static final Product PRODUCT1 = new Product(PRODUCT_ID, "laptop", "Super laptop from Apple", 10000);
    public static final Product PRODUCT2 = new Product(PRODUCT_ID + 1, "Картофелечистка", "Лучшая на планете картофелечистка", 500);
    public static final Product PRODUCT3 = new Product(PRODUCT_ID + 2, "Репетитор русского языка", "Подготовлю за неделю к ЕГЭ", 700);
    public static final Product PRODUCT4 = new Product(PRODUCT_ID + 3, "Квартира", "Двухкомнатная квартира в центре Лондона", 500000);
    public static final Product PRODUCT5 = new Product(PRODUCT_ID + 4, "Айфон 20 PRO", "Продам айфон будущего", 5000);
    public static final Product PRODUCT6 = new Product(PRODUCT_ID + 5, "Массаж", "Быстро, дёшево, сердито", 300);
    public static final Product PRODUCT7 = new Product(PRODUCT_ID + 6, "Продам кофе", "Жаренная арабика", 100);

    public static final List<Product> PRODUCTS = List.of(PRODUCT1, PRODUCT2, PRODUCT3, PRODUCT4, PRODUCT5, PRODUCT6, PRODUCT7);

    public static final List<Product> PRODUCTS_SELLER = List.of(PRODUCT2, PRODUCT3, PRODUCT4, PRODUCT5, PRODUCT6, PRODUCT7);

    public static Product getNew() {
        return new Product(null, "Новый продукт", "Какое-то описание нового продукта", 2222);
    }

    public static Product getUpdate() {
        return new Product(PRODUCT1.getId(), "Обновлённый продукт", "Совсем другое описание", 100500);
    }

    public static final TestMatchers<Product> PRODUCT_MATCHERS = TestMatchers.useFieldsComparator(Product.class,"registered", "category", "user");
}
