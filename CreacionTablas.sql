CREATE TABLE public.propietario(
	id integer NOT NULL,
	nombre character varying(20),
	apellido character varying(20),
	tipdoc character varying(3),
	numdoc character varying(8),
	calle character varying(20),
	numdom character varying(4),
	provincia character varying(20),
	localidad character varying(20),
	telefono character varying(20),
	email character varying(20),

	CONSTRAINT pk_propietario PRIMARY KEY(id)
);

CREATE TABLE public.vendedor(
		id integer NOT NULL,
	nombre character varying(20),
	apellido character varying(20),
	numdoc character varying(8),
	claveAcceso character varying(20),

	CONSTRAINT pk_vendedor PRIMARY KEY(id)
);

CREATE TABLE public.inmueble(
	id integer NOT NULL,
	codigoInmueble character varying(20),
	estadoInmueble character varying(20),
	localidad character varying(20),
	provincia character varying(20),
	fechaCarga date,

	CONSTRAINT pk_inmueble PRIMARY KEY(id)
);

CREATE TABLE public.cliente(
	id integer NOT NULL,
	nombre character varying(40),
	apellido character varying(40),
	telefono character varying(20),
	usuario character varying(20),
	claveacceso character varying(20),

	CONSTRAINT pk_propietario PRIMARY KEY(id)
); 

CREATE SEQUENCE public.seq_id
    INCREMENT 1
    START 405
    MINVALUE 400
    MAXVALUE 9999
    CACHE 1;

ALTER SEQUENCE public.seq_id
    OWNER TO postgres;