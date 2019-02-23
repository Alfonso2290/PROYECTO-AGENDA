
package VENTANAS.Usuario;

import PANELES.Usuario.PanelVentanaMostrarContactosUsuario;
import javax.swing.*;
import java.awt.*;

public class VentanaMostrarContactosUsuario extends JFrame
{
    private PanelVentanaMostrarContactosUsuario miPanel;
    private String nombreUsuario;
    
    public VentanaMostrarContactosUsuario(String nombreUsuario)
    {
        this.nombreUsuario=nombreUsuario;
        setTitle("Agenda Contactos");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width*3/5,tamañoPantalla.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaMostrarContactosUsuario(nombreUsuario);
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        add(miPanel);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
