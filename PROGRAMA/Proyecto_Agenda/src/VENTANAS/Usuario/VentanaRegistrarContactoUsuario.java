/*
    FALTA: 
    VALIDAR CORREO
    PONER * EN CAMPOS OBLIGATORIOS
*/
package VENTANAS.Usuario;

import BEAN.AgendaBEAN;
import BEAN.ContactoBEAN;
import BEAN.UsuarioBEAN;
import DAO.AgendaDAO;
import DAO.ContactoDAO;
import DAO.UsuarioDAO;
import PANELES.Usuario.PanelVentanaRegistrarContactoUsuario;
import java.awt.Color;
import java.awt.event.*;
import javax.swing.*;

public class VentanaRegistrarContactoUsuario extends JFrame implements ActionListener,FocusListener
{
    private PanelVentanaRegistrarContactoUsuario miPanel;
    private String nombreUsuario;
    
    public VentanaRegistrarContactoUsuario(String nombreUsuario)
    {
        this.nombreUsuario=nombreUsuario;
        setTitle("Registrar Contacto");
        setSize(350,690);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaRegistrarContactoUsuario();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnGuardar().addActionListener(this);
        miPanel.getBtnCancelar().addActionListener(this);
        miPanel.getTxtDni().addFocusListener(this);
        
        miPanel.getBtnCancelar().addKeyListener(new cambioCampo());
        miPanel.getBtnGuardar().addKeyListener(new cambioCampo());
        miPanel.getTxtApema().addKeyListener(new cambioCampo());
        miPanel.getTxtApepa().addKeyListener(new cambioCampo());
        miPanel.getTxtCor().addKeyListener(new cambioCampo());
        miPanel.getTxtNom().addKeyListener(new cambioCampo());
        miPanel.getTxtTele().addKeyListener(new cambioCampo());
        miPanel.getTxtDir().addKeyListener(new cambioCampo());
        miPanel.getTxtEdad().addKeyListener(new cambioCampo());
        miPanel.getTxtDni().addKeyListener(new cambioCampo());
        miPanel.getCbdis().addKeyListener(new cambioCampo());
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnCancelar())
        {
            eventoCancelar();
        }
        
        if(e.getSource()==miPanel.getBtnGuardar())
        {
            eventoGuardar();
        }
    }
    
    private void eventoGuardar()
    {
        String nom,dni,apepa,apema,tele,dis,dir,cor,cod,stredad,nomusu;
        int edad;
        dni=miPanel.getTxtDni().getText();
        nom=miPanel.getTxtNom().getText();
        apepa=miPanel.getTxtApepa().getText();
        apema=miPanel.getTxtApema().getText();
        tele=miPanel.getTxtTele().getText();
        dis=miPanel.getCbdis().getSelectedItem().toString();
        dir=miPanel.getTxtDir().getText();
        cor=miPanel.getTxtCor().getText();
        stredad=miPanel.getTxtEdad().getText();
        nomusu=nombreUsuario;

        if(dni.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo DNI");
            miPanel.getTxtDni().requestFocus();
        }
        else if(nom.equals(""))
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
        else if(dis.equals("-Seleccionar Distrito-"))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe seleccionar el campo Distrito");
            miPanel.getCbdis().requestFocus();
        }
        else if(dir.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Dirección");
            miPanel.getTxtDir().requestFocus();
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
        else if(stredad.equals(""))
        {
            JOptionPane.showMessageDialog(null, "Ustede debe llenar el campo Edad");
            miPanel.getTxtEdad().requestFocus();
        }
        else
        {
            edad=Integer.parseInt(stredad);

            ContactoDAO contactoDAO=new ContactoDAO();
            String codigo=contactoDAO.generarCodigo();
            AgendaDAO agendaDAO=new AgendaDAO();
            UsuarioDAO usuario=new UsuarioDAO();
            String cod_usu=usuario.getCodigoUsuario(nomusu);

            ContactoBEAN contacto=new ContactoBEAN();
            contacto.setCodigo(codigo);
            contacto.setDni(dni);
            contacto.setApellidoMat(apema);
            contacto.setApellidoPat(apepa);
            contacto.setCorreo(cor);
            contacto.setDireccion(dir);
            contacto.setDistrito(dis);
            contacto.setEdad(edad);
            contacto.setNombre(nom);
            contacto.setTelefono(tele);

            AgendaBEAN agenda=new AgendaBEAN();
            agenda.setCodigoUsuario(cod_usu);

            UsuarioBEAN usu=new UsuarioBEAN();
            usu.setCodigo(cod_usu);

            int verificarDNI=contactoDAO.verificarPersona(contacto,usu);

            if(verificarDNI==0)
            {
                agenda.setCodigoContacto(codigo);
                contactoDAO.registraContacto(contacto);
                int i=agendaDAO.registraAgenda(agenda);
                if(i==1)
                    miPanel.limpiarCampos();
                else
                    miPanel.getTxtDni().requestFocus();
            }
            else
            {
                JOptionPane.showMessageDialog(null, "Error!!..Verifique los datos ingresados");
                miPanel.getTxtDni().requestFocus();
            }
        }
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }
    
    @Override
    public void focusGained(FocusEvent e)
    {
        miPanel.getMensaje().setText("");
    }
    
    @Override
    public void focusLost(FocusEvent e)
    {
        if(e.getSource()==miPanel.getTxtDni())
        {
            String dni=miPanel.getTxtDni().getText();
            ContactoBEAN contacto=new ContactoBEAN();
            contacto.setDni(dni);
            
            String nomusu=nombreUsuario;
            UsuarioDAO usuario=new UsuarioDAO();
            String cod_usu=usuario.getCodigoUsuario(nomusu);
            UsuarioBEAN usu=new UsuarioBEAN();
            usu.setCodigo(cod_usu);
            
            ContactoDAO contactoDAO=new ContactoDAO();
            int verificacion=contactoDAO.verificarContacto(contacto, usu);
            if(verificacion>0 && dni.compareTo("")!=0 )
            {
                miPanel.getMensaje().setText("Contacto Registrado");
            }
        }
    }
    
    private void eventoCancelar()
    {
        int rpta=JOptionPane.showConfirmDialog(null,"Esta seguro que desea cancelar?\nLos Datos ingresados en la ventana se perderán","Alerta!!" ,JOptionPane.YES_NO_OPTION);
        if(rpta==JOptionPane.YES_OPTION)
        {
            setVisible(false);
        }
    }
    
    private class cambioCampo extends KeyAdapter
    {
        @Override
        public void keyPressed(KeyEvent e)
        {
            if(e.getSource()==miPanel.getTxtDni())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtDni().nextFocus();
            }
            
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
            
            if(e.getSource()==miPanel.getCbdis())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getCbdis().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtDir())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtDir().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtTele())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtTele().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtCor())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    miPanel.getTxtCor().nextFocus();
            }
            
            if(e.getSource()==miPanel.getTxtEdad())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoGuardar(); 
            }
            
            if(e.getSource()==miPanel.getBtnGuardar())
            {
                if(e.VK_ENTER==e.getKeyCode())
                    eventoGuardar();
            }
            
            if(e.getSource()==miPanel.getBtnCancelar())
            {
                if(e.VK_ENTER==e.getKeyCode())
                   eventoCancelar();
            }
                
        }
    }
}
