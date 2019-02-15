
package VENTANAS;

import PANELES.PanelVentanaPrincipal;
import java.awt.event.*;
import javax.swing.*;
import VENTANAS.Administrador.VentanaPrincipalAdministrador;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    
    private JButton btnSalir,btnIngresar;
    private PanelVentanaPrincipal miPanel;
            
    public VentanaPrincipal()
    {
        setTitle("Ventana Principal");
        setSize(350,300);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();  
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaPrincipal();
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setBounds(80,200,85,30);
        btnIngresar.addActionListener(this);
        
        btnSalir=new JButton("Salir");
        btnSalir.setBounds(190,200,80,30);
        btnSalir.addActionListener(this);
        
        add(miPanel);
        miPanel.add(btnSalir);
        miPanel.add(btnIngresar);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnSalir)
        {
            System.exit(0);
        }
        
        if(e.getSource()==btnIngresar)
        {
            setVisible(false);
            VentanaPrincipalAdministrador miVentana=new VentanaPrincipalAdministrador();
            miVentana.setVisible(true);
            miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
        }
    }
}
