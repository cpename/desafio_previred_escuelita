DROP TABLE IF EXISTS trabajadores;
DROP TABLE IF EXISTS empresas;

CREATE TABLE empresas(
  empresa_id INT AUTO_INCREMTEN PRIMARY KEY,
  rut_empresa int UNIQUE NOT NULL,
  digito_verif int,
  razon_social varchar(250),
  fecha_inser timestamp DEFAULT (now()),
  fecha_modif timestamp,
  identificador varchar(50) NOT NULL
);

ALTER TABLE empresas
    ADD CONSTRAINT empresas_un UNIQUE (identificador);

CREATE TABLE trabajadores (
  trabajador_id UNIQUE PRIMARY KEY,
  rut_trabajador int UNIQUE NOT NULL,
  nombre varchar(50),
  apellido varchar(50),
  fecha_inser timestamp DEFAULT (now()),
  fecha_modif timestamp,
  direccion varchar(250), 
  FOREIGN KEY (trabajador_id) REFERENCES "empresas" ("empresa_id")
);

--ALTER TABLE trabajadores ADD FOREIGN KEY ("trabajador_id") REFERENCES "empresas" ("empresa_id");
