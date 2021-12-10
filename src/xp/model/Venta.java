package xp.model;

import java.time.LocalDate;
import java.util.Date;

public class Venta {
	String idI;
	String codigoI;
	String barrioI;
	String nombreC;
	String apellidoC;
	String dniC;
	String monto;
	LocalDate fecha;
	
	public Venta() {
		
	}
	
	public Venta(String idI, String codigoI, String barrioI, String nombreC, String apellidoC, String dniC,
			String monto) {
		super();
		this.idI = idI;
		this.codigoI = codigoI;
		this.barrioI = barrioI;
		this.nombreC = nombreC;
		this.apellidoC = apellidoC;
		this.dniC = dniC;
		this.monto = monto;
	}
	
	
	
	
	public LocalDate getFecha() {
		return fecha;
	}

	public void setFecha(LocalDate localDate) {
		this.fecha = localDate;
	}

	public String getIdI() {
		return idI;
	}
	public void setIdI(String idI) {
		this.idI = idI;
	}
	public String getCodigoI() {
		return codigoI;
	}
	public void setCodigoI(String codigoI) {
		this.codigoI = codigoI;
	}
	public String getBarrioI() {
		return barrioI;
	}
	public void setBarrioI(String barrioI) {
		this.barrioI = barrioI;
	}
	public String getNombreC() {
		return nombreC;
	}
	public void setNombreC(String nombreC) {
		this.nombreC = nombreC;
	}
	public String getApellidoC() {
		return apellidoC;
	}
	public void setApellidoC(String apellidoC) {
		this.apellidoC = apellidoC;
	}
	public String getDniC() {
		return dniC;
	}
	public void setDniC(String dniC) {
		this.dniC = dniC;
	}
	public String getMonto() {
		return monto;
	}
	public void setMonto(String monto) {
		this.monto = monto;
	}
	
	
}
