package com.gms.Db;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;

public class ConnectionDb {
	 public static Connection getConn() {
		    String loadDriver="com.mysql.cj.jdbc.Driver";
		    String dbURL="jdbc:mysql://localhost:3306/zumba";
		    String dbUSERNAME="root";
		    String dbPASSWORD="VICKY007vicky@$";
		    
		    Connection con = null;
		    try {
		      Class.forName(loadDriver);
		      con = DriverManager.getConnection(dbURL,dbUSERNAME,dbPASSWORD);
		    } catch (ClassNotFoundException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    } catch (SQLException e) {
		      // TODO Auto-generated catch block
		      e.printStackTrace();
		    }
		    return con;
		  }
}
