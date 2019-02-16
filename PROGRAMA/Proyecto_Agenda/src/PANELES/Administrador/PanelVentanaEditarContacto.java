
package PANELES.Administrador;

import javax.swing.*;
import javax.swing.table.*;

public class PanelVentanaEditarContacto extends JPanel
{
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton btnBuscar;
    private JComboBox cbDistrito,cbNombre;
    private JButton btnEliminar,btnModificar;
    
    public PanelVentanaEditarContacto()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        btnModificar=new JButton("Editar");
        btnModificar.setBounds(10, 30, 80, 30);
        
        btnEliminar=new JButton("Eliminar");
        btnEliminar.setBounds(110, 30, 80, 30);
        
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
        
        modelo.addColumn("Item");
        modelo.addColumn("DNI");
        modelo.addColumn("Nombre");
        modelo.addColumn("Apellidos");
        modelo.addColumn("Teléfono");
        modelo.addColumn("Edad");
        modelo.addColumn("Distrito");
        modelo.addColumn("Dirección");
        modelo.addColumn("Email");
        
        tabla.setModel(modelo);
        
        modelo.addRow(new Object[]{"o" ,"72190542","Alfonso",
            "Molero Farman","5231468",28,"San Martín de Porres","Urb. Miguel Grau",
            "alfonsomolerofarman@gmail.com"});
        
        scroll.setBounds(10,80,800,250);
        
        add(cbDistrito);
        add(cbNombre);
        add(btnBuscar);
        add(btnEliminar);
        add(btnModificar);
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

    public JButton getBtnEliminar() {
        return btnEliminar;
    }

    public JButton getBtnModificar() {
        return btnModificar;
    }
    
    
}
