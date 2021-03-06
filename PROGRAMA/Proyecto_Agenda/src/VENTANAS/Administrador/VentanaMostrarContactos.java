
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaMostrarContactos;
import javax.swing.*;
import java.awt.*;


public class VentanaMostrarContactos extends JFrame
{
    private PanelVentanaMostrarContactos miPanel;
    private String nombreUsuario;
    
    public VentanaMostrarContactos(String nombreUsuario)
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
        miPanel=new PanelVentanaMostrarContactos(nombreUsuario);
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        add(miPanel);
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
}
