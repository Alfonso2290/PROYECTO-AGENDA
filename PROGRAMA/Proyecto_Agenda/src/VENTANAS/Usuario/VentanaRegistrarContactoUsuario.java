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
        setSize(300,530);
        setResizable(false);
        setLocationRelativeTo(null);
        Inicio();
    }
    
    private void Inicio()
    {
        miPanel=new PanelVentanaRegistrarContactoUsuario();
        miPanel.setBackground(Color.LIGHT_GRAY.brighter());
        
        miPanel.getBtnGuardar().addActionListener(this);
        miPanel.getBtnAtras().addActionListener(this);
        miPanel.getBtnCancelar().addActionListener(this);
        miPanel.getTxtDni().addFocusListener(this);
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnAtras())
        {
            setVisible(false);
        }
        
        if(e.getSource()==miPanel.getBtnCancelar())
        {
            miPanel.limpiarCampos();
        }
        
        if(e.getSource()==miPanel.getBtnGuardar())
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
            else if(dis.equals("-Seleccionar-"))
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
                    agendaDAO.registraAgenda(agenda);
                }
                else
                {
                    JOptionPane.showMessageDialog(null, "Error!!..Verifique los datos ingresados");
                }
                
                miPanel.limpiarCampos();
                
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
}