DROP TABLE IF EXISTS AIRCRAFTS;

CREATE TABLE AIRCRAFTS (
  id INT AUTO_INCREMENT  PRIMARY KEY,
  code VARCHAR(250) NOT NULL,
  description VARCHAR(250) NOT NULL,
  UNIQUE (code)
);

DROP TABLE IF EXISTS FLIGHTS;

CREATE TABLE FLIGHTS (
    id INT AUTO_INCREMENT  PRIMARY KEY,
    type VARCHAR(250),
    origin VARCHAR(250),
    destination VARCHAR(250),
    departure_date TIMESTAMP,
    arrival_date TIMESTAMP,
    aircraft_id INT,
    FOREIGN KEY (aircraft_id) REFERENCES aircrafts(id) ON DELETE CASCADE
)