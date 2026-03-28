package servicio;
import datos.RepositorioEmpleado;
import modelo.Empleado;

public class ServicioEmpleado extends Servicio {

    //Inyeccion de dependencias
    RepositorioEmpleado repoE;

    public ServicioEmpleado(RepositorioEmpleado nuevoRepoE){ this.repoE = nuevoRepoE; }

    public Empleado[] obtenerEmps(){ return repoE.obtenerEmps(); }
    public Empleado obtener1Emp(int i){ return repoE.obtenerEmp(i); }


    //Metodo para registrar un nuevo empleado
    public void registrarEmpleado(){
        for (i = 0; i < obtenerEmps().length; i++) {
            if (obtener1Emp(i) == null) {
                System.out.println("\n=== Registrar moderador ===");
                System.out.println(">Ingrese 0 para salir");
                System.out.println("Para un correcto registro de moderador ingrese los siguientes datos:");
                System.out.print("Nombre: ");
                String nNombre = t.scanner.nextLine();

                if (nNombre.equals("0")){System.out.println("Saliendo...");return;}

                System.out.print("Primer apellido: ");
                String nApellidoPaterno = t.scanner.nextLine();
                System.out.print("Segundo apellido: ");
                String nApellidoMaterno = t.scanner.nextLine();
                System.out.print("Nombre de usuario: ");
                String nNombreUsuario = t.scanner.nextLine();
                System.out.print("Contraseña: ");
                String nContrasenia = t.scanner.nextLine();
                System.out.print("Día de nacimiento: ");
                int nDiaNac = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print("Mes de nacimiento: ");
                int nMesNac = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print("Año de nacimiento: ");
                int nAnioNac = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print("Sexo: ");
                String nSexo = t.scanner.nextLine();
                System.out.print("CURP: ");
                String nCurp = t.scanner.nextLine();
                System.out.print("RFC: ");
                String nRfc = t.scanner.nextLine();
                System.out.print("Sueldo: ");
                int nSueldo = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print("Dirección: ");
                String nDireccion = t.scanner.nextLine();

                int nDiaRegistro = t.fechaActual.getDayOfMonth();
                int nMesRegistro = t.fechaActual.getMonthValue();
                int nAnioRegistro = t.fechaActual.getYear();
                int nNumEmp = i + 1;

                repoE.agregarEmpleado(nNombre, nApellidoPaterno, nApellidoMaterno, nDiaNac, nMesNac, nAnioNac, nSexo,
                        nNombreUsuario, nDiaRegistro, nMesRegistro, nAnioRegistro, nContrasenia, nCurp, nDireccion,
                        nNumEmp, nRfc, nSueldo, i);

                System.out.println(t.ANSI_GREEN + "Registro exitoso!!" + t.ANSI_RESET);

                i = obtenerEmps().length;

            } else if (i == obtenerEmps().length - 1) {

                System.out.println(t.ANSI_RED + "Lista de empleados llena..." + t.ANSI_RESET);

            }
        }
    }

    //Metodo que tiene el empleado para modificar sus datos
    public void editar1Empleado(int i){
        do{

            System.out.println("\n=== Editar perfil ===");
            System.out.println("1.- Nombre de usuario: " + obtener1Emp(i).getNombreUsuario());
            System.out.println("2.- Contraseña: ********");
            System.out.println("3.- Dirección: " + obtener1Emp(i).getDireccion());
            do {
                System.out.println("\n>Ingrese 0 para salir");
                System.out.print(">Ingrese opción a editar: ");
                opcionIng = t.leerEntero(t.scanner);
                t.scanner.nextLine();

                if (opcionIng == 0) {System.out.println("Saliendo...");return;

                } else if (opcionIng < 0 || opcionIng > 3) {System.out.println(t.ANSI_RED + "Opción invalida, vuelva a intentar" + t.ANSI_RESET);}

            }while(opcionIng < 0 || opcionIng > 3);

            System.out.println("\n>Ingrese 0 para salir");
            System.out.print(">Ingrese la correción: ");

            datoIng = t.scanner.nextLine();

            if (datoIng.equals("0")) { System.out.println("Saliendo..."); return; }

            repoE.modificarEmpleado(datoIng,valorIng,i,opcionIng);

        }while (opcionIng != 0);
    }

