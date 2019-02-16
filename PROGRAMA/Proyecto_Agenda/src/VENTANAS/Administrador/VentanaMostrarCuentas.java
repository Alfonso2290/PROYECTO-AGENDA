
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaMostrarCuentas;
import javax.swing.*;
import java.awt.*;

public class VentanaMostrarCuentas extends JFrame
{
    private PanelVentanaMostrarCuentas miPanel;
    
    public VentanaMostrarCuentas()
    {
        setTitle("Cuentas de Usuarios");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width/2,tamañoPantalla.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaMostrarCuentas();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        add(miPanel);
    }
}
