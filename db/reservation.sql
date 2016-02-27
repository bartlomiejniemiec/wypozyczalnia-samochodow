CREATE TABLE reservation(
id SERIAL primary key,
car_id INTEGER REFERENCES car(id),
begin_date DATE,
end_date DATE,
total_price INTEGER
);