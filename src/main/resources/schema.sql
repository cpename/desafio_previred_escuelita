
-- Create the database
--CREATE DATABASE previred;


-- Create the role
--CREATE ROLE previred LOGIN PASSWORD 'previred';

-- Grant all permissions to the role
--GRANT ALL PRIVILEGES ON DATABASE previred TO previred;


DROP TABLE IF EXISTS trabajadores cascade;;
DROP TABLE IF EXISTS empresas cascade;

CREATE TABLE "empresas" (
  "empresa_id" SERIAL UNIQUE PRIMARY KEY,
  "rut_empresa" int UNIQUE NOT NULL,
  "digito_verif" int,
  "razon_social" varchar(250),
  "fecha_inser" timestamp DEFAULT (now()),
  "fecha_modif" timestamp,
  "identificador" varchar(50) UNIQUE NOT NULL
);

CREATE TABLE "trabajadores" (
  "trabajador_id" SERIAL UNIQUE PRIMARY KEY,
  empresa_id int,
  "rut_trabajador" int UNIQUE NOT NULL,
  "nombre" varchar(50),
  "apellido" varchar(50),
  "fecha_inser" timestamp DEFAULT (now()),
  "fecha_modif" timestamp,
  "direccion" varchar(250),
   CONSTRAINT fk_empresa_id
   FOREIGN KEY(empresa_id)
   REFERENCES empresas(empresa_id)
   ON DELETE NO ACTION
  
);

-- PRIMARY KEY(sportsperson_id),

--ALTER TABLE "trabajadores" ADD FOREIGN KEY ("trabajador_id") REFERENCES "empresas" ("empresa_id");
