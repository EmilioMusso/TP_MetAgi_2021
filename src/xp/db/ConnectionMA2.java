package xp.db;

import java.security.PublicKey;
import java.sql.Connection;
import java.sql.DatabaseMetaData;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.logging.Level;
import java.util.logging.Logger;

import org.ietf.jgss.GSSManager;

public class ConnectionMA2 {
	
	
	   static final String DB_URL = "jdbc:postgresql://localhost/";
	   static final String USER = "guest";
	   static final String PASS = "guest123";

	   public ConnectionMA2() {
	      // Open a connection
	      try(Connection conn = DriverManager.getConnection(DB_URL, USER, PASS);
	         Statement stmt = conn.createStatement();
	      ) {		      
	         String sql = "CREATE DATABASE STUDENTS";
	         stmt.executeUpdate(sql);
	         System.out.println("Database created successfully...");   	  
	      } catch (SQLException e) {
	         e.printStackTrace();
	      } 
	   }
	
/*	
	private static final String url = "jdbc:postgresql:/MyDB.";
	private static final String user = "postgres";
	private static final String pass = "777611";
	
	//private ConnectionP(){ }
	
	public static Connection get() {	//throws PgException{
		Connection conn = DataBase.getC;
		try {
			Class.forName("org.postgresql.Driver");
			conn = DriverManager.getConnection(url, user, pass);
		}catch (ClassNotFoundException ex) {
			ex.printStackTrace();
			//Logger.getLogger(ConnectionP.class.getName()).log(Level.SEVERE,null,ex);
			//throw new PgException
		}catch (SQLException ex) {
			ex.printStackTrace();
		}
		return conn;
	}
*/	
    

	public static Connection get() {
		// TODO Auto-generated method stub
		return null;
	}
}
