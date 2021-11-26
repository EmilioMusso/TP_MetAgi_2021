package xp.model;

import java.util.ArrayList;

import xp.AppSistema;

public class Cliente {
	
	private Integer id;
	private String nombre;
	private String apellido;
	private String telefono;
	private String usuario;
	private String claveacceso;

	
	public Cliente(AppSistema appSistema) {
		super();
	}

	public Cliente(Integer id, String nombre, String apellido, String telefono, String usuario, String claveacceso) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
		this.usuario = usuario;
		this.claveacceso = claveacceso;
	}
	
	public Cliente(Integer id, String nombre, String apellido, String telefono) 
	{
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.telefono = telefono;
	}

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}

	public Integer getId() {
		return id;
	}

	public void setId(Integer id) {
		this.id = id;
	}

	public String getNombre() {
		return nombre;
	}

	public void setNombre(String nombre) {
		this.nombre = nombre;
	}

	public String getApellido() {
		return apellido;
	}

	public void setApellido(String apellido) {
		this.apellido = apellido;
	}

	public String getTelefono() {
		return telefono;
	}

	public void setTelefono(String telefono) {
		this.telefono = telefono;
	}

	public String getUsuario() {
		return usuario;
	}

	public void setUsuario(String usuario) {
		this.usuario = usuario;
	}

	public String getClaveacceso() {
		return claveacceso;
	}

	public void setClaveacceso(String claveacceso) {
		this.claveacceso = claveacceso;
	}

	

	
}
