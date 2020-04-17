create table user
(
  id        int auto_increment
    primary key,
  firstname varchar(255) null,
  lastname  varchar(255) null,
  phone     varchar(255) null
);

INSERT INTO car_park.user (id, firstname, lastname, phone) VALUES (1, 'Bob', 'Sponge', '+375(17)111-11-11');

create table auth_user
(
  id       int auto_increment
    primary key,
  login    varchar(255) not null,
  password varchar(255) not null,
  role     varchar(255) not null,
  userId   int          not null,
  constraint authuser_login_uindex
    unique (login),
  constraint authuser_user_id_fk
    foreign key (userId) references user (id)
      on update cascade on delete cascade
);

INSERT INTO car_park.auth_user (id, login, password, role, userId) VALUES (1, 'admin', 'admin', 'DISPATCHER', 1);

create table car
(
  carId         int auto_increment
    primary key,
  name          varchar(255)  not null,
  model         varchar(255)  not null,
  regnumber     varchar(255)  not null,
  needforrepair int default 0 not null
);

INSERT INTO car_park.car (carId, name, model, regnumber, needforrepair) VALUES (1, 'SCANIA', 'R420', 'AA0001-7', 0);
INSERT INTO car_park.car (carId, name, model, regnumber, needforrepair) VALUES (2, 'VOLVO', 'FH12', 'AA0002-7', 0);
INSERT INTO car_park.car (carId, name, model, regnumber, needforrepair) VALUES (3, 'IVECO', 'DAILY', 'AA0003-7', 0);
INSERT INTO car_park.car (carId, name, model, regnumber, needforrepair) VALUES (4, 'Москвич', '412', 'AB0004-7', 1);

create table flightapplication
(
  id           int auto_increment
    primary key,
  driver       varchar(255) null,
  CAR          varchar(255) not null,
  datebegin    date         not null,
  dateexp      date         null,
  cargo        varchar(255) not null,
  weight       int          not null,
  flightstatus varchar(255) not null
);

INSERT INTO car_park.flightapplication (id, driver, CAR, datebegin, dateexp, cargo, weight, flightstatus) VALUES (1, 'вввв', 'MAYBACH', '2020-04-01', '2020-04-16', 'Кокаин', 20600, '1');
INSERT INTO car_park.flightapplication (id, driver, CAR, datebegin, dateexp, cargo, weight, flightstatus) VALUES (2, 'фыыфы', 'Лада', '1970-03-05', '2020-04-12', 'Металл', 10600, '2');

create table repair_request
(
  id         int auto_increment
    primary key,
  car_name   varchar(255) not null,
  reg_number varchar(255) not null,
  reason     text         not null,
  status     varchar(255) not null
);

INSERT INTO car_park.repair_request (id, car_name, reg_number, reason, status) VALUES (1, 'Москвич', 'СС1478-7', 'СЛОМАЛСЯ', 'IN_PROGRESS');

