
package PANELES;

import java.awt.*;
import javax.swing.*;

public class PanelVentanaPrincipal extends JPanel 
{
    private JLabel titulo,usu,cla;
    private JTextField txtusu;
    private JPasswordField txtcla;
    
    public PanelVentanaPrincipal()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        Font fuenteTitulo=new Font("Arial", Font.BOLD, 16);
        Font fuenteCampos=new Font("Arial", Font.BOLD, 13);
        
        titulo=new JLabel("INICIO DE SESIÓN");
        titulo.setBounds(105,10,150,30);
        titulo.setFont(fuenteTitulo);
        
        usu=new JLabel("Usuario: ");
        usu.setBounds(50,80,80,20);
        usu.setFont(fuenteCampos);
        
        txtusu=new JTextField();
        txtusu.setBounds(150,80,150,20);
        txtusu.setFont(fuenteCampos);
        
        cla=new JLabel("Contraseña: ");
        cla.setBounds(50,130,80,20);
        cla.setFont(fuenteCampos);
        
        txtcla=new JPasswordField();
        txtcla.setBounds(150,130,150,20);
        txtcla.setFont(fuenteCampos);
        
        add(txtusu);
        add(txtcla);
        add(titulo);
        add(usu);
        add(cla);
    }
    
}
