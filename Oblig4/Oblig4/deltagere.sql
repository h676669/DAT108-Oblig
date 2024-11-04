-- Names in SQL must begin with a letter (a-z) or underscore (_).
-- Subsequent characters in a name can be letters, digits (0-9), or underscores.

-- Dette eksemplet innholder en 1:N-forbindelse mellom entitetstypene ansatt og avdeling.

-- Sletter hele sulamitten og oppretter på nytt.
DROP SCHEMA IF EXISTS DAT108Oblig4 CASCADE;
CREATE SCHEMA DAT108Oblig4;
SET search_path TO DAT108Oblig4;

--

CREATE TABLE deltagerListe
(
    MobilNummer VARCHAR(8) PRIMARY KEY,
    Fornavn VARCHAR(25) NOT NULL,
    Etternavn VARCHAR(50) NOT NULL,
    kjonn CHAR CHECK (kjonn='M' OR kjonn='K'),
    Passsord VARCHAR(99) NOT NULL -- dette burde sikkert endres
);

