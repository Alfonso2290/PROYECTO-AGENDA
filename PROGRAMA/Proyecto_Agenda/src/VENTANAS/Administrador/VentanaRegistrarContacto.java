
package VENTANAS.Administrador;


import PANELES.Administrador.PanelVentanaRegistrarContacto;
import java.awt.event.*;
import javax.swing.*;


public class VentanaRegistrarContacto extends JFrame implements ActionListener
{
    private JButton btnGuardar,btnCancelar,btnAtras;
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
        
        btnGuardar=new JButton("Guardar");
        btnGuardar.setBounds(60,435,80,20);
        btnGuardar.addActionListener(this);
        
        btnCancelar=new JButton("Cancelar");
        btnCancelar.setBounds(150,435,85,20);
//        btnCancelar.addActionListener(this);
        
        btnAtras=new JButton("<<Atrás");
        btnAtras.setBounds(10,475,80,20);
        btnAtras.addActionListener(this);
        
        miPanel.add(btnGuardar);
        miPanel.add(btnAtras);
        miPanel.add(btnCancelar);
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==btnAtras)
        {
            setVisible(false);
        }
        
        if(e.getSource()==btnGuardar)
        {
            setVisible(false);
        }
    }
}

