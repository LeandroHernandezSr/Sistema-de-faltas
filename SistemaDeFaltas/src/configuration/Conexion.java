package configuration;

import java.sql.*;

import model.*;


public class Conexion extends Persona {
		
		static boolean confirmacion;
		private String url="jdbc:mysql://localhost/registro";
		private String userDB="root";
		private String passwordDB="root";
		
		
		public Conexion() {
			cargarDriver();
		}


		
		public String consulta(){
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				ResultSet result=command.executeQuery("SELECT user, password, `type` FROM registro.personas where user='"+getUser()+"' and password='"+getPassword()+"'");
				if(result.next()==true) {
					confirmacion=true;
				}else {
					confirmacion=false;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			String hola="Es: "+confirmacion;
			return hola;
		}
		
		
		
		private void cargarDriver() {
		    try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		    }catch(Exception ex) {
		      
		    }
		  }
								
}
