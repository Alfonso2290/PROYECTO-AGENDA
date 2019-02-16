
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaEditarContacto;
import javax.swing.*;
import java.awt.*;

public class VentanaEditarContacto extends JFrame
{
    private PanelVentanaEditarContacto miPanel;
    
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
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());

        add(miPanel);
    }
}
