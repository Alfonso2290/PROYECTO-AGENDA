
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
            String tipo,usu,cla1,cla2;
            tipo=miPanel.getCbtipo().getSelectedItem().toString();
            usu=miPanel.getTxtUsu().getText();
            cla1=miPanel.getTxtCla().getText();
            cla2=miPanel.getTxtCla2().getText();
            
            if(tipo.equals("-Seleccionar-"))
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
    }
}
