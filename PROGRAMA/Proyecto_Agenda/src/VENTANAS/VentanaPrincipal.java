
package VENTANAS;

import PANELES.PanelVentanaPrincipal;
import java.awt.event.*;
import javax.swing.*;
import VENTANAS.Administrador.VentanaPrincipalAdministrador;
import java.awt.*;

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
        Font fuenteCampos=new Font("Arial", Font.BOLD, 13);
        miPanel=new PanelVentanaPrincipal();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        btnIngresar=new JButton("Ingresar");
        btnIngresar.setBounds(80,200,90,30);
        btnIngresar.addActionListener(this);
        btnIngresar.addMouseListener(new ColorBotones(Color.LIGHT_GRAY.darker(),Color.WHITE,btnIngresar));
        btnIngresar.setFont(fuenteCampos);
        
        btnSalir=new JButton("Salir");
        btnSalir.setBounds(190,200,85,30);
        btnSalir.addActionListener(this);
        btnSalir.addMouseListener(new ColorBotones(Color.LIGHT_GRAY.darker(),Color.WHITE,btnSalir));
        btnSalir.setFont(fuenteCampos);
        
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
    
    private class ColorBotones extends MouseAdapter
    {
        private Color colorFondo,colorLetra;
        private JButton boton;
        
        public ColorBotones(Color colorFondo,Color colorLetra,JButton boton)
        {
            this.colorFondo=colorFondo;
            this.colorLetra=colorLetra;
            this.boton=boton;
        }
        
        @Override
        public void mouseEntered(MouseEvent e)
        {
            
            this.boton.setBackground(colorFondo);
            this.boton.setForeground(colorLetra);
        }
        
        @Override
        public void mouseExited(MouseEvent e)
        {
            
            this.boton.setBackground(getBackground());
            this.boton.setForeground(null);
            
        }
    }
}
