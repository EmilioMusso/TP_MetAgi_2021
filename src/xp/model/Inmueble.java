package xp.model;

import java.util.Date;

public class Inmueble {
	/**
	 * Se deberá crear la clase Inmueble incluyendo el atributo propietario relacionado a la clase propietario. 
*La clase deberá contener los atributos: localidad, provincia, …, DateTime:fechaCarga, 
*Integer:codigoInmueble, EstadoInmueble estadoInmueble (generar enum EstadoInmueble= {DISPONIBLE, VENDIDO, RESERVADO}. 
	 */
	

	private Object id;
	private String codigoInmueble;
	private String estadoInmueble;
	private String localidad;
	private String provincia;
	private Date fechaCarga;
//	private Propietario propietario;	
	
	public Inmueble(String codigoInmueble,String estadoInmueble, String localidad,String provincia,Date fechaCarga) {
		super();
	
		this.codigoInmueble = codigoInmueble;
		this.estadoInmueble = estadoInmueble; //1 disponile, 2 vendido, 3 reservado esto va en el front nomas
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaCarga = fechaCarga;
	}
	
	public Inmueble(Object id,String codigoInmueble, String estadoInmueble, String localidad,String provincia,Date fechaCarga) {
		super();
		this.id = id;
		this.codigoInmueble = codigoInmueble;
		this.estadoInmueble = estadoInmueble; //1 disponile, 2 vendido, 3 reservado esto va en el front nomas
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaCarga = fechaCarga;
	}
	
	

	public Object getId() {
		return id;
	}
	public void setId(Object id) {
		this.id = id;
	}
	public String getCodigoInmueble() {
		return codigoInmueble;
	}
	public void setCodigoInmueble(String codigoInmueble) {
		this.codigoInmueble = codigoInmueble;
	}
	public String getEstadoInmueble() {
		return estadoInmueble;
	}
	public void setEstadoInmueble(String estadoInmueble) {
		this.estadoInmueble = estadoInmueble;
	}
	public String getLocalidad() {
		return localidad;
	}
	public void setLocalidad(String localidad) {
		this.localidad = localidad;
	}
	public String getProvincia() {
		return provincia;
	}
	public void setProvincia(String provincia) {
		this.provincia = provincia;
	}
	public Date getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	
}
