DROP TABLE IF EXISTS TBL_TAREAS;
CREATE TABLE TBL_TAREAS(
ID_TAREA INT AUTO_INCREMENT PRIMARY KEY NOT NULL,
NOMBRE VARCHAR2(100) NOT NULL,
PRIORIDAD VARCHAR2(20) NOT NULL,
ESTADO INT NOT NULL
);

DROP TABLE IF EXISTS TBL_ESTADOS;
CREATE TABLE TBL_ESTADOS(
ID INT PRIMARY KEY NOT NULL,
NOMBRE VARCHAR2(100) NOT NULL
);

DROP TABLE IF EXISTS TBL_PRIORIDADES;
CREATE TABLE TBL_PRIORIDADES(
ID INT PRIMARY KEY NOT NULL,
NOMBRE VARCHAR2(20) NOT NULL
);

--CREATE SEQUENCE SQ_TAREA 
--START WITH 0 
--INCREMENT BY 1;