package datos;
import modelo.Empleado;

public class RepositorioEmpleado extends Repositorios {

    //Inicializacion de los empleados en un arreglo
    private Empleado[] mod = new Empleado[20];
    //Constructor de la clase
    public RepositorioEmpleado(){
        mod[0] = new Empleado();
        mod[0].setNombre("Juan");
        mod[0].setApellidoPaterno("Gonzalez");
        mod[0].setApellidoMaterno("Morales");
        mod[0].setDiaNac(5);
        mod[0].setMesNac(9);
        mod[0].setAnioNac(2007);
        mod[0].setSexo("Masculino");
        mod[0].setNombreUsuario("Electro");
        mod[0].setDiaRegistro(15);
        mod[0].setMesRegistro(10);
        mod[0].setAnioNac(2018);
        mod[0].setContrasenia("1");
        mod[0].setCurp("AUCD0548GS60R");
        mod[0].setDireccion("Villas del crimen");
        mod[0].setRfc("AUCD0548");
        mod[0].setSueldo(1500);
        mod[0].setNumEmp(1);
    }

    //METODOS PARA RETORNAR EL ARREGLO COMPLETO E INDIVIDUAL
    public Empleado[] obtenerEmps(){ return mod; }
    public Empleado obtenerEmp(int i){ return mod[i];}

    //Metodos para agregar, modificar y elimnar empleado
    public void agregarEmpleado(String nNombre, String nApellidoPaterno, String nAapellidoMaterno, int nDiaNac, int nMesNac, int nAnioNac, String nSexo,
                                String nNombreUsuario, int nDiaRegistro, int nMesRegistro, int nAnioRegistro, String nContrasenia, String nCurp, String nDireccion,
                                int nNumEmp, String nRfc, int nSueldo, int i)
    {
        mod[i] = new Empleado();
        mod[i].setNombre(nNombre);
        mod[i].setApellidoPaterno(nApellidoPaterno);
        mod[i].setApellidoMaterno(nAapellidoMaterno);
        mod[i].setDiaNac(nDiaNac);
        mod[i].setMesNac(nMesNac);
        mod[i].setAnioNac(nAnioNac);
        mod[i].setSexo(nSexo);
        mod[i].setNombreUsuario(nNombreUsuario);
        mod[i].setDiaRegistro(nDiaRegistro);
        mod[i].setMesRegistro(nMesRegistro);
        mod[i].setAnioRegistro(nAnioRegistro);
        mod[i].setContrasenia(nContrasenia);
        mod[i].setCurp(nCurp);
        mod[i].setDireccion(nDireccion);
        mod[i].setNumEmp(nNumEmp);
        mod[i].setRfc(nRfc);
        mod[i].setSueldo(nSueldo);
    }

    public void modificarEmpleado (String datoIngresado, int valorIngresado, int i, int opcion)
    {
        switch (opcion){
            case 1:
                mod[i].setNombreUsuario(datoIngresado);
                break;

            case 2:
                mod[i].setContrasenia(datoIngresado);
                break;

            case 3:
                mod[i].setDireccion(datoIngresado);
                break;

            case 4:
                mod[i].setNombre(datoIngresado);
                break;

            case 5:
                mod[i].setApellidoPaterno(datoIngresado);
                break;

            case 6:
                mod[i].setApellidoMaterno(datoIngresado);
                break;

            case 7:
                mod[i].setDiaNac(valorIngresado);
                break;

            case 8:
                mod[i].setMesNac(valorIngresado);
                break;

            case 9:
                mod[i].setAnioNac(valorIngresado);
                break;

            case 10:
                mod[i].setSexo(datoIngresado);
                break;

            case 11:
                mod[i].setCurp(datoIngresado);
                break;

            case 12:
                mod[i].setRfc(datoIngresado);
                break;

            case 13:
                mod[i].setSueldo(valorIngresado);
                break;

            default: System.out.println(t.ANSI_RED + "Opción ingresada no válida" + t.ANSI_RESET);
        }
    }

    public void eliminarEmpleado(int i){ mod[i] = null; }

}
