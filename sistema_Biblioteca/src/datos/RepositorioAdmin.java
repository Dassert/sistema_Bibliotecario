package datos;

import modelo.Administrador;

public class RepositorioAdmin extends Repositorios {
    //Inicializacion del admin
    Administrador admin = new Administrador();

    public RepositorioAdmin(){
        admin.setNombre("Ulises");
        admin.setApellidoPaterno("Alderete");
        admin.setApellidoMaterno("Huerta");
        admin.setDiaNac(7);
        admin.setMesNac(6);
        admin.setAnioNac(2002);
        admin.setSexo("Therian");
        admin.setNombreUsuario("E");
        admin.setDiaRegistro(15);
        admin.setMesRegistro(10);
        admin.setAnioNac(2018);
        admin.setContrasenia("1");
        admin.setCurp("AUCD0548GS60R");
        admin.setDireccion("Villas del crimen");
        admin.setRfc("AUCD0548");
        admin.setSueldo(1500);
        admin.setNumEmp(0);
    }

    //metodo para retornar el admin
    public Administrador obtenerAdmin(){return admin;}

    //Metodo para que el admin pueda modificar sus datos
    public void modificarAdmin (String datoIngresado, int valorIngresado, int opcion)
    {
        switch (opcion){
            case 1:
                admin.setNombreUsuario(datoIngresado);
                break;

            case 2:
                admin.setContrasenia(datoIngresado);
                break;

            case 3:
                admin.setDireccion(datoIngresado);
                break;

            case 4:
                admin.setNombre(datoIngresado);
                break;

            case 5:
                admin.setApellidoPaterno(datoIngresado);
                break;

            case 6:
                admin.setApellidoMaterno(datoIngresado);
                break;

            case 7:
                admin.setDiaNac(valorIngresado);
                break;

            case 8:
                admin.setMesNac(valorIngresado);
                break;

            case 9:
                admin.setAnioNac(valorIngresado);
                break;

            case 10:
                admin.setSexo(datoIngresado);
                break;

            case 11:
                admin.setCurp(datoIngresado);
                break;

            case 12:
                admin.setRfc(datoIngresado);
                break;

            case 13:
                admin.setSueldo(valorIngresado);
                break;

            default: System.out.println(t.ANSI_RED + "Opcion ingresada no válida" + t.ANSI_RESET);
        }
    }


}
