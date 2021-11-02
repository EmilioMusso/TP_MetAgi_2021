package xp.model;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import xp.db.ConnectionMA;

public class Vendedor {
	private static final String ins = "INSERT INTO public.vendedor(id,nombre,apellido,numdoc,claveAcceso) VALUES(?,?,?,?,?,?,?,?,?,?)";
	private static final String bus = "SELECT * FROM public.vendedor WHERE nombre=?";
	private static final String tod = "SELECT * FROM public.vendedor";
	private static final String next_id = "SELECT nextval('public.seq_id') as num";
	private static final String del = "DELETE FROM public.vendedor WHERE Id=?";

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


	public void delete(Object id){
		Connection con = null;
		Statement ps =  null;
		con = ConnectionMA.get();
		try{
		//ps = con.prepareStatement(del);
		//ps.setInt(1,id);
		
		ps = con.createStatement();
		int nro=ps.executeUpdate("DELETE FROM public.vendedor WHERE Id="+id+"");
		
		}catch (SQLException e) {e.printStackTrace();
		}finally {
			if (con!=null)
				try {con.close ();}
				catch (SQLException e) {e.printStackTrace();}
			if (ps!=null)
				try {ps.close ();}
				catch (SQLException e) {e.printStackTrace();}
			
			}
		}



	public void insert(String nombre, String apellido, String nrodoc, String claveacceso) {
		Connection con = null;
		PreparedStatement ps =  null;
		con = ConnectionMA.get();
		try{
		ps = con.prepareStatement(ins);
		ps.setInt(1,this.nextId());
		ps.setString(2,nombre);
		ps.setString(3,apellido);
		ps.setString(4,nrodoc);
		ps.setString(5,claveacceso);
		ps.executeUpdate();
		
		}catch (SQLException e) {e.printStackTrace();
		}finally {
			if (con!=null)
				try {con.close ();}
				catch (SQLException e) {e.printStackTrace();}
			if (ps!=null)
				try {ps.close ();}
				catch (SQLException e) {e.printStackTrace();}
			
			}
		}
	
	public Integer nextId() {
		Integer newId = -1;
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		try{
		ps = con.prepareStatement(next_id);
		rs = ps.executeQuery();
		if(rs.next()) {newId = rs.getInt(1);}
		
		}catch (SQLException e) {e.printStackTrace();
		}finally {
			if (con!=null)
				try {con.close ();}
				catch (SQLException e) {e.printStackTrace();}
			if (ps!=null)
				try {ps.close ();}
				catch (SQLException e) {e.printStackTrace();}
			if (rs!=null)
				try {rs.close ();}
				catch (SQLException e) {e.printStackTrace();}
			
			}
		return newId;
	}
	
}
