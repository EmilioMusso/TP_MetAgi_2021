package xp.model;

import java.util.Date;

import javax.swing.JCheckBox;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import javax.swing.JTextArea;
import javax.swing.JTextField;

import xp.enums.EstadoInmueble;
import xp.enums.TipoInmueble;

public class Inmueble {
	
	private Object id;
	private String codigoInmueble;
	private EstadoInmueble estadoInmueble;
	private String localidad;
	private String provincia;
	private Date fechaCarga;
	private Propietario propietario;
	private Integer id_propietario;
	
	private String calle;
	private String numTelefono;
	private String barrio;
	private Integer precio;
	private Integer pisoDpto;
	private Integer frente;
	private Integer fondo;
	private Integer superficie;
	
	private String orientacion;
	private TipoInmueble tipoInmueble;
	private Integer habitaciones;
	private Integer banios;
	private Boolean propiedadhorizontal;
	private Boolean patio;
	private Boolean piscina;
	private Boolean cochera;
	private Boolean telefono;
	private Boolean cloacas;
	private Boolean lavadero;
	private Boolean aguacaliente;
	private Boolean aguacorriente;
	private Boolean gasnatural;
	private Boolean pavimento;
	private String observaciones;
	
	public Inmueble(String codigoInmueble,EstadoInmueble estadoInmueble, String localidad,String provincia,Date fechaCarga) {
		super();
	
		this.codigoInmueble = codigoInmueble;
		this.estadoInmueble = estadoInmueble;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaCarga = fechaCarga;
	}
	
	public Inmueble(Object id,String codigoInmueble, EstadoInmueble estadoInmueble, String localidad,String provincia,Date fechaCarga) {
		super();
		this.id = id;
		this.codigoInmueble = codigoInmueble;
		this.estadoInmueble = estadoInmueble;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaCarga = fechaCarga;
	}

	public Inmueble(Integer id, String codigoInmueble, EstadoInmueble estadoInmueble, String localidad, String provincia,
			Date fechaCarga, Integer propietario, String calle, String numtelefono, String barrio, Integer precio,
			Integer pisodpto, Integer frente, Integer fondo, Integer superficie, String orientacion,
			TipoInmueble tipoInmueble, Integer habitaciones, Integer banios, Boolean propiedadhorizontal, Boolean patio,
			Boolean piscina, Boolean cochera, Boolean telefono, Boolean cloacas, Boolean lavadero, Boolean aguacaliente,
			Boolean aguacorriente, Boolean gasnatural, Boolean pavimento, String observaciones) {
		super();
		this.id = id;
		this.codigoInmueble = codigoInmueble;
		this.estadoInmueble = estadoInmueble;
		this.localidad = localidad;
		this.provincia = provincia;
		this.fechaCarga = fechaCarga;
		this.id_propietario = propietario;
		this.calle = calle;
		this.numTelefono = numtelefono;
		this.barrio = barrio;
		this.precio = precio;
		this.pisoDpto = pisodpto;
		this.frente = frente;
		this.fondo = fondo;
		this.superficie = superficie;
		this.orientacion = orientacion;
		this.tipoInmueble = tipoInmueble;
		this.habitaciones = habitaciones;
		this.banios = banios;
		this.propiedadhorizontal = propiedadhorizontal;
		this.patio = patio;
		this.piscina = piscina;
		this.cochera = cochera;
		this.telefono = telefono;
		this.cloacas = cloacas;
		this.lavadero = lavadero;
		this.aguacaliente = aguacaliente;
		this.aguacorriente = aguacorriente;
		this.gasnatural = gasnatural;
		this.pavimento = pavimento;
		this.observaciones = observaciones;
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

	public Date getFechaCarga() {
		return fechaCarga;
	}

	public void setFechaCarga(Date fechaCarga) {
		this.fechaCarga = fechaCarga;
	}

	public Propietario getPropietario() {
		return propietario;
	}

	public void setPropietario(Propietario propietario) {
		this.propietario = propietario;
	}

	public String getCalle() {
		return calle;
	}

	public void setCalle(String calle) {
		this.calle = calle;
	}

	public String getNumTelefono() {
		return numTelefono;
	}

	public void setNumTelefono(String numtelefono) {
		this.numTelefono = numtelefono;
	}

	public String getBarrio() {
		return barrio;
	}

	public void setBarrio(String barrio) {
		this.barrio = barrio;
	}

	public Integer getPrecio() {
		return precio;
	}

	public void setPrecio(Integer precio) {
		this.precio = precio;
	}

	public Integer getPisoDpto() {
		return pisoDpto;
	}

	public void setPisoDpto(Integer pisodpto) {
		this.pisoDpto = pisodpto;
	}

	public Integer getFrente() {
		return frente;
	}

	public void setFrente(Integer frente) {
		this.frente = frente;
	}

	public Integer getFondo() {
		return fondo;
	}

	public void setFondo(Integer fondo) {
		this.fondo = fondo;
	}

	public Integer getSuperficie() {
		return superficie;
	}

	public void setSuperficie(Integer superficie) {
		this.superficie = superficie;
	}

	public String getOrientacion() {
		return orientacion;
	}

	public void setOrientacion(String orientacion) {
		this.orientacion = orientacion;
	}

	public TipoInmueble getTipoInmueble() {
		return tipoInmueble;
	}

	public void setTipoInmueble(TipoInmueble tipoInmueble) {
		this.tipoInmueble = tipoInmueble;
	}

	public Integer getHabitaciones() {
		return habitaciones;
	}

	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}

