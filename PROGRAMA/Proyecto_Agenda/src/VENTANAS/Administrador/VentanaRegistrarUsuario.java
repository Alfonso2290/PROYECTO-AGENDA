
package VENTANAS.Administrador;

import java.awt.Color;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JPasswordField;
import javax.swing.JTextField;

public class VentanaRegistrarUsuario extends JFrame implements ActionListener
{
    private JLabel mensaje,titulo,usu,cla,cla2,tipo;
    private JTextField txtUsu;
    private JComboBox cbtipo;
    private JPasswordField txtCla,txtCla2;
    private JButton btnSiguiente,btnAtras;
    
    public VentanaRegistrarUsuario()
    {
        setTitle("Registrar Usuario");
        setSize(300,350);
        setResizable(false);
        setLocationRelativeTo(null);
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
        cbtipo.addItem("Propietario");
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
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(40,265,100,20);
        btnAtras.addActionListener(this);
        btnSiguiente=new JButton("Siguiente>>");
        btnSiguiente.setBounds(150,265,110,20);
        btnSiguiente.addActionListener(this);
        
        add(titulo);
        add(usu);
        add(mensaje);
        add(txtUsu);
        add(cla);
        add(txtCla);
        add(cla2);
        add(txtCla2);
        add(btnSiguiente);
        add(btnAtras);
        add(tipo);
        add(cbtipo);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnAtras)
        {
            setVisible(false);
        }
        
        if(e.getSource()==btnSiguiente)
        {
            setVisible(false);
            VentanaRegistrarPersona obj=new VentanaRegistrarPersona();
            obj.setVisible(true);
        }
    }
}
