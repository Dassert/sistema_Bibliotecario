package servicio;
import datos.RepositorioAsociados;
import modelo.Asociados;

public class ServicioAsociados extends Servicio{

    //Inyeccion de dependencias
    RepositorioAsociados repoA;
    public ServicioAsociados(RepositorioAsociados nuevoRepoA){ this.repoA = nuevoRepoA; }

    public Asociados[] obtenerAsociados(){
        return repoA.obtenerAsociados();
    }
    public Asociados obtener1Asociado(int i){ return repoA.obtener1Asociado(i); }

    //Metodo para registrar el asociado
    public void registrarAsociado(){
        for (i = 0; i < obtenerAsociados().length; i++) {
            if (obtener1Asociado(i) == null) {
                System.out.println("\n=== Registro usuarios ===");
                System.out.println(">Ingrese 0 para salir");
                System.out.println("Para un correcto registro de moderador ingrese los siguientes datos: ");
                System.out.print(">Nombre: ");
                String nombre = t.scanner.nextLine();

                if (nombre.equals("0")){System.out.println("Saliendo...");return;}

                System.out.print(">Primer apellido: ");
                String apellidoPaterno = t.scanner.nextLine();
                System.out.print(">Segundo apellido: ");
                String apellidoMaterno = t.scanner.nextLine();
                System.out.print(">Nombre de usuario: ");
                String nombreUsuario = t.scanner.nextLine();
                System.out.print(">Contraseña: ");
                String nuevaCont = t.scanner.nextLine();
                System.out.print(">Día de nacimiento: ");
                int diaNac = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print(">Mes de nacimiento: ");
                int mesNac = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print(">Año de nacimiento: ");
                int anioNac = t.leerEntero(t.scanner);
                t.scanner.nextLine();
                System.out.print(">Sexo: ");
                String sexo = t.scanner.nextLine();
                System.out.print(">CURP: ");
                String curp = t.scanner.nextLine();
                System.out.print(">Dirección: ");
                String direccion = t.scanner.nextLine();

                int diaRegistro = t.fechaActual.getDayOfMonth();
                int mesRegistro = t.fechaActual.getMonthValue();
                int anioRegistro = t.fechaActual.getYear();
                int asignarNumAso = i + 1;

                repoA.agregarAsociado(nombre, apellidoPaterno, apellidoMaterno, diaNac, mesNac, anioNac, sexo, nombreUsuario,
                        diaRegistro, mesRegistro, anioRegistro, nuevaCont, curp, direccion, asignarNumAso, i);

                System.out.println(t.ANSI_GREEN + "Registro exitoso!!" + t.ANSI_RESET);

                i = obtenerAsociados().length;

            } else if (i == obtenerAsociados().length - 1) {

                System.out.println(t.ANSI_RED + "Lista de usuarios llena, favor de contactar con la biblioteca..." + t.ANSI_RESET);

            }
        }
    }

    //Metodo para editar a un solo asociado
    public void editar1Asociado(int i){
        do{

            System.out.println("\n=== Editar perfil ===");
                System.out.println("1.- Nombre de usuario: " + obtener1Asociado(i).getNombreUsuario());
                System.out.println("2.- Contraseña: ********");
                System.out.println("3.- Dirección: " + obtener1Asociado(i).getDireccion());
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

                repoA.modificarAsociado(datoIng,valorIng,i,opcionIng);

        }while (opcionIng != 0);

    }

    //Metodo para editar a varios asociados, este es para admin
    public void editarAsociados(){
        do {
            System.out.println("\n=== Editar asociado ===");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el ID para editar un asociado: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if (idIngresado == 0) {System.out.println("Saliendo...");return;}

            for (i = 0; i < obtenerAsociados().length; i++){
                if (obtener1Asociado(i) != null && obtener1Asociado(i).getNumAso() == idIngresado){
                    do{
                        System.out.println("\n=== Editar perfil ===");
                        System.out.println("1.- Nombre de usuario: " + obtener1Asociado(i).getNombreUsuario());
                        System.out.println("2.- Contraseña: ********");
                        System.out.println("3.- Dirección: " + obtener1Asociado(i).getDireccion());
                        System.out.println("4.- Nombre: " + obtener1Asociado(i).getNombre());
                        System.out.println("5.- Apellido Paterno: " + obtener1Asociado(i).getApellidoPaterno());
                        System.out.println("6.- Apellido Materno: " + obtener1Asociado(i).getApellidoMaterno());
                        System.out.println("7.- Día de nacimiento: " + obtener1Asociado(i).getDiaNac());
                        System.out.println("8.- Mes de nacimiento: " + obtener1Asociado(i).getMesNac());
                        System.out.println("9.- Año de nacimiento: " + obtener1Asociado(i).getAnioNac());
                        System.out.println("10.- Sexo: " + obtener1Asociado(i).getSexo());
                        System.out.println("11.- CURP: " + obtener1Asociado(i).getCurp());
                        do {
                            System.out.println("\n>Ingrese 0 para salir");
                            System.out.print(">Ingrese opción a editar: ");
                            opcionIng = t.leerEntero(t.scanner);
                            t.scanner.nextLine();

                            if (opcionIng == 0) {System.out.println("Saliendo...");return;

                            } else if (opcionIng < 0 || opcionIng > 12) {System.out.println(t.ANSI_RED + "Opción invalida, vuelva a intentar" + t.ANSI_RESET);}

                        }while(opcionIng < 0 || opcionIng > 12);

                        System.out.println("\n>Ingrese 0 para salir");
                        System.out.print(">Ingrese la correción: ");

                        if(opcionIng >= 7 && opcionIng <= 9)
                        {

                            valorIng = t.leerEntero(t.scanner);
                            t.scanner.nextLine();

                        }else{datoIng = t.scanner.nextLine();}

                        if (datoIng.equals("0") && valorIng == 0) { System.out.println("Saliendo..."); return; }
                        repoA.modificarAsociado(datoIng,valorIng,i,opcionIng);

                    }while (opcionIng != 0);

                } else if (i == obtenerAsociados().length - 1){System.out.println(t.ANSI_RED + "ID ingresado no encontrado" + t.ANSI_RESET);}
            }
        }while (idIngresado != 0);
    }

