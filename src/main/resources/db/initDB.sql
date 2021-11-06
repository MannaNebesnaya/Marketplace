DROP TABLE IF EXISTS products;
DROP TABLE IF EXISTS user_roles;
DROP TABLE IF EXISTS users;
DROP TABLE IF EXISTS cities;
DROP TABLE IF EXISTS regions;
DROP TABLE IF EXISTS root_categories;
DROP TABLE IF EXISTS shop;
DROP SEQUENCE IF EXISTS global_seq;


CREATE SEQUENCE global_seq START WITH 100001;

CREATE TABLE shop
(
    id INTEGER PRIMARY KEY DEFAULT nextval('global_seq')
);

INSERT INTO shop (id)
VALUES ('100000');

CREATE TABLE root_categories
(
    id      INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name    VARCHAR NOT NULL,
    shop_id INTEGER NOT NULL,
    FOREIGN KEY (shop_id) REFERENCES shop (id)
    /*Подумать над каскадом*/
);

CREATE TABLE regions
(
    id   INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name VARCHAR NOT NULL
);


CREATE TABLE cities
(
    id         INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name       VARCHAR NOT NULL,
    region_id INTEGER NOT NULL,
    FOREIGN KEY (region_id) REFERENCES regions (id) ON DELETE CASCADE
);


CREATE TABLE users
(
    id           INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name         VARCHAR(25)                       NOT NULL,
    surname      VARCHAR(30)                       NOT NULL,
    email        VARCHAR                           NOT NULL,
    password     VARCHAR                           NOT NULL,
    registered   TIMESTAMP           DEFAULT now() NOT NULL,
    phone_number VARCHAR,
    city_id      INTEGER                           NOT NULL,
    enabled      BOOL                DEFAULT TRUE  NOT NULL,
    FOREIGN KEY (city_id) REFERENCES cities (id)
);

CREATE UNIQUE INDEX users_unique_email_idx ON users (email);

CREATE TABLE user_roles
(
    user_id INTEGER NOT NULL,
    role    VARCHAR,
    CONSTRAINT user_roles_idx UNIQUE (user_id, role),
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE
);

CREATE TABLE products
(
    id               INTEGER PRIMARY KEY DEFAULT nextval('global_seq'),
    name             VARCHAR(80)                       NOT NULL,
    description      TEXT                              NOT NULL,
    price            INTEGER                           NOT NULL,
    registered       TIMESTAMP           DEFAULT now() NOT NULL,
    enabled          BOOL                DEFAULT FALSE NOT NULL,
    root_category_id INTEGER                           NOT NULL,
    user_id         INTEGER                           NOT NULL,
    FOREIGN KEY (root_category_id) REFERENCES root_categories (id) ON DELETE CASCADE,
    FOREIGN KEY (user_id) REFERENCES users (id) ON DELETE CASCADE

-- Регионы доставки в продукту прикрутим позже
--     FOREIGN KEY (id_region) REFERENCES regions (id)
    --     id_region        INTEGER                           NOT NULL,
);






