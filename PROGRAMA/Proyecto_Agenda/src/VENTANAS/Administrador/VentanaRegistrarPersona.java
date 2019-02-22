/*
    FALTA VALIDAR CORREO
*/
package VENTANAS.Administrador;

import BEAN.PersonaBEAN;
import BEAN.UsuarioBEAN;
import DAO.PersonaDAO;
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
        setSize(300,550);
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
        
        add(miPanel);
    }
    
    @Override
    public void actionPerformed(ActionEvent e)
    {
        if(e.getSource()==miPanel.getBtnAtras())
        {
            setVisible(false);
            VentanaRegistrarUsuario obj=new VentanaRegistrarUsuario();
            obj.setVisible(true);
        }
        
        if(e.getSource()==miPanel.getBtnFinalizar())
        {
            String nom,dni,apepa,apema,tele,dis,dir,cor,cod,stredad;
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
                if(miPanel.getMensaje2().getText().equals("")==false)
                    JOptionPane.showMessageDialog(null, "La persona que intenta registrar ya esta registrada...Se proseguirá a registrar la cuenta de Usuario pero no se tomaran en cuenta los datos personales ingresados");
                edad=Integer.parseInt(stredad);
                PersonaBEAN persona=new PersonaBEAN();
                persona.setApellidoMat(apema);
                persona.setApellidoPat(apepa);
                persona.setCorreo(cor);
                persona.setDireccion(dir);
                persona.setDistrito(dis);
                persona.setDni(dni);
                persona.setEdad(edad);
                persona.setNombre(nom);
                persona.setTelefono(tele);
                
                PersonaDAO personaDAO=new PersonaDAO();
                UsuarioDAO usuarioDAO=new UsuarioDAO();
                String codigo=usuarioDAO.generarCodigo();
                
                UsuarioBEAN usuario=new UsuarioBEAN();
                usuario.setCodigo(codigo);
                usuario.setDni(dni);
                usuario.setNombreUsuario(nombreUsuario);
                usuario.setClave(Clave);
                usuario.setTipo(tipoUsuario);
                
                personaDAO.registraPersona(persona);
                usuarioDAO.registraUsuario(usuario);

                setVisible(false);
                
            }
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
    
    
}
