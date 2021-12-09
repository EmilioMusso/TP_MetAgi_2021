package xp.model;

import java.awt.Desktop;
import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Date;
import java.time.LocalDate;

import javax.swing.JOptionPane;

import com.lowagie.text.Document;
import com.lowagie.text.DocumentException;
import com.lowagie.text.Paragraph;
import com.lowagie.text.pdf.PdfWriter;

public class Reserva {
	String idI;
	String calleI;
	String numeroI;
	String localidadI;
	String idCliente;
	String precio;
	LocalDate fecha;
	
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
	public String getPrecio() {
		return precio;
	}
	public void setPrecio(String precio) {
		this.precio = precio;
	}
	public LocalDate getFecha() {
		return fecha;
	}
	public void setFecha(LocalDate fecha) {
		this.fecha = fecha;
	}
	

	
}