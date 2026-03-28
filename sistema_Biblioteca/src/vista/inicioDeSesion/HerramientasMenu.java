package vista.inicioDeSesion;

import modelo.Tools;
import servicio.*;

//Clase para asignar variables a clases nuevas creadas
public abstract class HerramientasMenu {
    //atributos para inyeccion de dependencias
    ServicioAsociados servA;
    ServicioEmpleado servE;
    ServicioLibros servL;
    ServicioPrestamos servP;
    ServicioAdmin servAdmin;

    public Tools t =  new Tools();

    //Variables para el menu usuario
    String sesionUsuario;
    String sesionCont;
    int sesionID;
    int i;
    int seleccionUsuario;
    int usuarioMenu;

    //Variables para el menu mod
    int modMenu;

    //Variable menu admin1
    int menuAdmin;

}
