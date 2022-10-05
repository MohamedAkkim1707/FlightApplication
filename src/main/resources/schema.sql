DROP TABLE IF EXISTS FLIGHT;
CREATE TABLE FLIGHT
(
    flightid        INT AUTO_INCREMENT PRIMARY KEY,
    flightnumber    VARCHAR(250) NOT NULL,
    origincode      VARCHAR(250) NOT NULL,
    destinationcode VARCHAR(250) NOT NULL,
    duration        TIMESTAMP    NOT NULL,
    CONSTRAINT FLIGHT UNIQUE (flightnumber)
);

