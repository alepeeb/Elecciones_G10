package Classes;

import java.util.LinkedList;

public class ClsCandidato extends ClsPersona {

    private String partidoPolitico;
    private String ciudadrigen;
    private String descripcion;
    private String mensajeCampania;
    //private String propuestas;
    private LinkedList<ClsPropuesta> propuestas;
    private String votos;

    public String getVotos() {
        return votos;
    }

    public void setVotos(String votos) {
        this.votos = votos;
    }

    public ClsCandidato(String numeroDocumento, String nombre, String telefono, String correo, String partidoPolitico, String ciudadrigen,String descripcion, String mensajeCampania) {
        super(numeroDocumento, nombre, telefono, correo);
        this.partidoPolitico = partidoPolitico;
        this.ciudadrigen = ciudadrigen;
        this.descripcion = descripcion;
        this.mensajeCampania = mensajeCampania;
        this.propuestas = new LinkedList<>();
    }
    
    
    
    

    public String getPartidoPolitico() {
        return partidoPolitico;
    }

    public void setPartidoPolitico(String partidoPolitico) {
        this.partidoPolitico = partidoPolitico;
    }

    public String getCiudadrigen() {
        return ciudadrigen;
    }

    public void setCiudadrigen(String ciudadrigen) {
        this.ciudadrigen = ciudadrigen;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getMensajeCampania() {
        return mensajeCampania;
    }

    public void setMensajeCampania(String mensajeCampania) {
        this.mensajeCampania = mensajeCampania;
    }

    public LinkedList<ClsPropuesta> getPropuestas() {
        return propuestas;
    }

    public void setPropuestas(LinkedList<ClsPropuesta> propuestas) {
        this.propuestas = propuestas;
    }



}
