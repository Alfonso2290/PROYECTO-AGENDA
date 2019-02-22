
package PANELES.Administrador;

import BEAN.UsuarioBEAN;
import DAO.UsuarioDAO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelVentanaRegistrarPersona extends JPanel
{
    private JLabel mensaje,titulo,nom,apepa,apema,tele,cor;
    private JTextField txtNom,txtApepa,txtApema,txtTele,txtCor;
    private JButton btnFinalizar,btnAtras;
    
    public PanelVentanaRegistrarPersona()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        Font fuenteMensaje=new Font("Arial",Font.ITALIC,10);
        Font fuenteTitulo=new Font("Arial", Font.BOLD, 16);
        Font fuenteCampos=new Font("Arial", Font.BOLD, 12);
        
        mensaje=new JLabel("Paso 2 de 2");
        mensaje.setBounds(110,10,150,30);
        mensaje.setForeground(Color.red);
        mensaje.setFont(fuenteMensaje);
        
        titulo=new JLabel("Registrar Datos Personales");
        titulo.setBounds(45,40,210,30);
        titulo.setFont(fuenteTitulo);
        
        nom=new JLabel("Nombre:");
        nom.setBounds(20,90,80,20);
        nom.setFont(fuenteCampos);
        
        txtNom=new JTextField();
        txtNom.setBounds(135,90,120,20);
        txtNom.addKeyListener(new validarCampos());
        txtNom.setFont(fuenteCampos);
        
        apepa=new JLabel("Apellido Paterno:");
        apepa.setBounds(20,130,110,20);
        apepa.setFont(fuenteCampos);
        
        txtApepa=new JTextField();
        txtApepa.setBounds(135,130,120,20);
        txtApepa.addKeyListener(new validarCampos());
        txtApepa.setFont(fuenteCampos);

        apema=new JLabel("Apellido Materno:");
        apema.setBounds(20,170,110,20);
        apema.setFont(fuenteCampos);
        
        txtApema=new JTextField();
        txtApema.setBounds(135,170,120,20);
        txtApema.addKeyListener(new validarCampos());
        txtApema.setFont(fuenteCampos);
        
        tele=new JLabel("Teléfono:");
        tele.setBounds(20,210,110,20);
        tele.setFont(fuenteCampos);
        
        txtTele=new JTextField();
        txtTele.setBounds(135,210,120,20);
        txtTele.addKeyListener(new validarCampos());
        txtTele.setFont(fuenteCampos);
        
        cor=new JLabel("Correo Electrónico:");
        cor.setBounds(20,250,110,20);
        cor.setFont(fuenteCampos);
        
        txtCor=new JTextField();
        txtCor.setBounds(135,250,120,20);
        txtCor.setFont(fuenteCampos);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(40,305,100,20);
        btnAtras.setFont(fuenteCampos);
        
        btnFinalizar=new JButton("Finalizar");
        btnFinalizar.setBounds(150,305,110,20);
        btnFinalizar.setFont(fuenteCampos);
        
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
        add(mensaje);
        add(btnFinalizar);
        add(btnAtras);
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
}
