package xp.model;


public class Vendedor {

	private String nombre;
	private String apellido;
	private String tipoDoc;
	private String dni;
	private String claveAcceso;
	
	public Vendedor() {	}


	public Vendedor(String nombre, String apellido, String tipoDoc, String dni, String claveAcceso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.tipoDoc = tipoDoc;
		this.dni = dni;
		this.claveAcceso = claveAcceso;
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

	public String getDni() {
		return dni;
	}

	public void setDni(String dni) {
		this.dni = dni;
	}

	public String getClaveAcceso() {
		return claveAcceso;
	}

	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}


	@Override
	public String toString() {
		return "Vendedor [nombre=" + nombre + ", apellido=" + apellido + ", tipoDoc=" + tipoDoc + ", dni=" + dni
				+ ", claveAcceso=" + claveAcceso + "]";
	}
	
	
}
