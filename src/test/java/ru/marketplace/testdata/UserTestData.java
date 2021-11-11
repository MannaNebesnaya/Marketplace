package ru.marketplace.testdata;

import ru.marketplace.TestMatchers;
import ru.marketplace.model.Role;
import ru.marketplace.model.User;

import java.util.List;

import static ru.marketplace.service.AbstractServiceTest.START_SEQ;


public class UserTestData {

    public static final int ADMIN_ID = START_SEQ + 9;
    public static final int BUYER_ID = START_SEQ + 10;
    public static final int SELLER_ID = START_SEQ + 12;

    public static final User ADMIN1 = new User(
            ADMIN_ID, "Alexey", "Shevchenko", "dozory4@yandex.ru", "admin", "+79084945151", Role.ROLE_ADMIN, Role.ROLE_BUYER, Role.ROLE_SELLER);
    public static final User BUYER1 = new User(
            BUYER_ID, "Ivan", "Ivanov", "ivanov@gmail.com", "password", "+79630234528", Role.ROLE_BUYER);
    public static final User BUYER2 = new User(
            BUYER_ID + 1, "Kalyan", "Petrov", "petrov@mail.ru", "qwerty", "+79630454528", Role.ROLE_BUYER);
    public static final User SELLER1 = new User(
            SELLER_ID, "Alina", "Kapustina", "kapustina@gmail.com", "lololo12345", "+79510731232", Role.ROLE_SELLER, Role.ROLE_BUYER);

    public static final List<User> USERS = List.of(ADMIN1, BUYER1, BUYER2, SELLER1);

    public static User getNew() {
        return new User(null, "Новое имя", "Новая фамилия", "new@new.com", "newnewnew123", "+70000000000",  Role.ROLE_ADMIN, Role.ROLE_BUYER, Role.ROLE_SELLER);
    }

    public static User getUpdate() {
        return new User(ADMIN_ID, "Обновлённое имя", "Обновлённая фамилия", "update@mail.ru", "update223", "+79084325689", Role.ROLE_BUYER, Role.ROLE_SELLER);
    }

    public static final TestMatchers<User> USER_MATCHERS = TestMatchers.useFieldsComparator(User.class, "registered", "products", "cityAccommodation");
}
