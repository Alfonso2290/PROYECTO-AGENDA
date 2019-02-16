
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaMostrarContactos;
import javax.swing.*;
import java.awt.*;

public class VentanaMostrarContactos extends JFrame
{
    private PanelVentanaMostrarContactos miPanel;
    
    public VentanaMostrarContactos()
    {
        setTitle("Agenda Contactos");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width*3/5,tamañoPantalla.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaMostrarContactos();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        add(miPanel);
    }
}
