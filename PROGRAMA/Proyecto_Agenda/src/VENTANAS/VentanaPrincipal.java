
package VENTANAS;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;
import VENTANAS.Administrador.VentanaPrincipalAdministrador;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    private JLabel titulo,usu,cla;
    private JTextField txtusu;
    private JPasswordField txtcla;
    private JButton btnSalir,btnIngresar;
    
    public VentanaPrincipal()
    {
        setTitle("Ventana Principal");
        setSize(350,300);
        setResizable(false);
        setLocationRelativeTo(null);
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
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setBounds(80,200,85,30);
        btnIngresar.addActionListener(this);
        
        btnSalir=new JButton("Salir");
        btnSalir.setBounds(190,200,80,30);
        btnSalir.addActionListener(this);
        
        add(titulo);
        add(usu);
        add(cla);
        add(btnSalir);
        add(txtusu);
        add(txtcla);
        add(btnIngresar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnSalir)
        {
            System.exit(0);
        }
        
        if(e.getSource()==btnIngresar)
        {
            setVisible(false);
            VentanaPrincipalAdministrador miVentana=new VentanaPrincipalAdministrador();
            miVentana.setVisible(true);
        }
    }
}
