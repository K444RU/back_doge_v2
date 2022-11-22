-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-22 14:49:58.843

-- tables
-- Table: breed
CREATE TABLE breed
(
    id   serial      NOT NULL,
    name varchar(20) NOT NULL,
    CONSTRAINT breed_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city
(
    id   serial       NOT NULL,
    name varchar(255) NOT NULL,
    CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact
(
    id                   serial       NOT NULL,
    e_mail               varchar(30)  NOT NULL,
    city                 varchar(30)  NOT NULL,
    firstname            varchar(30)  NOT NULL,
    lastname             varchar(30)  NOT NULL,
    adittion_information varchar(200) NULL,
    photo_data           bytea        NULL,
    CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: dog
CREATE TABLE dog
(
    id                     serial       NOT NULL,
    owner_user_id          int          NOT NULL,
    name                   varchar(30)  NOT NULL,
    age                    int          NOT NULL,
    adittional_information varchar(300) NULL,
    CONSTRAINT dog_pk PRIMARY KEY (id)
);

-- Table: dog_breed
CREATE TABLE dog_breed
(
    id       serial NOT NULL,
    dog_id   int    NOT NULL,
    breed_id int    NOT NULL,
    CONSTRAINT dog_breed_pk PRIMARY KEY (id)
);

-- Table: dog_order
CREATE TABLE dog_order
(
    id       serial NOT NULL,
    dog_id   int    NOT NULL,
    order_id int    NOT NULL,
    CONSTRAINT dog_order_pk PRIMARY KEY (id)
);

-- Table: dog_picture
CREATE TABLE dog_picture
(
    id         serial NOT NULL,
    dog_id     int    NOT NULL,
    picture_id int    NOT NULL,
    CONSTRAINT dog_picture_pk PRIMARY KEY (id)
);

-- Table: order
CREATE TABLE "order"
(
    id           serial NOT NULL,
    walking_id   int    NOT NULL,
    walking_date date   NOT NULL,
    time_from    time   NOT NULL,
    time_to      time   NOT NULL,
    address      int    NOT NULL,
    total_price  int    NOT NULL,
    CONSTRAINT order_pk PRIMARY KEY (id)
);

-- Table: picture
CREATE TABLE picture
(
    id   serial NOT NULL,
    data bytea  NULL,
    CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: price
CREATE TABLE price
(
    id      serial NOT NULL,
    size_id int    NOT NULL,
    hour    int    NOT NULL,
    CONSTRAINT price_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role
(
    id   serial      NOT NULL,
    type varchar(20) NOT NULL,
    CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: size
CREATE TABLE size
(
    id    serial      NOT NULL,
    type  varchar(30) NOT NULL,
    price int         NOT NULL,
    CONSTRAINT size_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user"
(
    id         serial      NOT NULL,
    role_id    int         NOT NULL,
    contact_id int         NOT NULL,
    username   varchar(20) NOT NULL,
    password   int         NOT NULL,
    CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: walking
CREATE TABLE walking
(
    id             serial NOT NULL,
    walker_user_id int    NOT NULL,
    city_id        int    NOT NULL,
    date_from      date   NOT NULL,
    date_to        date   NOT NULL,
    time_from      time   NOT NULL,
    time_to        time   NOT NULL,
    CONSTRAINT walking_pk PRIMARY KEY (id)
);

-- Table: walking_size
CREATE TABLE walking_size
(
    id         serial NOT NULL,
    walking_id int    NOT NULL,
    size_id    int    NOT NULL,
    CONSTRAINT walking_size_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: dog_breed_breed (table: dog_breed)
ALTER TABLE dog_breed
    ADD CONSTRAINT dog_breed_breed
        FOREIGN KEY (breed_id)
            REFERENCES breed (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: dog_breed_dog (table: dog_breed)
ALTER TABLE dog_breed
    ADD CONSTRAINT dog_breed_dog
        FOREIGN KEY (dog_id)
            REFERENCES dog (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: dog_order_dog (table: dog_order)
ALTER TABLE dog_order
    ADD CONSTRAINT dog_order_dog
        FOREIGN KEY (dog_id)
            REFERENCES dog (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: dog_order_order (table: dog_order)
ALTER TABLE dog_order
    ADD CONSTRAINT dog_order_order
        FOREIGN KEY (order_id)
            REFERENCES "order" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: dog_picture_dog (table: dog_picture)
ALTER TABLE dog_picture
    ADD CONSTRAINT dog_picture_dog
        FOREIGN KEY (dog_id)
            REFERENCES dog (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: dog_picture_picture (table: dog_picture)
ALTER TABLE dog_picture
    ADD CONSTRAINT dog_picture_picture
        FOREIGN KEY (picture_id)
            REFERENCES picture (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: dog_user (table: dog)
ALTER TABLE dog
    ADD CONSTRAINT dog_user
        FOREIGN KEY (owner_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: order_walking (table: order)
ALTER TABLE "order"
    ADD CONSTRAINT order_walking
        FOREIGN KEY (walking_id)
            REFERENCES walking (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: price_size (table: price)
ALTER TABLE price
    ADD CONSTRAINT price_size
        FOREIGN KEY (size_id)
            REFERENCES size (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_contact
        FOREIGN KEY (contact_id)
            REFERENCES contact (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: user_role (table: user)
ALTER TABLE "user"
    ADD CONSTRAINT user_role
        FOREIGN KEY (role_id)
            REFERENCES role (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: walking_city (table: walking)
ALTER TABLE walking
    ADD CONSTRAINT walking_city
        FOREIGN KEY (city_id)
            REFERENCES city (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: walking_size_size (table: walking_size)
ALTER TABLE walking_size
    ADD CONSTRAINT walking_size_size
        FOREIGN KEY (size_id)
            REFERENCES size (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: walking_size_walking (table: walking_size)
ALTER TABLE walking_size
    ADD CONSTRAINT walking_size_walking
        FOREIGN KEY (walking_id)
            REFERENCES walking (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- Reference: walking_user (table: walking)
ALTER TABLE walking
    ADD CONSTRAINT walking_user
        FOREIGN KEY (walker_user_id)
            REFERENCES "user" (id)
            NOT DEFERRABLE
                INITIALLY IMMEDIATE
;

-- End of file.

