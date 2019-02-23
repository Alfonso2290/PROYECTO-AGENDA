
package PANELES.Usuario;

import java.net.URL;
import javax.swing.*;

public class PanelVentanaPrincipalUsuario extends JPanel
{
    private JLabel imagen;
    
    public PanelVentanaPrincipalUsuario()
    {
        Inicio();
    }
    
     private void Inicio()
    {
        setLayout(null);
        ////Agregar imagen a un label
        String ruta="/imagenes/usuario.jpg";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        imagen=new JLabel();
        imagen.setBounds(60,20,400,200);
        imagen.setIcon(icono);
        add(imagen);
        ///*************************************
    }
}
