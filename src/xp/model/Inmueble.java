package xp.model;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

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
	
	
	
	public Inmueble() {
		this.estadoInmueble = EstadoInmueble.DISPONIBLE;
		this.localidad = "";
		this.provincia = "";
		this.fechaCarga = null;
		this.id_propietario = 0;
		this.calle = "";
		this.numTelefono = "";
		this.barrio = "";
		this.precio = 0;
		this.pisoDpto = 0;
		this.frente = 0;
		this.fondo = 0;
		this.superficie = 0;
//		this.orientacion = orientacion;
		this.tipoInmueble = TipoInmueble.L;
		this.habitaciones = 1;
		this.banios = 1;
		this.propiedadhorizontal = false;
		this.patio = false;
		this.piscina = false;
		this.cochera = false;
		this.telefono = false;
		this.cloacas = false;
		this.lavadero = false;
		this.aguacaliente = false;
		this.aguacorriente = false;
		this.gasnatural = false;
		this.pavimento = false;
		this.observaciones = "";
	}

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
		this();
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
	
	public String getDescripcion() {
		//Se genera una descripcion del inmueble en base a sus caracteristicas
		// L/Local, C/casa, D/departamento, T/terreno, Q/quinta, G/galpón
		String descripcion="";
		
		switch(this.tipoInmueble) {
		case L:
			descripcion+="Local";
			descripcion+=" en "+this.getLocalidad()+", "+this.getProvincia();
			break;
		case C:
			descripcion+="Casa";
			if(this.getPiscina()!=null)
				if(this.getPiscina())
					descripcion+=" con piscina";
			descripcion+=" en "+this.getLocalidad()+", "+this.getProvincia();
			break;
		case D:
			descripcion+="Departamento";
			if(this.getHabitaciones()>0)
				descripcion+=" "+this.getHabitaciones()+" habitacion(es)";
			descripcion+=" en "+this.getLocalidad()+", "+this.getProvincia();
			break;
		case T:
			descripcion+="Terreno";
			if(this.getSuperficie()>0)
				descripcion+=" "+this.getSuperficie()+" (m2) de superficie";
			descripcion+=" en "+this.getLocalidad()+", "+this.getProvincia();
			break;
		case Q:
			descripcion+="Quinta";
			descripcion+=" en "+this.getLocalidad()+", "+this.getProvincia();
			break;
		case G:
			descripcion+="Galpon";
			descripcion+=" en "+this.getLocalidad()+", "+this.getProvincia();
			break;
		}
		return descripcion;
	}
	
	public String getDetalles() {
		String detalles="";
		String comodidades = seleccionarComodidadesPrincipales(this);
		Boolean poseeComodidades = comodidades!="";
		
		switch(this.tipoInmueble) {
		case L:
			detalles+="  - "+this.getBanios()+" baños.\n"
					+ "  - Barrio "+this.getBarrio()+".\n";
			if(poseeComodidades) {
				detalles+="  - Posee "+comodidades+".\n";
			}
			detalles+="  - Telefono "+this.getNumTelefono()+".\n"
					+ "  - Precio $"+this.getPrecio()+".\n";
			break;
			
			
		case C:
			detalles+="  - "+this.getBanios()+" baños.\n"
					+ "  - "+this.getHabitaciones()+" habitaciones.\n"
					+ "  - Superficie de "+this.getSuperficie()+" (m2).\n"
					+ "  - Barrio "+this.getBarrio()+".\n";
			if(poseeComodidades) {
				detalles+="  - Posee "+comodidades+".\n";
			}
			detalles+="  - Telefono "+this.getNumTelefono()+".\n"
					+ "  - Precio $"+this.getPrecio()+".\n";
			break;
			
			
		case D:
			detalles+="  - "+this.getBanios()+" baños.\n"
					+ "  - "+this.getHabitaciones()+" habitaciones.\n"
					+ "  - Barrio "+this.getBarrio()+".\n";
			if(poseeComodidades) {
				detalles+="  - Posee "+comodidades+".\n";
			}
			detalles+="  - Telefono "+this.getNumTelefono()+".\n"
					+ "  - Precio $"+this.getPrecio()+".\n";
			break;
			
			
		case T:
			detalles+="  - Barrio "+this.getBarrio()+".\n"
					+ "  - Telefono "+this.getNumTelefono()+".\n"
					+ "  - Precio $"+this.getPrecio()+".\n";
			break;
			
			
		case Q:
			detalles+="  - "+this.getBanios()+" baños.\n"
					+ "  - "+this.getHabitaciones()+" habitaciones.\n"
					+ "  - Superficie de "+this.getSuperficie()+" (m2).\n"
					+ "  - Barrio "+this.getBarrio()+".\n";
			if(poseeComodidades) {
				detalles+="  - Posee "+comodidades+".\n";
			}
			detalles+="  - Telefono "+this.getNumTelefono()+".\n"
					+ "  - Precio $"+this.getPrecio()+".\n";
			break;
			
			
		case G:
			detalles+="  - Barrio "+this.getBarrio()+".\n"
					+ "  - Telefono "+this.getNumTelefono()+".\n"
					+ "  - Precio $"+this.getPrecio()+".\n";
			break;
		}
		return detalles;
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
	
	
	private String seleccionarComodidadesPrincipales(Inmueble inmueble) {
		//Se eligen 3 comodidades que posea por orden de prioridad
		ArrayList<String> lista = new ArrayList<String>();
		if(this.getPiscina())			lista.add("piscina");
		if(this.getPatio())				lista.add("patio");
		if(this.getCochera())			lista.add("cochera");
		if(this.getAguacaliente())		lista.add("agua caliente");
		if(this.getTelefono())			lista.add("telefono");
		if(this.getCloacas())			lista.add("cloacas");
		if(this.getLavadero())			lista.add("lavadero");
		if(this.getAguacorriente())		lista.add("agua corriente");
		if(this.getGasnatural())		lista.add("gas natural");
		if(this.getPavimento())			lista.add("pavimento");
		
		if(lista.size()==1)
			return lista.get(0);
		if(lista.size()==2)
			return lista.get(0)+" y "+lista.get(1);
		if(lista.size()==3)
			return lista.get(0)+", "+lista.get(1)+" y "+lista.get(2);
		return "";
	}
}
