create table users
(
    login       varchar(50) primary key,
    password    varchar(50)  not null,
    first_name  varchar(250) not null,
    last_name   varchar(250) not null,
    telegram_id bigint       not null
);

create table pages

(
    id             bigint primary key,
    name           varchar(100),
    url            varchar(2000) not null,
    parsing_x_path varchar       not null

);

create sequence sq_pages_id start with 1 increment by 1;

create table subscriptions

(
    id      bigint primary key,
    user_id varchar(50),
    page_id bigint
);

create sequence sq_subscriptions_id start with 1 increment by 1;


create table parsing_results

(
    id                bigint primary key,
    parsing_date_time timestamp,
    result            varchar(4000),
    page_id           bigint,
    sent              boolean
);

create sequence sq_parsing_results_id start with 1 increment by 1;

INSERT INTO users
-- Здесь нужно подставить Telegram ID тренера, узнать можно у бота @userinfobot https://t.me/userinfobot --
VALUES ('user', 'пароль', 'Имя', 'Фамилия', '123456');
INSERT INTO pages
VALUES (NEXT VALUE FOR sq_pages_id, 'Курс USD', 'https://www.cbr.ru/',
             '//div[@class=''main-indicator_rate''][2]/div[contains(@class,''mono-num'')][2]/text()');
INSERT INTO subscriptions
VALUES (NEXT VALUE FOR sq_subscriptions_id, 'user', 1);
INSERT INTO parsing_results
VALUES (NEXT VALUE FOR sq_parsing_results_id, '2021-01-01', 'result', 1, false);
