
package configuration;

import java.sql.*;

import model.*;
import repository.CrudRepository;


public class Conexion extends Persona implements CrudRepository{
		
		private static boolean confirmacion;
		
		public Conexion() {
			cargarDriver();
		}		
				
		@Override
		public boolean consulta(){
			try {
				Connection conexion=DriverManager.getConnection(url,userDB,passwordDB);
				Statement command=conexion.createStatement();
				ResultSet 
				result=command.executeQuery("SELECT user, password, `type` FROM registro.personas where user='"+getUser()+"' and password='"+getPassword()+"'");
				if(result.next()==true) {
					confirmacion=true;
				}else {
					confirmacion=false;
				}
			} catch (SQLException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}			
			return confirmacion;
		}
		
		@Override
		public void alta() {
			// TODO Auto-generated method stub
			
		}
		
		private void cargarDriver() {
		    try {
		      Class.forName("com.mysql.cj.jdbc.Driver");
		    }catch(Exception ex) {
		      
		    }
		  }		
							
}
