package vista.inicioDeSesion;

import modelo.Tools;
import servicio.ServicioAsociados;
import servicio.ServicioLibros;
import servicio.ServicioPrestamos;

public class MenuAsociado extends HerramientasMenu {

    MenuAsociado(ServicioAsociados servA, ServicioLibros servL, ServicioPrestamos servP) {
        this.servA = servA;
        this.servL = servL;
        this.servP = servP;
    }

    public void ejecutarMenuAso(int sesion){
        sesionID = sesion;
        System.out.println(t.ANSI_GREEN + "\n·Bienvenido ☺ " + servA.obtener1Asociado(sesionID).getNombreUsuario() + t.ANSI_RESET);

//--------------------------------------------Menu para usuario-------------------------------------------------------
        do {
            System.out.println(t.ANSI_CYAN + "\n=== MENÚ ASOCIADO ===" + t.ANSI_RESET);
            System.out.println("1.- Mostrar catálogo");
            System.out.println("2.- Añadir libro al carrito");
            System.out.println("3.- Devolver libro");
            System.out.println("4.- Mi perfil");
            System.out.println("5.- Editar perfil");
            System.out.println("0.- Cerrar sesión");

            System.out.print("\n>Ingrese una opción: ");
            usuarioMenu = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            //Switch dependiendo la seleccion del usuario
            switch (usuarioMenu) {
                //*******************Mostrar catálogo mediante un for******************
                case 1:
                    servL.mostrarDatos();
                    break;

                //**********************Añadir libro al carrito********************
                case 2:
                    servP.tomarLibroPrestado(sesionID);
                    break;

                //**************************Devolver el libro***********************
                case 3:
                    servP.devolverLibro(sesionID);
                    break;

                case 4:
                    //muestra los datos del usuario
                    servA.mostrarDatosAso(sesionID);

                    //muestra los libros del usuario en su inventario
                    servP.mostrarPrestamosAso(sesionID);
                    break;

                case 5:
                    servA.editar1Asociado(sesionID);
                    break;
                //Despedida
                case 0:
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println(t.ANSI_RED + "Ingrese una opción valida"+ t.ANSI_RESET);
                    break;
            }
        } while (usuarioMenu != 0);
    }

}
