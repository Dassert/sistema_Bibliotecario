package servicio;
import modelo.Tools;

public abstract class Servicio{
        //instancias que todos los servicios necesitan
        int i;
        int j;
        int k;
        int l;
        int idIngresado;
        int opcionIng;
        String datoIng;
        int valorIng;
        int contadorNulos;
        int contador;
        int contadorUsuarios;
        public Tools t = new Tools();
        //poliformismo para mostrar todos los datos de los servicios
        public abstract void mostrarDatos();
}
