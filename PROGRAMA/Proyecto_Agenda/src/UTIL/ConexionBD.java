
package UTIL;

import java.sql.*;

public class ConexionBD {

    private Connection conexion;
    
    public Connection getConexionBD()
    {
        conexion=null;
        try 
        {
            Class.forName("com.mysql.jdbc.Driver");
            conexion=DriverManager.getConnection("jdbc:mysql://localhost/AGENDA","root","Lacronfonso");
            //System.out.println("Conexión exitosa");
        } 
        catch (Exception e) 
        {
            System.out.println("Error!!");
        }
        
        return conexion;
    }
    
    public void cerrarConexion()
    {
        try 
        {
            conexion.close();
        }
        catch (Exception e) {}  
    }
    
//    public static void main(String[] args) 
//    {
//       ConexionBD obj=new ConexionBD();
//       obj.getConexionBD();
//    }
    
}
