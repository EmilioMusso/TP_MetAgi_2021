package xp.db;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import xp.model.Propietario;

public class T_propietario {
	private static final String ins = "INSERT INTO public.propietario(id,nombre,apellido,tipdoc,numdoc,calle,numdom,provincia,localidad,telefono,email) VALUES(?,?,?,?,?,?,?,?,?,?,?)";
	private static final String bus = "SELECT * FROM public.propietario WHERE nombre=?";
	private static final String busid = "SELECT * FROM public.propietario WHERE id=?";
	private static final String tod = "SELECT * FROM public.propietario";
	private static final String next_id = "SELECT nextval('public.seq_id') as num";
	private static final String del = "DELETE FROM public.propietario WHERE Id=?";
	
	
	public T_propietario() {
		super();
	}

	

	public void insert(String nombre,String apellido, String tipdoc, String nrodoc,String calle,String nrodom,String provincia,String localidad,String telefono,String email) {
		Connection con = null;
		PreparedStatement ps =  null;
		con = ConnectionMA.get();
		try{
		ps = con.prepareStatement(ins);
		ps.setInt(1,this.nextId());
		ps.setString(2,nombre);
		ps.setString(3,apellido);
		ps.setString(4,tipdoc);
		ps.setString(5,nrodoc);
		ps.setString(6,calle);
		ps.setString(7,nrodom);
		ps.setString(8,provincia);
		ps.setString(9,localidad);
		ps.setString(10,telefono);
		ps.setString(11,email);
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
	
	public void delete(Object id){
		Connection con = null;
		Statement ps =  null;
		con = ConnectionMA.get();
		try{
		//ps = con.prepareStatement(del);
		//ps.setInt(1,id);
		
		ps = con.createStatement();
		int nro=ps.executeUpdate("DELETE FROM public.propietario WHERE Id="+id+"");
		
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
			
			fila.add(rs.getString("Id"));
			fila.add(rs.getString("nombre"));
			fila.add(rs.getString("apellido"));
			fila.add(rs.getString("tipdoc"));
			fila.add(rs.getString("numdoc"));
			fila.add(rs.getString("calle"));
			fila.add(rs.getString("numdom"));
			fila.add(rs.getString("provincia"));
			fila.add(rs.getString("localidad"));
			fila.add(rs.getString("telefono"));
			fila.add(rs.getString("email"));
			
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
	
	public ArrayList<Propietario> buscarTodos() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		
		ArrayList<Propietario> propietarios = new ArrayList<Propietario>();
		
		try{
			ps = con.prepareStatement(tod);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Propietario p = new Propietario(Integer.parseInt(rs.getString("Id")),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("tipdoc"),
						rs.getString("numdoc"),
						rs.getString("calle"),
						rs.getString("numdom"),
						rs.getString("provincia"),
						rs.getString("localidad"),
						rs.getString("telefono"),
						rs.getString("email"));
				
				propietarios.add(p);
			}
		}
				
		catch (SQLException e) {
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
		return propietarios;
	}
	
	public ArrayList<String> buscar_nombres() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> nombres = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(tod);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			nombres.add(rs.getString("nombre"));
			
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
		return nombres;
		}
	
	
	public void buscar(String nombre, List<String> lis) {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		
		con = ConnectionMA.get();
		try{
			ps = con.prepareStatement(bus);
			ps.setString(1,nombre);
			rs = ps.executeQuery();
			
			while(rs.next()) { 
				lis.add(rs.getString(2));}
				
		} catch(SQLException e) {
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
		}
	
	public static Propietario buscarPorId(Integer id) {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		ArrayList<Propietario> propietarios = new ArrayList<Propietario>();
		
		con = ConnectionMA.get();
		try{
			ps = con.prepareStatement(busid);
			ps.setInt(1,id);
			rs = ps.executeQuery();
			
			while(rs.next()) {
				Propietario p = new Propietario(Integer.parseInt(rs.getString("Id")),
						rs.getString("nombre"),
						rs.getString("apellido"),
						rs.getString("tipdoc"),
						rs.getString("numdoc"),
						rs.getString("calle"),
						rs.getString("numdom"),
						rs.getString("provincia"),
						rs.getString("localidad"),
						rs.getString("telefono"),
						rs.getString("email"));
				
				propietarios.add(p);
			}
			
			return propietarios.get(0);
				
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
		return null;
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
		
		

