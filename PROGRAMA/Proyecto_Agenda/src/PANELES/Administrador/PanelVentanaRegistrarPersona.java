
package PANELES.Administrador;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelVentanaRegistrarPersona extends JPanel
{
    private JLabel titulo,nom,apepa,apema,tele,cor;
    private JTextField txtNom,txtApepa,txtApema,txtTele,txtCor;
    private JButton btnFinalizar,btnAtras;
    private JSeparator h1,h2,h3,h4,h5;
    private JLabel icono1,icono2,icono3,icono4,icono5;
    
    public PanelVentanaRegistrarPersona()
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
        
        titulo=new JLabel("Registrar Datos Personales");
        titulo.setBounds(50,10,300,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        nom=new JLabel("Nombre");
        nom.setBounds(50,70,120,20);
        nom.setFont(fuenteCamposLabel);
        nom.setForeground(ColorFuente);
        
        txtNom=new JTextField();
        txtNom.setBounds(50,95,250,20);
        txtNom.addKeyListener(new validarCampos());
        txtNom.setFont(fuenteCampos);
        txtNom.setBorder(null);
        
        h1=new JSeparator();
        h1.setBounds(50,115,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        apepa=new JLabel("Apellido Paterno");
        apepa.setBounds(50,130,150,20);
        apepa.setFont(fuenteCamposLabel);
        apepa.setForeground(ColorFuente);
        
        txtApepa=new JTextField();
        txtApepa.setBounds(50,155,250,20);
        txtApepa.addKeyListener(new validarCampos());
        txtApepa.setFont(fuenteCampos);
        txtApepa.setBorder(null);
        
        h2=new JSeparator();
        h2.setBounds(50,175,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);

        apema=new JLabel("Apellido Materno");
        apema.setBounds(50,190,150,20);
        apema.setFont(fuenteCamposLabel);
        apema.setForeground(ColorFuente);
        
        txtApema=new JTextField();
        txtApema.setBounds(50,215,250,20);
        txtApema.addKeyListener(new validarCampos());
        txtApema.setFont(fuenteCampos);
        txtApema.setBorder(null);
        
        h3=new JSeparator();
        h3.setBounds(50,235,250,20);
        h3.setOpaque(false);
        h3.setBackground(Color.gray);
        
        tele=new JLabel("Teléfono");
        tele.setBounds(50,250,150,20);
        tele.setFont(fuenteCamposLabel);
        tele.setForeground(ColorFuente);
        
        txtTele=new JTextField();
        txtTele.setBounds(50,275,250,20);
        txtTele.addKeyListener(new validarCampos());
        txtTele.setFont(fuenteCampos);
        txtTele.setBorder(null);
        
        h4=new JSeparator();
        h4.setBounds(50,295,250,20);
        h4.setOpaque(false);
        h4.setBackground(Color.gray);
        
        cor=new JLabel("Correo Electrónico");
        cor.setBounds(50,310,180,20);
        cor.setFont(fuenteCamposLabel);
        cor.setForeground(ColorFuente);
        
        txtCor=new JTextField();
        txtCor.setBounds(50,335,250,20);
        txtCor.setFont(fuenteCampos);
        txtCor.setBorder(null);
        
        h5=new JSeparator();
        h5.setBounds(50,355,250,20);
        h5.setOpaque(false);
        h5.setBackground(Color.gray);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(50,400,110,30);
        btnAtras.setFont(fuenteCamposLabel);
        btnAtras.setBackground(null);
        btnAtras.setForeground(ColorFuente);
        btnAtras.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnAtras));
        
        btnFinalizar=new JButton("Finalizar");
        btnFinalizar.setBounds(165,400,130,30);
        btnFinalizar.setFont(fuenteCamposLabel);
        btnFinalizar.setBackground(null);
        btnFinalizar.setForeground(ColorFuente);
        btnFinalizar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnFinalizar));
        
        add(titulo);
        add(nom);
        add(apepa);
        add(tele);
        add(cor);
        add(apema);
        add(txtNom);
        add(txtApepa);
        add(txtTele);
        add(txtCor);
        add(txtApema);
        add(btnFinalizar);
        add(btnAtras);
        add(h1);
        add(h2);
        add(h3);
        add(h4);
        add(h5);
    }

    public JTextField getTxtNom() {
        return txtNom;
    }

    public JTextField getTxtApepa() {
        return txtApepa;
    }

    public JTextField getTxtApema() {
        return txtApema;
    }

    public JTextField getTxtTele() {
        return txtTele;
    }

    public JTextField getTxtCor() {
        return txtCor;
    }

    public JButton getBtnFinalizar() {
        return btnFinalizar;
    }

    public JButton getBtnAtras() {
        return btnAtras;
    }
    
    public void limpiarCampos()
    {
        txtNom.setText("");
        txtApepa.setText("");
        txtApema.setText("");
        txtTele.setText("");
        txtCor.setText("");
        txtNom.requestFocus();
    }

    private class validarCampos extends KeyAdapter
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            char teclaPresionada=e.getKeyChar();
            if(e.getSource()==txtTele)
            {
                if(teclaPresionada<'0' || teclaPresionada>'9')
                    e.consume();
            }
            if(e.getSource()==txtNom || e.getSource()==txtApema || e.getSource()==txtApepa)
            {
                if((teclaPresionada<'a' || teclaPresionada>'z') && (teclaPresionada<'A' || teclaPresionada>'Z'))
                    e.consume();
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
