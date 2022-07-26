package Classes;

public class ClsPropuesta {

    private String idPropuesta;
    private String idCandidato;
    private String descripcion;
    private String fech_ins;
    private String sector;

    public String getSector() {
        return sector;
    }

    public void setSector(String sector) {
        this.sector = sector;
    }

    public ClsPropuesta(String idCandidato, String sector, String descripcion) {
        this.idCandidato = idCandidato;
        this.sector = sector;
        this.descripcion = descripcion;
    }

    public ClsPropuesta(String idPropuesta, String idCandidato, String descripcion, String fech_ins, String sector) {
        this.idPropuesta = idPropuesta;
        this.idCandidato = idCandidato;
        this.descripcion = descripcion;
        this.fech_ins = fech_ins;
        this.sector = sector;
    }

    public String getIdPropuesta() {
        return idPropuesta;
    }

    public void setIdPropuesta(String idPropuesta) {
        this.idPropuesta = idPropuesta;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

    public String getDescripcion() {
        return descripcion;
    }

    public void setDescripcion(String descripcion) {
        this.descripcion = descripcion;
    }

    public String getFech_ins() {
        return fech_ins;
    }

    public void setFech_ins(String fech_ins) {
        this.fech_ins = fech_ins;
    }
    
    

}
