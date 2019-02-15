
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaRegistrarPersona;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistrarPersona extends JFrame implements ActionListener
{
    private PanelVentanaRegistrarPersona miPanel;
    private JButton btnFinalizar,btnAtras;
    
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
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(40,465,100,20);
        btnAtras.addActionListener(this);
        
        btnFinalizar=new JButton("Finalizar");
        btnFinalizar.setBounds(150,465,110,20);
        btnFinalizar.addActionListener(this);
        
        add(miPanel);
        miPanel.add(btnFinalizar);
        miPanel.add(btnAtras);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnAtras)
        {
            setVisible(false);
            VentanaRegistrarUsuario obj=new VentanaRegistrarUsuario();
            obj.setVisible(true);
        }
        
        if(e.getSource()==btnFinalizar)
        {
            setVisible(false);
        }
    }
}
