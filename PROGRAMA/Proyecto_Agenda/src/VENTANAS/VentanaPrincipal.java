
package VENTANAS;

import BEAN.UsuarioBEAN;
import DAO.UsuarioDAO;
import PANELES.PanelVentanaPrincipal;
import java.awt.event.*;
import javax.swing.*;
import VENTANAS.Administrador.VentanaPrincipalAdministrador;
import VENTANAS.Usuario.VentanaPrincipalUsuario;
import java.awt.*;

public class VentanaPrincipal extends JFrame implements ActionListener
{
    private PanelVentanaPrincipal miPanel;
    private int contador=0;
            
    public VentanaPrincipal()
    {
        setTitle("Ventana Principal");
        setSize(350,350);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();  
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaPrincipal();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnIngresar().addActionListener(this);
        miPanel.getBtnSalir().addActionListener(this);
        miPanel.getBtnIngresar().addKeyListener(new cambioCampo());
        miPanel.getTxtcla().addKeyListener(new cambioCampo());
        miPanel.getTxtusu().addKeyListener(new cambioCampo());
        miPanel.getBtnSalir().addKeyListener(new cambioCampo());
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnSalir())
        {
            System.exit(0);
        }
        
        if(e.getSource()==miPanel.getBtnIngresar())
        {
            eventoIngreso();
        }
    }
    
    public void eventoIngreso()
    {
        String usu,cla;
        usu=miPanel.getTxtusu().getText();
        cla=miPanel.getTxtcla().getText();

        if(usu.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Usuario ");
            miPanel.getTxtusu().requestFocus();
        }
        else if(cla.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Usted debe llenar el campo Contraseña ");
            miPanel.getTxtcla().requestFocus();
        }
        else
        {
            contador++;
            if(contador==2)
            {
                miPanel.getCerrar().setBounds(305,60,40,12);
                miPanel.getMensaje().setText("A Usted le queda " + (3-contador) + " intento para acceder al Sistema");
            }
            else
            {
                miPanel.getMensaje().setText("A Usted le quedan " + (3-contador) + " intentos para acceder al Sistema");
                miPanel.getMensaje().setBounds(25,55,300,20);
                miPanel.getCerrar().setBounds(310,60,40,12);
            }

            if(contador<4)
            {
                UsuarioBEAN usuario=new UsuarioBEAN();
                usuario.setNombreUsuario(usu);
                usuario.setClave(cla);
                UsuarioDAO usuarioDAO=new UsuarioDAO();
                int verificar=usuarioDAO.verificarCuentaDeUsuario(usuario);
                if(verificar==1)
                {
                    String tipo=usuarioDAO.getTipoUsuario(usuario);
                    setVisible(false);
                    if(tipo.equals("Administrador"))
                    {
                        VentanaPrincipalAdministrador miVentana=new VentanaPrincipalAdministrador(miPanel.getTxtusu().getText());
                        miVentana.setVisible(true);
                        miVentana.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                    }
                    else
                    {
                        VentanaPrincipalUsuario miVentana2=new VentanaPrincipalUsuario(miPanel.getTxtusu().getText());
                        miVentana2.setVisible(true);
                        miVentana2.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE); 
                    }
                }
                else if(contador==3)
                {
                    JOptionPane.showMessageDialog(null, "Usted ha superado el límite de intentos\nPrograma Finalizado!!");
                    System.exit(0);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "El usuario y/o contraseña son incorrectos");
                    miPanel.limpiarCampos();
                    miPanel.getTxtusu().requestFocus();
                }
            }
        }
    }
    
    private class cambioCampo extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getSource()==miPanel.getTxtusu())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtusu().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtcla())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoIngreso(); 
            }
            
            if(e.getSource()==miPanel.getBtnIngresar())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoIngreso();
            }
            
            if(e.getSource()==miPanel.getBtnSalir())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    System.exit(0);
            }
                
        }
    }
}
