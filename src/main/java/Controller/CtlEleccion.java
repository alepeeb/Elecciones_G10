package Controller;

import Classes.ClsCandidato;
import Classes.ClsEleccion;
import Classes.ClsMensaje;
import Model.MdlEleccion;
import java.util.LinkedList;

public class CtlEleccion {

    MdlEleccion modelo;

    public CtlEleccion() {
        this.modelo = new MdlEleccion();
    }

    public ClsMensaje AgregarEleccion(ClsEleccion eleccion) {
        ClsMensaje respuesta = this.modelo.AgregarEleccion(eleccion);
        return respuesta;
    }

    public LinkedList<ClsEleccion> ObtenerElecciones() {
        return this.modelo.ObtenerElecciones();

    }

    public ClsMensaje EliminarEleccion(String id) {
        ClsMensaje respuesta = this.modelo.EliminarEleccion(id);
        return respuesta;
    }

    public LinkedList<ClsCandidato> ObtenerCandidatosEleccion(String idEleccion) {

        return this.modelo.ObtenerCandidatosEleccion(idEleccion);

    }

    public ClsMensaje AsociarCandidato(String idEleccion, String idCandidato) {

        ClsMensaje respuesta = this.modelo.AsociarCandidato(idEleccion, idCandidato);
        return respuesta;

    }
    
    public ClsMensaje EliminarAsociacion(String idEleccion, String idCandidato) {
        ClsMensaje respuesta = this.modelo.EliminarAsociacion(idEleccion, idCandidato);
        return respuesta;
    }
}
