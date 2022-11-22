-- Created by Vertabelo (http://vertabelo.com)
-- Last modification date: 2022-11-22 11:40:26.48

-- tables
-- Table: breed
CREATE TABLE breed (
                       id serial  NOT NULL,
                       name varchar(20)  NOT NULL,
                       description varchar(200)  NOT NULL,
                       CONSTRAINT breed_pk PRIMARY KEY (id)
);

-- Table: city
CREATE TABLE city (
                      id serial  NOT NULL,
                      name varchar(20)  NOT NULL,
                      CONSTRAINT city_pk PRIMARY KEY (id)
);

-- Table: contact
CREATE TABLE contact (
                         id serial  NOT NULL,
                         e_mail varchar(30)  NOT NULL,
                         city varchar(30)  NOT NULL,
                         firstname varchar(30)  NOT NULL,
                         lastname varchar(30)  NOT NULL,
                         adittion_information varchar(200)  NULL,
                         CONSTRAINT contact_pk PRIMARY KEY (id)
);

-- Table: contact_photo
CREATE TABLE contact_photo (
                               id serial  NOT NULL,
                               photo_id int  NOT NULL,
                               photo_name varchar(30)  NOT NULL,
                               contact_id int  NOT NULL,
                               CONSTRAINT contact_photo_pk PRIMARY KEY (id)
);

-- Table: dog
CREATE TABLE dog (
                     id serial  NOT NULL,
                     owner_user_id int  NOT NULL,
                     name varchar(30)  NOT NULL,
                     age int  NOT NULL,
                     adittional_information varchar(300)  NULL,
                     CONSTRAINT dog_pk PRIMARY KEY (id)
);

-- Table: dog_breed
CREATE TABLE dog_breed (
                           id serial  NOT NULL,
                           dog_id int  NOT NULL,
                           breed_id int  NOT NULL,
                           CONSTRAINT dog_breed_pk PRIMARY KEY (id)
);

-- Table: dog_picture
CREATE TABLE dog_picture (
                             id serial  NOT NULL,
                             dog_id int  NOT NULL,
                             picture_id int  NOT NULL,
                             CONSTRAINT dog_picture_pk PRIMARY KEY (id)
);

-- Table: location
CREATE TABLE location (
                          id serial  NOT NULL,
                          city_id int  NOT NULL,
                          address varchar(50)  NOT NULL,
                          CONSTRAINT location_pk PRIMARY KEY (id)
);

-- Table: order_price
CREATE TABLE order_price (
                             id serial  NOT NULL,
                             price_id int  NOT NULL,
                             set_order_id int  NOT NULL,
                             amount int  NOT NULL,
                             CONSTRAINT order_price_pk PRIMARY KEY (id)
);

-- Table: photo
CREATE TABLE photo (
                       id serial  NOT NULL,
                       name varchar(30)  NOT NULL,
                       CONSTRAINT photo_pk PRIMARY KEY (id,name)
);

-- Table: picture
CREATE TABLE picture (
                         id serial  NOT NULL,
                         name varchar(50)  NOT NULL,
                         CONSTRAINT picture_pk PRIMARY KEY (id)
);

-- Table: price
CREATE TABLE price (
                       id serial  NOT NULL,
                       dog_size varchar(255)  NOT NULL,
                       weight_type varchar(255)  NOT NULL,
                       price int  NOT NULL,
                       CONSTRAINT price_pk PRIMARY KEY (id)
);

-- Table: role
CREATE TABLE role (
                      id serial  NOT NULL,
                      type varchar(20)  NOT NULL,
                      CONSTRAINT role_pk PRIMARY KEY (id)
);

-- Table: set_order
CREATE TABLE set_order (
                           id serial  NOT NULL,
                           walker_user_id int  NOT NULL,
                           dog_id int  NOT NULL,
                           location_id int  NOT NULL,
                           date date  NOT NULL,
                           time time  NOT NULL,
                           CONSTRAINT walking_pk PRIMARY KEY (id)
);

-- Table: user
CREATE TABLE "user" (
                        id serial  NOT NULL,
                        contact_id int  NOT NULL,
                        username varchar(10)  NOT NULL,
                        password int  NOT NULL,
                        role varchar(20)  NOT NULL,
                        CONSTRAINT user_pk PRIMARY KEY (id)
);

-- Table: user_role
CREATE TABLE user_role (
                           id serial  NOT NULL,
                           user_id int  NOT NULL,
                           role_id int  NOT NULL,
                           CONSTRAINT user_role_pk PRIMARY KEY (id)
);

-- foreign keys
-- Reference: Table_8_role (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT Table_8_role
    FOREIGN KEY (role_id)
        REFERENCES role (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: Table_8_user (table: user_role)
ALTER TABLE user_role ADD CONSTRAINT Table_8_user
    FOREIGN KEY (user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: contact_photo_contact (table: contact_photo)
ALTER TABLE contact_photo ADD CONSTRAINT contact_photo_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: contact_photo_photo (table: contact_photo)
ALTER TABLE contact_photo ADD CONSTRAINT contact_photo_photo
    FOREIGN KEY (photo_id, photo_name)
        REFERENCES photo (id, name)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: dog_breed_breed (table: dog_breed)
ALTER TABLE dog_breed ADD CONSTRAINT dog_breed_breed
    FOREIGN KEY (breed_id)
        REFERENCES breed (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: dog_breed_dog (table: dog_breed)
ALTER TABLE dog_breed ADD CONSTRAINT dog_breed_dog
    FOREIGN KEY (dog_id)
        REFERENCES dog (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: dog_picture_dog (table: dog_picture)
ALTER TABLE dog_picture ADD CONSTRAINT dog_picture_dog
    FOREIGN KEY (dog_id)
        REFERENCES dog (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: dog_picture_picture (table: dog_picture)
ALTER TABLE dog_picture ADD CONSTRAINT dog_picture_picture
    FOREIGN KEY (picture_id)
        REFERENCES picture (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: dog_user (table: dog)
ALTER TABLE dog ADD CONSTRAINT dog_user
    FOREIGN KEY (owner_user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: location_city (table: location)
ALTER TABLE location ADD CONSTRAINT location_city
    FOREIGN KEY (city_id)
        REFERENCES city (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_price_price (table: order_price)
ALTER TABLE order_price ADD CONSTRAINT order_price_price
    FOREIGN KEY (price_id)
        REFERENCES price (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: order_price_set_order (table: order_price)
ALTER TABLE order_price ADD CONSTRAINT order_price_set_order
    FOREIGN KEY (set_order_id)
        REFERENCES set_order (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: set_order_dog (table: set_order)
ALTER TABLE set_order ADD CONSTRAINT set_order_dog
    FOREIGN KEY (dog_id)
        REFERENCES dog (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: set_order_location (table: set_order)
ALTER TABLE set_order ADD CONSTRAINT set_order_location
    FOREIGN KEY (location_id)
        REFERENCES location (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: set_order_user (table: set_order)
ALTER TABLE set_order ADD CONSTRAINT set_order_user
    FOREIGN KEY (walker_user_id)
        REFERENCES "user" (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- Reference: user_contact (table: user)
ALTER TABLE "user" ADD CONSTRAINT user_contact
    FOREIGN KEY (contact_id)
        REFERENCES contact (id)
        NOT DEFERRABLE
            INITIALLY IMMEDIATE
;

-- End of file.

