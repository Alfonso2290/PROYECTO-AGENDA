
package DAO;

import BEAN.UsuarioBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;

public class UsuarioDAO 
{
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList <UsuarioBEAN> lista=null;
    
    public int verificarCuentaDeUsuario(UsuarioBEAN usu)
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT NOMBRE,CLAVE FROM USUARIO WHERE NOMBRE=? AND CLAVE=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,usu.getNombreUsuario());
            instruccion.setString(2,usu.getClave());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                cont++;
            
            tabla.close();
            conexion.cerrarConexion();
            instruccion.close();
            
            
        }catch (Exception e) {}
        
        return cont;
    }
}
