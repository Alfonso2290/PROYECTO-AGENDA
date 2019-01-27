
package VENTANAS.Administrador;

import VENTANAS.VentanaPrincipal;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.URL;
import javax.swing.ImageIcon;
import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

public class VentanaPrincipalAdministrador extends JFrame implements ActionListener 
{
    private JMenuBar barraMenu;
    private JMenu menuUsuario,menuContactos,menuCuentas;
    private JMenuItem itemUsuarioSalir,itemUsuarioCerrarSesion,itemCuentasNuevo,
            itemCuentasEditar,itemCuentasVer,itemContactosNuevo,itemContactosEditar,
            itemContactosVer;
    private JLabel imagen;
    
    public VentanaPrincipalAdministrador()
    {
        setTitle("Administrador");
        setSize(350,300);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        setLayout(null);
        
        barraMenu=new JMenuBar();
        menuUsuario=new JMenu("Usuario");
        itemUsuarioCerrarSesion=new JMenuItem("Cerrar Sesión");
        menuUsuario.add(itemUsuarioCerrarSesion);
        itemUsuarioCerrarSesion.addActionListener(this);
        itemUsuarioSalir=new JMenuItem("Salir");
        menuUsuario.add(itemUsuarioSalir);
        itemUsuarioSalir.addActionListener(this);
        
        menuCuentas=new JMenu("Cuentas");
        itemCuentasNuevo=new JMenuItem("Nuevo");
        menuCuentas.add(itemCuentasNuevo);
        itemCuentasNuevo.addActionListener(this);
        itemCuentasEditar=new JMenuItem("Editar");
        menuCuentas.add(itemCuentasEditar);
        itemCuentasVer=new JMenuItem("Ver");
        menuCuentas.add(itemCuentasVer);
        
        menuContactos=new JMenu("Contactos");
        itemContactosNuevo=new JMenuItem("Nuevo");
        itemContactosNuevo.addActionListener(this);
        menuContactos.add(itemContactosNuevo);
        itemContactosEditar=new JMenuItem("Editar");
        menuContactos.add(itemContactosEditar);
        itemContactosVer=new JMenuItem("Ver");
        menuContactos.add(itemContactosVer);
        
        barraMenu.add(menuUsuario);
        barraMenu.add(menuCuentas);
        barraMenu.add(menuContactos);
        
        setJMenuBar(barraMenu);
        
        ////Agregar imagen a un label
        String ruta="/imagenes/administrador.jpg";
        URL url=this.getClass().getResource(ruta);
        ImageIcon icono=new ImageIcon(url);
        imagen=new JLabel();
        imagen.setBounds(30,20,400,200);
        imagen.setIcon(icono);
        add(imagen);
        ///*************************************
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==itemUsuarioSalir)
        {
            System.exit(0);
        }
        
        if(e.getSource()==itemUsuarioCerrarSesion)
        {
            setVisible(false);
            VentanaPrincipal miVentana=new VentanaPrincipal();
            miVentana.setVisible(true);
        }
        
        if(e.getSource()==itemCuentasNuevo)
        {
            VentanaRegistrarUsuario miVentana=new VentanaRegistrarUsuario();
            miVentana.setVisible(true);
        }
        
        if(e.getSource()==itemContactosNuevo)
        {
            VentanaRegistrarContacto miVentana=new VentanaRegistrarContacto();
            miVentana.setVisible(true);
        }
    }
}
