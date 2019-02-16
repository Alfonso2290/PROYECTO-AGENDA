
package PANELES;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelVentanaPrincipal extends JPanel 
{
    private JLabel titulo,usu,cla,mensaje;
    private JTextField txtusu;
    private JPasswordField txtcla;
    private JButton btnSalir,btnIngresar;
    
    public PanelVentanaPrincipal()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        Font fuenteTitulo=new Font("Arial", Font.BOLD, 16);
        Font fuenteCampos=new Font("Arial", Font.BOLD, 13);
        Font fuenteMensaje=new Font("Arial",Font.ITALIC,10);
        
        titulo=new JLabel("INICIO DE SESIÓN");
        titulo.setBounds(105,10,150,30);
        titulo.setFont(fuenteTitulo);
        
        mensaje=new JLabel("Usted tiene 3 intentos para acceder al Sistema");
        mensaje.setBounds(60,45,220,20);
        mensaje.setFont(fuenteMensaje);
        mensaje.setForeground(Color.RED);
        
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
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setBounds(80,200,90,30);
        btnIngresar.addMouseListener(new ColorBotones(Color.LIGHT_GRAY.darker(),Color.WHITE,btnIngresar));
        btnIngresar.setFont(fuenteCampos);
        
        btnSalir=new JButton("Salir");
        btnSalir.setBounds(190,200,85,30);
        btnSalir.addMouseListener(new ColorBotones(Color.LIGHT_GRAY.darker(),Color.WHITE,btnSalir));
        btnSalir.setFont(fuenteCampos);
        
        add(txtusu);
        add(txtcla);
        add(titulo);
        add(usu);
        add(cla);
        add(btnSalir);
        add(btnIngresar);
        add(mensaje);
    }

    public JTextField getTxtusu() 
    {
        return txtusu;
    }

    public JPasswordField getTxtcla() 
    {
        return txtcla;
    }

    public JButton getBtnSalir() {
        return btnSalir;
    }

    public JButton getBtnIngresar() {
        return btnIngresar;
    }

    public JLabel getMensaje() {
        return mensaje;
    }
    
    public void limpiarCampos()
    {
        txtcla.setText("");
        txtusu.setText("");
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
            this.boton.setBackground(getBackground());
            this.boton.setForeground(null);
            
        }
    }
    
    
}
