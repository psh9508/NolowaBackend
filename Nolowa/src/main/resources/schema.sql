DROP TABLE IF EXISTS USER;

CREATE TABLE USER (
    ID bigint not null AUTO_INCREMENT PRIMARY KEY,
    EMAIL varchar(255),
    JOINDATE TIMESTAMP,
    PASSWORD varchar(255)
)