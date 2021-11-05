package xp;

import java.util.ArrayList;

import xp.model.Propietario;
import xp.model.Vendedor;

public class AppSistema {
	private ArrayList<Vendedor> vendedoresSistema = new ArrayList<Vendedor>();
	private ArrayList<Propietario> propietariosSistema = new ArrayList<Propietario>();
	
	public AppSistema() {
		Vendedor v1 = new Vendedor("Lucia", null, null, null, null);
		Vendedor v2 = new Vendedor("German", null, null, null, null);
		Vendedor v3 = new Vendedor("Emilio", null, null, null, null);
		vendedoresSistema.add(v1);
		
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
	
	public Integer cantDeVendedores() {
		return vendedoresSistema.size();
	}
	
	
}