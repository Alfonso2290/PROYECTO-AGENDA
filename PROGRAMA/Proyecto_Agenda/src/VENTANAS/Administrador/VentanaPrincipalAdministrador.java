
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaPrincipalAdministrador;
import VENTANAS.VentanaPrincipal;
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
        miPanel=new PanelVentanaPrincipalAdministrador();
        
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
        add(miPanel);
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
            miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
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
