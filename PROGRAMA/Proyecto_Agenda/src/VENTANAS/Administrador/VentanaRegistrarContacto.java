
package VENTANAS.Administrador;


import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import javax.swing.JButton;
import javax.swing.JComboBox;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JTextField;

public class VentanaRegistrarContacto extends JFrame implements ActionListener
{
    private JLabel titulo,nom,dni,apepa,apema,tele,edad,dis,dir,cor;
    private JTextField txtNom,txtDni,txtApepa,txtApema,txtTele,txtEdad,txtDir,txtCor;
    private JComboBox cbdis;
    private JButton btnGuardar,btnCancelar,btnAtras;
    
    public VentanaRegistrarContacto()
    {
        setTitle("Registrar Contacto");
        setSize(300,530);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
               
        titulo=new JLabel("REGISTRAR CONTACTO");
        titulo.setBounds(90,10,140,30);
        
        dni=new JLabel("DNI:");
        dni.setBounds(20,60,80,20);
        
        txtDni=new JTextField();
        txtDni.setBounds(135,60,120,20);
        
        nom=new JLabel("Nombre:");
        nom.setBounds(20,100,80,20);
        
        txtNom=new JTextField();
        txtNom.setBounds(135,100,120,20);
        
        apepa=new JLabel("Apellido Paterno:");
        apepa.setBounds(20,140,110,20);
        
        txtApepa=new JTextField();
        txtApepa.setBounds(135,140,120,20);

        apema=new JLabel("Apellido Materno:");
        apema.setBounds(20,180,110,20);
        
        txtApema=new JTextField();
        txtApema.setBounds(135,180,120,20);
        
        dis=new JLabel("Distrito:");
        dis.setBounds(20,220,110,20);
        
        cbdis=new JComboBox();
        cbdis.addItem("-Seleccionar-");
        cbdis.addItem("Magdalena");
        cbdis.addItem("Pueblo Libre");
        cbdis.addItem("San Martín de Porres");
        cbdis.setBounds(135,220,120,20);
        
        dir=new JLabel("Dirección:");
        dir.setBounds(20,260,110,20);
        
        txtDir=new JTextField();
        txtDir.setBounds(135,260,120,20);
        
        tele=new JLabel("Teléfono:");
        tele.setBounds(20,300,110,20);
        
        txtTele=new JTextField();
        txtTele.setBounds(135,300,120,20);
        
        cor=new JLabel("Correo Electrónico:");
        cor.setBounds(20,340,110,20);
        
        txtCor=new JTextField();
        txtCor.setBounds(135,340,120,20);
        
        edad=new JLabel("Edad:");
        edad.setBounds(20,380,110,20);
        
        txtEdad=new JTextField();
        txtEdad.setBounds(135,380,120,20);

        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(60,435,80,20);
        btnGuardar.addActionListener(this);
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(150,435,85,20);
//        btnCancelar.addActionListener(this);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(10,475,80,20);
        btnAtras.addActionListener(this);
        
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
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnAtras)
        {
            setVisible(false);
        }
        
        if(e.getSource()==btnGuardar)
        {
            setVisible(false);
        }
    }
}
