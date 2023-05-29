-- Creación de tabla Cita
CREATE TABLE Cita (
                      id INT PRIMARY KEY,
                      date DATE,
                      intervaloHora VARCHAR(20),
                      state VARCHAR(20),
                      note VARCHAR(255),
                      type VARCHAR(50),
                      location VARCHAR(50),
                      enfermero_id INT,
                      paciente_id INT,
                      FOREIGN KEY (enfermero_id) REFERENCES Enfermero(id),
                      FOREIGN KEY (paciente_id) REFERENCES Paciente(id)
);

-- Creación de tabla Enfermero
CREATE TABLE Enfermero (
                           id INT PRIMARY KEY,
                           nombre VARCHAR(50),
                           apellidos VARCHAR(50),
                           fechaNacimiento DATE,
                           sexo VARCHAR(10),
                           telefono VARCHAR(20),
                           email VARCHAR(50) UNIQUE,
                           identificacion VARCHAR(20) UNIQUE,
                           tipoIdentificacion VARCHAR(20),
                           ips VARCHAR(50),
                           especialidad VARCHAR(50),
                           tarjetaProfesional VARCHAR(50) UNIQUE,
                           contrasena VARCHAR(50)
);

-- Creación de tabla Facturador
CREATE TABLE Facturador (
                            id INT PRIMARY KEY,
                            nombre VARCHAR(50),
                            apellidos VARCHAR(50),
                            fechaNacimiento DATE,
                            sexo VARCHAR(10),
                            telefono VARCHAR(20),
                            email VARCHAR(50) UNIQUE,
                            identificacion VARCHAR(20) UNIQUE,
                            tipoIdentificacion VARCHAR(20),
                            ips VARCHAR(50),
                            especialidad VARCHAR(50),
                            tarjetaProfesional VARCHAR(50) UNIQUE,
                            contrasena VARCHAR(50)
);

-- Creación de tabla HistoriaClinica
CREATE TABLE HistoriaClinica (
                                 id INT PRIMARY KEY,
                                 date DATE,
                                 familyBackground VARCHAR(255),
                                 weight FLOAT,
                                 height FLOAT,
                                 paciente_id INT,
                                 enfermero_id INT,
                                 FOREIGN KEY (paciente_id) REFERENCES Paciente(id),
                                 FOREIGN KEY (enfermero_id) REFERENCES Enfermero(id)
);

-- Creación de tabla Paciente
CREATE TABLE Paciente (
                          id INT PRIMARY KEY,
                          nombre VARCHAR(50),
                          apellidos VARCHAR(50),
                          fechaNacimiento DATE,
                          sexo VARCHAR(10),
                          direccion VARCHAR(100),
                          telefono VARCHAR(20),
                          email VARCHAR(50) UNIQUE,
                          identificacion VARCHAR(20) UNIQUE,
                          tipoIdentificacion VARCHAR(20),
                          tipoSangre VARCHAR(10),
                          estadoCivil VARCHAR(20),
                          eps VARCHAR(50),
                          etnia VARCHAR(50),
                          genero VARCHAR(10),
                          zonaResidencia VARCHAR(50),
                          gruposPoblacionales VARCHAR(50),
                          ocupacion VARCHAR(50)
);
-- Población de datos para tabla Cita
INSERT INTO Cita (id, date, intervaloHora, state, note, type, location, enfermero_id, paciente_id)
VALUES
    (1, '2023-05-01', '09:00 - 10:00', 'Confirmada', 'Nota de prueba 1', 'Tipo 1', 'Ubicación 1', 1, 1),
    (2, '2023-05-02', '10:00 - 11:00', 'Confirmada', 'Nota de prueba 2', 'Tipo 2', 'Ubicación 2', 1, 2),
    (3, '2023-05-03', '11:00 - 12:00', 'Cancelada', 'Nota de prueba 3', 'Tipo 1', 'Ubicación 1', 2, 3);

-- Población de datos para tabla Enfermero
INSERT INTO Enfermero (id, nombre, apellidos, fechaNacimiento, sexo, telefono, email, identificacion, tipoIdentificacion, ips, especialidad, tarjetaProfesional, contrasena)
VALUES
    (1, 'Enfermero 1', 'Apellido 1', '1990-01-01', 'Masculino', '123456789', 'enfermero1@example.com', 'ENF001', 'Cédula de Ciudadanía', 'IPS 1', 'Especialidad 1', 'TP001', 'contrasena1'),
    (2, 'Enfermero 2', 'Apellido 2', '1991-02-02', 'Femenino', '987654321', 'enfermero2@example.com', 'ENF002', 'Tarjeta de Identidad', 'IPS 2', 'Especialidad 2', 'TP002', 'contrasena2');

-- Población de datos para tabla Facturador
INSERT INTO Facturador (id, nombre, apellidos, fechaNacimiento, sexo, telefono, email, identificacion, tipoIdentificacion, ips, especialidad, tarjetaProfesional, contrasena)
VALUES
    (1, 'Facturador 1', 'Apellido 1', '1980-01-01', 'Masculino', '111111111', 'facturador1@example.com', 'FAC001', 'Cédula de Ciudadanía', 'IPS 1', 'Especialidad 1', 'TPF001', 'contrasena1'),
    (2, 'Facturador 2', 'Apellido 2', '1981-02-02', 'Femenino', '222222222', 'facturador2@example.com', 'FAC002', 'Tarjeta de Identidad', 'IPS 2', 'Especialidad 2', 'TPF002', 'contrasena2');

-- Población de datos para tabla HistoriaClinica
INSERT INTO HistoriaClinica (id, date, familyBackground, weight, height, paciente_id, enfermero_id)
VALUES
    (1, '2023-05-01', 'Antecedentes familiares 1', 70.5, 170.2, 1, 1),
    (2, '2023-05-02', 'Antecedentes familiares 2', 65.2, 165.8, 2, 1),
    (3, '2023-05-03', 'Antecedentes familiares 3', 80.0, 180.0, 3, 2);

-- Población de datos para tabla Paciente
INSERT INTO Paciente (id, nombre, apellidos, fechaNacimiento, sexo, direccion, telefono, email, identificacion, tipoIdentificacion, tipoSangre, estadoCivil, eps, etnia, genero, zonaResidencia, gruposPoblacionales, ocupacion)
VALUES
    (1, 'Paciente 1', 'Apellido 1', '1995-01-01', 'Femenino', 'Dirección 1', '555111111', 'paciente1@example.com', 'PAC001', 'Cédula de Ciudadanía', 'O+', 'Soltero/a', 'EPS 1', 'Etnia 1', 'Género 1', 'Zona 1', 'Grupos 1', 'Ocupación 1'),
    (2, 'Paciente 2', 'Apellido 2', '1996-02-02', 'Masculino', 'Dirección 2', '555222222', 'paciente2@example.com', 'PAC002', 'Tarjeta de Identidad', 'A-', 'Casado/a', 'EPS 2', 'Etnia 2', 'Género 2', 'Zona 2', 'Grupos 2', 'Ocupación 2'),
    (3, 'Paciente 3', 'Apellido 3', '1997-03-03', 'Femenino', 'Dirección 3', '555333333', 'paciente3@example.com', 'PAC003', 'Cédula de Ciudadanía', 'B+', 'Soltero/a', 'EPS 3', 'Etnia 3', 'Género 3', 'Zona 3', 'Grupos 3', 'Ocupación 3');
