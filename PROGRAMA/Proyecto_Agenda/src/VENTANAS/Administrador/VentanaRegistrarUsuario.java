
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaRegistrarUsuario;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistrarUsuario extends JFrame implements ActionListener
{
    private JButton btnSiguiente,btnAtras;
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
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(40,265,100,20);
        btnAtras.addActionListener(this);
        
        btnSiguiente=new JButton("Siguiente>>");
        btnSiguiente.setBounds(150,265,110,20);
        btnSiguiente.addActionListener(this);
        
        miPanel.add(btnSiguiente);
        miPanel.add(btnAtras);
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnAtras)
        {
            setVisible(false);
        }
        
        if(e.getSource()==btnSiguiente)
        {
            setVisible(false);
            VentanaRegistrarPersona obj=new VentanaRegistrarPersona();
            obj.setVisible(true);
        }
    }
}
