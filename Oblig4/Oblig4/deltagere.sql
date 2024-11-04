-- Names in SQL must begin with a letter (a-z) or underscore (_).
-- Subsequent characters in a name can be letters, digits (0-9), or underscores.

-- Dette eksemplet innholder en 1:N-forbindelse mellom entitetstypene ansatt og avdeling.

-- Sletter hele sulamitten og oppretter på nytt.
DROP SCHEMA IF EXISTS DAT108Oblig4 CASCADE;
CREATE SCHEMA DAT108Oblig4;
SET search_path TO DAT108Oblig4;

--

CREATE TABLE deltager (
    mobil CHARACTER (8) PRIMARY KEY,
    hash CHARACTER (64) NOT NULL,
    salt CHARACTER (32) NOT NULL,
    fornavn CHARACTER VARYING (40),
    etternavn CHARACTER VARYING (40),
    kjonn CHARACTER VARYING (6)
);

