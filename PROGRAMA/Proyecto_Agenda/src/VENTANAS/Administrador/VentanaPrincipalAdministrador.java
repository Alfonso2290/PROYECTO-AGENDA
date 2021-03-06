
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaPrincipalAdministrador;
import VENTANAS.VentanaPrincipal;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VentanaPrincipalAdministrador extends JFrame implements ActionListener 
{
    private JMenuBar barraMenu;
    private JMenu menuUsuario,menuContactos,menuCuentas;
    private JMenuItem itemUsuarioSalir,itemUsuarioCerrarSesion,itemCuentasNuevo,
            itemCuentasEditar,itemCuentasVer,itemContactosNuevo,itemContactosEditar,
            itemContactosVer;
    private PanelVentanaPrincipalAdministrador miPanel;
    private String nombreUsuario;
    
    public VentanaPrincipalAdministrador(String nombreUsuario)
    {
        this.nombreUsuario=nombreUsuario;
        setTitle("Administrador");
        setSize(350,300);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaPrincipalAdministrador();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
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
        itemCuentasEditar.addActionListener(this);
        menuCuentas.add(itemCuentasEditar);
        itemCuentasVer=new JMenuItem("Ver");
        itemCuentasVer.addActionListener(this);
        menuCuentas.add(itemCuentasVer);
        
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
        barraMenu.add(menuCuentas);
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
        
        else if(e.getSource()==itemCuentasNuevo)
        {
            VentanaRegistrarUsuario miVentana1=new VentanaRegistrarUsuario();
            miVentana1.setVisible(true);
        }
        else if(e.getSource()==itemCuentasVer)
        {
            VentanaMostrarCuentas miVentana2=new VentanaMostrarCuentas();
            miVentana2.setVisible(true);
        }
        else if(e.getSource()==itemCuentasEditar)
        {
            VentanaEditarCuenta miVentana3=new VentanaEditarCuenta();
            miVentana3.setVisible(true);
        }
        
        else if(e.getSource()==itemContactosNuevo)
        {
            VentanaRegistrarContacto miVentana4=new VentanaRegistrarContacto(nombreUsuario);
            miVentana4.setVisible(true);
        }
        else if(e.getSource()==itemContactosVer)
        {
            VentanaMostrarContactos miVentana5=new VentanaMostrarContactos(nombreUsuario);
            miVentana5.setVisible(true);
        }
        else if(e.getSource()==itemContactosEditar)
        {
            VentanaEditarContacto miVentana6=new VentanaEditarContacto();
            miVentana6.setVisible(true);
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    
    
    
}
