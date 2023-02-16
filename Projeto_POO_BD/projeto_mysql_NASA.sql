#BANCO DE DADOS Nasa
drop database Nasa;
CREATE DATABASE IF NOT EXISTS Nasa;
USE Nasa ;


CREATE TABLE IF NOT EXISTS Planeta 
(
  idPlaneta INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  habitavel TINYINT NOT NULL,
  PRIMARY KEY (idPlaneta)
    );

CREATE TABLE IF NOT EXISTS Nave
(
  idNave INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  PRIMARY KEY (idNave)
  );

CREATE TABLE IF NOT EXISTS Mapa
(
  idMapa INT NOT NULL,
  titulo VARCHAR(45) NOT NULL,
  orientacoes VARCHAR(45) NOT NULL,
  obstaculos INT NULL,
  PRIMARY KEY (idMapa)
  );

CREATE TABLE IF NOT EXISTS Viagem
(
  idViagem INT NOT NULL,
  Planeta_idPlaneta INT,
  Nave_idNave INT,
  distancia FLOAT NOT NULL,
  Mapa_idMapa INT ,
  PRIMARY KEY (Planeta_idPlaneta, Nave_idNave, Mapa_idMapa, idViagem),
  CONSTRAINT fk_Planeta_has_Nave_Planeta1
    FOREIGN KEY (Planeta_idPlaneta)
    REFERENCES Planeta (IdPlaneta)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Planeta_has_Nave_Nave1
    FOREIGN KEY  (Nave_idNave)
    REFERENCES Nave (idNave)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION,
  CONSTRAINT fk_Viagem_Mapa1
    FOREIGN KEY (Mapa_idMapa)
    REFERENCES Mapa (idMapa)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );

CREATE TABLE IF NOT EXISTS Passageiro
(
  idPassageiro INT NOT NULL,
  nome VARCHAR(45) NOT NULL,
  idade INT NOT NULL,
  sexo VARCHAR(1) NOT NULL,
  passageiro_has_nave INT,
  PRIMARY KEY (idPassageiro),
  CONSTRAINT fk_Passageiro_Nave1
    FOREIGN KEY (passageiro_has_nave)
    REFERENCES Nave (idNave)
    ON DELETE NO ACTION
    ON UPDATE NO ACTION
    );

select * from Planeta;
select * from Mapa;
select * from Passageiro;
select * from Nave;
select * from Viagem;