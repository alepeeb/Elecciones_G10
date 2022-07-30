package Controller;

import Classes.ClsCandidato;
import Classes.ClsMensaje;
import Classes.ClsPropuesta;
import Model.MdlCandidato;
import java.util.LinkedList;

public class CtlCandidato {

    MdlCandidato modelo;

    public CtlCandidato() {
        this.modelo = new MdlCandidato();
    }

    public ClsMensaje AgregarCandidato(ClsCandidato candidato) {

        ClsMensaje respuesta = this.modelo.AgregarCandidato(candidato);

        return respuesta;
    }

    public ClsMensaje EliminarCandidato(String candidato) {
        ClsMensaje respuesta = this.modelo.EliminarCandidato(candidato);
        return respuesta;
    }

    public LinkedList<ClsCandidato> ObtenerCandidatos() {
        return this.modelo.ObtenerCandidatos();
    }

    public ClsMensaje ActualizarCandidato(ClsCandidato candidato) {
        ClsMensaje respuesta = this.modelo.ActualizarCandidato(candidato);
        return respuesta;
    }

// :::::::::::::::: PROPUESTAS
    
    public LinkedList<ClsPropuesta> ObtenerPropuestas(String idCandidato) {
        return this.modelo.ObtenerPropuestas(idCandidato);
    }

    public ClsMensaje AgregarPropuesta(ClsPropuesta propuesta) {
        ClsMensaje respuesta = this.modelo.AgregarPropuesta(propuesta);
        return respuesta;
    }

    public ClsMensaje EliminarPropuesta(String idPropuesta) {
        ClsMensaje respuesta = this.modelo.EliminarPropuesta(idPropuesta);
        return respuesta;
    }

    public ClsMensaje ActualizarPropuesta(ClsPropuesta propuesta) {

        ClsMensaje respuesta = this.modelo.ActualizarPropuesta(propuesta);
        return respuesta;
    }

}
