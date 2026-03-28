package vista.inicioDeSesion;

import modelo.Tools;
import servicio.ServicioEmpleado;
import servicio.ServicioLibros;
import servicio.ServicioPrestamos;
//CLASE PARA MOSTRAR EL MENU DEL EMPLEADO
public class MenuEmp extends HerramientasMenu{

    //CONSTRUCTOR PARA EL MENU EMPLEADO
    MenuEmp(ServicioEmpleado servE, ServicioLibros servL, ServicioPrestamos servP) {
        this.servE = servE;
        this.servL = servL;
        this.servP = servP;
    }

    //METODO PARA EJECUTAR MENU DEL EMPLEADO
    public void ejecutarMenuEmp(int sesion){
        sesionID = sesion;

        System.out.println(t.ANSI_GREEN + "\n·Bienvenido " + servE.obtener1Emp(sesionID).getNombreUsuario() + t.ANSI_RESET);

        do {
            System.out.println(t.ANSI_PURPLE + "\n=== MENÚ MOD ===" + t.ANSI_RESET);
            System.out.println("1.- Mostrar catalogo");
            System.out.println("2.- Mostrar usuarios con libros prestados");
            System.out.println("3.- Agregar libro");
            System.out.println("4.- Editar libro");
            System.out.println("5.- Editar mi perfil");
            System.out.println("0.- Cerrar sesión");

            System.out.print("\n>Ingrese una opción: ");
            modMenu = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            switch (modMenu) {
                case 1:
                    //mostar catalogo
                    servL.mostrarDatosLib();
                    break;

                case 2:
                    //muestra los libros de usuarios
                    servP.mostrarDatos();
                    break;

                case 3:
                    //**************pasos para ingresar libros nuevos***************
                    servL.registrarLibro();
                    break;

                case 4:
                    servL.editarLibro();
                    break;

                case 5:
                    servE.editar1Empleado(sesionID);
                    break;

                case 0:
                    System.out.println("Adiós...");
                    break;

                //Caso para mostrar a los usuarios con los libros que tienen prestados
                default:
                    System.out.println(t.ANSI_RED + "Selecciona una opción valida" + t.ANSI_RESET);
                    break;

            }
        } while (modMenu != 0);
    }
}