	public Integer getBanios() {
		return banios;
	}

	public void setBanios(Integer banios) {
		this.banios = banios;
	}

	public Boolean getPropiedadhorizontal() {
		return propiedadhorizontal;
	}

	public void setPropiedadhorizontal(Boolean propiedadhorizontal) {
		this.propiedadhorizontal = propiedadhorizontal;
	}

	public Boolean getPatio() {
		return patio;
	}

	public void setPatio(Boolean patio) {
		this.patio = patio;
	}

	public Boolean getPiscina() {
		return piscina;
	}

	public void setPiscina(Boolean piscina) {
		this.piscina = piscina;
	}

	public Boolean getCochera() {
		return cochera;
	}

	public void setCochera(Boolean cochera) {
		this.cochera = cochera;
	}

	public Boolean poseeTelefono() {
		return telefono;
	}

	public void setTelefono(Boolean telefono) {
		this.telefono = telefono;
	}

	public Boolean getCloacas() {
		return cloacas;
	}

	public void setCloacas(Boolean cloacas) {
		this.cloacas = cloacas;
	}

	public Boolean getLavadero() {
		return lavadero;
	}

	public void setLavadero(Boolean lavadero) {
		this.lavadero = lavadero;
	}

	public Boolean getAguacaliente() {
		return aguacaliente;
	}

	public void setAguacaliente(Boolean aguacaliente) {
		this.aguacaliente = aguacaliente;
	}

	public Boolean getAguacorriente() {
		return aguacorriente;
	}

	public void setAguacorriente(Boolean aguacorriente) {
		this.aguacorriente = aguacorriente;
	}

	public Boolean getGasnatural() {
		return gasnatural;
	}

	public void setGasnatural(Boolean gasnatural) {
		this.gasnatural = gasnatural;
	}

	public Boolean getPavimento() {
		return pavimento;
	}

	public void setPavimento(Boolean pavimento) {
		this.pavimento = pavimento;
	}

	public String getObservaciones() {
		return observaciones;
	}

	public void setObservaciones(String observaciones) {
		this.observaciones = observaciones;
	}

	public Integer getId_propietario() {
		return id_propietario;
	}

	public void setId_propietario(Integer id_propietario) {
		this.id_propietario = id_propietario;
	}

	public Boolean getTelefono() {
		return telefono;
	}
	
	
	
}
