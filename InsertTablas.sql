INSERT INTO public.propietario
	VALUES  (345,'Carlos','Garcia','DNI','30433539','4 de Enero','2300','','','','carlos@garcia.com'),
		(346,'Carlos','Gomez','LE','30433539','Hernandarias','2300','','','','gomez@gmail.com');

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
	'',
	20000000,
	8,
	9,
	72,
	2,
	1,
	'{false, true,true,true,true,false,true,true,true,true,false,true}'
);