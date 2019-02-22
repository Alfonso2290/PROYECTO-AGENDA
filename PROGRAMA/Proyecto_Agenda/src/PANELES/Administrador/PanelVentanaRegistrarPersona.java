
package PANELES.Administrador;

import BEAN.PersonaBEAN;
import BEAN.UsuarioBEAN;
import DAO.PersonaDAO;
import DAO.UsuarioDAO;
import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelVentanaRegistrarPersona extends JPanel implements FocusListener
{
    private JLabel mensaje,mensaje2,titulo,nom,dni,apepa,apema,tele,edad,dis,dir,cor;
    private JTextField txtNom,txtDni,txtApepa,txtApema,txtTele,txtEdad,txtDir,txtCor;
    private JComboBox cbdis;
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
        
        dni=new JLabel("DNI:");
        dni.setBounds(20,90,80,20);
        dni.setFont(fuenteCampos);
        
        mensaje2=new JLabel();
        mensaje2.setBounds(20,105,120,20);
        mensaje2.setForeground(Color.red);
        mensaje2.setFont(fuenteMensaje);
        
        txtDni=new JTextField();
        txtDni.setBounds(135,90,120,20);
        txtDni.addKeyListener(new validarCampos());
        txtDni.addFocusListener(this);
        txtDni.setFont(fuenteCampos);
        
        nom=new JLabel("Nombre:");
        nom.setBounds(20,130,80,20);
        nom.setFont(fuenteCampos);
        
        txtNom=new JTextField();
        txtNom.setBounds(135,130,120,20);
        txtNom.addKeyListener(new validarCampos());
        txtNom.setFont(fuenteCampos);
        
        apepa=new JLabel("Apellido Paterno:");
        apepa.setBounds(20,170,110,20);
        apepa.setFont(fuenteCampos);
        
        txtApepa=new JTextField();
        txtApepa.setBounds(135,170,120,20);
        txtApepa.addKeyListener(new validarCampos());
        txtApepa.setFont(fuenteCampos);

        apema=new JLabel("Apellido Materno:");
        apema.setBounds(20,210,110,20);
        apema.setFont(fuenteCampos);
        
        txtApema=new JTextField();
        txtApema.setBounds(135,210,120,20);
        txtApema.addKeyListener(new validarCampos());
        txtApema.setFont(fuenteCampos);
        
        dis=new JLabel("Distrito:");
        dis.setBounds(20,250,110,20);
        dis.setFont(fuenteCampos);
        
        cbdis=new JComboBox();
        cbdis.addItem("-Seleccionar-");
        cbdis.addItem("Magdalena");
        cbdis.addItem("Pueblo Libre");
        cbdis.addItem("San Martín de Porres");
        cbdis.setBounds(135,250,120,20);
        cbdis.setFont(fuenteCampos);
        
        dir=new JLabel("Dirección:");
        dir.setBounds(20,290,110,20);
        
        txtDir=new JTextField();
        txtDir.setBounds(135,290,120,20);
        txtDir.setFont(fuenteCampos);
        
        tele=new JLabel("Teléfono:");
        tele.setBounds(20,330,110,20);
        tele.setFont(fuenteCampos);
        
        txtTele=new JTextField();
        txtTele.setBounds(135,330,120,20);
        txtTele.addKeyListener(new validarCampos());
        txtTele.setFont(fuenteCampos);
        
        cor=new JLabel("Correo Electrónico:");
        cor.setBounds(20,370,110,20);
        cor.setFont(fuenteCampos);
        
        txtCor=new JTextField();
        txtCor.setBounds(135,370,120,20);
        txtCor.setFont(fuenteCampos);
        
        edad=new JLabel("Edad:");
        edad.setBounds(20,410,110,20);
        edad.setFont(fuenteCampos);
        
        txtEdad=new JTextField();
        txtEdad.setBounds(135,410,120,20);
        txtEdad.addKeyListener(new validarCampos());
        txtEdad.setFont(fuenteCampos);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(40,465,100,20);
        btnAtras.setFont(fuenteCampos);
        
        btnFinalizar=new JButton("Finalizar");
        btnFinalizar.setBounds(150,465,110,20);
        btnFinalizar.setFont(fuenteCampos);
        
        add(titulo);
        add(dni);
        add(nom);
        add(apepa);
        add(dis);
        add(tele);
        add(edad);
        add(cor);
        add(dir);
        add(apema);
        add(txtDni);
        add(txtNom);
        add(txtApepa);
        add(cbdis);
        add(txtTele);
        add(txtEdad);
        add(mensaje2);
        add(txtCor);
        add(txtDir);
        add(txtApema);
        add(mensaje);
        add(btnFinalizar);
        add(btnAtras);
    }

    public JTextField getTxtNom() {
        return txtNom;
    }

    public JTextField getTxtDni() {
        return txtDni;
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

    public JTextField getTxtEdad() {
        return txtEdad;
    }

    public JTextField getTxtDir() {
        return txtDir;
    }

    public JTextField getTxtCor() {
        return txtCor;
    }

    public JComboBox getCbdis() {
        return cbdis;
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
        txtDni.setText("");
        txtApepa.setText("");
        txtApema.setText("");
        txtTele.setText("");
        txtEdad.setText("");
        txtDir.setText("");
        txtCor.setText("");
        cbdis.setSelectedIndex(0);
        txtDni.requestFocus();
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
        if(e.getSource()==txtDni)
        {
            String ver_dni=txtDni.getText();
            PersonaBEAN persona=new PersonaBEAN();
            persona.setDni(ver_dni);
            
            PersonaDAO personaDAO=new PersonaDAO();
            int verificacion=personaDAO.verificarPersona(persona);
            if(verificacion>0 && ver_dni.compareTo("")!=0 )
            {
                mensaje2.setText("DNI Registrado");
            }
        }
    }
    
    private class validarCampos extends KeyAdapter
    {
        @Override
        public void keyTyped(KeyEvent e)
        {
            char teclaPresionada=e.getKeyChar();
            if(e.getSource()==txtDni || e.getSource()==txtEdad || e.getSource()==txtTele)
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
