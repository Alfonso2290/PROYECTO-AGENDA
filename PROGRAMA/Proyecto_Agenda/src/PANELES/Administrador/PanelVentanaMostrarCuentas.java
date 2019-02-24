
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
    private JButton btnBuscar;
    private JLabel retornar;
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
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        capturarListas();
        
        cbNombre=new JComboBox();
        cbNombre.addItem("-Seleccionar Usuario-");
        for(UsuarioBEAN obj: listaNombres)
        {
            cbNombre.addItem(obj.getNombreUsuario());
        }
        cbNombre.setBounds(105, 30, 200, 30);
        cbNombre.setFont(fuenteCampos);
        
        cbTipo=new JComboBox();
        cbTipo.addItem("-Seleccionar Tipo-");
        for(UsuarioBEAN obj: listaTipos)
        {
            cbTipo.addItem(obj.getTipo());
        }
        cbTipo.setBounds(315, 30, 200, 30);
        cbTipo.setFont(fuenteCampos);
        
        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(525, 30, 100, 30);
        btnBuscar.addActionListener(new filtrar());
        btnBuscar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnBuscar));
        btnBuscar.setFont(fuenteCamposLabel);
        btnBuscar.setForeground(ColorFuente);
        btnBuscar.setBackground(null);
        
        String ruta="/imagenes/retornar.png";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        retornar=new JLabel(icono);
        retornar.setBounds(635, 30, 30, 30);
        retornar.addMouseListener(new AccionMouse());
        
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
        mensaje.setBounds(95,150,400,50);
        mensaje.setFont(new Font("Decker",Font.BOLD,18));
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
            add(retornar);
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
            mensaje.setBounds(95,150,400,50);
            mensaje.setText("");
        }
        else
        {
            scroll.setVisible(false);
            mensaje.setBounds(100,150,500,50);
            mensaje.setText(msj);
        }
    }
    
    private class AccionMouse extends MouseAdapter
    {
        public void mouseClicked(MouseEvent e)
        {
            if(e.getSource()==retornar)
            {
                capturarListaTabla();
                llenarTabla("");
                cbTipo.setSelectedIndex(0);
                cbNombre.setSelectedIndex(0);
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
