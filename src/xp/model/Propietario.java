package xp.model;

import java.util.ArrayList;

import xp.AppSistema;

public class Propietario {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private String numDoc;
	private String calle;
	private String numeroDir;
	private String provincia;
	private String localidad;
	private String telefono;
	private String email;
	
	public Propietario(AppSistema appSistema) {
		super();
	}

	public Propietario(Integer id, String nombre, String apellido, String tipoDoc, String numDoc, String calle,
			String numeroDir, String provincia, String localidad, String telefono, String email) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.numDoc = numDoc;
		this.calle = calle;
		this.numeroDir = numeroDir;
		this.provincia = provincia;
		this.localidad = localidad;
		this.telefono = telefono;
		this.email = email;
	}

	@Override
	public String toString() {
		return "Propietario [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	

	
}