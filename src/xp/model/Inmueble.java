package xp.model;

import java.util.Date;

public class Inmueble {
	/**
	 * Se deber� crear la clase Inmueble incluyendo el atributo propietario
	 * relacionado a la clase propietario.La clase deber� contener los atributos:
	 * localidad, provincia, �, DateTime:fechaCarga, Integer:codigoInmueble, 
	 * EstadoInmueble estadoInmueble (generar enum EstadoInmueble= {DISPONIBLE, VENDIDO, RESERVADO}. 
	 */
	
	public enum EstadoInmueble{DISPONIBLE, VENDIDO, RESERVADO};

	private Object id;
	private String codigoInmueble;
	private EstadoInmueble estadoInmueble;
	private String localidad;
	private String provincia;
	private String fechaCarga;
	private Propietario propietario;
	
	public Inmueble(String codigoInmueble,EstadoInmueble estadoInmueble, String localidad,String provincia,String fechaCarga) {
		super();
	
		this.codigoInmueble = codigoInmueble;
		this.estadoInmueble = estadoInmueble; //1 disponile, 2 vendido, 3 reservado esto va en el front nomas
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaCarga = fechaCarga;
	}
	
	public Inmueble(Object id,String codigoInmueble, EstadoInmueble estadoInmueble, String localidad,String provincia,String fechaCarga) {
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
	public EstadoInmueble getEstadoInmueble() {
		return estadoInmueble;
	}
	public void setEstadoInmueble(EstadoInmueble estadoInmueble) {
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
	public String getFechaCarga() {
		return fechaCarga;
	}
	public void setFechaCarga(String fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	
}
