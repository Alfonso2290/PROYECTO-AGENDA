
package PANELES.Administrador;

import BEAN.UsuarioBEAN;
import DAO.UsuarioDAO;
import java.awt.Color;
import java.awt.Font;
import java.awt.event.*;
import java.net.URL;
import javax.swing.*;

public class PanelVentanaRegistrarUsuario extends JPanel implements FocusListener
{
    private JLabel mensaje2,titulo,usu,cla,cla2,tipo;
    private JTextField txtUsu;
    private JComboBox cbtipo;
    private JPasswordField txtCla,txtCla2;
    private JButton btnSiguiente,btnAtras;
    private JSeparator h1,h2,h3;
    private JLabel icono1,icono2,icono3,icono4;
    
    public PanelVentanaRegistrarUsuario()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        Color ColorFuente=new Color(232,44,12);
        Font fuenteTitulo=new Font("Decker", Font.BOLD, 20);
        Font fuenteCampos=new Font("Decker", Font.PLAIN, 14);
        Font fuenteCamposLabel=new Font("Decker", Font.BOLD, 16);
        Font fuenteMensaje=new Font("Decker",Font.PLAIN,12);
        
        titulo=new JLabel("REGISTRO DE USUARIO");
        titulo.setBounds(70,10,250,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        icono1=new JLabel(insertarIcono("/imagenes/tipo_usuario.png"));
        icono1.setBounds(10,70,40,30);
        
        tipo=new JLabel("Tipo Usuario");
        tipo.setBounds(50,70,150,20);
        tipo.setFont(fuenteCamposLabel);
        tipo.setForeground(ColorFuente);
        
        cbtipo=new JComboBox();
        cbtipo.addItem("-Seleccionar Tipo Usuario-");
        cbtipo.addItem("Administrador");
        cbtipo.addItem("Personal");
        cbtipo.setBounds(50,95,250,20);
        cbtipo.setFont(fuenteCampos);
        
        icono2=new JLabel(insertarIcono("/imagenes/user.png"));
        icono2.setBounds(10,130,40,30);
        
        usu=new JLabel("Usuario");
        usu.setBounds(50,130,80,20);
        usu.setFont(fuenteCamposLabel);
        usu.setForeground(ColorFuente);
        
        txtUsu=new JTextField();
        txtUsu.setBounds(50,155,250,20);
        txtUsu.addFocusListener(this);
        txtUsu.setFont(fuenteCampos);
        txtUsu.setBorder(null);
        
        h1=new JSeparator();
        h1.setBounds(50,175,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        mensaje2=new JLabel();
        mensaje2.setBounds(195,130,120,20);
        mensaje2.setForeground(ColorFuente);
        mensaje2.setFont(fuenteMensaje);
        
        icono3=new JLabel(insertarIcono("/imagenes/llave.png"));
        icono3.setBounds(10,190,40,30);
        
        cla=new JLabel("Contraseña");
        cla.setBounds(50,190,150,20);
        cla.setFont(fuenteCamposLabel);
        cla.setForeground(ColorFuente);
        
        txtCla=new JPasswordField();
        txtCla.setBounds(50,215,250,20);
        txtCla.setFont(fuenteCampos);
        txtCla.setBorder(null);
        
        h2=new JSeparator();
        h2.setBounds(50,235,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);
        
        icono4=new JLabel(insertarIcono("/imagenes/llave.png"));
        icono4.setBounds(10,250,40,30);
        
        cla2=new JLabel("Repita Contraseña");
        cla2.setBounds(50,250,180,20);
        cla2.setFont(fuenteCamposLabel);
        cla2.setForeground(ColorFuente);
        
        txtCla2=new JPasswordField();
        txtCla2.setBounds(50,275,250,20);
        txtCla2.setFont(fuenteCampos);
        txtCla2.setBorder(null);
        
        h3=new JSeparator();
        h3.setBounds(50,295,250,20);
        h3.setOpaque(false);
        h3.setBackground(Color.gray);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(50,340,110,30);
        btnAtras.setFont(fuenteCamposLabel);
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        
        btnSiguiente=new JButton("Siguiente>>");
        btnSiguiente.setBounds(165,340,140,30);
        btnSiguiente.setFont(fuenteCamposLabel);
        btnSiguiente.setBackground(null);
        btnSiguiente.setForeground(ColorFuente);
        btnSiguiente.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnSiguiente));
        
        add(titulo);
        add(tipo);
        add(cbtipo);
        add(usu);
        add(txtUsu);
        add(cla);
        add(txtCla);
        add(cla2);
        add(txtCla2);
        add(mensaje2);
        add(btnSiguiente);
        add(btnAtras);
        add(h1);
        add(h2);
        add(h3);
        add(icono1);
        add(icono2);
        add(icono3);
        add(icono4);
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
    
    private Icon insertarIcono(String ruta)
    {
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        
        return icono;
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
    
    private class ColorBotones extends MouseAdapter
    {
        private Color colorFondo,colorLetra;
        private JButton boton;
        
        public ColorBotones(Color colorFondo,Color colorLetra,JButton boton)
        {
            this.colorFondo=colorFondo;
            this.colorLetra=colorLetra;
            this.boton=boton;
        }
        
        @Override
        public void mouseEntered(MouseEvent e)
        {
            this.boton.setBackground(colorFondo);
            this.boton.setForeground(colorLetra);
        }
        
        @Override
        public void mouseExited(MouseEvent e)
        {
            this.boton.setBackground(null);
            this.boton.setForeground(colorFondo);
            
        }
    }
}
