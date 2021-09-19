
//Script DB DDL

CREATE DATABASE easyparking4;
USE easyparking4;

CREATE TABLE Persona
(
    ccPersonaPk VARCHAR(15) PRIMARY KEY,
    nombrePersona VARCHAR(30) NOT NULL,
    apellidoPersona VARCHAR(30) NULL
);

CREATE TABLE Servicio
(
    idServicioPk INT PRIMARY KEY AUTO_INCREMENT,
    fechaServicio DATE NOT NULL,
    horaEntradaServicio TIME NOT NULL,
    horaSalidaServicio TIME NOT NULL,
    valorMinutoServicio INT NOT NULL
);

CREATE TABLE Vehiculo
(
    placaVehiculoPk VARCHAR(15) PRIMARY KEY,
    modeloVehiculo VARCHAR(15) NOT NULL
);

CREATE TABLE Factura
(
    idFacturaPk INT PRIMARY KEY AUTO_INCREMENT,
    fechaFactura DATE NOT NULL,
    tiempoFactura INT NOT NULL,
    valorFactura INT NOT NULL,
    placaVehiculoFk VARCHAR(15),
    idServicioFk INT,
    ccPersonaFk VARCHAR(15)
);

ALTER TABLE Factura
ADD FOREIGN KEY (placaVehiculoFk)
REFERENCES Vehiculo (placaVehiculoPk);

ALTER TABLE Factura
ADD FOREIGN KEY (idServicioFk)
REFERENCES Servicio (idServicioPk);

ALTER TABLE Factura
ADD FOREIGN KEY (ccPersonaFk)
REFERENCES Persona (ccPersonaPk);

//Script DB DML

INSERT INTO persona VALUES
('830134', 'DIANA', 'RAMOS'),
('112145686', 'RAUL', 'MOLANO'),
('40375432', 'JULIO', 'VARGAS'),
('111276543', 'JAVIER', 'CASAS'),
('34532476', 'MICHEL', 'CASTRO');

INSERT INTO vehiculo VALUES
('PLX499', 'EXPLORER'),
('RIM150', 'BMW X4'),
('PQL312', 'AVEO'),
('MDL142', 'KOLEOS'),
('UVV499', 'GOLF');

INSERT INTO servicio VALUES
(1, '2021-09-13', '08:30:50', '08:42:45', 70),
(2, '2021-09-13', '10:25:30', '10:30:35', 70),
(3, '2021-09-14', '15:40:10', '16:20:23', 70),
(4, '2021-09-16', '18:15:10', '18:46:26', 70),
(5, '2021-09-18', '13:50:20', '14:16:41', 70);

INSERT INTO factura VALUES
(1, '2021-09-13', 12, 840, 'PLX499', 1, '830134'),
(2, '2021-09-13', 5, 350, 'RIM150', 2, '112145686'),
(3, '2021-09-14', 40, 2800, 'PQL312', 3, '40375432'),
(4, '2021-09-16', 31, 2170, 'MDL142', 4, '111276543'),
(5, '2021-09-18', 26, 1820, 'UVV499', 5, '34532476');

