
package VENTANAS.Usuario;

import PANELES.Usuario.PanelVentanaPrincipalUsuario;
import VENTANAS.VentanaPrincipal;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipalUsuario extends JFrame implements ActionListener 
{
    private JMenuBar barraMenu;
    private JMenu menuUsuario,menuContactos;
    private JMenuItem itemUsuarioSalir,itemUsuarioCerrarSesion,
            itemContactosNuevo,itemContactosEditar,
            itemContactosVer;
    private PanelVentanaPrincipalUsuario miPanel;
    private String nombreUsuario;
    
    public VentanaPrincipalUsuario(String nombreUsuario)
    {
        this.nombreUsuario=nombreUsuario;
        setTitle("Usuario");
        setSize(350,300);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaPrincipalUsuario();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        barraMenu=new JMenuBar();
        menuUsuario=new JMenu("Usuario");
        itemUsuarioCerrarSesion=new JMenuItem("Cerrar Sesión");
        menuUsuario.add(itemUsuarioCerrarSesion);
        itemUsuarioCerrarSesion.addActionListener(this);
        itemUsuarioSalir=new JMenuItem("Salir");
        menuUsuario.add(itemUsuarioSalir);
        itemUsuarioSalir.addActionListener(this);
        
        menuContactos=new JMenu("Contactos");
        itemContactosNuevo=new JMenuItem("Nuevo");
        itemContactosNuevo.addActionListener(this);
        menuContactos.add(itemContactosNuevo);
        itemContactosEditar=new JMenuItem("Editar");
        itemContactosEditar.addActionListener(this);
        menuContactos.add(itemContactosEditar);
        itemContactosVer=new JMenuItem("Ver");
        itemContactosVer.addActionListener(this);
        menuContactos.add(itemContactosVer);
              
        barraMenu.add(menuUsuario);
        barraMenu.add(menuContactos);
        
        setJMenuBar(barraMenu);
        add(miPanel);
        
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==itemUsuarioSalir)
        {
            System.exit(0);
        }
        
        else if(e.getSource()==itemUsuarioCerrarSesion)
        {
            setVisible(false);
            VentanaPrincipal miVentana=new VentanaPrincipal();
            miVentana.setVisible(true);
            miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
        
        else if(e.getSource()==itemContactosNuevo)
        {
            VentanaRegistrarContactoUsuario miVentana4=new VentanaRegistrarContactoUsuario(nombreUsuario);
            miVentana4.setVisible(true);
        }
        else if(e.getSource()==itemContactosVer)
        {
            VentanaMostrarContactosUsuario miVentana5=new VentanaMostrarContactosUsuario(nombreUsuario);
            miVentana5.setVisible(true);
        }
        else if(e.getSource()==itemContactosEditar)
        {
            /*VentanaEditarContacto miVentana6=new VentanaEditarContacto();
            miVentana6.setVisible(true);*/
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

}
