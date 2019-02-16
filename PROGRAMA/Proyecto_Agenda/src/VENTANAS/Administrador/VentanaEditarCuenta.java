
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaEditarCuenta;
import javax.swing.*;
import java.awt.*;

public class VentanaEditarCuenta extends JFrame
{
    private PanelVentanaEditarCuenta miPanel;
    
    public VentanaEditarCuenta()
    {
        setTitle("Edición de Cuentas de Usuarios");
        Dimension tamañoPantalla=Toolkit.getDefaultToolkit().getScreenSize();
        setSize(tamañoPantalla.width/2,tamañoPantalla.height/2);
        setLocationRelativeTo(null);
        setResizable(false);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaEditarCuenta();
        add(miPanel);
    }
}
