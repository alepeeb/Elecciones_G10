package Controller;

import Classes.ClsMensaje;
import Classes.ClsVotante;
import Model.MdlVotante;
import java.util.LinkedList;

public class CtlVotante {

    MdlVotante modelo;

    public CtlVotante() {
        this.modelo = new MdlVotante();
    }

    public ClsMensaje agregarVotante(ClsVotante votante) {

        ClsMensaje respuesta = this.modelo.agregarVotante(votante);

        return respuesta;
    }

    public ClsMensaje EliminarVotante(String votante) {
        ClsMensaje respuesta = this.modelo.EliminarVotante(votante);
        return respuesta;
    }

    public LinkedList<ClsVotante> ObtenerVotantes() {
        return this.modelo.ObtenerVotantes();
    }

    public ClsMensaje ActualizarVotante(ClsVotante votante) {
        ClsMensaje respuesta = this.modelo.ActualizarVotante(votante);
        return respuesta;
    }

    public boolean UsuarioExiste(String idVotante) {
        boolean respuesta = this.modelo.UsurioExiste(idVotante);
        return respuesta;
    }
}
