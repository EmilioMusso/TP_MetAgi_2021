package xp.model;

import java.util.Date;

public class Inmueble {
	/**
	 * Se deberá crear la clase Inmueble incluyendo el atributo propietario relacionado a la clase propietario. 
*La clase deberá contener los atributos: localidad, provincia, …, DateTime:fechaCarga, 
*Integer:codigoInmueble, EstadoInmueble estadoInmueble (generar enum EstadoInmueble= {DISPONIBLE, VENDIDO, RESERVADO}. 
	 */
	

	private Object id;
	private Integer codigoInmueble;
	private Integer estadoInmueble;
	private String localidad;
	private String provincia;
	private Date fechaCarga;
//	private Propietario propietario;	
	
	public Inmueble(Integer codigoInmueble, Integer estadoInmueble, String localidad,String provincia,Date fechaCarga) {
		super();
	
		this.codigoInmueble = codigoInmueble;
		this.estadoInmueble = estadoInmueble; //1 disponile, 2 vendido, 3 reservado esto va en el front nomas
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaCarga = fechaCarga;
	}
	
	public Inmueble(Object id,Integer codigoInmueble, Integer estadoInmueble, String localidad,String provincia,Date fechaCarga) {
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
	public Integer getCodigoInmueble() {
		return codigoInmueble;
	}
	public void setCodigoInmueble(Integer codigoInmueble) {
		this.codigoInmueble = codigoInmueble;
	}
	public Integer getEstadoInmueble() {
		return estadoInmueble;
	}
	public void setEstadoInmueble(Integer estadoInmueble) {
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
