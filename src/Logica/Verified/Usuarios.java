package Logica.Verified;

public class Usuarios {

    private String NomEmpleado, ApeEmpleado, Usuario, Contraseña;
    private long CodEmpleado, TelEmpleado;

    public long getCodEmpleado() {
        return CodEmpleado;
    }

    public void setCodEmpleado(long CodEmpleado) {
        this.CodEmpleado = CodEmpleado;
    }

    public String getNomEmpleado() {
        return NomEmpleado;
    }

    public void setNomEmpleado(String NomEmpleado) {
        this.NomEmpleado = NomEmpleado;
    }

    public String getApeEmpleado() {
        return ApeEmpleado;
    }

    public void setApeEmpleado(String ApeEmpleado) {
        this.ApeEmpleado = ApeEmpleado;
    }

    public long getTelEmpleado() {
        return TelEmpleado;
    }

    public void setTelEmpleado(long TelEmpleado) {
        this.TelEmpleado = TelEmpleado;
    }

    public String getUsuario() {
        return Usuario;
    }

    public void setUsuario(String Usuario) {
        this.Usuario = Usuario;
    }

    public String getContraseña() {
        return Contraseña;
    }

    public void setContraseña(String Contraseña) {
        this.Contraseña = Contraseña;
    }

}
