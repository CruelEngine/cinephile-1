--liquibase formatted sql

--changeset Umang:1-add-subscriber-table
CREATE TABLE SUBSCRIBER
(
    ID INT IDENTITY NOT NULL PRIMARY KEY ,
    EMAIL VARCHAR(255),
    FIRST_NAME VARCHAR(255)
);