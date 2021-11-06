DELETE FROM products;
DELETE FROM user_roles;
DELETE FROM users;
DELETE FROM cities;
DELETE FROM regions;
DELETE FROM root_categories;
-- DELETE FROM shop;
ALTER SEQUENCE global_seq RESTART WITH 100001;


INSERT INTO root_categories (name, shop_id)
VALUES ('buy_sell', 100000),
       ('services', 100000),
       ('real_estate', 100000),
       ('job', 100000);

INSERT INTO regions(id, name)
VALUES (100005,'Челябинская область'),
       (100006,'Свердловская область');

INSERT INTO cities (name, region_id)
VALUES ('Челябинск', 100005),
       ('Южноуральск', 100005),
       ('Кыштым', 100005),
       ('Екатеринбург', 100006);



INSERT INTO users (name, surname, email, password, phone_number, city_id)
VALUES ('Alexey', 'Shevchenko', 'dozory4@yandex.ru', 'admin', '+79084945151', 100005),
       ('Ivan', 'Ivanov', 'ivanov@gmail.com', 'password', '+79630234528', 100006),
       ('Kalyan', 'Petrov', 'petrov@mail.ru', 'qwerty', '+79630454528', 100007),
       ('Alina', 'Kapustina', 'kapustina@gmail.com', 'lololo12345', '+79510731232', 100008);


INSERT INTO user_roles (role, user_id) VALUES
       ('ROLE_ADMIN', 100009),
       ('ROLE_BUYER', 100010),
       ('ROLE_BUYER', 100011),
       ('ROLE_BUYER', 100012),
       ('ROLE_SELLER', 100012);


INSERT INTO products (name, description, price, root_category_id, user_id)
VALUES ('laptop', 'Super laptop from Apple', 1000, 100002, 100012)


