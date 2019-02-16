
package VENTANAS.Administrador;


import PANELES.Administrador.PanelVentanaRegistrarContacto;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;


public class VentanaRegistrarContacto extends JFrame implements ActionListener
{
    private PanelVentanaRegistrarContacto miPanel;
    
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
        miPanel=new PanelVentanaRegistrarContacto();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnGuardar().addActionListener(this);
        miPanel.getBtnAtras().addActionListener(this);
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnAtras())
        {
            setVisible(false);
        }
        
        if(e.getSource()==miPanel.getBtnGuardar())
        {
            setVisible(false);
        }
    }
}

