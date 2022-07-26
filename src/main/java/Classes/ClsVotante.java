package Classes;

public class ClsVotante extends ClsPersona {
   private String direccion;

    public ClsVotante(String numeroDocumento, String nombre, String telefono, String correo, String direccion) {
        super(numeroDocumento, nombre, telefono, correo);
        this.direccion = direccion;
    }

    public String getDireccion() {
        return direccion;
    }

    public void setDireccion(String direccion) {
        this.direccion = direccion;
    }
   
   

}
