package xp.dto;

import javax.swing.JTextField;

import xp.enums.TipoInmueble;
import xp.model.Propietario;

public class OpcionalesInmuebleDTO {
	private String calle;
	private Integer pisoDpto;
	private String orientacion;
	private TipoInmueble tipoInmueble;
	private String barrio;
	private Integer precio;
	private Integer habitaciones;
	private Integer baños;
	private String nroTelefono;
	private Integer frente;
	private Integer fondo;
	private Integer superficie;
	private Boolean propiedadHorizontal;
	private Boolean patio;
	private Boolean piscina;
	private Boolean cochera;
	private Boolean telefono;
	private Boolean cloacas;
	private Boolean lavadero;
	private Boolean aguaCaliente;
	private Boolean aguaCorriente;
	private Boolean gasNatural;
	private Boolean pavimento;
	private String observaciones;
	private Propietario propietario;
	
	public OpcionalesInmuebleDTO() {
		super();
		this.calle = null;
		this.pisoDpto = null;
		this.orientacion = null;
		this.tipoInmueble = null;
		this.barrio = null;
		this.precio = null;
		this.habitaciones = null;
		this.baños = null;
		this.nroTelefono = null;
		this.frente = null;
		this.fondo = null;
		this.superficie = null;
		this.propiedadHorizontal = null;
		this.patio = null;
		this.piscina = null;
		this.cochera = null;
		this.telefono = null;
		this.cloacas = null;
		this.lavadero = null;
		this.aguaCaliente = null;
		this.aguaCorriente = null;
		this.gasNatural = null;
		this.pavimento = null;
		this.observaciones = null;
		this.propietario = null;
	}
	public OpcionalesInmuebleDTO(String calle, Integer pisoDpto, String orientacion, TipoInmueble tipoInmueble,
			String barrio, Integer precio, Integer habitaciones, Integer baños, String nroTelefono, Integer frente,
			Integer fondo, Integer superficie, Boolean propiedadHorizontal, Boolean patio, Boolean piscina,
			Boolean cochera, Boolean telefono, Boolean cloacas, Boolean lavadero, Boolean aguaCaliente,
			Boolean aguaCorriente, Boolean gasNatural, Boolean pavimento, String observaciones,
			Propietario propietario) {
		super();
		this.calle = calle;
		this.pisoDpto = pisoDpto;
		this.orientacion = orientacion;
		this.tipoInmueble = tipoInmueble;
		this.barrio = barrio;
		this.precio = precio;
		this.habitaciones = habitaciones;
		this.baños = baños;
		this.nroTelefono = nroTelefono;
		this.frente = frente;
		this.fondo = fondo;
		this.superficie = superficie;
		this.propiedadHorizontal = propiedadHorizontal;
		this.patio = patio;
		this.piscina = piscina;
		this.cochera = cochera;
		this.telefono = telefono;
		this.cloacas = cloacas;
		this.lavadero = lavadero;
		this.aguaCaliente = aguaCaliente;
		this.aguaCorriente = aguaCorriente;
		this.gasNatural = gasNatural;
		this.pavimento = pavimento;
		this.observaciones = observaciones;
		this.propietario = propietario;
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}	
}
