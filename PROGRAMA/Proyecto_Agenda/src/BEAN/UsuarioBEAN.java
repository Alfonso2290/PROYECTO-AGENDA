
package BEAN;

public class UsuarioBEAN extends PersonaBEAN
{
    private String codigo,nombreUsuario,clave,tipo;

    public void setCodigo(String codigo) {
        this.codigo = codigo;
    }

    public void setNombreUsuario(String nombreUsuario) {
        this.nombreUsuario = nombreUsuario;
    }

    public void setClave(String clave) {
        this.clave = clave;
    }

    public void setTipo(String tipo) {
        this.tipo = tipo;
    }

    public String getCodigo() {
        return codigo;
    }

    public String getNombreUsuario() {
        return nombreUsuario;
    }

    public String getClave() {
        return clave;
    }

    public String getTipo() {
        return tipo;
    }
    
}