    //Metodo para que el admin pueda editar los datos de cualquier empleado
    public void editarEmpleados(){
        do {
            System.out.println("\n=== Editar moderador ===");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el ID para editar un moderador: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if (idIngresado == 0) {System.out.println("Saliendo...");return;}

            for (i = 0; i < obtenerEmps().length; i++){
                if (obtener1Emp(i) != null && obtener1Emp(i).getNumEmp() == idIngresado){
                    do{
                        System.out.println("\n=== Editar perfil ===");
                        System.out.println("1.- Nombre de usuario: " + obtener1Emp(i).getNombreUsuario());
                        System.out.println("2.- Contraseña: ********");
                        System.out.println("3.- Dirección: " + obtener1Emp(i).getDireccion());
                        System.out.println("4.- Nombre: " + obtener1Emp(i).getNombre());
                        System.out.println("5.- Apellido Paterno: " + obtener1Emp(i).getApellidoPaterno());
                        System.out.println("6.- Apellido Materno: " + obtener1Emp(i).getApellidoMaterno());
                        System.out.println("7.- Día de nacimiento: " + obtener1Emp(i).getDiaNac());
                        System.out.println("8.- Mes de nacimiento: " + obtener1Emp(i).getMesNac());
                        System.out.println("9.- Año de nacimiento: " + obtener1Emp(i).getAnioNac());
                        System.out.println("10.- Sexo: " + obtener1Emp(i).getSexo());
                        System.out.println("11.- CURP: " + obtener1Emp(i).getCurp());
                        System.out.println("12.- RFC: " + obtener1Emp(i).getRfc());
                        System.out.println("13.- Sueldo: " + obtener1Emp(i).getSueldo());
                        do {

                            System.out.println("\n>Ingrese 0 para salir");
                            System.out.print(">Ingrese opción a editar: ");

                            opcionIng = t.leerEntero(t.scanner);
                            t.scanner.nextLine();

                            if (opcionIng == 0) {System.out.println("Saliendo...");return;

                            } else if (opcionIng < 0 || opcionIng > 13) {System.out.println(t.ANSI_RED + "Opción invalida, vuelva a intentar" + t.ANSI_RESET);}

                        }while(opcionIng < 0 || opcionIng > 13);

                        System.out.println("\n>Ingrese 0 para salir");
                        System.out.print(">Ingrese la correción: ");


                        if(opcionIng >= 7 && opcionIng <= 9 || opcionIng == 13)
                        {
                            valorIng = t.leerEntero(t.scanner);
                            t.scanner.nextLine();

                        }else{datoIng = t.scanner.nextLine();}

                        if (datoIng.equals("0") && valorIng == 0) { System.out.println("Saliendo..."); return; }

                        repoE.modificarEmpleado(datoIng,valorIng,i,opcionIng);

                    }while (opcionIng != 0);

                } else if (i == obtenerEmps().length - 1){System.out.println(t.ANSI_RED + "ID ingresado no encontrado" + t.ANSI_RESET);}
            }
        }while (idIngresado != 0);
    }

    //Metodo para admin para eliminar 1 empleado
    public void eliminarEmpleado() {
        do {
            System.out.println("\n=== Eliminar moderador ===");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el número de empleado para eliminar el moderador: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if (idIngresado == 0) {System.out.println("Saliendo...");return;}

            for (i = 0; i < obtenerEmps().length; i++) {

                //verifica que el numero ingresado coincida con los registrados
                if (obtener1Emp(i) != null && idIngresado == obtener1Emp(i).getNumEmp()) {

                    repoE.eliminarEmpleado(i);
                    System.out.println(t.ANSI_GREEN + "Eliminado correctamente..." + t.ANSI_RESET);
                    i = obtenerEmps().length;

                } else if (i == obtenerEmps().length - 1) {
                    System.out.println(t.ANSI_RED + "Numero de empleado no valido." + t.ANSI_RESET);
                }
            }
        } while (idIngresado != 0);
    }

    //Metodo abstracto para mostrar los datos de todos los empleados
    @Override
    public void mostrarDatos(){
        for (i = 0; i < obtenerEmps().length; i++){
            if (obtener1Emp(i) != null) {
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("Nombre de usuario: "+ obtener1Emp(i).getNombreUsuario());
                System.out.println("Nombre: "+ obtener1Emp(i).getNombre());
                System.out.println("Apellido paterno: "+ obtener1Emp(i).getApellidoPaterno());
                System.out.println("Apellido materno: "+ obtener1Emp(i).getApellidoMaterno());
                System.out.println("Dia de nacimiento: "+ obtener1Emp(i).getDiaNac());
                System.out.println("Mes de nacimiento: "+ obtener1Emp(i).getMesNac());
                System.out.println("Año de nacimiento: "+ obtener1Emp(i).getAnioNac());
                System.out.println("Sexo: "+ obtener1Emp(i).getSexo());
                System.out.println("CURP: "+ obtener1Emp(i).getCurp());
                System.out.println("RFC: " + obtener1Emp(i).getRfc());
                System.out.println("Dirección: "+ obtener1Emp(i).getDireccion());
                System.out.println("Sueldo: " + obtener1Emp(i).getSueldo());
                System.out.println("ID de usuario: " + obtener1Emp(i).getNumEmp());
            }
        }
    }

    //Muestra datos del empleado
    public void mostrarDatosEmp(int i) {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Nombre de usuario: " + obtener1Emp(i).getNombreUsuario());
        System.out.println("Nombre: "+ obtener1Emp(i).getNombre());
        System.out.println("Apellido paterno: "+ obtener1Emp(i).getApellidoPaterno());
        System.out.println("Apellido materno: "+ obtener1Emp(i).getApellidoMaterno());
        System.out.println("Dia de nacimiento: "+ obtener1Emp(i).getDiaNac());
        System.out.println("Mes de nacimiento: "+ obtener1Emp(i).getMesNac());
        System.out.println("Año de nacimiento: "+ obtener1Emp(i).getAnioNac());
        System.out.println("Sexo: "+ obtener1Emp(i).getSexo());
        System.out.println("CURP: "+ obtener1Emp(i).getCurp());
        System.out.println("RFC: " + obtener1Emp(i).getRfc());
        System.out.println("Dirección: "+ obtener1Emp(i).getDireccion());
        System.out.println("Año de registro: "+ obtener1Emp(i).getAnioRegistro());
        System.out.println("Numero de empleado: " + obtener1Emp(i).getNumEmp());
    }

}
