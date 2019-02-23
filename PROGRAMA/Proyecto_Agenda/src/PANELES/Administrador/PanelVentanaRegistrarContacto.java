
package PANELES.Administrador;

import java.awt.*;
import javax.swing.*;
import java.awt.event.*;

public class PanelVentanaRegistrarContacto extends JPanel  
{
    private JLabel mensaje,titulo,nom,dni,apepa,apema,tele,edad,dis,dir,cor;
    private JTextField txtNom,txtDni,txtApepa,txtApema,txtTele,txtEdad,txtDir,txtCor;
    private JComboBox cbdis;
    private JButton btnGuardar,btnCancelar;
    private JSeparator h1,h2,h3,h4,h5,h6,h7,h8,h9;
    private JLabel icono1,icono2,icono3,icono4,icono5,icono6,icono7,icono8,icono9;
    
    public PanelVentanaRegistrarContacto()
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
        
        titulo=new JLabel("REGISTRAR CONTACTO");
        titulo.setBounds(70,10,300,30);
        titulo.setFont(fuenteTitulo);
        titulo.setForeground(ColorFuente);
        
        dni=new JLabel("DNI");
        dni.setBounds(50,70,120,20);
        dni.setFont(fuenteCamposLabel);
        dni.setForeground(ColorFuente);
        
        txtDni=new JTextField();
        txtDni.setBounds(50,95,250,20);
        txtDni.addKeyListener(new validarCampos());
        txtDni.setFont(fuenteCampos);
        txtDni.setBorder(null);
        
        h1=new JSeparator();
        h1.setBounds(50,115,250,20);
        h1.setOpaque(false);
        h1.setBackground(Color.gray);
        
        mensaje=new JLabel();
        mensaje.setBounds(190,70,120,20);
        mensaje.setForeground(ColorFuente);
        mensaje.setFont(fuenteMensaje);
        
        nom=new JLabel("Nombre");
        nom.setBounds(50,130,150,20);
        nom.setFont(fuenteCamposLabel);
        nom.setForeground(ColorFuente);
        
        txtNom=new JTextField();
        txtNom.setBounds(50,155,250,20);
        txtNom.addKeyListener(new validarCampos());
        txtNom.setFont(fuenteCampos);
        txtNom.setBorder(null);
        
        h2=new JSeparator();
        h2.setBounds(50,175,250,20);
        h2.setOpaque(false);
        h2.setBackground(Color.gray);
        
        apepa=new JLabel("Apellido Paterno");
        apepa.setBounds(50,190,150,20);
        apepa.setFont(fuenteCamposLabel);
        apepa.setForeground(ColorFuente);
        
        txtApepa=new JTextField();
        txtApepa.setBounds(50,215,250,20);
        txtApepa.addKeyListener(new validarCampos());
        txtApepa.setFont(fuenteCampos);
        txtApepa.setBorder(null);
        
        h3=new JSeparator();
        h3.setBounds(50,235,250,20);
        h3.setOpaque(false);
        h3.setBackground(Color.gray);

        apema=new JLabel("Apellido Materno");
        apema.setBounds(50,250,150,20);
        apema.setFont(fuenteCamposLabel);
        apema.setForeground(ColorFuente);
        
        txtApema=new JTextField();
        txtApema.setBounds(50,275,250,20);
        txtApema.addKeyListener(new validarCampos());
        txtApema.setFont(fuenteCampos);
        txtApema.setBorder(null);
        
        h4=new JSeparator();
        h4.setBounds(50,295,250,20);
        h4.setOpaque(false);
        h4.setBackground(Color.gray);
        
        dis=new JLabel("Distrito");
        dis.setBounds(50,310,180,20);
        dis.setFont(fuenteCamposLabel);
        dis.setForeground(ColorFuente);
        
        cbdis=new JComboBox();
        cbdis.addItem("-Seleccionar Distrito-");
        agregarItems();
        cbdis.setBounds(50,335,250,20);
        cbdis.setFont(fuenteCampos);
        
        h5=new JSeparator();
        h5.setBounds(50,355,250,20);
        h5.setOpaque(false);
        h5.setBackground(Color.gray);
        
        dir=new JLabel("Dirección");
        dir.setBounds(50,370,180,20);
        dir.setFont(fuenteCamposLabel);
        dir.setForeground(ColorFuente);
        
        txtDir=new JTextField();
        txtDir.setBounds(50,395,250,20);
        txtDir.setFont(fuenteCampos);
        txtDir.setBorder(null);
        
        h6=new JSeparator();
        h6.setBounds(50,415,250,20);
        h6.setOpaque(false);
        h6.setBackground(Color.gray);
        
        tele=new JLabel("Teléfono");
        tele.setBounds(50,430,180,20);
        tele.setFont(fuenteCamposLabel);
        tele.setForeground(ColorFuente);
        
        txtTele=new JTextField();
        txtTele.setBounds(50,455,250,20);
        txtTele.addKeyListener(new validarCampos());
        txtTele.setFont(fuenteCampos);
        txtTele.setBorder(null);
        
        h7=new JSeparator();
        h7.setBounds(50,475,250,20);
        h7.setOpaque(false);
        h7.setBackground(Color.gray);
        
        cor=new JLabel("Correo Electrónico");
        cor.setBounds(50,490,180,20);
        cor.setFont(fuenteCamposLabel);
        cor.setForeground(ColorFuente);
        
        txtCor=new JTextField();
        txtCor.setBounds(50,515,250,20);
        txtCor.setFont(fuenteCampos);
        txtCor.setBorder(null);
        
        h8=new JSeparator();
        h8.setBounds(50,535,250,20);
        h8.setOpaque(false);
        h8.setBackground(Color.gray);
        
        edad=new JLabel("Edad");
        edad.setBounds(50,550,180,20);
        edad.setFont(fuenteCamposLabel);
        edad.setForeground(ColorFuente);
        
        txtEdad=new JTextField();
        txtEdad.setBounds(50,575,250,20);
        txtEdad.addKeyListener(new validarCampos());
        txtEdad.setFont(fuenteCampos);
        txtEdad.setBorder(null);
        
        h9=new JSeparator();
        h9.setBounds(50,595,250,20);
        h9.setOpaque(false);
        h9.setBackground(Color.gray);
        
        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(50,620,110,30);
        btnGuardar.setFont(fuenteCamposLabel);
        btnGuardar.setBackground(null);
        btnGuardar.setForeground(ColorFuente);
        btnGuardar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnGuardar));
        
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(175,620,120,30);
        btnCancelar.setFont(fuenteCamposLabel);
        btnCancelar.setBackground(null);
        btnCancelar.setForeground(ColorFuente);
        btnCancelar.addMouseListener(new ColorBotones(ColorFuente,Color.WHITE,btnCancelar));

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
        add(btnCancelar);
        add(mensaje);
        add(h1);
        add(h2);
        add(h3);
        add(h4);
        add(h5);
        add(h6);
        add(h7);
        add(h8);
        add(h9);
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
