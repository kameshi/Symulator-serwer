DROP TABLE Spalanie;
DROP TABLE Produkt;
DROP TABLE Model;
DROP TABLE Marka;


CREATE TABLE Marka(
  Id_marka NUMBER(5),
  Nazwa VARCHAR2(30) UNIQUE,
  CONSTRAINT marka_pk PRIMARY KEY (Id_marka)
);

CREATE TABLE Model(
  Id_model NUMBER(5),
  Id_marka NUMBER(5),
  Nazwa VARCHAR2(30) UNIQUE,
  CONSTRAINT model_marka_fk FOREIGN KEY (Id_marka) REFERENCES Marka(Id_marka),
  CONSTRAINT model_pk PRIMARY KEY (Id_model)
);

CREATE TABLE Samochod(
  Id_Samochod NUMBER(8),
  Id_model NUMBER(5),
  Pojemnosc Varchar2(5),
  Rok_produkcji Varchar2(4),
  Moc Varchar2(4),
  Paliwo VARCHAR2(7),
  CONSTRAINT samochod_model_fk FOREIGN KEY (Id_model) REFERENCES Model(Id_model),
  CONSTRAINT paliwo_check CHECK (Paliwo IN ('benzyna', 'gaz', 'hybryda', 'diesel')),
  CONSTRAINT samochod_pk PRIMARY KEY (Id_produkt)
);

CREATE TABLE Spalanie(
  Id_spalanie NUMBER(10),
  Id_samochod NUMBER(8),
  Sr_predkosc NUMBER(4),
  Sr_spalanie NUMBER(3),
  CONSTRAINT samochod_spalanie_fk FOREIGN KEY (Id_samochod) REFERENCES Samochod(Id_samochod),
  CONSTRAINT spalanie_pk PRIMARY KEY (Id_spalanie)
);
