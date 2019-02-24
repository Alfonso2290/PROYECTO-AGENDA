
package PANELES.Administrador;

import BEAN.ContactoBEAN;
import BEAN.UsuarioBEAN;
import DAO.ContactoDAO;
import DAO.UsuarioDAO;
import java.awt.*;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;
import java.net.URL;

public class PanelVentanaMostrarContactos extends JPanel
{
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton btnBuscar;
    private JLabel retornar;
    private JComboBox cbDistrito,cbNombre;
    private ArrayList<ContactoBEAN> lista,listaNombres,listaDistritos;
    private String nombreUsuario;
    private JLabel mensaje;
    
    public PanelVentanaMostrarContactos(String nombreUsuario)
    {
        this.nombreUsuario=nombreUsuario;
        Inicio();
    }

    private void Inicio()
    {
        setLayout(null);
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        capturarListas();

        cbNombre=new JComboBox();
        cbNombre.addItem("-Seleccionar Nombre-");
        for(ContactoBEAN obj: listaNombres)
        {
            cbNombre.addItem(obj.getNombre());
        }
        cbNombre.setBounds(250, 30, 200, 30);
        cbNombre.setFont(fuenteCampos);
        
        cbDistrito=new JComboBox();
        cbDistrito.addItem("-Seleccionar Distrito-");
        for(ContactoBEAN obj: listaDistritos)
        {
            cbDistrito.addItem(obj.getDistrito());
        }
        cbDistrito.setBounds(460, 30, 200, 30);
        cbDistrito.setFont(fuenteCampos);
        
        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(670, 30, 100, 30);
        btnBuscar.addActionListener(new filtrar());
        btnBuscar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnBuscar));
        btnBuscar.setFont(fuenteCamposLabel);
        btnBuscar.setForeground(ColorFuente);
        btnBuscar.setBackground(null);
        
        String ruta="/imagenes/retornar.png";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        retornar=new JLabel(icono);
        retornar.setBounds(780, 30, 30, 30);
        retornar.addMouseListener(new AccionMouse());
        
        modelo=new DefaultTableModel();
        tabla=new JTable();
        scroll=new JScrollPane(tabla);
        
        tabla.setFont(new Font("Arial",Font.BOLD,10));
        
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Edad");
        modelo.addColumn("Distrito");
        modelo.addColumn("Dirección");
        modelo.addColumn("Email");
        
        tabla.setModel(modelo);
        tabla.setEnabled(false);
        centrarTextoTabla();

        capturarListaTabla();
        
        mensaje=new JLabel();
        mensaje.setBounds(250,150,350,50);
        mensaje.setFont(new Font("Arial",Font.BOLD,18));
        mensaje.setForeground(Color.RED);
        
        if(lista.size()!=0)
        {
            for(ContactoBEAN obj:lista)
            {
                modelo.addRow(new Object[]{obj.getDni(),obj.getNombre(),
                obj.getApellidoPat() + " " + obj.getApellidoMat(),obj.getTelefono(),obj.getEdad(),
                obj.getDistrito(),obj.getDireccion(),obj.getCorreo()});
            }

            scroll.setBounds(10,80,800,250);
            
            mensaje.setText("");
            
            add(cbDistrito);
            add(cbNombre);
            add(btnBuscar);
            add(retornar);
            add(scroll);
        }
        else
        {
            mensaje.setText("<< No tienes contactos actualmente >>");
        }
        
        add(mensaje);
    }
    
    private void centrarTextoTabla()
    {
        //COPIE CODIGO
        DefaultTableCellRenderer tcr = new DefaultTableCellRenderer();
        tcr.setHorizontalAlignment(SwingConstants.CENTER);
        
        for(int i=0;i<tabla.getColumnCount();i++)
            tabla.getColumnModel().getColumn(i).setCellRenderer(tcr);
    }
    
    private void capturarListas()
    {
        UsuarioDAO usuarioD=new UsuarioDAO();
        String codigo_usu=usuarioD.getCodigoUsuario(nombreUsuario);
        UsuarioBEAN usu=new UsuarioBEAN();
        usu.setCodigo(codigo_usu);
        ContactoDAO contactoD=new ContactoDAO();
        listaNombres=contactoD.getNombresContactos(usu);
        listaDistritos=contactoD.getDristritosContactos(usu);
    }
    
    private void capturarListaTabla()
    {
        UsuarioDAO usuarioDAO=new UsuarioDAO();
        String cod_usu=usuarioDAO.getCodigoUsuario(nombreUsuario);
        UsuarioBEAN usuario=new UsuarioBEAN();
        usuario.setCodigo(cod_usu);
        ContactoDAO contactoDAO=new ContactoDAO();
        lista=contactoDAO.listarContactos(usuario);
    }
    
    private class filtrar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String nombre=cbNombre.getSelectedItem().toString();
            String distrito=cbDistrito.getSelectedItem().toString();
            
            UsuarioDAO usuarioD=new UsuarioDAO();
            String codigo_usu=usuarioD.getCodigoUsuario(nombreUsuario);
            UsuarioBEAN usu=new UsuarioBEAN();
            usu.setCodigo(codigo_usu);
            ContactoBEAN contacto=new ContactoBEAN();
            contacto.setNombre(nombre);
            contacto.setDistrito(distrito);
            ContactoDAO contactoD=new ContactoDAO();
            
            if(e.getSource()==btnBuscar)
            {
                if(nombre.equals("-Seleccionar Nombre-")==false && distrito.equals("-Seleccionar Distrito-"))
                {
                    lista=contactoD.listarContactosFiltroNombres(usu, contacto);
                    llenarTabla("");
                }
                else if(nombre.equals("-Seleccionar Nombre-") && distrito.equals("-Seleccionar Distrito-")==false)
                {
                    lista=contactoD.listarContactosFiltroDistritos(usu, contacto);
                    llenarTabla("");
                }
                else if(nombre.equals("-Seleccionar Nombre-")==false && distrito.equals("-Seleccionar Distrito-")==false)
                {
                    lista=contactoD.listarContactosFiltroNombresDistritos(usu, contacto);
                    llenarTabla("<< No tienes contactos con el filtro seleccionado >>");
                }
                else
                {
                    lista=contactoD.listarContactos(usu);
                    llenarTabla("");
                    //JOptionPane.showMessageDialog(null, "Para realizar un filtro Usted debe seleccionar un Nombre y/o Distrito");
                }
            }
        }
    }
    
    private void llenarTabla(String msj)
    {
        if(lista.size()!=0)
        {
            scroll.setVisible(true);
            limpiarTabla();
            for(ContactoBEAN obj:lista)
            {
                modelo.addRow(new Object[]{obj.getDni(),obj.getNombre(),
                obj.getApellidoPat() + " " + obj.getApellidoMat(),obj.getTelefono(),obj.getEdad(),
                obj.getDistrito(),obj.getDireccion(),obj.getCorreo()});
            }
            mensaje.setBounds(250,150,350,50);
            mensaje.setText("");
        }
        else
        {
            scroll.setVisible(false);
            mensaje.setBounds(180,150,470,50);
            mensaje.setText(msj);
        }
    }
    
    private class AccionMouse extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==retornar)
            {
                UsuarioDAO usuarioD=new UsuarioDAO();
                String codigo_usu=usuarioD.getCodigoUsuario(nombreUsuario);
                UsuarioBEAN usu=new UsuarioBEAN();
                usu.setCodigo(codigo_usu);
                
                ContactoDAO contactoD=new ContactoDAO();
                lista=contactoD.listarContactos(usu);
                llenarTabla("");
                cbDistrito.setSelectedIndex(0);
                cbNombre.setSelectedIndex(0);
            }
        }
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
 
    public void limpiarTabla()
    {
        for(int i=0;i<tabla.getRowCount();i++)
        {
            modelo.removeRow(i);
            i--;
        }
    }
    
    private class ColorBotones extends MouseAdapter
    {
        private Color colorFondo,colorLetra;
        private JButton boton;
        
        public ColorBotones(Color colorFondo,Color colorLetra,JButton boton)
        {
            this.colorFondo=colorFondo;
            this.colorLetra=colorLetra;
            this.boton=boton;
        }
        
        @Override
        public void mouseEntered(MouseEvent e)
        {
            this.boton.setBackground(colorFondo);
            this.boton.setForeground(colorLetra);
        }
        
        @Override
        public void mouseExited(MouseEvent e)
        {
            this.boton.setBackground(null);
            this.boton.setForeground(colorFondo);
            
        }
    }
}
