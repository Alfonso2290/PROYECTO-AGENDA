
package PANELES.Administrador;

import javax.swing.*;
import javax.swing.table.*;

public class PanelVentanaEditarCuenta extends JPanel
{
    private DefaultTableModel modelo;
    private JTable tabla;
    private JScrollPane scroll;
    private JButton btnBuscar;
    private JComboBox cbTipo,cbNombre;
    
    public PanelVentanaEditarCuenta()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        cbNombre=new JComboBox();
        cbNombre.addItem("-Seleccionar Usuario-");
        cbNombre.addItem("Cura");
        cbNombre.addItem("PriestMurderer");
        cbNombre.addItem("Loquito");
        cbNombre.setBounds(235, 30, 150, 30);
        
        cbTipo=new JComboBox();
        cbTipo.addItem("-Seleccionar Tipo-");
        cbTipo.addItem("Administrador");
        cbTipo.addItem("Personal");
        cbTipo.setBounds(410, 30, 150, 30);
        
        btnBuscar=new JButton("Buscar");
        btnBuscar.setBounds(585, 30, 80, 30);
        
        
        modelo=new DefaultTableModel();
        tabla=new JTable();
        scroll=new JScrollPane(tabla);
        
        modelo.addColumn("Código");
        modelo.addColumn("Usuario");
        modelo.addColumn("Contraseña");
        modelo.addColumn("Tipo");
        modelo.addColumn("Propietario");
        modelo.addColumn("Modificar");
        modelo.addColumn("Eliminar");
        
        tabla.setModel(modelo);

        Object [] obj=new Object[7];
        obj[0]="72190542";
        obj[1]="Cura";
        obj[2]="12345";
        obj[3]="Administrador";      
        obj[4]="Alfonso Molero Farman";        
        obj[5]=null;
        obj[6]=null;
        modelo.addRow(obj);
        
        scroll.setBounds(10,80,660,250);
        
        add(cbTipo);
        add(cbNombre);
        add(btnBuscar);
        add(scroll);
    }
}
