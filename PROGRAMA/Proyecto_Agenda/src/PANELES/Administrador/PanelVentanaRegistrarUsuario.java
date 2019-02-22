
package PANELES.Administrador;

import BEAN.UsuarioBEAN;
import DAO.UsuarioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import javax.swing.*;

public class PanelVentanaRegistrarUsuario extends JPanel implements FocusListener
{
    private JLabel mensaje,mensaje2,titulo,usu,cla,cla2,tipo;
    private JTextField txtUsu;
    private JComboBox cbtipo;
    private JPasswordField txtCla,txtCla2;
    private JButton btnSiguiente,btnAtras;
    
    public PanelVentanaRegistrarUsuario()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        Font fuenteMensaje=new Font("Arial",Font.ITALIC,10);
        Font fuenteTitulo=new Font("Arial", Font.BOLD, 16);
        Font fuenteCampos=new Font("Arial", Font.BOLD, 12);
        
        mensaje=new JLabel("Paso 1 de 2");
        mensaje.setBounds(110,10,150,30);
        mensaje.setForeground(Color.RED);
        mensaje.setFont(fuenteMensaje);
        
        titulo=new JLabel("REGISTRO DE USUARIO");
        titulo.setBounds(50,40,210,30);
        titulo.setFont(fuenteTitulo);
        
        tipo=new JLabel("Tipo Usuario:");
        tipo.setBounds(20,90,80,20);
        tipo.setFont(fuenteCampos);
        
        cbtipo=new JComboBox();
        cbtipo.addItem("-Seleccionar-");
        cbtipo.addItem("Administrador");
        cbtipo.addItem("Personal");
        cbtipo.setBounds(135,90,120,20);
        cbtipo.setFont(fuenteCampos);
        
        usu=new JLabel("Usuario:");
        usu.setBounds(20,130,80,20);
        usu.setFont(fuenteCampos);
        
        txtUsu=new JTextField();
        txtUsu.setBounds(135,130,120,20);
        txtUsu.addFocusListener(this);
        txtUsu.setFont(fuenteCampos);
        
        mensaje2=new JLabel();
        mensaje2.setBounds(20,145,120,20);
        mensaje2.setForeground(Color.RED);
        mensaje2.setFont(fuenteMensaje);
        
        cla=new JLabel("Contraseña:");
        cla.setBounds(20,170,80,20);
        
        txtCla=new JPasswordField();
        txtCla.setBounds(135,170,120,20);
        txtCla.setFont(fuenteCampos);
        
        cla2=new JLabel("Repita Contraseña:");
        cla2.setBounds(20,210,110,20);
        cla2.setFont(fuenteCampos);
        
        txtCla2=new JPasswordField();
        txtCla2.setBounds(135,210,120,20);
        txtCla2.setFont(fuenteCampos);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(40,265,100,20);
        btnAtras.setFont(fuenteCampos);
        
        btnSiguiente=new JButton("Siguiente>>");
        btnSiguiente.setBounds(150,265,110,20);
        btnSiguiente.setFont(fuenteCampos);
        
        add(titulo);
        add(usu);
        add(mensaje);
        add(mensaje2);
        add(txtUsu);
        add(cla);
        add(txtCla);
        add(cla2);
        add(txtCla2);
        add(tipo);
        add(cbtipo);
        add(btnSiguiente);
        add(btnAtras);
    }

    public JTextField getTxtUsu() {
        return txtUsu;
    }

    public JComboBox getCbtipo() {
        return cbtipo;
    }

    public JPasswordField getTxtCla() {
        return txtCla;
    }

    public JPasswordField getTxtCla2() {
        return txtCla2;
    }

    public JButton getBtnSiguiente() {
        return btnSiguiente;
    }

    public JButton getBtnAtras() {
        return btnAtras;
    }

    public JLabel getMensaje2() {
        return mensaje2;
    }
 
    @Override
    public void focusGained(FocusEvent e)
    {
        mensaje2.setText("");
    }
    
    @Override
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()==txtUsu)
        {
            String nom_usu=txtUsu.getText();
            UsuarioBEAN usuario=new UsuarioBEAN();
            usuario.setNombreUsuario(nom_usu);
            
            UsuarioDAO usuarioDAO=new UsuarioDAO();
            int verificacion=usuarioDAO.verificarNombreUsuario(usuario);
            if(verificacion>0 && nom_usu.compareTo("")!=0 )
            {
                mensaje2.setText("Usuario Registrado");
            }
        }
    }
}
