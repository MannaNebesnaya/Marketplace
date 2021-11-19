package ru.marketplace.testdata;

import ru.marketplace.TestMatchers;
import ru.marketplace.model.Offer;

import java.util.List;

import static ru.marketplace.service.AbstractServiceTest.START_SEQ;


public class OfferTestData {

    public static final int OFFER_ID = START_SEQ + 13;

    public static final Offer OFFER_1 = new Offer(OFFER_ID, "laptop", "Super laptop from Apple", 10000);
    public static final Offer OFFER_2 = new Offer(OFFER_ID + 1, "Картофелечистка", "Лучшая на планете картофелечистка", 500);
    public static final Offer OFFER_3 = new Offer(OFFER_ID + 2, "Репетитор русского языка", "Подготовлю за неделю к ЕГЭ", 700);
    public static final Offer OFFER_4 = new Offer(OFFER_ID + 3, "Квартира", "Двухкомнатная квартира в центре Лондона", 500000);
    public static final Offer OFFER_5 = new Offer(OFFER_ID + 4, "Айфон 20 PRO", "Продам айфон будущего", 5000);
    public static final Offer OFFER_6 = new Offer(OFFER_ID + 5, "Массаж", "Быстро, дёшево, сердито", 300);
    public static final Offer OFFER_7 = new Offer(OFFER_ID + 6, "Продам кофе", "Жаренная арабика", 100);

    public static final List<Offer> OFFERS = List.of(OFFER_1, OFFER_2, OFFER_3, OFFER_4, OFFER_5, OFFER_6, OFFER_7);

    public static final List<Offer> OFFERS_SELLER = List.of(OFFER_2, OFFER_3, OFFER_4, OFFER_5, OFFER_6, OFFER_7);

    public static Offer getNew() {
        return new Offer(null, "Новый продукт", "Какое-то описание нового продукта", 2222);
    }

    public static Offer getUpdate() {
        return new Offer(OFFER_1.getId(), "Обновлённый продукт", "Совсем другое описание", 100500);
    }

    public static final TestMatchers<Offer> OFFER_MATCHERS = TestMatchers.useFieldsComparator(Offer.class,"registered", "category", "user");
}
