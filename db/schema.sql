
CREATE TABLE accident (
  id serial primary key,
  name varchar(255),
  text varchar(255),
  address varchar(255),
  type_id int references accident_type(id)
);

CREATE TABLE accident_type (
  id serial primary key,
  name varchar(255)
);

CREATE TABLE accident_rule (
  id serial primary key,
  name varchar(255)
);

CREATE TABLE type_rule (
  id serial primary key,
  acciident_id int references accident(id),
  rule_id int references accident_rule(id)
);

insert into accident_type(name) values
                                     ('автомобиль и человек'),
                                     ('автомобиль и велосипед'),
                                     ('автомобиль и пешеход');

insert into accident_rule(name) values
                                     ('list 1'),
                                     ('list 2'),
                                     ('list 3');

