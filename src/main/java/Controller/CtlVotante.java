package Controller;

import Classes.ClsVotante;
import Model.MdlVotante;
import java.util.LinkedList;

public class CtlVotante {

    MdlVotante modelo;

    public CtlVotante() {
        this.modelo = new MdlVotante();
    }

    public boolean agregarVotante(ClsVotante votante) {

        boolean respuesta = this.modelo.agregarVotante(votante);

        return respuesta;
    }

    public boolean EliminarVotante(String votante) {
        boolean respuesta = this.modelo.EliminarVotante(votante);
        return respuesta;
    }

    public LinkedList<ClsVotante> ObtenerVotantes() {
        return this.modelo.ObtenerVotantes();
    }
    
    public boolean ActualizarVotante(ClsVotante votante) {
        boolean respuesta = this.modelo.ActualizarVotante(votante);
        return respuesta;
    }
}
