package Classes;

public class ClsVotacion {
    private int idVoto;
    private String idVotante;
    private String idCandidato;
    private int idEleccion;
    private String votos;

    public ClsVotacion(String idVotante, String idCandidato, int idEleccion) {
        //this.idVoto = idVoto;
        this.idVotante = idVotante;
        this.idCandidato = idCandidato;
        this.idEleccion = idEleccion;
    }

    public ClsVotacion(String votos) {
        this.votos = votos;
    }

    public String getVotos() {
        return votos;
    }

    public void setVotos(String votos) {
        this.votos = votos;
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
