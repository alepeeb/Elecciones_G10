package Controller;

import Classes.ClsCandidato;
import Classes.ClsEleccion;
import Classes.ClsMensaje;
import Classes.ClsVotacion;
//import Model.MdlEleccion;
import Model.MdlVotacion;
import java.util.LinkedList;

public class CtlVotacion {

    MdlVotacion modelo;

    public CtlVotacion() {
        this.modelo = new MdlVotacion();
    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {
        return this.modelo.ObtenerElecciones();

    }

    public LinkedList<ClsCandidato> ObtenerCandidatosEleccion(String idEleccion) {
        return this.modelo.ObtenerCandidatosEleccion(idEleccion);

    }
    
    public ClsMensaje AgregarVoto(ClsVotacion voto) {

        ClsMensaje respuesta = this.modelo.AgregarVoto(voto);
        return respuesta;
    }

    public int UsuarioVoto(String idVotante, int idEleccion) {
        int respuesta = this.modelo.UsurioVoto(idVotante, idEleccion);
        return respuesta;
    }
}
