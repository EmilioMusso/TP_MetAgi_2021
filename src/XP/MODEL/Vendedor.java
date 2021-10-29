package XP.MODEL;

public class Vendedor {

	private String nombre;
	private String apellido;
	private String dni;
	private String claveAcceso;
	
	public Vendedor() {	}

	public Vendedor(String nombre, String apellido, String dni, String claveAcceso) {
		this.nombre = nombre;
		this.apellido = apellido;
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
	
	
	
}
