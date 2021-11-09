package xp.db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.logging.Level;
import java.util.logging.Logger;

public class ConnectionMA {
	private static final String url = "jdbc:postgresql://127.0.0.1:5432/ma2021";
	private static final String user = "postgres";
//	private static final String pass = "lea83"; //lea
//	private static final String pass = "777611"; //emi
	private static final String pass = "ma2021"; //lu
	//private ConnectionP(){ }
	
	public static Connection get() {	//throws PgException{
		Connection conn = null;
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
	
}