    //Metodo para elimar a un asociado
    public void eliminarAsociado(){
        do {
            System.out.println("\n=== Eliminar usuarios ===");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el ID para eliminar el usuario: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if (idIngresado == 0) {System.out.println("Saliendo...");return;}

            for (i = 0; i < obtenerAsociados().length; i++) {
                //verifica que el id a eliminar existe en el catalogo
                if (obtener1Asociado(i) != null && idIngresado == obtener1Asociado(i).getNumAso()) {

                    repoA.eliminarAsociado(i);
                    System.out.println(t.ANSI_GREEN + "Eliminado correctamente..." + t.ANSI_RESET);
                    i = obtenerAsociados().length;

                } else if (i == obtenerAsociados().length - 1) {
                    System.out.println(t.ANSI_RED + "Numero de ID no valido." + t.ANSI_RESET);
                }
            }

        }while(idIngresado!=0);
    }

    //Metodo abstracto para mostrar los datos del empleado
    @Override
    public void mostrarDatos(){
        for (i = 0; i < obtenerAsociados().length; i++) {
            if (obtener1Asociado(i) != null) {
                System.out.println("\n-------------------------------------------------------------------------");
                System.out.println("Nombre de usuario: " + obtener1Asociado(i).getNombreUsuario());
                System.out.println("Nombre: " + obtener1Asociado(i).getNombre());
                System.out.println("Apellido paterno: " + obtener1Asociado(i).getApellidoPaterno());
                System.out.println("Apellido materno: " + obtener1Asociado(i).getApellidoMaterno());
                System.out.println("Dia de nacimiento: " + obtener1Asociado(i).getDiaNac());
                System.out.println("Mes de nacimiento: " + obtener1Asociado(i).getMesNac());
                System.out.println("Año de nacimiento: " + obtener1Asociado(i).getAnioNac());
                System.out.println("Sexo: " + obtener1Asociado(i).getSexo());
                System.out.println("CURP: " + obtener1Asociado(i).getCurp());
                System.out.println("Dirección: " + obtener1Asociado(i).getDireccion());
                System.out.println("Dia registro: " + obtener1Asociado(i).getDiaRegistro());
                System.out.println("Mes registro: " + obtener1Asociado(i).getMesRegistro());
                System.out.println("Año reigistro:: " + obtener1Asociado(i).getAnioRegistro());
                System.out.println("ID de usuario: " + obtener1Asociado(i).getNumAso());
            }
        }
    }

    //Muestra a los asociados
    public void mostrarDatosAso(int i) {
        System.out.println("\n-------------------------------------------------------------------------");
        System.out.println("Nombre de usuario: " + obtener1Asociado(i).getNombreUsuario());
        System.out.println("Nombre: "+ obtener1Asociado(i).getNombre());
        System.out.println("Apellido paterno: "+ obtener1Asociado(i).getApellidoPaterno());
        System.out.println("Apellido materno: "+ obtener1Asociado(i).getApellidoMaterno());
        System.out.println("Dia de nacimiento: "+ obtener1Asociado(i).getDiaNac());
        System.out.println("Mes de nacimiento: "+ obtener1Asociado(i).getMesNac());
        System.out.println("Año de nacimiento: "+ obtener1Asociado(i).getAnioNac());
        System.out.println("Sexo: "+ obtener1Asociado(i).getSexo());
        System.out.println("CURP: "+ obtener1Asociado(i).getCurp());
        System.out.println("Dirección: "+ obtener1Asociado(i).getDireccion());
        System.out.println("Año reigistro: " + obtener1Asociado(i).getAnioRegistro());
        System.out.println("ID de usuario: " + obtener1Asociado(i).getNumAso());
    }
}
