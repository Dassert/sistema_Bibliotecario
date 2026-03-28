package vista.inicioDeSesion;


import servicio.*;

public class MenuAdmin extends HerramientasMenu{
    //constructor de la clase
    public MenuAdmin(ServicioAsociados nServA, ServicioEmpleado nServE, ServicioLibros nServL, ServicioPrestamos nServP, ServicioAdmin nServAdmin) {
        this.servA = nServA;
        this.servE = nServE;
        this.servL = nServL;
        this.servP = nServP;
        this.servAdmin = nServAdmin;
    }

    private void opcionesMod(){
        do{
            System.out.println(t.ANSI_YELLOW + "\n=== Opciones para moderadores ===" + t.ANSI_RESET);
            System.out.println("1.- Añadir moderador");
            System.out.println("2.- Mostrar moderadores");
            System.out.println("3.- Editar moderadores");
            System.out.println("4.- Eliminar moderadores");
            System.out.println("0.- Salir");
            System.out.print("\n>Ingrese una opción: ");
            usuarioMenu = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            switch(usuarioMenu){
                case 1:
                    //***************menu para agregar nuevos moderadores**************
                    servE.registrarEmpleado();
                    break;

                case 2:
                    //************muestra moderadores registrados en el sistema**********
                    servE.mostrarDatos();
                    break;

                case 3:
                    //editar perfil de empleados
                    servE.editarEmpleados();
                    break;

                case 4:
                    //***************elimina moderadores************************
                    servE.eliminarEmpleado();
                    break;

                case 0:
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println(t.ANSI_RED + "Ingrese una opción valida" + t.ANSI_RESET);
                    break;
            }
        }while(usuarioMenu != 0);
    }

    private void opcionesLibros(){
        do{
            System.out.println(t.ANSI_YELLOW + "\n=== Opciones para libros ===" + t.ANSI_RESET);
            System.out.println("1.- Mostrar libros");
            System.out.println("2.- Mostrar usuarios con libros prestados");
            System.out.println("3.- Eliminar libros");
            System.out.println("0.- Salir");
            System.out.print("\n>Ingrese una opción: ");
            usuarioMenu = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            switch(usuarioMenu){
                case 1:
                    //****** Muestra las portadas de los libros con su cantidad prestada ****
                    servL.mostrarDatosLib();
                    break;

                case 2:
                    servP.mostrarDatos();
                    break;

                case 3:
                    //********************Menu para eliminar libros**************
                    servL.eliminarLibro();
                    break;

                case 0:
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println(t.ANSI_RED + "Ingrese una opción valida" + t.ANSI_RESET);
                    break;
            }
        }while(usuarioMenu != 0);
    }

    private void opcionesAsociado(){
        do {
            System.out.println(t.ANSI_YELLOW + "\n=== Opciones para asociados ===" + t.ANSI_RESET);
            System.out.println("1.- Mostrar asociados");
            System.out.println("2.- Editar asociados");
            System.out.println("3.- Eliminar asociados");
            System.out.println("0.- Salir");
            System.out.print("\n>Ingrese una opción: ");
            usuarioMenu = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            switch (usuarioMenu){
                case 1:
                    servA.mostrarDatos();
                    break;

                case 2:
                    servA.editarAsociados();
                    break;

                case 3:
                    servA.eliminarAsociado();
                    break;

                case 0:
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println(t.ANSI_RED + "Ingrese una opción valida" + t.ANSI_RESET);
                    break;
            }
        }while (usuarioMenu != 0);
    }



    //METODO PARA EJECUTAR MENU DEL ADMIN
    public void ejecutarMenuAdmin(int sesion){
        sesionID = sesion;

        System.out.println(t.ANSI_GREEN + "\n·Bienvenido " + servAdmin.obtenerAdmin().getNombreUsuario() + t.ANSI_RESET);

        do {
//-----------------------------------------------------Menu del administrador-------------------------------------------

            System.out.println(t.ANSI_YELLOW + "\n=== MENÚ ADMIN ===" + t.ANSI_RESET);
            System.out.println("1.- Opciones para moderadores");
            System.out.println("2.- Opciones para libros");
            System.out.println("3.- Opciones para asociados");
            System.out.println("4.- Ver mi perfil");
            System.out.println("5.- Editar mi perfil");
            System.out.println("0.- Cerrar sesión");

            System.out.print("\n>Ingrese una opción: ");
            menuAdmin = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            switch (menuAdmin) {
                case 1:
                    //***************sub menu para los moderadores**************
                    opcionesMod();
                    break;

                case 2:
                    //****************sub menu para los libros********************************
                    opcionesLibros();
                    break;

                case 3:
                    //***********************sub menu para los asociados**********************
                    opcionesAsociado();
                    break;

                case 4:
                    //***************Muestra los datos del admin************************
                    servAdmin.mostrarDatos();
                    break;

                case 5:
                    //****** Poder editar el perfil de admin ****
                    servAdmin.editarAdmin();
                    break;

                case 0:
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println(t.ANSI_RED + "Ingrese una opción valida" + t.ANSI_RESET);
                    break;
            }
        } while (menuAdmin != 0);
    }
}
