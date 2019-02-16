
package PANELES.Administrador;

import java.awt.Color;
import javax.swing.*;

public class PanelVentanaRegistrarUsuario extends JPanel
{
    private JLabel mensaje,titulo,usu,cla,cla2,tipo;
    private JTextField txtUsu;
    private JComboBox cbtipo;
    private JPasswordField txtCla,txtCla2;
    
    public PanelVentanaRegistrarUsuario()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        mensaje=new JLabel("Paso 1 de 2");
        mensaje.setBounds(110,10,150,30);
        mensaje.setForeground(Color.red);
        
        titulo=new JLabel("REGISTRO DE USUARIO");
        titulo.setBounds(80,40,150,30);
        
        tipo=new JLabel("Tipo Usuario:");
        tipo.setBounds(20,90,80,20);
        
        cbtipo=new JComboBox();
        cbtipo.addItem("-Seleccionar-");
        cbtipo.addItem("Administrador");
        cbtipo.addItem("Personal");
        cbtipo.setBounds(135,90,120,20);
        
        usu=new JLabel("Usuario:");
        usu.setBounds(20,130,80,20);
        
        txtUsu=new JTextField();
        txtUsu.setBounds(135,130,120,20);
        
        cla=new JLabel("Contraseña:");
        cla.setBounds(20,170,80,20);
        
        txtCla=new JPasswordField();
        txtCla.setBounds(135,170,120,20);
        
        cla2=new JLabel("Repita Contraseña:");
        cla2.setBounds(20,210,110,20);
        
        txtCla2=new JPasswordField();
        txtCla2.setBounds(135,210,120,20);
        
        add(titulo);
        add(usu);
        add(mensaje);
        add(txtUsu);
        add(cla);
        add(txtCla);
        add(cla2);
        add(txtCla2);
        add(tipo);
        add(cbtipo);
    }
}
