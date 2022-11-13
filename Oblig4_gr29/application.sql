DROP SCHEMA IF EXISTS deltaker CASCADE;
CREATE SCHEMA deltaker;
SET search_path TO deltaker;
    
CREATE TABLE deltaker
(
   fornavn VARCHAR(30) NOT NULL,
   etternavn VARCHAR(30) NOT NULL,
   mobil VARCHAR(8) PRIMARY KEY,
   passord VARCHAR(64) NOT NULL,
   passordrepetert VARCHAR(64) NOT NULL,
   salt varchar(32) NOT NULL,
   kjonn CHAR CHECK (kjonn='M' OR kjonn='K')
);
