
package PANELES.Administrador;

import BEAN.UsuarioBEAN;
import DAO.UsuarioDAO;
import java.awt.*;
import java.net.URL;
import javax.swing.*;
import javax.swing.table.*;
import java.util.*;
import java.awt.event.*;

public class PanelVentanaMostrarCuentas extends JPanel
{
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton btnBuscar,btnRetornar;
    private JComboBox cbTipo,cbNombre;
    private ArrayList<UsuarioBEAN> lista,listaNombres,listaTipos;
    private JLabel mensaje;
    
    public PanelVentanaMostrarCuentas()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        capturarListas();
        
        cbNombre=new JComboBox();
        cbNombre.addItem("-Seleccionar Usuario-");
        for(UsuarioBEAN obj: listaNombres)
        {
            cbNombre.addItem(obj.getNombreUsuario());
        }
        cbNombre.setBounds(185, 30, 150, 30);
        
        cbTipo=new JComboBox();
        cbTipo.addItem("-Seleccionar Tipo-");
        for(UsuarioBEAN obj: listaTipos)
        {
            cbTipo.addItem(obj.getTipo());
        }
        cbTipo.setBounds(360, 30, 150, 30);
        
        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(535, 30, 80, 30);
        btnBuscar.addActionListener(new filtrar());
        
        String ruta="/imagenes/return.png";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        btnRetornar=new JButton(icono);
        btnRetornar.setBounds(635, 30, 25, 30);
        btnRetornar.setBorderPainted(false);
        btnRetornar.addActionListener(new filtrar());
        
        modelo=new DefaultTableModel();
        tabla=new JTable();
        scroll=new JScrollPane(tabla);
        
        tabla.setFont(new Font("Arial",Font.BOLD,10));
        
        modelo.addColumn("Código");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Tipo");
        modelo.addColumn("Propietario");
        
        tabla.setModel(modelo);
        
        tabla.setEnabled(false);
        centrarTextoTabla();

        capturarListaTabla();
        
        mensaje=new JLabel();
        mensaje.setBounds(120,150,350,50);
        mensaje.setFont(new Font("Arial",Font.BOLD,18));
        mensaje.setForeground(Color.RED);
        
        if(lista.size()!=0)
        {
            for(UsuarioBEAN obj:lista)
            {
                modelo.addRow(new Object[]{obj.getCodigo(),obj.getNombreUsuario(),
                obj.getClave(),obj.getTipo(),obj.getNombre() + " " +
                obj.getApellidoPat() + " " + obj.getApellidoMat()});
            }

            scroll.setBounds(10,80,660,250);
            
            mensaje.setText("");
            
            add(cbTipo);
            add(cbNombre);
            add(btnBuscar);
            add(btnRetornar);
            add(scroll);
        }
        else
        {
            mensaje.setText("<< No tienes usuarios actualmente >>");
        }
        
        add(mensaje);
    }

    public JButton getBtnBuscar() {
        return btnBuscar;
    }

    public JComboBox getCbTipo() {
        return cbTipo;
    }

    public JComboBox getCbNombre() {
        return cbNombre;
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
        listaNombres=usuarioD.getNombresUsuarios();
        listaTipos=usuarioD.getTiposUsuarios();
    }
    
    private void capturarListaTabla()
    {
        UsuarioDAO usuarioD=new UsuarioDAO();
        lista=usuarioD.listarUsuarios();
    }
    
    private class filtrar implements ActionListener
    {
        public void actionPerformed(ActionEvent e)
        {
            String nombre=cbNombre.getSelectedItem().toString();
            String tipo=cbTipo.getSelectedItem().toString();
            
            UsuarioBEAN usu=new UsuarioBEAN();
            usu.setNombreUsuario(nombre);
            usu.setTipo(tipo);
            UsuarioDAO usuarioD=new UsuarioDAO();
            
            if(e.getSource()==btnBuscar)
            {
                if(nombre.equals("-Seleccionar Usuario-")==false && tipo.equals("-Seleccionar Tipo-"))
                {
                    lista=usuarioD.listarUsuariosFiltroUsuario(usu);
                    llenarTabla("");
                }
                else if(nombre.equals("-Seleccionar Usuario-") && tipo.equals("-Seleccionar Tipo-")==false)
                {
                    lista=usuarioD.listarUsuariosFiltroTipoUsuario(usu);
                    llenarTabla("");
                }
                else if(nombre.equals("-Seleccionar Usuario-")==false && tipo.equals("-Seleccionar Tipo-")==false)
                {
                    lista=usuarioD.listarUsuariosFiltroTipoUsuario_Usuario(usu);
                    llenarTabla("<< No existen usuarios con el filtro seleccionado >>");
                }
                else
                {
                    lista=usuarioD.listarUsuarios();
                    llenarTabla("");
                    //JOptionPane.showMessageDialog(null, "Para realizar un filtro Usted debe seleccionar un Nombre y/o Distrito");
                }
            }
            
            if(e.getSource()==btnRetornar)
            {
                lista=usuarioD.listarUsuarios();
                llenarTabla("");
                cbTipo.setSelectedIndex(0);
                cbNombre.setSelectedIndex(0);
            }
        }
        
        private void llenarTabla(String msj)
        {
            if(lista.size()!=0)
            {
                scroll.setVisible(true);
                limpiarTabla();
                for(UsuarioBEAN obj:lista)
                {
                    modelo.addRow(new Object[]{obj.getCodigo(),obj.getNombreUsuario(),
                    obj.getClave(),obj.getTipo(),obj.getNombre() + " " +
                    obj.getApellidoPat() + " " + obj.getApellidoMat()});
                }
                mensaje.setBounds(120,150,350,50);
                mensaje.setText("");
            }
            else
            {
                scroll.setVisible(false);
                mensaje.setBounds(120,150,470,50);
                mensaje.setText(msj);
            }
        }
    }
    
    public void limpiarTabla()
    {
        for(int i=0;i<tabla.getRowCount();i++)
        {
            modelo.removeRow(i);
            i--;
        }
    }
}
