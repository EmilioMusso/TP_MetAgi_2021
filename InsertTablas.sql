INSERT INTO public.propietario
	VALUES  (345,'Carlos','Garcia','DNI','30433539','4 de Enero','2300','','','','carlos@garcia.com'),
		(346,'Carla','Gomez','LE','30433539','Hernandarias','2300','','','','gomez@gmail.com'),
		(350,'Jorge','Drexler','DNI','30103522','Rambla','2000','','','','jdrx@gmail.com');

INSERT INTO public.vendedor
	VALUES  (001, 'Bill', 'Gates', '12123456', 'unaClave'),
		(002, 'Elon', 'Musk', '98987654', 'otraClave');
		
INSERT INTO public.cliente
	VALUES  (111, '', '', '', '', ''),
		(112, '', '', '', '', '');
		
INSERT INTO public.inmueble
	VALUES (
	11,
	'11',
	'RESERVADO',
	'Progreso',
	'Santa Fe',
	null,
	null,
	77777777776,
	'Libertad',
	0,
	'NORTE',
	'L',
	'Este',
	10000000,
	12,
	6,
	72,
	4,
	2,
	'{false, true,true,true,true,false,true,true,true,true,false,true}'),
	(12,
	'12',
	'DISPONIBLE',
	'Santa Fe',
	'Santa Fe',
	null,
	null,
	1234124,
	'Lavaisse',
	6,
	'SUR',
	'L',
	'Roma',
	20000000,
	8,
	9,
	72,
	2,
	1,
	'{false, true,true,true,true,false,true,true,true,true,false,true}'),
	(13,
	'13',
	'DISPONIBLE',
	'C�rdoba',
	'C�rdoba',
	null,
	null,
	1234124,
	'San Mart�n',
	6,
	'SUR',
	'C',
	'Alta C�rdoba',
	70000000,
	8,
	9,
	72,
	1,
	1,
	'{false, true,true,true,true,false,true,true,true,true,false,true}'),
	(14,
	'14',
	'DISPONIBLE',
	'San Rafael',
	'Mendoza',
	null,
	null,
	1234124,
	'Vi�as',
	1421,
	'SUR',
	'L',
	'Los Vi�edos',
	30000000,
	8,
	9,
	72,
	3,
	1,
	'{false, true,true,true,true,false,true,true,true,true,false,true}'),
	(15,
	'15',
	'DISPONIBLE',
	'San Rafael',
	'Mendoza',
	null,
	null,
	1234124,
	'Malbec',
	453,
	'SUR',
	'C',
	'Los Vi�edos',
	30000000,
	8,
	9,
	72,
	3,
	1,
	'{false, true,true,true,true,false,true,true,true,true,false,true}'),
	(16,
	'16',
	'RESERVADO',
	'Progreso',
	'Santa Fe',
	null,
	null,
	77777777776,
	'Sarmiento',
	6521,
	'NORTE',
	'L',
	'Este',
	10000000,
	12,
	6,
	72,
	3,
	2,
	'{false, true,true,true,true,false,true,true,true,true,false,true}'),
;