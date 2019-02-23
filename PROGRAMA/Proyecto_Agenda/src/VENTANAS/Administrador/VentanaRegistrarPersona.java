/*
    FALTA VALIDAR CORREO
    PONER * EN CAMPOS OBLIGATORIOS
*/
package VENTANAS.Administrador;

import BEAN.UsuarioBEAN;
import DAO.UsuarioDAO;
import PANELES.Administrador.PanelVentanaRegistrarPersona;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistrarPersona extends JFrame implements ActionListener
{
    private PanelVentanaRegistrarPersona miPanel;
    private String nombreUsuario,Clave,tipoUsuario;
    
    public VentanaRegistrarPersona(String nombreUsuario,String Clave,String tipoUsuario)
    {
        this.nombreUsuario=nombreUsuario;
        this.Clave=Clave;
        this.tipoUsuario=tipoUsuario;
        setTitle("Registrar Datos Personales");
        setSize(350,500);
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
        miPanel.getBtnFinalizar().addKeyListener(new cambioCampo());
        miPanel.getBtnAtras().addKeyListener(new cambioCampo());
        miPanel.getTxtApema().addKeyListener(new cambioCampo());
        miPanel.getTxtApepa().addKeyListener(new cambioCampo());
        miPanel.getTxtCor().addKeyListener(new cambioCampo());
        miPanel.getTxtNom().addKeyListener(new cambioCampo());
        miPanel.getTxtTele().addKeyListener(new cambioCampo());
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnAtras())
        {
            eventoAtras();
        }
        
        if(e.getSource()==miPanel.getBtnFinalizar())
        {
            eventoFinalizar();
        }
    }
    
    private void eventoAtras()
    {
        int rpta=JOptionPane.showConfirmDialog(null,"Esta seguro que desea retroceder?\nLos Datos ingresados en la ventana anterior se perderán","Alerta!!" ,JOptionPane.YES_NO_OPTION);
        if(rpta==JOptionPane.YES_OPTION)
        {
            setVisible(false);
            VentanaRegistrarUsuario obj=new VentanaRegistrarUsuario();
            obj.setVisible(true);
        }
    }
    
    private void eventoFinalizar()
    {
        String nom,apepa,apema,tele,cor,cod;
        nom=miPanel.getTxtNom().getText();
        apepa=miPanel.getTxtApepa().getText();
        apema=miPanel.getTxtApema().getText();
        tele=miPanel.getTxtTele().getText();
        cor=miPanel.getTxtCor().getText();

        if(nom.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Nombre");
            miPanel.getTxtNom().requestFocus();
        }
        else if(apepa.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Apellido Paterno");
            miPanel.getTxtApepa().requestFocus();
        }
        else if(apema.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Apellido Materno");
            miPanel.getTxtApema().requestFocus();
        }
        else if(tele.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Teléfono");
            miPanel.getTxtTele().requestFocus();
        }
        else if(cor.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Correo Electrónico");
            miPanel.getTxtCor().requestFocus();
        }
        else
        {
            UsuarioDAO usuarioDAO=new UsuarioDAO();
            String codigo=usuarioDAO.generarCodigo();

            UsuarioBEAN usuario=new UsuarioBEAN();
            usuario.setCodigo(codigo);
            usuario.setNombreUsuario(nombreUsuario);
            usuario.setClave(Clave);
            usuario.setTipo(tipoUsuario);
            usuario.setApellidoMat(apema);
            usuario.setApellidoPat(apepa);
            usuario.setCorreo(cor);
            usuario.setNombre(nom);
            usuario.setTelefono(tele);

            usuarioDAO.registraUsuario(usuario);

            setVisible(false);

        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClave() {
        return Clave;
    }

    public String getTipoUsuario() {
        return tipoUsuario;
    }
    
    private class cambioCampo extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getSource()==miPanel.getTxtNom())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtNom().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtApepa())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtApepa().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtApema())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtApema().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtTele())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtTele().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtCor())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoFinalizar(); 
            }
            
            if(e.getSource()==miPanel.getBtnFinalizar())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoFinalizar();
            }
            
            if(e.getSource()==miPanel.getBtnAtras())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoAtras();
            }
                
        }
    }
}
