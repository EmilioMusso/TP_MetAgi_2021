package xp.db;

import java.sql.Array;
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
//	private static final String ins = "INSERT INTO public.inmueble(id,"
//			+ "codigoInmueble,estadoInmueble,localidad,provincia,fechaCarga,"
//			+ "propietario, calle, pisoDpto, orientacion, tipoInmueble, barrio,"
//			+ "precio, telefono, frente, fondo, superficie, cantHabitaciones)"
//			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String ins = "INSERT INTO public.inmueble "
			+ "VALUES(?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?,?)";
	private static final String bus = "SELECT * FROM public.inmueble WHERE nombre=?"; //codigo
	private static final String consId = "SELECT * FROM public.inmueble WHERE =?";
	private static final String tod = "SELECT * FROM public.inmueble";
	private static final String consInm = "SELECT id, codigoInmueble, estadoInmueble, localidad, provincia, barrio, tipoInmueble, habitaciones, precio FROM public.inmueble"; 
	private static final String next_id = "SELECT nextval('public.seq_id') as num";
	private static final String del = "DELETE FROM public.inmueble WHERE Id=?";
	private static final String prov = "SELECT DISTINCT provincia FROM public.inmueble";
	private static final String loc = "SELECT DISTINCT localidad FROM public.inmueble";
	private static final String barr = "SELECT DISTINCT barrio FROM public.inmueble";
	private static final String tipo = "SELECT DISTINCT tipoInmueble FROM public.inmueble";
	private static final String hab = "SELECT DISTINCT habitaciones FROM public.inmueble";
	private static final String prec = "SELECT DISTINCT precio FROM public.inmueble";
	
	
	public T_inmueble() {	}
	
	public void insert(String codigoInmueble,
			String estadoInmueble,
			String localidad,
			String provincia,
			Date fechaCarga) throws SQLException {
		Connection con = null;
		PreparedStatement ps =  null;
		con = ConnectionMA.get();
		try{
		ps = con.prepareStatement(ins);
		ps.setInt(1,this.nextId());
		ps.setString(2,codigoInmueble);
		ps.setString(3,estadoInmueble);
		ps.setString(4,localidad);
		ps.setString(5,provincia);
		ps.setDate(6, null); //fechacarga
		ps.executeUpdate();
		System.out.println(ps.toString());
		
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			if (con!=null)
				try {con.close ();}
				catch (SQLException e) {e.printStackTrace();}
			if (ps!=null)
				try {ps.close ();}
				catch (SQLException e) {e.printStackTrace();}
			
			}
		}
	
	public void insertInmueble(Inmueble inm) throws SQLException { //TODO implementar propietario y fecha
		Connection con = null;
		PreparedStatement ps =  null;
		con = ConnectionMA.get();
		try{
			ps = con.prepareStatement(ins);
			ps.setInt(1,this.nextId());
			ps.setString(2,inm.getCodigoInmueble());
			ps.setString(3,inm.getEstadoInmueble().toString());
			ps.setString(4,inm.getLocalidad());
			ps.setString(5,inm.getProvincia());
			ps.setDate(6, (java.sql.Date) inm.getFechaCarga()); //fechacarga
			ps.setInt(7, 0); //propietario
			ps.setString(8, inm.getNumTelefono());
			ps.setString(9, inm.getCalle());
			ps.setInt(10, inm.getPisoDpto());
			ps.setString(11, inm.getOrientacion());
			ps.setString(12, inm.getTipoInmueble().toString());
			ps.setString(13, inm.getBarrio());
			ps.setInt(14, inm.getPrecio());
			ps.setInt(15, inm.getFrente());
			ps.setInt(16, inm.getFondo());
			ps.setInt(17, inm.getSuperficie());
			ps.setInt(18, inm.getHabitaciones());
			ps.setInt(19, inm.getBanios());
		
			ps.setArray(20, con.createArrayOf("BOOLEAN", new String[] {}));//Array de 12

			System.out.println(ps.toString());
			ps.executeUpdate();
		
		} catch (SQLException e) {
			throw new SQLException();
		} finally {
			if (con!=null)
				try {con.close ();}
				catch (SQLException e) {e.printStackTrace();}
			if (ps!=null)
				try {
					ps.close ();
				} catch (SQLException e) {
					e.printStackTrace();
				}
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

	public ArrayList<Object> buscar() {
		//genera una lista con todos los registros de una tabla
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<Object> fila = new ArrayList<Object>();
		
		try{
		ps = con.prepareStatement(tod);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			fila.add(rs.getString("id"));
			fila.add(rs.getString("codigoInmueble"));
			fila.add(rs.getString("estadoInmueble"));
			fila.add(rs.getString("localidad"));	
			fila.add(rs.getString("provincia"));	
			fila.add(rs.getDate("fechaCarga"));	
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
	
	public ArrayList<String> buscarS() {
		//genera una lista con todos los registros de una tabla
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> fila = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(consInm);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			fila.add(rs.getString("id"));
			fila.add(rs.getString("codigoInmueble"));
			fila.add(rs.getString("estadoInmueble"));
			fila.add(rs.getString("localidad"));	
			fila.add(rs.getString("provincia"));	
			fila.add(rs.getString("barrio"));
			fila.add(rs.getString("tipoInmueble"));
			fila.add(rs.getString("habitaciones"));
			fila.add(rs.getString("precio"));
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
	
	public ArrayList<String> buscarFiltro(String pv, String lc, String br, String tp, String dr, String pr) {
		//genera una lista con todos los registros de una tabla
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> fila = new ArrayList<String>();
		
		String filtro = consInm+" WHERE id>0";
				
		if(pv!=null) {filtro = filtro+" AND provincia="+"'"+pv+"'";}
		if(lc!=null) {filtro = filtro+" AND localidad="+"'"+lc+"'";}
		if(br!=null) {filtro = filtro+" AND barrio="+"'"+br+"'";}
		if(tp!=null) {filtro = filtro+" AND tipoinmueble="+"'"+tp+"'";}
		if(dr!=null) {filtro = filtro+" AND habitaciones="+"'"+dr+"'";}
		if(pr!=null) {filtro = filtro+" AND precio="+"'"+pr+"'";}
			
	
		System.out.println(filtro);
		
		try{
		ps = con.prepareStatement(filtro);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			fila.add(rs.getString("id"));
			fila.add(rs.getString("codigoInmueble"));
			fila.add(rs.getString("estadoInmueble"));
			fila.add(rs.getString("localidad"));	
			fila.add(rs.getString("provincia"));	
			fila.add(rs.getString("barrio"));
			fila.add(rs.getString("tipoInmueble"));
			fila.add(rs.getString("habitaciones"));
			fila.add(rs.getString("precio"));
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
//				i1 = new Inmueble(
//						rs.getString("id"),
//						rs.getString("codigoInmueble"),
//						rs.getString("estadoInmueble"),
//						rs.getString("localidad"),	
//						rs.getString("provincia"),	
//						rs.getString("fechaCarga"),
//						rs.getString("provincia"),
//						rs.getString("provincia"),
//						rs.getString("provincia"),
//						rs.getString("provincia"),
//						rs.getString("provincia"),
//						);
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
	
	public ArrayList<String> buscar_provincia() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> nombres = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(prov);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			nombres.add(rs.getString("provincia"));
			
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
	
	public ArrayList<String> buscar_localidad() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> nombres = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(loc);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			nombres.add(rs.getString("localidad"));
			
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

	public ArrayList<String> buscar_barrio() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> nombres = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(barr);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			nombres.add(rs.getString("barrio"));
			
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
	
	public ArrayList<String> buscar_tipo() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> nombres = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(tipo);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			nombres.add(rs.getString("tipoInmueble"));
			
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
	
	public ArrayList<String> buscar_habit() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> nombres = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(hab);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			nombres.add(rs.getString("habitaciones"));
			
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
	
	public ArrayList<String> buscar_precio() {
		Connection con = null;
		PreparedStatement ps =  null;
		ResultSet rs = null;
		con = ConnectionMA.get();
		ArrayList<String> nombres = new ArrayList<String>();
		
		try{
		ps = con.prepareStatement(prec);
		rs = ps.executeQuery();
		
		while(rs.next()) {
			nombres.add(rs.getString("precio"));
			
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
	
}
