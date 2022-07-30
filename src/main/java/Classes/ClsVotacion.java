package Classes;

public class ClsVotacion {
    private int idVoto;
    private String idVotante;
    private String idCandidato;
    private int idEleccion;

    public ClsVotacion(String idVotante, String idCandidato, int idEleccion) {
        this.idVotante = idVotante;
        this.idCandidato = idCandidato;
        this.idEleccion = idEleccion;
    }

    public int getIdEleccion() {
        return idEleccion;
    }

    public void setIdEleccion(int idEleccion) {
        this.idEleccion = idEleccion;
    }

    public int getIdVoto() {
        return idVoto;
    }

    public void setIdVoto(int idVoto) {
        this.idVoto = idVoto;
    }

    public String getIdVotante() {
        return idVotante;
    }

    public void setIdVotante(String idVotante) {
        this.idVotante = idVotante;
    }

    public String getIdCandidato() {
        return idCandidato;
    }

    public void setIdCandidato(String idCandidato) {
        this.idCandidato = idCandidato;
    }

}
