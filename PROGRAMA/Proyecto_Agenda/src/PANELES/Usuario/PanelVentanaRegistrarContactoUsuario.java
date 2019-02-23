
package PANELES.Usuario;

import BEAN.ContactoBEAN;
import java.awt.Color;
import java.awt.Font;
import javax.swing.*;
import java.awt.event.*;

public class PanelVentanaRegistrarContactoUsuario extends JPanel  
{
    private JLabel mensaje,titulo,nom,dni,apepa,apema,tele,edad,dis,dir,cor;
    private JTextField txtNom,txtDni,txtApepa,txtApema,txtTele,txtEdad,txtDir,txtCor;
    private JComboBox cbdis;
    private JButton btnGuardar,btnCancelar,btnAtras;
    
    public PanelVentanaRegistrarContactoUsuario()
    {
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        Font fuenteMensaje=new Font("Arial",Font.ITALIC,10);
        Font fuenteTitulo=new Font("Arial", Font.BOLD, 16);
        Font fuenteCampos=new Font("Arial", Font.BOLD, 12);
        
        titulo=new JLabel("REGISTRAR CONTACTO");
        titulo.setBounds(50,10,200,30);
        titulo.setFont(fuenteTitulo);
        
        dni=new JLabel("DNI:");
        dni.setBounds(20,60,80,20);
        dni.setFont(fuenteCampos);
        
        txtDni=new JTextField();
        txtDni.setBounds(135,60,120,20);
        txtDni.addKeyListener(new validarCampos());
        txtDni.setFont(fuenteCampos);
        
        mensaje=new JLabel();
        mensaje.setBounds(20,75,120,20);
        mensaje.setForeground(Color.RED);
        mensaje.setFont(fuenteMensaje);
        
        nom=new JLabel("Nombre:");
        nom.setBounds(20,100,80,20);
        nom.setFont(fuenteCampos);
        
        txtNom=new JTextField();
        txtNom.setBounds(135,100,120,20);
        txtNom.addKeyListener(new validarCampos());
        txtNom.setFont(fuenteCampos);
        
        apepa=new JLabel("Apellido Paterno:");
        apepa.setBounds(20,140,110,20);
        apepa.setFont(fuenteCampos);
        
        txtApepa=new JTextField();
        txtApepa.setBounds(135,140,120,20);
        txtApepa.addKeyListener(new validarCampos());
        txtApepa.setFont(fuenteCampos);

        apema=new JLabel("Apellido Materno:");
        apema.setBounds(20,180,110,20);
        apema.setFont(fuenteCampos);
        
        txtApema=new JTextField();
        txtApema.setBounds(135,180,120,20);
        txtApema.addKeyListener(new validarCampos());
        txtApema.setFont(fuenteCampos);
        
        dis=new JLabel("Distrito:");
        dis.setBounds(20,220,110,20);
        dis.setFont(fuenteCampos);
        
        cbdis=new JComboBox();
        cbdis.addItem("-Seleccionar-");
        agregarItems();
        cbdis.setBounds(135,220,120,20);
        cbdis.setFont(fuenteCampos);
        
        dir=new JLabel("Dirección:");
        dir.setBounds(20,260,110,20);
        dir.setFont(fuenteCampos);
        
        txtDir=new JTextField();
        txtDir.setBounds(135,260,120,20);
        txtDir.setFont(fuenteCampos);
        
        tele=new JLabel("Teléfono:");
        tele.setBounds(20,300,110,20);
        tele.setFont(fuenteCampos);
        
        txtTele=new JTextField();
        txtTele.setBounds(135,300,120,20);
        txtTele.addKeyListener(new validarCampos());
        txtTele.setFont(fuenteCampos);
        
        cor=new JLabel("Correo Electrónico:");
        cor.setBounds(20,340,110,20);
        cor.setFont(fuenteCampos);
        
        txtCor=new JTextField();
        txtCor.setBounds(135,340,120,20);
        txtCor.setFont(fuenteCampos);
        
        edad=new JLabel("Edad:");
        edad.setBounds(20,380,110,20);
        edad.setFont(fuenteCampos);
        
        txtEdad=new JTextField();
        txtEdad.setBounds(135,380,120,20);
        txtEdad.addKeyListener(new validarCampos());
        txtEdad.setFont(fuenteCampos);
        
        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(60,435,80,20);
        btnGuardar.setFont(fuenteCampos);
        
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(150,435,85,20);
        btnCancelar.setFont(fuenteCampos);

        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(10,475,80,20);
        btnAtras.setFont(fuenteCampos);
        
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
        add(btnGuardar);
        add(btnAtras);
        add(btnCancelar);
        add(mensaje);
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

    public JLabel getMensaje() {
        return mensaje;
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

    public JButton getBtnGuardar() {
        return btnGuardar;
    }

    public JButton getBtnCancelar() {
        return btnCancelar;
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
    private void agregarItems()
    {
        cbdis.addItem("Ancón");
        cbdis.addItem("Ate");
        cbdis.addItem("Barranco");
        cbdis.addItem("Breña");
        cbdis.addItem("Carabayllo");
        cbdis.addItem("Chaclacayo");
        cbdis.addItem("Chorrillos");
        cbdis.addItem("Cieneguilla");
        cbdis.addItem("Comas");
        cbdis.addItem("El Agustino");
        cbdis.addItem("Huaycán");
        cbdis.addItem("Independencia");
        cbdis.addItem("Jesús María");
        cbdis.addItem("La Molina");
        cbdis.addItem("La Victoria");
        cbdis.addItem("Lima");
        cbdis.addItem("Lince");
        cbdis.addItem("Los Olivos");
        cbdis.addItem("Lurigancho");
        cbdis.addItem("Lurín");
        cbdis.addItem("Magdalena del Mar");
        cbdis.addItem("Miraflores");
        cbdis.addItem("Pachacamac");
        cbdis.addItem("Pucusana");
        cbdis.addItem("Pueblo Libre");
        cbdis.addItem("Puente Piedra");
        cbdis.addItem("Punta Hermosa");
        cbdis.addItem("Punta Negra");
        cbdis.addItem("Rímac");
        cbdis.addItem("San Bartolo");
        cbdis.addItem("San Borja");
        cbdis.addItem("San Isidro");
        cbdis.addItem("San Juan de Lurigancho");
        cbdis.addItem("San Juan de Miraflores");
        cbdis.addItem("San Luis");
        cbdis.addItem("San Martín de Porres");
        cbdis.addItem("San Miguel");
        cbdis.addItem("Santa Anita");
        cbdis.addItem("Santa María de Huachipa	");
        cbdis.addItem("Santa María del Mar");
        cbdis.addItem("Santa Rosa");
        cbdis.addItem("Santiago de Surco");
        cbdis.addItem("Surquillo");
        cbdis.addItem("Villa El Salvador");
        cbdis.addItem("Villa María del Triunfo");
    }
}
