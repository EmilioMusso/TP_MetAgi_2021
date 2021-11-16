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

	@Override
	public String toString() {
		return "Cliente [id=" + id + ", nombre=" + nombre + ", apellido=" + apellido + "]";
	}
	

	
}
