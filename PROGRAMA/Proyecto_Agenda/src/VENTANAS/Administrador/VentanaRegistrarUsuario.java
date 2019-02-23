
package VENTANAS.Administrador;

import PANELES.Administrador.PanelVentanaRegistrarUsuario;
import java.awt.*;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistrarUsuario extends JFrame implements ActionListener
{
    private PanelVentanaRegistrarUsuario miPanel;
    
    public VentanaRegistrarUsuario()
    {
        setTitle("Registrar Usuario");
        setSize(350,430);
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
        miPanel.getBtnSiguiente().addKeyListener(new cambioCampo());
        miPanel.getBtnAtras().addKeyListener(new cambioCampo());
        miPanel.getTxtCla().addKeyListener(new cambioCampo());
        miPanel.getTxtCla2().addKeyListener(new cambioCampo());
        miPanel.getTxtUsu().addKeyListener(new cambioCampo());
        miPanel.getCbtipo().addKeyListener(new cambioCampo());
        
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
            eventoSiguiente(); 
        }
    }
    
    private void eventoSiguiente()
    {
        String tipo,usu,cla1,cla2;
        tipo=miPanel.getCbtipo().getSelectedItem().toString();
        usu=miPanel.getTxtUsu().getText();
        cla1=miPanel.getTxtCla().getText();
        cla2=miPanel.getTxtCla2().getText();

        if(tipo.equals("-Seleccionar Tipo Usuario-"))
        {
            JOptionPane.showMessageDialog(null, "Usted debe seleccionar el Tipo de usuario");
            miPanel.getCbtipo().requestFocus();
        }
        else if(usu.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Usuario");
            miPanel.getTxtUsu().requestFocus();
        }
        else if(cla1.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Contraseña");
            miPanel.getTxtCla().requestFocus();
        }
        else if(cla2.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Repita Contraseña");
            miPanel.getTxtCla2().requestFocus();
        }
        else if(cla1.compareTo(cla2)!=0)
        {
            JOptionPane.showMessageDialog(null, "Las contraseñas ingresadas no coinciden\nInténtelo de nuevo");
            miPanel.getTxtCla().setText("");
            miPanel.getTxtCla2().setText("");
            miPanel.getTxtCla().requestFocus();
        }
        else if(miPanel.getMensaje2().getText().equals("")==false)
        {
            JOptionPane.showMessageDialog(null, "La cuenta ingresada ya existe\nInténte con otro Usuario");
            miPanel.getTxtUsu().requestFocus();
        }
        else
        {
            setVisible(false);
            VentanaRegistrarPersona obj=new VentanaRegistrarPersona(usu,cla1,tipo);
            obj.setVisible(true);
        }
    }
    
    private class cambioCampo extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getSource()==miPanel.getCbtipo())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getCbtipo().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtUsu())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtUsu().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtCla())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtCla().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtCla2())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoSiguiente(); 
            }
            
            if(e.getSource()==miPanel.getBtnSiguiente())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoSiguiente();
            }
            
            if(e.getSource()==miPanel.getBtnAtras())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    setVisible(false);
            }
                
        }
    }
}
