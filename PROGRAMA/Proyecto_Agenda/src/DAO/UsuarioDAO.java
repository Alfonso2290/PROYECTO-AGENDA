
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
            sql+="WHERE NOMBRE_USUARIO=?";
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
    
    public int registraUsuario(UsuarioBEAN usuario)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO USUARIO VALUES (?,?,?,?,?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usuario.getCodigo());
            instruccion.setString(2, usuario.getNombreUsuario());
            instruccion.setString(3, usuario.getClave());
            instruccion.setString(4, usuario.getTipo());
            instruccion.setString(5, usuario.getNombre());
            instruccion.setString(6, usuario.getApellidoPat());
            instruccion.setString(7, usuario.getApellidoMat());
            instruccion.setString(8, usuario.getTelefono());
            instruccion.setString(9, usuario.getCorreo());
            i=instruccion.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usted ha registrado el nuevo usuario exitosamente");        
        } 
        catch (Exception e) 
        {
            
        }
        
        return i;
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
            
        } 
        catch (Exception e) 
        {
            
        }
        
        return codigo;
    }
    
    public int verificarCuentaDeUsuario(UsuarioBEAN usu)
    {
        int cont=0;
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT NOMBRE_USUARIO,CLAVE FROM USUARIO WHERE NOMBRE_USUARIO=? AND CLAVE=?";
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
            sql="SELECT CODIGO FROM USUARIO WHERE NOMBRE_USUARIO=?";
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
    
    public ArrayList<UsuarioBEAN> getNombresUsuarios()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT NOMBRE_USUARIO FROM USUARIO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN usuario=new UsuarioBEAN();
                usuario.setNombreUsuario(tabla.getString(1));
                
                lista.add(usuario);
            }
            
        } 
        catch (Exception e) {
        }
        
        return lista;
    }
    
    public ArrayList<UsuarioBEAN> getTiposUsuarios()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT DISTINCT TIPO FROM USUARIO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN usuario=new UsuarioBEAN();
                usuario.setTipo(tabla.getString(1));
                
                lista.add(usuario);
            }
            
        } 
        catch (Exception e) {
        }
        
        return lista;
    }
    
    public ArrayList<UsuarioBEAN> listarUsuarios()
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM USUARIO";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN ususario=new UsuarioBEAN();
                ususario.setCodigo(tabla.getString(1));
                ususario.setNombreUsuario(tabla.getString(2));
                ususario.setClave(tabla.getString(3));
                ususario.setTipo(tabla.getString(4));
                ususario.setNombre(tabla.getString(5));
                ususario.setApellidoPat(tabla.getString(6));
                ususario.setApellidoMat(tabla.getString(7));
                ususario.setTelefono(tabla.getString(8));
                ususario.setCorreo(tabla.getString(9));
                
                lista.add(ususario);
            }
            
        } 
        catch (Exception e) {
        }
        
        return lista;
    }
    
    public ArrayList<UsuarioBEAN> listarUsuariosFiltroUsuario(UsuarioBEAN usu)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM USUARIO WHERE NOMBRE_USUARIO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,usu.getNombreUsuario());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN ususario=new UsuarioBEAN();
                ususario.setCodigo(tabla.getString(1));
                ususario.setNombreUsuario(tabla.getString(2));
                ususario.setClave(tabla.getString(3));
                ususario.setTipo(tabla.getString(4));
                ususario.setNombre(tabla.getString(5));
                ususario.setApellidoPat(tabla.getString(6));
                ususario.setApellidoMat(tabla.getString(7));
                ususario.setTelefono(tabla.getString(8));
                ususario.setCorreo(tabla.getString(9));
                
                lista.add(ususario);
            }
            
        } 
        catch (Exception e) {
        }
        
        return lista;
    }
    
    public ArrayList<UsuarioBEAN> listarUsuariosFiltroTipoUsuario(UsuarioBEAN usu)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM USUARIO WHERE TIPO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,usu.getTipo());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN ususario=new UsuarioBEAN();
                ususario.setCodigo(tabla.getString(1));
                ususario.setNombreUsuario(tabla.getString(2));
                ususario.setClave(tabla.getString(3));
                ususario.setTipo(tabla.getString(4));
                ususario.setNombre(tabla.getString(5));
                ususario.setApellidoPat(tabla.getString(6));
                ususario.setApellidoMat(tabla.getString(7));
                ususario.setTelefono(tabla.getString(8));
                ususario.setCorreo(tabla.getString(9));
                
                lista.add(ususario);
            }
            
        } 
        catch (Exception e) {
        }
        
        return lista;
    }
    
    public ArrayList<UsuarioBEAN> listarUsuariosFiltroTipoUsuario_Usuario(UsuarioBEAN usu)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT * FROM USUARIO WHERE TIPO=? AND NOMBRE_USUARIO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1,usu.getTipo());
            instruccion.setString(2,usu.getNombreUsuario());
            tabla=instruccion.executeQuery();
            lista=new ArrayList<UsuarioBEAN>();
            
            while(tabla.next())
            {
                UsuarioBEAN ususario=new UsuarioBEAN();
                ususario.setCodigo(tabla.getString(1));
                ususario.setNombreUsuario(tabla.getString(2));
                ususario.setClave(tabla.getString(3));
                ususario.setTipo(tabla.getString(4));
                ususario.setNombre(tabla.getString(5));
                ususario.setApellidoPat(tabla.getString(6));
                ususario.setApellidoMat(tabla.getString(7));
                ususario.setTelefono(tabla.getString(8));
                ususario.setCorreo(tabla.getString(9));
                
                lista.add(ususario);
            }
            
        } 
        catch (Exception e) {
        }
        
        return lista;
    }
    
    public String getTipoUsuario(UsuarioBEAN usuario)
    {
        String tipo="";
        try 
        {
            conexion=new ConexionBD();
            sql="SELECT TIPO FROM USUARIO ";
            sql+="WHERE NOMBRE_USUARIO=?";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, usuario.getNombreUsuario());
            tabla=instruccion.executeQuery();
            
            if(tabla.next())
                tipo=tabla.getString(1);
            
        } 
        catch (Exception e) {
        }
        
        return tipo;
    }
}
