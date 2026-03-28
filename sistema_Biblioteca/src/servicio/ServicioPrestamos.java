package servicio;
import datos.RepositorioLibros;
import datos.RepositorioAsociados;

public class ServicioPrestamos extends Servicio {
    //Inyeccion de dependencias
    RepositorioLibros repoL;
    RepositorioAsociados repoA;

    public ServicioPrestamos(RepositorioAsociados repoA, RepositorioLibros repoL){
        this.repoA = repoA;
        this.repoL = repoL;
    }

    //Tomar prestado un libro
    public void tomarLibroPrestado(int sesionI){
        do {
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el ID del libro que desea: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if ( idIngresado == 0 ) {System.out.println("Saliendo..."); return; }

            for (i = 0; i < repoL.obtenerLibros().length; i++) {
                //Verifica si existe ese id ingresado
                if (repoL.obtener1Libro(i) != null && idIngresado == repoL.obtener1Libro(i).getId()) {

                    //Verifica si hay en existencia el libro
                    if (repoL.obtener1Libro(i).getCantidad() > 0) {

                        if (repoA.asignarPrestamos(idIngresado, sesionI)) {
                            System.out.println(t.ANSI_GREEN + "Se ha añadido al carrito" + t.ANSI_RESET);

                            for (int i = 0; i < repoA.obtener1Asociado(sesionI).prestamos.length; i++){
                                if (repoA.obtener1Asociado(sesionI).prestamos[i] == idIngresado){
                                    System.out.println(t.ANSI_YELLOW + "Fecha limite de entrega: " + repoA.obtener1Asociado(sesionI).fechaEntrega[i] + t.ANSI_RESET);}
                            }

                            repoL.tomarLibro(1, i);
                        }

                    } else { System.out.println(t.ANSI_RED + "Lo sentimos, no hay suficiente cantidad disponible" + t.ANSI_RESET);
                    }

                    i = repoL.obtenerLibros().length;
                    //En caso de salir
                } else if (i == repoL.obtenerLibros().length - 1) {
                    System.out.println(t.ANSI_RED + "ID inválido, por favor vuela a intentar" + t.ANSI_RESET);
                }
            }

        } while (idIngresado != 0);
    }

    //Metodo para delvover el libro
    public void devolverLibro(int sesionI){
        do {
            System.out.println("\n-------------------------------------------------------------------------");
            System.out.println(">Ingrese 0 para salir");
            System.out.print(">Ingrese el ID del libro que desea regresar: ");
            idIngresado = t.leerEntero(t.scanner);
            t.scanner.nextLine();

            if ( idIngresado == 0 ) {System.out.println("Saliendo..."); return; }

            //Verificamos que el id ingresado lo tenga el usuario en su inventario
            for (i = 0; i < repoA.obtener1Asociado(sesionI).prestamos.length; i++) {

                if (repoA.obtener1Asociado(sesionI).prestamos[i] != 0 && idIngresado == repoA.obtener1Asociado(sesionI).prestamos[i]) {

                    //verifica que sea un libro existente en el catalogo
                    if (repoL.obtener1Libro(idIngresado - 1).getId() == idIngresado) {

                        //verifica que la devolucion se realizo con exito
                        if (repoA.devolverPrestamos(idIngresado, sesionI)) {

                            System.out.println(t.ANSI_GREEN + "El libro se ha devuelto con éxito" + t.ANSI_RESET);
                            repoL.devolverLibro(1,(idIngresado - 1));
                        }

                    } else {
                        System.out.println(t.ANSI_RED + "El libro que intenta ingresar no coincide" + t.ANSI_RESET);
                    }

                    i = repoA.obtener1Asociado(sesionI).prestamos.length;

                } else if (idIngresado == 0) {
                    i = repoA.obtener1Asociado(sesionI).prestamos.length;

                } else if (i == repoA.obtener1Asociado(sesionI).prestamos.length - 1) {
                    System.out.println(t.ANSI_RED + "ID inválido, por favor vuelva a intentar" + t.ANSI_RESET);
                }
            }
        } while (idIngresado!= 0);
    }

