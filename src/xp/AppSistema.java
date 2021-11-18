package xp;

import java.util.ArrayList;
import java.util.Collection;

import xp.db.T_propietario;
import xp.db.T_vendedor;
import xp.enums.TipoUsuario;
import xp.model.Inmueble;
import xp.model.Localidad;
import xp.model.Propietario;
import xp.model.Provincia;
import xp.model.Vendedor;

public class AppSistema {
	private ArrayList<Vendedor> vendedoresSistema;
	private ArrayList<Propietario> propietariosSistema;
	private ArrayList<Inmueble> inmueblesSistema;
	private ArrayList<Localidad> localidadesSistema;
	private ArrayList<String> provinciasSistema;
	private TipoUsuario tipoUsuario;
	
	public AppSistema() {
		this.vendedoresSistema = new ArrayList<Vendedor>();
		this.propietariosSistema = new ArrayList<Propietario>();
		this.inmueblesSistema = new ArrayList<Inmueble>();
		this.provinciasSistema = new ArrayList<String>();
		this.tipoUsuario = TipoUsuario.NO_REGISTRADO; //por default
		
		T_propietario aT = new T_propietario();
//		propietariosSistema = aT.buscarTodos();
		
		//TODO buscar vendedores e inmuebles
//		T_vendedor vT = new T_vendedor();
//		propietariosSistema = vT.buscarTodos();
//		propietariosSistema.stream().forEach( prop -> {
//			System.out.println(prop.toString());
//		});
//		
//		T_inmueble iT = new T_inmueble();
//		propietariosSistema = iT.buscarTodos();
//		propietariosSistema.stream().forEach( prop -> {
//			System.out.println(prop.toString());
//		});
		
		
		
		localidadesSistema = new ArrayList<Localidad>(); 
		localidadesSistema.add(new Localidad("Santa Fe")); //TODO agregar a DB
		localidadesSistema.add(new Localidad("Santo Tomé"));
		localidadesSistema.add(new Localidad("Sauce Viejo"));
		localidadesSistema.add(new Localidad("Rincón"));
		localidadesSistema.add(new Localidad("Colastiné Norte"));
		localidadesSistema.add(new Localidad("Colastiné Sur"));
		

		provinciasSistema.add("Santa Fe");
		provinciasSistema.add("Buenos Aires");
		
//		provinciasSistema.add("Buenos Aires", //TODO agregar a DB
//				"Catamarca",
//				"Chaco",
//				"Chubut",
//				"Cordoba",
//				"Corrientes",
//				"Entre Ríos",
//				"Formosa",
//				"Jujuy",
//				"La Pampa",
//				"La Rioja",
//				"Mendoza",
//				"Misiones",
//				"Neuquén",
//				"Río Negro",
//				"Salta",
//				"San Juan",
//				"San Luis",
//				"Santa Cruz",
//				"Santiago del Estero",
//				"Tierra del Fuego",
//				"Tucumán");
		
		
	}

	public ArrayList<Vendedor> getVendedoresSistema() {
		return vendedoresSistema;
	}

	public void setVendedoresSistema(ArrayList<Vendedor> vendedoresSistema) {
		this.vendedoresSistema = vendedoresSistema;
	}

	public ArrayList<Propietario> getPropietariosSistema() {
		return propietariosSistema;
	}

	public void setPropietariosSistema(ArrayList<Propietario> propietariosSistema) {
		this.propietariosSistema = propietariosSistema;
	}	
	
		
	public ArrayList<Inmueble> getInmueblesSistema() {
		return inmueblesSistema;
	}

	public ArrayList<Localidad> getLocalidadesSistema() {
		return localidadesSistema;
	}

	public ArrayList<String> getProvinciasSistema() {
		return provinciasSistema;
	}

	public Integer cantDeVendedores() {
		return vendedoresSistema.size();
	}
	
	public void agregarLocalidad(String nombre) {
		this.localidadesSistema.add(new Localidad(nombre));
	}

	public TipoUsuario getTipoUsuario() {
		return this.tipoUsuario;
	}

	public void setTipoUsuario(TipoUsuario tipoUsuario) {
		this.tipoUsuario = tipoUsuario;
	}


	
	
}