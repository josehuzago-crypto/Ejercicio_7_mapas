USE libreria;

CREATE TABLE editorial (
    id_editorial INT PRIMARY KEY,
    nombre VARCHAR(100)
);

CREATE TABLE cliente (
    id_cliente INT PRIMARY KEY,
    nombre VARCHAR(100),
    nacionalidad VARCHAR(100)
);

CREATE TABLE biblioteca (
    id_biblioteca INT PRIMARY KEY,
    nombre VARCHAR(100),
    ciudad VARCHAR(100),
    pais VARCHAR(100)
);

CREATE TABLE libro (
    id_libro INT PRIMARY KEY,
    titulo VARCHAR(100),
    autor VARCHAR(100),
    anioPublicado INT,
    existencias INT,
    id_editorial INT,
    FOREIGN KEY (id_editorial) REFERENCES editorial(id_editorial)
);

CREATE TABLE biblioteca_libro (
    id_biblioteca INT,
    id_libro INT,
    PRIMARY KEY (id_biblioteca, id_libro),
    FOREIGN KEY (id_biblioteca) REFERENCES biblioteca(id_biblioteca),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);

CREATE TABLE prestamo (
    id_prestamo INT PRIMARY KEY,
    id_cliente INT,
    id_libro INT,
    fecha_prestamo DATE,
    fecha_devolucion DATE,
    FOREIGN KEY (id_cliente) REFERENCES cliente(id_cliente),
    FOREIGN KEY (id_libro) REFERENCES libro(id_libro)
);