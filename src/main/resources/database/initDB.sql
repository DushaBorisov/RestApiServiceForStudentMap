CREATE TABLE IF NOT EXISTS users
(
    id SERIAL PRIMARY KEY,
    login VARCHAR(20),
    password VARCHAR(20),
    name VARCHAR(20),
    surname VARCHAR(20),
    age INTEGER,
    gender VARCHAR(20)
);

--DROP TABLE IF EXISTS users;

CREATE TABLE IF NOT EXISTS places
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(100),
    location VARCHAR(100),
    img VARCHAR(1000)
);

--DROP TABLE IF EXISTS places;

CREATE TABLE IF NOT EXISTS posts
(
    id SERIAL PRIMARY KEY,
    name VARCHAR(200),
    login VARCHAR(20),
    date VARCHAR(20),
    location VARCHAR(100),
    text VARCHAR(2000),
    img VARCHAR(1000)
);

--DROP TABLE IF EXISTS posts;
--