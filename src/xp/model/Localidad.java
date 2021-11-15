package xp.model;

public class Localidad { //TODO sobrevive por si acaso necesitamos algun dato mas de la localidad
	
	private String nombre;
	private String codPostal;
	
	public Localidad() {}
	
	public Localidad(String nombre) {
		this.nombre = nombre;
	}

	public String getNombre() {
		return this.nombre;
	}
	
}
