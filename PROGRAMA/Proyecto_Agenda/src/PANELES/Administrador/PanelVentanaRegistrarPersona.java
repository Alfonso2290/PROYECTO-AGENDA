
package PANELES.Administrador;

import java.awt.Color;
import javax.swing.*;

public class PanelVentanaRegistrarPersona extends JPanel
{
    private JLabel mensaje,titulo,nom,dni,apepa,apema,tele,edad,dis,dir,cor;
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
        
        mensaje=new JLabel("Paso 2 de 2");
        mensaje.setBounds(110,10,150,30);
        mensaje.setForeground(Color.red);
        
        titulo=new JLabel("Registrar Datos Personales");
        titulo.setBounds(60,40,170,30);
        
        dni=new JLabel("DNI:");
        dni.setBounds(20,90,80,20);
        
        txtDni=new JTextField();
        txtDni.setBounds(135,90,120,20);
        
        nom=new JLabel("Nombre:");
        nom.setBounds(20,130,80,20);
        
        txtNom=new JTextField();
        txtNom.setBounds(135,130,120,20);
        
        apepa=new JLabel("Apellido Paterno:");
        apepa.setBounds(20,170,110,20);
        
        txtApepa=new JTextField();
        txtApepa.setBounds(135,170,120,20);

        apema=new JLabel("Apellido Materno:");
        apema.setBounds(20,210,110,20);
        
        txtApema=new JTextField();
        txtApema.setBounds(135,210,120,20);
        
        dis=new JLabel("Distrito:");
        dis.setBounds(20,250,110,20);
        
        cbdis=new JComboBox();
        cbdis.addItem("-Seleccionar-");
        cbdis.addItem("Magdalena");
        cbdis.addItem("Pueblo Libre");
        cbdis.addItem("San Martín de Porres");
        cbdis.setBounds(135,250,120,20);
        
        dir=new JLabel("Dirección:");
        dir.setBounds(20,290,110,20);
        
        txtDir=new JTextField();
        txtDir.setBounds(135,290,120,20);
        
        tele=new JLabel("Teléfono:");
        tele.setBounds(20,330,110,20);
        
        txtTele=new JTextField();
        txtTele.setBounds(135,330,120,20);
        
        cor=new JLabel("Correo Electrónico:");
        cor.setBounds(20,370,110,20);
        
        txtCor=new JTextField();
        txtCor.setBounds(135,370,120,20);
        
        edad=new JLabel("Edad:");
        edad.setBounds(20,410,110,20);
        
        txtEdad=new JTextField();
        txtEdad.setBounds(135,410,120,20);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(40,465,100,20);
        
        btnFinalizar=new JButton("Finalizar");
        btnFinalizar.setBounds(150,465,110,20);
        
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
    
    
}
