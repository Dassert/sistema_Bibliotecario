package datos;
import modelo.Asociados;
import modelo.Tools;

public class RepositorioAsociados extends Repositorios {
    //Inicialización de objeto de la clase tools para las fechas
    public Tools t = new Tools();

    //Inicializacion de los asociados en un arreglo
    private Asociados[] lector = new Asociados[20];

    //Asociados ya inicializados
    public RepositorioAsociados(){
        lector[0] = new Asociados();
        lector[0].setNombre("Brayan");
        lector[0].setApellidoPaterno("Calderon");
        lector[0].setApellidoMaterno("Pacheco");
        lector[0].setDiaNac(1);
        lector[0].setMesNac(1);
        lector[0].setAnioNac(1);
        lector[0].setSexo("Masculino");
        lector[0].setNombreUsuario("Brayan");
        lector[0].setDiaRegistro(1);
        lector[0].setMesRegistro(1);
        lector[0].setAnioRegistro(1);
        lector[0].setContrasenia("1");
        lector[0].setCurp("CAPB01101");
        lector[0].setDireccion("Ojo de agua");
        lector[0].setNumAso(1);

        lector[1] = new Asociados();
        lector[1].setNombre("Tazzer");
        lector[1].setApellidoPaterno("Franchesco");
        lector[1].setApellidoMaterno("Leon");
        lector[1].setDiaNac(1);
        lector[1].setMesNac(1);
        lector[1].setAnioNac(1);
        lector[1].setSexo("Femenino");
        lector[1].setNombreUsuario("Tazzer");
        lector[1].setDiaRegistro(1);
        lector[1].setMesRegistro(1);
        lector[1].setAnioRegistro(1);
        lector[1].setContrasenia("1");
        lector[1].setCurp("LFTA01203");
        lector[1].setDireccion("Natura");
        lector[1].setNumAso(2);

    }

    //Metodo para retornar el arreglo completo o individuales
    public Asociados[] obtenerAsociados(){
        return lector;
    }
    public Asociados obtener1Asociado(int i) {
        return lector[i];
    }

    //Metodos para agregar, modificar y eliminar asociados
    public void agregarAsociado(String nNombre, String nApellidoPaterno, String nAapellidoMaterno, int nDiaNac, int nMesNac, int nAnioNac, String nSexo,
                                String nNombreUsuario, int nDiaRegistro, int nMesRegistro, int nAnioRegistro, String nContrasenia, String nCurp, String nDireccion,
                                int nNumAso, int i){
        this.lector[i] = new Asociados();
        this.lector[i].setNombre(nNombre);
        this.lector[i].setApellidoPaterno(nApellidoPaterno);
        this.lector[i].setApellidoMaterno(nAapellidoMaterno);
        this.lector[i].setDiaNac(nDiaNac);
        this.lector[i].setMesNac(nMesNac);
        this.lector[i].setAnioNac(nAnioNac);
        this.lector[i].setSexo(nSexo);
        this.lector[i].setNombreUsuario(nNombreUsuario);
        this.lector[i].setDiaRegistro(nDiaRegistro);
        this.lector[i].setMesRegistro(nMesRegistro);
        this.lector[i].setAnioRegistro(nAnioRegistro);
        this.lector[i].setContrasenia(nContrasenia);
        this.lector[i].setCurp(nCurp);
        this.lector[i].setDireccion(nDireccion);
        this.lector[i].setNumAso(nNumAso);
    }

    //Metodo para modificar asociado directamente
    public void modificarAsociado(String datoIngresado, int valorIngresado, int i, int opcion)
    {
        switch (opcion){
            case 1:
                lector[i].setNombreUsuario(datoIngresado);
                break;

            case 2:
                lector[i].setContrasenia(datoIngresado);
                break;

            case 3:
                lector[i].setDireccion(datoIngresado);
                break;

            case 4:
                lector[i].setNombre(datoIngresado);
                break;

            case 5:
                lector[i].setApellidoPaterno(datoIngresado);
                break;

            case 6:
                lector[i].setApellidoMaterno(datoIngresado);
                break;

            case 7:
                lector[i].setDiaNac(valorIngresado);
                break;

            case 8:
                lector[i].setMesNac(valorIngresado);
                break;

            case 9:
                lector[i].setAnioNac(valorIngresado);
                break;

            case 10:
                lector[i].setSexo(datoIngresado);
                break;

            case 11:
                lector[i].setCurp(datoIngresado);
                break;

            default: System.out.println(t.ANSI_RED + "Opción ingresada no válida" + t.ANSI_RESET);
        }
    }

    //metodo para eliminar un asociado (vuelve nula la posicion para otro nuevo)
    public void eliminarAsociado(int i){ lector[i] = null; }

    //Metodo para asignar libro a atributo
    public boolean asignarPrestamos(int idPrestamos, int sesionI)
    {
        if (idPrestamos > 0)
        {
            for (int i = 0; i < obtener1Asociado(sesionI).prestamos.length; i++){

                if (obtener1Asociado(sesionI).prestamos[i] == 0){

                    obtener1Asociado(sesionI).prestamos[i] = idPrestamos;
                    //Agregarle +7 días a la fecha
                    obtener1Asociado(sesionI).fechaPrestamo[i] = t.fechaActual;
                    obtener1Asociado(sesionI).fechaEntrega[i] = t.fechaActual.plusDays(7);

                    return true;


                }else if (obtener1Asociado(sesionI).prestamos[i] == idPrestamos){

                    System.out.println(t.ANSI_RED + "Ya tienes ese libro" + t.ANSI_RESET);
                    return false;


                } else if (i == obtener1Asociado(sesionI).prestamos.length - 1){

                    System.out.println(t.ANSI_RED + "Tienes libros pendientes por devolver" + t.ANSI_RESET);
                    return false;

                }
            }
            return false;
        }else{
            System.out.println(t.ANSI_RED + "ID de Libro ingresado no válido" + t.ANSI_RESET);
            return false;
        }
    }

    //Metodo para eliminar prestamos
    public boolean devolverPrestamos(int idDevolver, int sesionI) {
        if (idDevolver > 0) {

            for (int i = 0; i < obtener1Asociado(sesionI).prestamos.length; i++) {

                if (obtener1Asociado(sesionI).prestamos[i] == idDevolver) {

                    obtener1Asociado(sesionI).prestamos[i] = 0;
                    //Limpiar la posicion de fecha limite a 0
                    obtener1Asociado(sesionI).fechaPrestamo[i] = null;
                    obtener1Asociado(sesionI).fechaEntrega[i] = null;
                    return true;

                } else if (i == obtener1Asociado(sesionI).prestamos.length - 1) {

                    System.out.println(t.ANSI_RED + "ID de Libro ingresado no válido" + t.ANSI_RESET);
                    return false;

                }
            }
            return false;

        } else {

            System.out.println(t.ANSI_RED + "ID de Libro ingresado no válido" + t.ANSI_RESET);
            return false;

        }
    }

    //Muestra libros adquiridos
    public int prestamosAdq(int sesionI, int i) { return obtener1Asociado(sesionI).prestamos[i]; }

}
