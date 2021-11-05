package xp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;

public class T_vendedor {
	private static final String ins = "INSERT INTO public.vendedor(id,nombre,apellido,tipodoc,numdoc,claveAcceso) VALUES(?,?,?,?,?,?)";
	private static final String bus = "SELECT * FROM public.vendedor WHERE nombre=?";
	private static final String tod = "SELECT * FROM public.vendedor";
	private static final String next_id = "SELECT nextval('public.seq_id') as num";
	private static final String del = "DELETE FROM public.vendedor WHERE Id=?";

	public T_vendedor() {	}
	
	public void insert(String nombre, String apellido, String tipoDoc, String nrodoc, String claveacceso) {
		Connection con = null;
		PreparedStatement ps =  null;
		con = ConnectionMA.get();
		try{
		ps = con.prepareStatement(ins);
		ps.setInt(1,this.nextId());
		ps.setString(2,nombre);
		ps.setString(3,apellido);
		ps.setString(4,tipoDoc);
		ps.setString(5,nrodoc);
		ps.setString(6,claveacceso);
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
		//ps = con.prepareStatement(del);
		//ps.setInt(1,id);
		
		ps = con.createStatement();
		System.out.println(id);
		int nro=ps.executeUpdate("DELETE FROM public.vendedor WHERE Id="+id+"");
		
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
			fila.add(rs.getString("nombre"));
			fila.add(rs.getString("apellido"));
			fila.add(rs.getString("numdoc"));			
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
	
}
