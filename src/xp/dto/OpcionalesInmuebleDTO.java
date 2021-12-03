package xp.dto;

import javax.swing.JTextField;

import xp.enums.TipoInmueble;

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
	}
	public OpcionalesInmuebleDTO(String calle, Integer pisoDpto, String orientacion, TipoInmueble tipoInmueble,
			String barrio, Integer precio, Integer habitaciones, Integer baños, String nroTelefono, Integer frente,
			Integer fondo, Integer superficie, Boolean propiedadHorizontal, Boolean patio, Boolean piscina,
			Boolean cochera, Boolean telefono, Boolean cloacas, Boolean lavadero, Boolean aguaCaliente,
			Boolean aguaCorriente, Boolean gasNatural, Boolean pavimento, String observaciones) {
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
	}
	
	public String getCalle() {
		return calle;
	}
	public void setCalle(String calle) {
		this.calle = calle;
	}
	public Integer getPisoDpto() {
		return pisoDpto;
	}
	public void setPisoDpto(Integer pisoDpto) {
		this.pisoDpto = pisoDpto;
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
	public Integer getHabitaciones() {
		return habitaciones;
	}
	public void setHabitaciones(Integer habitaciones) {
		this.habitaciones = habitaciones;
	}
	public Integer getBaños() {
		return baños;
	}
	public void setBaños(Integer baños) {
		this.baños = baños;
	}
	public String getNroTelefono() {
		return nroTelefono;
	}
	public void setNroTelefono(String nroTelefono) {
		this.nroTelefono = nroTelefono;
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
	public Boolean getPropiedadHorizontal() {
		return propiedadHorizontal;
	}
	public void setPropiedadHorizontal(Boolean propiedadHorizontal) {
		this.propiedadHorizontal = propiedadHorizontal;
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
	public Boolean getTelefono() {
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
	public Boolean getAguaCaliente() {
		return aguaCaliente;
	}
	public void setAguaCaliente(Boolean aguaCaliente) {
		this.aguaCaliente = aguaCaliente;
	}
	public Boolean getAguaCorriente() {
		return aguaCorriente;
	}
	public void setAguaCorriente(Boolean aguaCorriente) {
		this.aguaCorriente = aguaCorriente;
	}
	public Boolean getGasNatural() {
		return gasNatural;
	}
	public void setGasNatural(Boolean gasNatural) {
		this.gasNatural = gasNatural;
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
	@Override
	public String toString() {
		return "OpcionalesInmuebleDTO [calle=" + calle + ", pisoDpto=" + pisoDpto + ", orientacion=" + orientacion
				+ ", tipoInmueble=" + tipoInmueble + ", barrio=" + barrio + ", precio=" + precio + ", habitaciones="
				+ habitaciones + ", baños=" + baños + ", nroTelefono=" + nroTelefono + ", frente=" + frente + ", fondo="
				+ fondo + ", superficie=" + superficie + ", propiedadHorizontal=" + propiedadHorizontal + ", patio="
				+ patio + ", piscina=" + piscina + ", cochera=" + cochera + ", telefono=" + telefono + ", cloacas="
				+ cloacas + ", lavadero=" + lavadero + ", aguaCaliente=" + aguaCaliente + ", aguaCorriente="
				+ aguaCorriente + ", gasNatural=" + gasNatural + ", pavimento=" + pavimento + ", observaciones="
				+ observaciones + "]";
	}	
}
