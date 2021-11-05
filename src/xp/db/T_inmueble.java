package xp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.Date;

import xp.model.Inmueble;
import xp.model.Vendedor;

public class T_inmueble {
	private static final String ins = "INSERT INTO public.inmueble(id,nombre,apellido,tipodoc,numdoc,claveAcceso) VALUES(?,?,?,?,?,?)";
	private static final String bus = "SELECT * FROM public.inmueble WHERE nombre=?"; //codigo
	private static final String consId = "SELECT * FROM public.inmueble WHERE =?";
	private static final String tod = "SELECT * FROM public.inmueble";
	private static final String next_id = "SELECT nextval('public.seq_id') as num";
	private static final String del = "DELETE FROM public.inmueble WHERE Id=?";

	public T_inmueble() {	}
	
	public void insert(Integer codigoInmueble, Integer estadoInmueble, String localidad,String provincia,Date fechaCarga) {
		Connection con = null;
		PreparedStatement ps =  null;
		con = ConnectionMA.get();
		try{
		ps = con.prepareStatement(ins);
		ps.setInt(1,this.nextId());
		ps.setInt(2,codigoInmueble);
		ps.setString(3,localidad);
		ps.setString(4,provincia);
		ps.setDate(5,(java.sql.Date) fechaCarga); //esto no se si esta bien - corroborar 
		ps.executeUpdate();
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			if (con!=null)
				try {con.close ();}
				catch (SQLException e) {e.printStackTrace();}
			if (ps!=null)
				try {ps.close ();}
				catch (SQLException e) {e.printStackTrace();}
			
			}
		}
	
	public void delete(Object id){
		Connection con = null;
		Statement ps =  null;
		con = ConnectionMA.get();
		try{
		
		ps = con.createStatement();
		System.out.println(id);
		int nro=ps.executeUpdate("DELETE FROM public.inmueble WHERE Id="+id+"");
		
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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

	public ArrayList<String> buscar() {
		//genera una lista con todos los registros de una tabla
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> fila = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(tod);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			fila.add(rs.getString("id"));
			fila.add(rs.getString("codigoInmueble"));
			fila.add(rs.getString("estadoInmueble"));
			fila.add(rs.getString("localidad"));	
			fila.add(rs.getString("provincia"));	
			fila.add(rs.getString("fechaCarga"));	
		}}
				
		catch (SQLException e) {e.printStackTrace();
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
		return fila;
		}
	
	public Inmueble buscarInmueble(Object id) {
		//genera una lista con todos los registros de una tabla
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		Inmueble i1 = null;
		
		try {
			ps = con.prepareStatement("SELECT * FROM public.inmueble WHERE Id="+id.toString()+"");
			rs = ps.executeQuery();
			
			while(rs.next()) {
				i1 = new Inmueble(
						rs.getString("id"),
						rs.getInt("codigoInmueble"),
						rs.getInt("estadoInmueble"),
						rs.getString("localidad"),	
						rs.getString("provincia"),	
						rs.getDate("fechaCarga") );	
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
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
		return i1;
	}
	
}
