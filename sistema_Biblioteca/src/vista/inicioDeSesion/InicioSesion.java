package vista.inicioDeSesion;

import modelo.Tools;

import servicio.*;

//CLASE PARA MENU DE INICIO DE SESION DESDE AQUI SE VINCULAN LOS DEMAS MENUS
public class InicioSesion extends HerramientasMenu {

    //CONSTRUCTOR CON TODAS LAS CLASES DE LA CAPA DE SERVICIO
    public InicioSesion(ServicioAsociados nServA, ServicioEmpleado nServE, ServicioLibros nServL, ServicioPrestamos  nServP, ServicioAdmin nServAdmin){
        this.servA = nServA;
        this.servE = nServE;
        this.servL = nServL;
        this.servP = nServP;
        this.servAdmin = nServAdmin;
    }

    //METODO PARA EJECUTAR MENU
    public void ejecutarMenu(){

        MenuAsociado menuAso = new MenuAsociado(this.servA, this.servL,this.servP);
        MenuEmp menuEmp = new MenuEmp(this.servE, this.servL, this.servP);
        MenuAdmin menuAdmin = new MenuAdmin(this.servA, this.servE, this.servL, this.servP, this.servAdmin);

        do {
            //****************************Primer menu para acceder**********************************
            System.out.println(t.ANSI_BLUE + "\n===== Bienvenido a la biblioteca de Alejandría =====" + t.ANSI_RESET);
            System.out.println("1. Iniciar Sesión");
            System.out.println("2. Registrarse");
            System.out.println("0. Salir de la aplicación");
            System.out.print(">Por favor, ingrese una opción: ");
            seleccionUsuario = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            switch (seleccionUsuario) {
                case 1:
                    sesionID = -1;
                    while (sesionID == -1) {
                        //Segundo menu para iniciar sesion
                        System.out.println("\n===== Inicio de sesión =====");
                        System.out.println(">Ingrese 0 para salir");
                        System.out.print(">Ingresa tu usuario: ");
                        sesionUsuario = t.scanner.nextLine();

                        if (sesionUsuario.equalsIgnoreCase("0")) {
                            break;
                        }

                        System.out.print(">Ingresa tu contraseña: ");
                        sesionCont = t.scanner.nextLine();


                        for (i = 0; i < servA.obtenerAsociados().length; i++) {
                            //Se verifica que los datos ingresados sean iguales a los registrados
                            //si el usuario es un lector se ejecuta esta parte
                            if (servA.obtener1Asociado(i) != null && sesionUsuario.equals(servA.obtener1Asociado(i).getNombreUsuario())
                                    && sesionCont.equals(servA.obtener1Asociado(i).getContrasenia())) {

                                //METODO PARA EJECUTAR EL MENU DEL ASOCIADO
                                menuAso.ejecutarMenuAso(i);
                                i = servA.obtenerAsociados().length;

//--------------------------------------------------Menu mod-----------------------------------------------------------
                            }else if (servE.obtener1Emp(i) != null && sesionUsuario.equals(servE.obtener1Emp(i).getNombreUsuario()) && sesionCont.equals(servE.obtener1Emp(i).getContrasenia())) {
                                //Se verifica que los datos ingresados sean iguales a los registrados
                                //si el usuario es un empleado se ejecuta esta parte
                                menuEmp.ejecutarMenuEmp(i);
                                i = servA.obtenerAsociados().length;

//-----------------------------------------------------Menu del administrador-------------------------------------------
                            } else if (sesionUsuario.equals(servAdmin.obtenerAdmin().getNombreUsuario()) && sesionCont.equals(servAdmin.obtenerAdmin().getContrasenia())) {

                                menuAdmin.ejecutarMenuAdmin(i);
                                i = servA.obtenerAsociados().length;

                            } else if (i == servA.obtenerAsociados().length - 1) { //En caso de no encontrar nada
                                System.out.println(t.ANSI_RED + "Usuario o contraseña inválido. Vuelve intentarlo" + t.ANSI_RESET);

                            }

                        }
                    }
                    break;

                case 2:
                    //*****************Registro de usuarios**********************
                    servA.registrarAsociado();
                    break;

                case 0:
                    System.out.println("Adiós...");
                    break;

                default:
                    System.out.println(t.ANSI_RED + "Ingrese una opción valida" + t.ANSI_RESET);
                    break;
            }
        } while (seleccionUsuario != 0);
    }
}