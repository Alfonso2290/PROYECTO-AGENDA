
package DAO;

import BEAN.PersonaBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;
import javax.swing.JOptionPane;

public class PersonaDAO 
{
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList <PersonaBEAN> lista=null;
    
    public void registraPersona(PersonaBEAN persona)
    {
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO PERSONA VALUES (?,?,?,?,?,?,?,?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, persona.getDni());
            instruccion.setString(2, persona.getNombre());
            instruccion.setString(3, persona.getApellidoPat());
            instruccion.setString(4, persona.getApellidoMat());
            instruccion.setString(5, persona.getTelefono());
            instruccion.setInt(6, persona.getEdad());
            instruccion.setString(7, persona.getDistrito());
            instruccion.setString(8, persona.getDireccion());
            instruccion.setString(9, persona.getCorreo());
            instruccion.executeUpdate();
                    
        } 
        catch (Exception e) 
        {
            
        }
    }
}