    //Muestra libros adquiridos
    public void mostrarPrestamosAso(int sesionI)
    {
        contadorNulos = 0;

        for ( k = 0; k <= repoA.obtener1Asociado(sesionI).prestamos.length -1 ; k++) {
            if (k == 0) {
                System.out.println("Libros adquiridos:");
            }

            if (repoA.obtener1Asociado(sesionI).prestamos[k] > 0) {

                for (l = 0; l <= repoL.obtenerLibros().length - 1; l++) {
                    if (repoL.obtener1Libro(l) != null && repoA.obtener1Asociado(sesionI).prestamos[k] == repoL.obtener1Libro(l).getId()) {
                        System.out.println("");
                        System.out.println(t.ANSI_GREEN + "Nombre: " + t.ANSI_RESET + repoL.obtener1Libro(l).getNombre() + t.ANSI_GREEN + " Autor: " + t.ANSI_RESET + repoL.obtener1Libro(l).getAutor() + t.ANSI_GREEN + " Código de libro: " + t.ANSI_RESET + repoA.prestamosAdq(sesionI, k));

                        System.out.println("Fecha de adquirido: " + repoA.obtener1Asociado(sesionI).fechaPrestamo[k].getDayOfMonth() + "/" +
                                repoA.obtener1Asociado(sesionI).fechaPrestamo[k].getMonthValue() + "/" + repoA.obtener1Asociado(sesionI).fechaPrestamo[k].getYear() + " - " + t.ANSI_YELLOW +
                                "Fecha de entrega: " + repoA.obtener1Asociado(sesionI).fechaEntrega[k].getDayOfMonth() + "/" + repoA.obtener1Asociado(sesionI).fechaEntrega[k].getMonthValue() +
                                "/" + repoA.obtener1Asociado(sesionI).fechaEntrega[k].getYear() + t.ANSI_RESET);
                    }
                }

            } else if (k == repoA.obtener1Asociado(sesionI).prestamos.length - 1 && contadorNulos == k) {
                System.out.println(t.ANSI_RED + "No hay libros para mostrar" + t.ANSI_RESET);

            } else if (repoA.obtener1Asociado(sesionI).prestamos[k] == 0) {
                contadorNulos++;

            }
        }

    }

    @Override
    public void mostrarDatos(){
        contador = 0;
        contadorUsuarios = 0;

        //recorre toda la lista de usuarios
        for (i = 0; i < repoA.obtenerAsociados().length; i++) {
            //verifica si hay un usuario en esa posicion
            if (repoA.obtener1Asociado(i) != null) {
                contadorNulos = 0;
                for (j = 0; j < repoA.obtener1Asociado(i).prestamos.length; j++){
                    //verifica si en la posicion de su inventario esta vacia y la cuenta
                    if(repoA.obtener1Asociado(i).prestamos[j] == 0){
                        contadorNulos++;
                    }
                }
                //si cuenta con almenos 1 libro se muestra
                if (contadorNulos < 5) {
                    System.out.println("\n-------------------------------------------------------------------------");
                    System.out.println("Nombre de usuario: " + repoA.obtener1Asociado(i).getNombreUsuario());
                    System.out.println("Nombre: " + repoA.obtener1Asociado(i).getNombre() + " " + repoA.obtener1Asociado(i).getApellidoPaterno() + " " +repoA.obtener1Asociado(i).getApellidoMaterno());
                    System.out.println("ID de usuario: " + repoA.obtener1Asociado(i).getNumAso());
                    mostrarPrestamosAso(i);
                } else if (contadorNulos == 5) { contador++; }

                contadorUsuarios ++;
                //Si ningun usuario cuenta con libros se muestra mensaje
            } else if (i == repoA.obtenerAsociados().length - 1 && contador == contadorUsuarios) {
                System.out.println(t.ANSI_RED + "\nNo hay prestamos para mostrar" + t.ANSI_RESET);
            }
        }
    }

}
