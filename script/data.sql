INSERT INTO public.empresas
(empresa_id, rut_empresa, razon_social, fecha_inser, identificador)
VALUES(9999,78827280, 'Ki Teknology', now(), '4b2cf10-29072023-AB93');

--77.341.890-K Time Books Ltda
INSERT INTO public.empresas
(empresa_id, rut_empresa, razon_social, fecha_inser, identificador)
VALUES(99991,77341890, 'Time Books Ltda', now(), 'ABC99991');

--76.426.265-4 Kepler Nova Ltda
INSERT INTO public.empresas
(empresa_id, rut_empresa, razon_social, fecha_inser, identificador)
VALUES(99992,76426265, 'Kepler Nova Ltda', now(), 'ABC76426265');

--77.818.480-K NEA CONSULTORES ASOCIADOS LTDA
INSERT INTO public.empresas
(empresa_id, rut_empresa, razon_social, fecha_inser, identificador)
VALUES(99993,77818480, 'NEA CONSULTORES ASOCIADOS LTDA', now(), 'ABC77818480');

--76.317.379-8 Ticblue Ltda.
--76.330.318-7 OS Chile Editorial Limitada
--76.486.150-7 Tigabytes (Super Software S.A)
--76.210.592-6 Hop.In Chile
--76.225.088-8 LINETS Chile SpA
--89.629.300-1 Videocorp
--76.382.958-8 Edugestor SpA
--76.005.174-8 Ingenieria de Software Fidelizador y Cia Ltda.
--78.573.960-4 Alfacom Ingenieria Ltda.
--10.153.305-0 Apro Chile
--76.424.135-5 ZBOX SPA
--99.588.680-4 ITSolutions
--99.581.150-2 IMATRONIX S.A.
--76.317.056-k INGEOP E.I.R.L
--76.540.437-1 Aceleracion Labs SpA
--76.580.036-6 Netbelief Computación
--76.372.725-4 Asimov Consultores SpA
--76.549.895-3 Backline Soluciones Integrales SPA


-- Trabajadores empresa
INSERT INTO public.trabajadores
(trabajador_id, empresa_id, rut_trabajador, nombre, apellido, fecha_inser,direccion)
VALUES(9999,9999,13027561, 'Cristian', 'Peña', now(), 'Albino 1485');
