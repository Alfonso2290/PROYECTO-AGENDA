
package DAO;

import BEAN.AgendaBEAN;
import UTIL.ConexionBD;
import java.sql.*;
import java.util.*;
import javax.swing.*;

public class AgendaDAO 
{
    private ConexionBD conexion=null;
    private PreparedStatement instruccion=null;
    private ResultSet tabla=null;
    private String sql="";
    private ArrayList <AgendaBEAN> lista=null;
    
    public int registraAgenda(AgendaBEAN agenda)
    {
        int i=0;
        try 
        {
            conexion=new ConexionBD();
            sql="INSERT INTO AGENDA VALUES (?,?)";
            instruccion=conexion.getConexionBD().prepareStatement(sql);
            instruccion.setString(1, agenda.getCodigoUsuario());
            instruccion.setString(2, agenda.getCodigoContacto());
            i=instruccion.executeUpdate();
            JOptionPane.showMessageDialog(null, "Usted ha registrado el nuevo contacto exitosamente");        

        } 
        catch (Exception e)
        {
            JOptionPane.showMessageDialog(null, "Error!!..Verifique los datos ingresados");
        }
        
        return i;
    }
}
