
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaRegistrarPersona;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistrarPersona extends JFrame implements ActionListener
{
    private PanelVentanaRegistrarPersona miPanel;
    
    public VentanaRegistrarPersona()
    {
        setTitle("Registrar Datos Personales");
        setSize(300,550);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaRegistrarPersona();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnAtras().addActionListener(this);
        miPanel.getBtnFinalizar().addActionListener(this);
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnAtras())
        {
            setVisible(false);
            VentanaRegistrarUsuario obj=new VentanaRegistrarUsuario();
            obj.setVisible(true);
        }
        
        if(e.getSource()==miPanel.getBtnFinalizar())
        {
            setVisible(false);
        }
    }
}
