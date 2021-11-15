package xp;

import java.util.ArrayList;

import xp.db.T_propietario;
import xp.db.T_vendedor;
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
	private ArrayList<Provincia> provinciasSistema;
	
	public AppSistema() {
		this.vendedoresSistema = new ArrayList<Vendedor>();
		this.propietariosSistema = new ArrayList<Propietario>();
		this.inmueblesSistema = new ArrayList<Inmueble>();
		
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
		localidadesSistema.add(new Localidad("Santa Fe"));
		localidadesSistema.add(new Localidad("Santo Tomé"));
		localidadesSistema.add(new Localidad("Sauce Viejo"));
		localidadesSistema.add(new Localidad("Rincón"));
		localidadesSistema.add(new Localidad("Colastiné Norte"));
		localidadesSistema.add(new Localidad("Colastiné Sur"));
		
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

	public ArrayList<Provincia> getProvinciasSistema() {
		return provinciasSistema;
	}

	public Integer cantDeVendedores() {
		return vendedoresSistema.size();
	}
	
	public void agregarLocalidad(String nombre) {
		this.localidadesSistema.add(new Localidad(nombre));
	}
	
}