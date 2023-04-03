-- database tables

use card;
DROP TABLE IF EXISTS credit_card;
CREATE TABLE credit_card (
    id bigint not null auto_increment,
    cvv varchar(30),
    expiration_date varchar(30),
    PRIMARY KEY (id)
);


use cardholder;
DROP TABLE IF EXISTS credit_card_holder;
CREATE TABLE credit_card_holder (
    id bigint not null auto_increment,
    first_name varchar(30),
    last_name varchar(30),
    zip_code varchar(10),
    credit_card_id bigint,
    PRIMARY KEY (id)
);


use pan;
DROP TABLE IF EXISTS credit_card_pan;
CREATE TABLE credit_card_pan (
    id bigint not null auto_increment,
    credit_card_number varchar(30),
    credit_card_id bigint,
    PRIMARY KEY (id)
);
