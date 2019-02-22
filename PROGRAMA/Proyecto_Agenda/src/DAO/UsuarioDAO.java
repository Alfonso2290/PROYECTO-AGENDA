
package DAO;

import BEAN.UsuarioBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class UsuarioDAO 
{
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList <UsuarioBEAN> lista=null;
    
    public int verificarNombreUsuario(UsuarioBEAN usuario)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) FROM USUARIO ";
            sql+="WHERE NOMBRE=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usuario.getNombreUsuario());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
    
    public void registraUsuario(UsuarioBEAN usuario)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO USUARIO VALUES (?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usuario.getCodigo());
            instruccion.setString(2, usuario.getNombreUsuario());
            instruccion.setString(3, usuario.getClave());
            instruccion.setString(4, usuario.getTipo());
            instruccion.setString(5, usuario.getDni());
            instruccion.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usted ha registrado el nuevo usuario exitosamente");        
        } 
        catch (Exception e) 
        {
            JOptionPane.showMessageDialog(null, "Error!!..Verifique los datos ingresados");
        }
    }
    
    public String generarCodigo()
    {
        String codigo="U001",temp;
        int temp2;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(CODIGO) FROM USUARIO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                temp=tabla.getString(1);
                temp2=Integer.parseInt(temp.charAt(1) + "" + temp.charAt(2) + "" + temp.charAt(3));
                temp2++;
                if(temp2<10)
                    codigo="U00" + temp2 + "";
                else if(temp2<100)
                    codigo="U0" + temp2 + "";
                else if(temp2<1000)
                    codigo="U" + temp2 + ""; 
            }
            
            tabla.close();
            conexion.cerrarConexion();
            instruccion.close();
        } 
        catch (Exception e) 
        {}
        
        return codigo;
    }
    
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
    
    public String getCodigoUsuario(String nombre)
    {
        String codigo="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT CODIGO FROM USUARIO WHERE NOMBRE=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,nombre);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                codigo=tabla.getString(1);
            
            tabla.close();
            conexion.cerrarConexion();
            instruccion.close();
            
            
        }catch (Exception e) {}
        
        return codigo;
    }
}
