
package PANELES.Administrador;

import java.net.URL;
import javax.swing.*;

public class PanelVentanaPrincipalAdministrador extends JPanel
{
    private JLabel imagen;
    
    public PanelVentanaPrincipalAdministrador()
    {
        Inicio();
    }
    
     private void Inicio()
    {
        setLayout(null);
        ////Agregar imagen a un label
        String ruta="/imagenes/administrador.jpg";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        imagen=new JLabel();
        imagen.setBounds(30,20,400,200);
        imagen.setIcon(icono);
        add(imagen);
        ///*************************************
    }
}
