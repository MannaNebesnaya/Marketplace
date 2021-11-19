DELETE
FROM offers;
DELETE
FROM user_roles;
DELETE
FROM users;
DELETE
FROM cities;
DELETE
FROM regions;
DELETE
FROM root_categories;
ALTER SEQUENCE global_seq RESTART WITH 100001;

INSERT INTO root_categories (name)
VALUES ('goods'), /*100001*/
       ('services'), /*100002*/
       ('realty'); /*100003*/

INSERT INTO regions(name)
VALUES ('Челябинская область'), /*100004*/
       ('Свердловская область'); /*100005*/

INSERT INTO cities (name, region_id)
VALUES ('Челябинск', 100004), /*100006*/
       ('Южноуральск', 100004), /*100007*/
       ('Кыштым', 100004),      /*100008*/
       ('Екатеринбург', 100005); /*100009*/


INSERT INTO users (name, surname, email, password, phone_number, city_id)
VALUES ('Alexey', 'Shevchenko', 'dozory4@yandex.ru', 'admin', '+79084945151', 100006), /*100010*/
       ('Ivan', 'Ivanov', 'ivanov@gmail.com', 'password', '+79630234528', 100007), /*100011*/
       ('Kalyan', 'Petrov', 'petrov@mail.ru', 'qwerty', '+79630454528', 100008), /*100012*/
       ('Alina', 'Kapustina', 'kapustina@gmail.com', 'lololo12345', '+79510731232', 100009); /*100013*/


INSERT INTO user_roles (role, user_id)
VALUES ('ROLE_ADMIN', 100010),
       ('ROLE_BUYER', 100010),
       ('ROLE_SELLER', 100010),
       ('ROLE_BUYER', 100011),
       ('ROLE_BUYER', 100012),
       ('ROLE_SELLER', 100013),
       ('ROLE_BUYER', 100013);



INSERT INTO offers (name, description, price, root_category_id, user_id)
VALUES ('laptop', 'Super laptop from Apple', 10000, 100001, 100010),                        /*100014*/
       ('Картофелечистка', 'Лучшая на планете картофелечистка', 500, 100001, 100013),        /*100015*/
       ('Репетитор русского языка', 'Подготовлю за неделю к ЕГЭ', 700, 100002, 100013),      /*100016*/
       ('Квартира', 'Двухкомнатная квартира в центре Лондона', 500000, 100003, 100013),     /*100017*/
       ('Айфон 20 PRO', 'Продам айфон будущего', 5000, 100001, 100013),                          /*100018*/
       ('Массаж', 'Быстро, дёшево, сердито', 300, 100002, 100013),                          /*100019*/
       ('Продам кофе', 'Жаренная арабика', 100, 100001, 100013);                          /*100020*/


