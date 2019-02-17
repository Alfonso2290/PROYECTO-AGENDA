
package DAO;

import BEAN.ContactoBEAN;
import BEAN.UsuarioBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;

public class ContactoDAO 
{
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList <ContactoBEAN> lista=null;
    
    public String generarCodigo()
    {
        String codigo="C001",temp;
        int temp2;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT MAX(CODIGO) FROM CONTACTO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
            {
                temp=tabla.getString(1);
                temp2=Integer.parseInt(temp.charAt(1) + "" + temp.charAt(2) + "" + temp.charAt(3));
                temp2++;
                if(temp2<10)
                    codigo="C00" + temp2 + "";
                else if(temp2<100)
                    codigo="C0" + temp2 + "";
                else if(temp2<1000)
                    codigo="C" + temp2 + ""; 
            }
            
            tabla.close();
            conexion.cerrarConexion();
            instruccion.close();
        } 
        catch (Exception e) 
        {}
        
        return codigo;
    }
    
    public void registraContacto(ContactoBEAN contacto)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO CONTACTO VALUES (?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, contacto.getCodigo());
            instruccion.setString(2, contacto.getDni());
            instruccion.executeUpdate();
                    
            tabla.close();
            conexion.cerrarConexion();
            instruccion.close();
        } 
        catch (Exception e) {
        }
    }
    
    public int verificarPersona(ContactoBEAN contacto)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DNI FROM CONTACTO WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, contacto.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i++;
            
            tabla.close();
            conexion.cerrarConexion();
            instruccion.close();
        } 
        catch (Exception e) {
        }
        
        return i;
    }
    
    public String getCodigoContacto(ContactoBEAN contacto)
    {
        String codigo="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT CODIGO FROM CONTACTO WHERE DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, contacto.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                codigo=tabla.getString(1);
            
            tabla.close();
            conexion.cerrarConexion();
            instruccion.close();
        } 
        catch (Exception e) {
        }
        
        return codigo;
    }
    
    public int verificarContacto(ContactoBEAN contacto,UsuarioBEAN usuario)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT COUNT(*) ";
            sql+="FROM AGENDA A INNER JOIN CONTACTO B  ";
            sql+="ON A.CODIGO_CONTACTO = B.CODIGO ";
            sql+="INNER JOIN USUARIO C ";
            sql+="ON C.CODIGO=A.CODIGO_USUARIO ";
            sql+="WHERE C.CODIGO=? AND B.DNI=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usuario.getCodigo());
            instruccion.setString(2, contacto.getDni());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                i=tabla.getInt(1);
            
        } 
        catch (Exception e) {
        }
        
        return i;
    }
}
