
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaEditarContacto;
import javax.swing.*;
import java.awt.*;

public class VentanaEditarContacto extends JFrame
{
    private PanelVentanaEditarContacto miPanel;
    private JButton btnEliminar,btnModificar;
    
    public VentanaEditarContacto()
    {
        setTitle("Edición de Contactos");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width*3/5,tamañoPantalla.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaEditarContacto();
        
        btnModificar=new JButton("Editar");
        btnModificar.setBounds(10, 30, 80, 30);
        
        btnEliminar=new JButton("Eliminar");
        btnEliminar.setBounds(110, 30, 80, 30);
        
        add(miPanel);
        miPanel.add(btnEliminar);
        miPanel.add(btnModificar);
    }
}
