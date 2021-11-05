package xp.model;

public class Vendedor {

	private Object id;
	private String nombre;
	private String apellido;
	private String tipoDoc;
	private String numDoc;
	private String claveAcceso;

	public Vendedor(String nombre, String apellido, String tipoDoc, String numDoc, String claveAcceso) {
		super();
		this.nombre = nombre;
		this.apellido = apellido;
		this.numDoc = numDoc;
		this.tipoDoc = tipoDoc;
		this.claveAcceso = claveAcceso;
	}

	public Vendedor(Object id, String nombre, String apellido, String numDoc) {
		super();
		this.id = id;
		this.nombre = nombre;
		this.apellido = apellido;
		this.numDoc = numDoc;
	}
	
	public Object getId() {
		return id;
	}

	public void setId(Object id) {
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


	public String getTipoDoc() {
		return tipoDoc;
	}


	public void setTipoDoc(String tipoDoc) {
		this.tipoDoc = tipoDoc;
	}


	public String getNumDoc() {
		return numDoc;
	}


	public void setNumDoc(String numDoc) {
		this.numDoc = numDoc;
	}


	public String getClaveAcceso() {
		return claveAcceso;
	}


	public void setClaveAcceso(String claveAcceso) {
		this.claveAcceso = claveAcceso;
	}
	
}
