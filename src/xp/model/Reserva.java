package xp.model;

public class Reserva {
	String idI;
	String calleI;
	String numeroI;
	String localidadI;
	String idCliente;
	
	public Reserva(String idI, String calleI, String numeroI, String localidadI, String idCliente) {
		super();
		this.idI = idI;
		this.calleI = calleI;
		this.numeroI = numeroI;
		this.localidadI = localidadI;
		this.idCliente = idCliente;
	}
	
	public Reserva() {
		
	}
	
	public String getIdI() {
		return idI;
	}

	public void setIdI(String idI) {
		this.idI = idI;
	}

	public String getCalleI() {
		return calleI;
	}

	public void setCalleI(String calleI) {
		this.calleI = calleI;
	}

	public String getNumeroI() {
		return numeroI;
	}

	public void setNumeroI(String numeroI) {
		this.numeroI = numeroI;
	}

	public String getLocalidadI() {
		return localidadI;
	}

	public void setLocalidadI(String localidadI) {
		this.localidadI = localidadI;
	}

	public String getIdCliente() {
		return idCliente;
	}

	public void setIdCliente(String idCliente) {
		this.idCliente = idCliente;
	}

	
}
