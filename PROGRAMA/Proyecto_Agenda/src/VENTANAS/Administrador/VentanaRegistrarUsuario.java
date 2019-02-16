
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaRegistrarUsuario;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistrarUsuario extends JFrame implements ActionListener
{
    private PanelVentanaRegistrarUsuario miPanel;
    
    public VentanaRegistrarUsuario()
    {
        setTitle("Registrar Usuario");
        setSize(300,350);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaRegistrarUsuario();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnAtras().addActionListener(this);
        miPanel.getBtnSiguiente().addActionListener(this);
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnAtras())
        {
            setVisible(false);
        }
        
        if(e.getSource()==miPanel.getBtnSiguiente())
        {
            setVisible(false);
            VentanaRegistrarPersona obj=new VentanaRegistrarPersona();
            obj.setVisible(true);
        }
    }
}
