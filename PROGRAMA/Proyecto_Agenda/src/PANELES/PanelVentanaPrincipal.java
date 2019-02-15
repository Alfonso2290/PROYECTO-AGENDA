
package PANELES;

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
        
        titulo=new JLabel("INICIO DE SESIÓN");
        titulo.setBounds(120,10,120,30);
        
        usu=new JLabel("Usuario: ");
        usu.setBounds(50,70,80,20);
        
        txtusu=new JTextField();
        txtusu.setBounds(150,70,120,20);
        
        cla=new JLabel("Contraseña: ");
        cla.setBounds(50,120,80,20);
        
        txtcla=new JPasswordField();
        txtcla.setBounds(150,120,120,20);
        
        add(txtusu);
        add(txtcla);
        add(titulo);
        add(usu);
        add(cla);
    }
}
