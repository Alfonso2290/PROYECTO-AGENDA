
package PANELES.Administrador;

import BEAN.ContactoBEAN;
import BEAN.UsuarioBEAN;
import DAO.ContactoDAO;
import DAO.UsuarioDAO;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;

public class PanelVentanaMostrarContactos extends JPanel
{
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton btnBuscar;
    private JComboBox cbDistrito,cbNombre;
    private ArrayList<ContactoBEAN> lista;
    private String nombreUsuario;
    
    public PanelVentanaMostrarContactos(String nombreUsuario)
    {
        this.nombreUsuario=nombreUsuario;
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        cbNombre=new JComboBox();
        cbNombre.addItem("-Seleccionar Nombre-");
        cbNombre.addItem("Alfonso");
        cbNombre.addItem("Juan");
        cbNombre.addItem("Miguel");
        cbNombre.setBounds(375, 30, 150, 30);
        
        cbDistrito=new JComboBox();
        cbDistrito.addItem("-Seleccionar Distrito-");
        cbDistrito.addItem("Pueblo Libre");
        cbDistrito.addItem("Magdalena");
        cbDistrito.addItem("San Miguel");
        cbDistrito.setBounds(550, 30, 150, 30);
        
        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(725, 30, 80, 30);
        
        modelo=new DefaultTableModel();
        tabla=new JTable();
        scroll=new JScrollPane(tabla);
        
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Edad");
        modelo.addColumn("Distrito");
        modelo.addColumn("Dirección");
        modelo.addColumn("Email");
        
        tabla.setModel(modelo);
        
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        String cod_usu=usuarioDAO.getCodigoUsuario(nombreUsuario);
        UsuarioBEAN usuario=new UsuarioBEAN();
        usuario.setCodigo(cod_usu);
        ContactoDAO contactoDAO=new ContactoDAO();
        lista=contactoDAO.listarContactos(usuario);
        
        for(ContactoBEAN obj:lista)
        {
            modelo.addRow(new Object[]{obj.getDni(),obj.getNombre(),
            obj.getApellidoPat() + " " + obj.getApellidoMat(),obj.getTelefono(),obj.getEdad(),
            obj.getDistrito(),obj.getDireccion(),obj.getCorreo()});
        }
        
        scroll.setBounds(10,80,800,250);
        
        add(cbDistrito);
        add(cbNombre);
        add(btnBuscar);
        add(scroll);
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JComboBox getCbDistrito() {
        return cbDistrito;
    }

    public JComboBox getCbNombre() {
        return cbNombre;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
